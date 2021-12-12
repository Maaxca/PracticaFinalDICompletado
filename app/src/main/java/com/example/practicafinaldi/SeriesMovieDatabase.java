package com.example.practicafinaldi;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class SeriesMovieDatabase extends AppCompatActivity {

    ListView lista2;
    ProgressDialog progressDialog;
    ArrayList<String> titulo=new ArrayList();
    ArrayList<Integer> foto=new ArrayList();
    ArrayList<String> descripcion=new ArrayList();
    ArrayList<String> popularidad=new ArrayList();
    ArrayList<String> fecha=new ArrayList();
    ArrayList<String> URL=new ArrayList();
    public int cont=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series_movie_database);
        lista2=findViewById(R.id.lista2);
        foto.add(R.drawable.naruto);
        foto.add(R.drawable.office);
        foto.add(R.drawable.seinfeld);
        foto.add(R.drawable.south);
        URL.add("https://api.themoviedb.org/3/search/tv?api_key=24f4481872e2d518f177894f1167ebbe&language=es-es&query=Naruto+Shippuden&page=1");
        URL.add("https://api.themoviedb.org/3/search/tv?api_key=24f4481872e2d518f177894f1167ebbe&language=es-es&query=The+Office&page=1");
        URL.add("https://api.themoviedb.org/3/search/tv?api_key=24f4481872e2d518f177894f1167ebbe&language=es-es&query=Seinfeld&page=1");
        URL.add("https://api.themoviedb.org/3/search/tv?api_key=24f4481872e2d518f177894f1167ebbe&language=es-es&query=South+Park&page=1");
        for(int i=0;i<URL.size();i++) {
            DescargarJSON descargarJSON = new DescargarJSON();
            descargarJSON.execute(URL.get(i));
            cont++;
        }
        lista2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder=new AlertDialog.Builder(SeriesMovieDatabase.this);
                builder.setIcon(foto.get(position));
                builder.setTitle("Informacion sobre la serie");
                builder.setMessage("Nombre de la serie: "+titulo.get(position)+
                        "\n Popularidad: "+popularidad.get(position)+
                        "\n Fecha de Salida: "+fecha.get(position)+
                        "\n Descripcion: "+descripcion.get(position));
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();
            }
        });



    }
    void RellenarListView(){
        AdaptadorParaSeries1 adaptadorParaSeries1= new AdaptadorParaSeries1(this,R.layout.plantilla_series,titulo);
        lista2.setAdapter(adaptadorParaSeries1);
        if(cont<URL.size()){
            DescargarJSON descargarJSON = new DescargarJSON();
            descargarJSON.execute(URL.get(cont));
            cont++;
        }

    }
    //Clase que usaremos para leer nuestros datos con JSON
    private class DescargarJSON extends AsyncTask<String, Void, Void> {
        String todo = "";

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void unused) {
            Boolean flag=true;
            super.onPostExecute(unused);
            JsonParser parser = new JsonParser();
            JsonArray jsonArray = parser.parse(todo).getAsJsonObject().getAsJsonArray("results");
            for (JsonElement elemento : jsonArray) {
                if(flag){
                    JsonObject objeto = elemento.getAsJsonObject();
                    titulo.add(objeto.get("name").getAsString());
                    descripcion.add(objeto.get("overview").getAsString());
                    popularidad.add(objeto.get("popularity").getAsString());
                    fecha.add(objeto.get("first_air_date").getAsString());
                    flag=false;
                }
            }
            RellenarListView();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);

        }

        @Override
        protected Void doInBackground(String... strings) {
            String script = strings[0];
            URL url;
            HttpURLConnection httpURLConnection;

            try {
                url = new URL(script);
                httpURLConnection = (HttpURLConnection) url.openConnection();
                if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

                    String linea = "";
                    while ((linea = br.readLine()) != null) {
                        todo += linea;
                        Thread.sleep(100);
                        publishProgress();
                    }
                    br.close();
                    inputStream.close();
                } else {
                    Toast.makeText(SeriesMovieDatabase.this, "No me pude conectar a la nube", Toast.LENGTH_SHORT).show();
                }


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
    //Clase que usaremos para poder adaptar al Layout y que se vea más bonito
    private class AdaptadorParaSeries1 extends ArrayAdapter<String> {

        public AdaptadorParaSeries1(@NonNull Context context, int resource, @NonNull ArrayList<String> objects) {
            super(context, resource, objects);

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            return rellenarFila(position, convertView, parent);
        }

        @Override
        public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            return rellenarFila(position, convertView, parent);
        }

        public View rellenarFila(int posicion, View view, ViewGroup padre) {

            LayoutInflater inflater = getLayoutInflater();
            View mifila = inflater.inflate(R.layout.plantilla_series, padre, false);

            TextView title = mifila.findViewById(R.id.textViewTituloS);
            title.setText(titulo.get(posicion));

            ImageView logo = mifila.findViewById(R.id.imageView);
            logo.setImageResource(foto.get(posicion));

            return mifila;
        }


    }
}
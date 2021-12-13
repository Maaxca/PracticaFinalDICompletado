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

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class ParrilllaTelevisiva extends AppCompatActivity {
    ProgressDialog progressDialog;
    ListView lista;
    ArrayList<String>Canales=new ArrayList<>();
    ArrayList<String>nombre=new ArrayList<>();
    ArrayList<Integer>Fotos=new ArrayList();
    public int cont=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parrillla_televisiva);
        lista=findViewById(R.id.lista2);
        rellenarFotos();
        DescargarXML descargarXML = new DescargarXML();
        descargarXML.execute("https://raw.githubusercontent.com/dracohe/CARLOS/master/guide_IPTV.xml");
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DescargarXML2 descargarXML2 = new DescargarXML2();
                descargarXML2.execute("https://raw.githubusercontent.com/dracohe/CARLOS/master/guide_IPTV.xml",Integer.toString(position));

            }
        });
    }
    void rellenarFotos(){
        Fotos.add(R.drawable.uno);
        Fotos.add(R.drawable.uno);
        Fotos.add(R.drawable.uno);
        Fotos.add(R.drawable.dos);
        Fotos.add(R.drawable.dos);
        Fotos.add(R.drawable.tres);
        Fotos.add(R.drawable.tres);
        Fotos.add(R.drawable.tres);
        Fotos.add(R.drawable.cuatro);
        Fotos.add(R.drawable.cuatro);
        Fotos.add(R.drawable.cuatro);
        Fotos.add(R.drawable.cinco);
        Fotos.add(R.drawable.cinco);
        Fotos.add(R.drawable.cinco);
        Fotos.add(R.drawable.sexta);
        Fotos.add(R.drawable.sexta);
        Fotos.add(R.drawable.sexta);
        Fotos.add(R.drawable.cero);
        Fotos.add(R.drawable.cero);
        Fotos.add(R.drawable.cero);
        Fotos.add(R.drawable.estrenos);
        Fotos.add(R.drawable.estrenos);
        Fotos.add(R.drawable.estrenos2);
        Fotos.add(R.drawable.fest);
        Fotos.add(R.drawable.clasicos);
        Fotos.add(R.drawable.accion);
        Fotos.add(R.drawable.accion);
        Fotos.add(R.drawable.accion);
        Fotos.add(R.drawable.comedia);
        Fotos.add(R.drawable.comedia);
        Fotos.add(R.drawable.comedia);
        Fotos.add(R.drawable.drama);
        Fotos.add(R.drawable.drama);
        Fotos.add(R.drawable.drama);
        Fotos.add(R.drawable.cinee);
        Fotos.add(R.drawable.cinee);
        Fotos.add(R.drawable.series);
        Fotos.add(R.drawable.series2);
        Fotos.add(R.drawable.tnt);
        Fotos.add(R.drawable.tnt);
        Fotos.add(R.drawable.tnt);
        Fotos.add(R.drawable.tcm);
        Fotos.add(R.drawable.tcm);
        Fotos.add(R.drawable.syfy);
        Fotos.add(R.drawable.syfy);
        Fotos.add(R.drawable.syfy);
        Fotos.add(R.drawable.sundance);
        Fotos.add(R.drawable.sundance);
        Fotos.add(R.drawable.hollywood);
        Fotos.add(R.drawable.hollywood);
        Fotos.add(R.drawable.fox);
        Fotos.add(R.drawable.fox);
        Fotos.add(R.drawable.fox);
        Fotos.add(R.drawable.fox);
        Fotos.add(R.drawable.foxhd);
        Fotos.add(R.drawable.foxhd);
        Fotos.add(R.drawable.foxhd);
        Fotos.add(R.drawable.dark);
        Fotos.add(R.drawable.dark);
        Fotos.add(R.drawable.cosmo);
        Fotos.add(R.drawable.cosmo);
        Fotos.add(R.drawable.cosmo);
        Fotos.add(R.drawable.comedycentral);
        Fotos.add(R.drawable.comedycentral);
        Fotos.add(R.drawable.calle);
        Fotos.add(R.drawable.calle);
        Fotos.add(R.drawable.calle);
        Fotos.add(R.drawable.axn);
        Fotos.add(R.drawable.axn);
        Fotos.add(R.drawable.axn);
        Fotos.add(R.drawable.axnwhite);
        Fotos.add(R.drawable.axnwhite);
        Fotos.add(R.drawable.axnwhite);
        Fotos.add(R.drawable.amc);
        Fotos.add(R.drawable.amc);
        Fotos.add(R.drawable.amc);
        Fotos.add(R.drawable.atres);
        Fotos.add(R.drawable.atres);
        Fotos.add(R.drawable.crimen);
        Fotos.add(R.drawable.crimen);
        Fotos.add(R.drawable.dream);
        Fotos.add(R.drawable.fdf);
        Fotos.add(R.drawable.fdf);
        Fotos.add(R.drawable.fdf);
        Fotos.add(R.drawable.energy);
        Fotos.add(R.drawable.divinity);
        Fotos.add(R.drawable.paramount);
        Fotos.add(R.drawable.paramount);
        Fotos.add(R.drawable.mtv);
        Fotos.add(R.drawable.mtv);
        Fotos.add(R.drawable.nova);
        Fotos.add(R.drawable.nova);
        Fotos.add(R.drawable.neox);
        Fotos.add(R.drawable.neox);
        Fotos.add(R.drawable.disneych);
        Fotos.add(R.drawable.disneych);
        Fotos.add(R.drawable.disneyjunior);
        Fotos.add(R.drawable.disneyjunior);
        Fotos.add(R.drawable.baby);
        Fotos.add(R.drawable.nick);
        Fotos.add(R.drawable.nick);
        Fotos.add(R.drawable.nickelodeon);
        Fotos.add(R.drawable.nickelodeon);
        Fotos.add(R.drawable.clan);
        Fotos.add(R.drawable.clan);
        Fotos.add(R.drawable.panda);
        Fotos.add(R.drawable.panda);
        Fotos.add(R.drawable.boing);
        Fotos.add(R.drawable.xtrm);
        Fotos.add(R.drawable.somos);
        Fotos.add(R.drawable.solmusica);
        Fotos.add(R.drawable.beti);
        Fotos.add(R.drawable.real);
        Fotos.add(R.drawable.sevilla);
        Fotos.add(R.drawable.barsa);
        Fotos.add(R.drawable.barsa);
        Fotos.add(R.drawable.vamos);
        Fotos.add(R.drawable.vamos);
        Fotos.add(R.drawable.vamos);
        Fotos.add(R.drawable.gol);
        Fotos.add(R.drawable.gol);
        Fotos.add(R.drawable.gol);
        Fotos.add(R.drawable.mvliga);
        Fotos.add(R.drawable.mvliga);
        Fotos.add(R.drawable.mvliga);
        Fotos.add(R.drawable.mvliga);
        Fotos.add(R.drawable.ligauno);
        Fotos.add(R.drawable.ligados);
        Fotos.add(R.drawable.ligatres);
        Fotos.add(R.drawable.liga4);
        Fotos.add(R.drawable.ligacinco);
        Fotos.add(R.drawable.ligaseis);
        Fotos.add(R.drawable.ligasiete);
        Fotos.add(R.drawable.ligabar);
        Fotos.add(R.drawable.orange);
        Fotos.add(R.drawable.campeones);
        Fotos.add(R.drawable.campeones);
        Fotos.add(R.drawable.campeones);
        Fotos.add(R.drawable.campeones);
        Fotos.add(R.drawable.campeones);
        Fotos.add(R.drawable.campeonesuno);
        Fotos.add(R.drawable.campeonesuno);
        Fotos.add(R.drawable.campeonesuno);
        Fotos.add(R.drawable.campeonesuno);
        Fotos.add(R.drawable.campeonesdos);
        Fotos.add(R.drawable.campeonesdos);
        Fotos.add(R.drawable.campeonesdos);
        Fotos.add(R.drawable.campeonestres);
        Fotos.add(R.drawable.campeonestres);
        Fotos.add(R.drawable.campeonestres);
        Fotos.add(R.drawable.campeonescuatro);
        Fotos.add(R.drawable.campeonescuatro);
        Fotos.add(R.drawable.campeonescuatro);
        Fotos.add(R.drawable.campeones5);
        Fotos.add(R.drawable.campeones6);
        Fotos.add(R.drawable.canpeonessiete);
        Fotos.add(R.drawable.daznf);
        Fotos.add(R.drawable.garege);
        Fotos.add(R.drawable.garege);
        Fotos.add(R.drawable.tdp);
        Fotos.add(R.drawable.tdp);
        Fotos.add(R.drawable.golf);
        Fotos.add(R.drawable.golf);
        Fotos.add(R.drawable.eurosport);
        Fotos.add(R.drawable.eurosportdos);
        Fotos.add(R.drawable.deportes);
        Fotos.add(R.drawable.deportes);
        Fotos.add(R.drawable.deportes);
        Fotos.add(R.drawable.mtvh);
        Fotos.add(R.drawable.mtv);
        Fotos.add(R.drawable.mtv);
        Fotos.add(R.drawable.toros);
        Fotos.add(R.drawable.toros);
        Fotos.add(R.drawable.toros);
        Fotos.add(R.drawable.cazavision);
        Fotos.add(R.drawable.iberalia);
        Fotos.add(R.drawable.caza);
        Fotos.add(R.drawable.caza);
        Fotos.add(R.drawable.caza);
        Fotos.add(R.drawable.viajar);
        Fotos.add(R.drawable.viajar);
        Fotos.add(R.drawable.ten);
        Fotos.add(R.drawable.ten);
        Fotos.add(R.drawable.odisea);
        Fotos.add(R.drawable.odisea);
        Fotos.add(R.drawable.nat);
        Fotos.add(R.drawable.nat);
        Fotos.add(R.drawable.wild);
        Fotos.add(R.drawable.wild);
        Fotos.add(R.drawable.wild);
        Fotos.add(R.drawable.wild);
        Fotos.add(R.drawable.inter);
        Fotos.add(R.drawable.dkiss);
        Fotos.add(R.drawable.mega);
        Fotos.add(R.drawable.mega);
        Fotos.add(R.drawable.historia);
        Fotos.add(R.drawable.historia);
        Fotos.add(R.drawable.dmax);
        Fotos.add(R.drawable.dmax);
        Fotos.add(R.drawable.discovery);
        Fotos.add(R.drawable.discovery);
        Fotos.add(R.drawable.decasa);
        Fotos.add(R.drawable.decasa);
        Fotos.add(R.drawable.cocina);
        Fotos.add(R.drawable.cocina);
        Fotos.add(R.drawable.blaze);
        Fotos.add(R.drawable.blaze);
        Fotos.add(R.drawable.bemad);
        Fotos.add(R.drawable.bemad);
        Fotos.add(R.drawable.trece);
        Fotos.add(R.drawable.horas);
        Fotos.add(R.drawable.canalsur);
        Fotos.add(R.drawable.canalsur);
        Fotos.add(R.drawable.andalucia);
        Fotos.add(R.drawable.tvg);
        Fotos.add(R.drawable.tvg);
        Fotos.add(R.drawable.tvg);
        Fotos.add(R.drawable.telemadrid);
        Fotos.add(R.drawable.telemadrid);
        Fotos.add(R.drawable.laotra);
        Fotos.add(R.drawable.casman);
        Fotos.add(R.drawable.casman);
        Fotos.add(R.drawable.etb);
        Fotos.add(R.drawable.etb);
        Fotos.add(R.drawable.etb);
        Fotos.add(R.drawable.extre);
        Fotos.add(R.drawable.extre);
        Fotos.add(R.drawable.cat);
        Fotos.add(R.drawable.asturias);
        Fotos.add(R.drawable.aragon);
        Fotos.add(R.drawable.aragon);
        Fotos.add(R.drawable.siete);
        Fotos.add(R.drawable.punt);
        Fotos.add(R.drawable.bom);
        Fotos.add(R.drawable.beteve);
        Fotos.add(R.drawable.baleares);
        Fotos.add(R.drawable.baleares);
        Fotos.add(R.drawable.canarias);
        Fotos.add(R.drawable.murcia);
        Fotos.add(R.drawable.esport);
        Fotos.add(R.drawable.ocho);
        Fotos.add(R.drawable.cadiz);
        Fotos.add(R.drawable.levante);
        Fotos.add(R.drawable.murcia);
        Fotos.add(R.drawable.dazn);
        Fotos.add(R.drawable.dazn2);
        Fotos.add(R.drawable.dazn3);
        Fotos.add(R.drawable.dazn4);
        Fotos.add(R.drawable.redbull);
        Fotos.add(R.drawable.deportes);
        Fotos.add(R.drawable.dazn);
        Fotos.add(R.drawable.resistencia);
        Fotos.add(R.drawable.biogra);
        Fotos.add(R.drawable.nautical);

    }
    private class DescargarXML extends AsyncTask<String, Void, Void> {
        String todo="" ;
        ArrayAdapter<String> adapter;
        ArrayList<String> list;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(ParrilllaTelevisiva.this);
            progressDialog.setTitle("Descargando datos...");
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.setIndeterminate(true);
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            adapter = new ParrilllaTelevisiva.AdaptadorParaSeries1(getApplicationContext(),R.layout.plantilla_series,list);
            lista.setAdapter(adapter);
            progressDialog.dismiss();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
            progressDialog.setProgress(progressDialog.getVolumeControlStream() + 10);

        }

        @Override
        protected Void doInBackground(String... strings) {
            String script = strings[0];
            URL url;
            HttpURLConnection httpURLConnection;

            try {
                url = new URL(script);
                httpURLConnection = (HttpURLConnection) url.openConnection();
                list= new ArrayList<String>();
                if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                    DocumentBuilder db = dbf.newDocumentBuilder();
                    Document doc = db.parse(new URL(url.toString()).openStream());
                    Element raiz = doc.getDocumentElement();
                    NodeList hijos = raiz.getChildNodes();

                    for (int i = 0; i < hijos.getLength(); i++) {
                        Node nodo = hijos.item(i);

                        if (nodo instanceof Element ) {
                            if(nodo.getNodeName().compareTo("channel")==0) {
                                NodeList nietos = nodo.getChildNodes();
                                for (int j = 0; j < nietos.getLength()-2; j++) {
                                    todo += nietos.item(j).getTextContent();
                                    if(nietos.item(j).getNodeName().compareTo("display-name")==0){
                                        nombre.add(nietos.item(j).getTextContent());
                                    }
                                }
                                list.add(todo);
                                todo = "";
                            }
                            }

                    }
                } else {
                    Toast.makeText(ParrilllaTelevisiva.this, "No me pude conectar a la nube", Toast.LENGTH_SHORT).show();
                }
                Thread.sleep(2000);


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
    private class DescargarXML2 extends AsyncTask<String, Void, Void> {
        String todo="" ;
        int algo;
        List<String> list;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(ParrilllaTelevisiva.this);
            progressDialog.setTitle("Descargando datos... Esto puede tardar un ratillo...");
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.setIndeterminate(true);
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            progressDialog.dismiss();
            AlertDialog.Builder builder=new AlertDialog.Builder(ParrilllaTelevisiva.this);
            builder.setTitle("Programacion del canal "+nombre.get(algo));
            for(int i =0;i<Canales.size();i++){
                builder.setMessage("\n"+Canales.get(i));
            }
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Canales.removeAll(Canales);
                }
            });
            builder.show();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);

        }

        @Override
        protected Void doInBackground(String... strings) {
            String script = strings[0];
            int posicion=Integer.parseInt(strings[1]);
            algo=posicion;
            URL url;
            HttpURLConnection httpURLConnection;

            try {
                url = new URL(script);
                httpURLConnection = (HttpURLConnection) url.openConnection();
                list= new ArrayList<String>();
                if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                    DocumentBuilder db = dbf.newDocumentBuilder();
                    Document doc = db.parse(new URL(url.toString()).openStream());
                    Element raiz = doc.getDocumentElement();
                    NodeList hijos = raiz.getChildNodes();

                    for (int i = 0; i < hijos.getLength(); i++) {
                        Node nodo = hijos.item(i);

                        if (nodo instanceof Element ) {
                            if(nodo.getNodeName().compareTo("programme")==0) {
                                if(((Element) nodo).getAttribute("channel").compareTo(nombre.get(posicion))==0) {
                                    NodeList nietos = nodo.getChildNodes();
                                    for (int j = 0; j < nietos.getLength(); j++) {
                                        todo += nietos.item(j).getTextContent();
                                    }
                                    Canales.add(todo);
                                }
                            }
                        }
                    }
                } else {
                    Toast.makeText(ParrilllaTelevisiva.this, "No me pude conectar a la nube", Toast.LENGTH_SHORT).show();
                }
                Thread.sleep(2000);


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
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
            title.setText(nombre.get(posicion));

            ImageView logo = mifila.findViewById(R.id.imageView);
            logo.setImageResource(Fotos.get(posicion));

            return mifila;
        }


    }
}
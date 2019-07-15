package org.pusillusgrex.pusilluxgrexapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import org.pusillusgrex.pusilluxgrexapp.models.Publicacao;
import org.pusillusgrex.pusilluxgrexapp.models.Tag;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(toogle);
        toogle.syncState();

        navigationView = findViewById(R.id.navView);
        navigationView.setNavigationItemSelectedListener(this);


        TextView textView = findViewById(R.id.textview);

        XmlPullParserFactory pullParserFactory;

        try {
            pullParserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = pullParserFactory.newPullParser();

            InputStream in_s = getApplicationContext().getAssets().open("pusillusgrex.xml");
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in_s, null);

            ArrayList<Publicacao> publicacaos =  parseXML(parser);

            String text="";

            for(Publicacao publicacao:publicacaos)
            {

                text+= publicacao.toString();
            }

            textView.setText(text);



        } catch (XmlPullParserException e) {

            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private ArrayList<Publicacao> parseXML(XmlPullParser parser) throws XmlPullParserException,IOException
    {
        ArrayList<Publicacao> publicacoes = null;
        ArrayList<Tag> categorias = null;
        int eventType = parser.getEventType();
        Publicacao publicacao = null;

        while (eventType != XmlPullParser.END_DOCUMENT){
            String nomeTag;
            switch (eventType){
                case XmlPullParser.START_DOCUMENT: {
                    publicacoes = new ArrayList<>();
                    break;
                }
                case XmlPullParser.START_TAG:{
                    nomeTag = parser.getName();
                    if(nomeTag.equalsIgnoreCase("publicacao")){
                        publicacao = new Publicacao();
                    }
                    else if(publicacao != null){
                        switch (nomeTag.toLowerCase()){
                            case "titulo": {
                                publicacao.setTitulo(parser.nextText());
                                break;
                            }
                            case "data": {
                                publicacao.setData(LocalDate.parse(parser.nextText()));
                                //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");
                                //publicacao.setData(LocalDate.parse(parser.nextText()));
                                break;
                            }
                            case "categorias": {
                                categorias = new ArrayList<>();
                                break;
                            }
                            case "categoria": {
                                categorias.add(Tag.valueOf(parser.nextText().toUpperCase()));
                                break;
                            }
                            case "midia": {
                                publicacao.setUrlMidia(parser.nextText());
                                break;
                            }
                            case "imagem": {
                                publicacao.setUrlImagem(parser.nextText());
                                break;
                            }
                            case "descricao": {
                                publicacao.setDescricao(parser.nextText());
                                break;
                            }
                            case "texto": {
                                publicacao.setTexto(parser.nextText());
                                break;
                            }
                        }
                    }
                    break;
                }
                case XmlPullParser.END_DOCUMENT:{
                    nomeTag = parser.getName();
                    if(nomeTag.equalsIgnoreCase("publicacao") && publicacao != null){
                        publicacoes.add(publicacao);
                    }
                }
            }
            eventType = parser.next();
        }
        return publicacoes;
    }



    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.menu_ajude: {
                Toast.makeText(this, "Menu ajude-nos", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.menu_aulas: {
                Toast.makeText(this, "Menu Aulas", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.menu_compartilhar: {
                Toast.makeText(this, "Menu Compartilhar", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.menu_contato: {
                Toast.makeText(this, "Menu Contato", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.menu_espiritualidade_formacao: {
                Toast.makeText(this, "Menu Espiritualidade e Formação", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.menu_ibp: {
                Toast.makeText(this, "Menu IBP pelo mundo", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.menu_informacao: {
                Toast.makeText(this, "Menu Sobre o IBP", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.menu_inicio: {
                Toast.makeText(this, "Menu Início", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.menu_liturgia: {
                Toast.makeText(this, "Menu Liturgia", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.menu_midia: {
                Toast.makeText(this, "Menu Mídia", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.menu_sermoes: {
                Toast.makeText(this, "Menu Sermões", Toast.LENGTH_SHORT).show();
                break;
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}

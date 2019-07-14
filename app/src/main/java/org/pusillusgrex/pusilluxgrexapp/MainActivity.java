package org.pusillusgrex.pusilluxgrexapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

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

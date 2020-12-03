package com.samiaza.sentinela.v3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;



public class Pag_inicial extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private FloatingActionButton floatingActionButton;

    private TextView nomeLogado;
    private TextView emailLogado;

    private FirebaseAuth autenticacao;
    private FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pag_inicial);

        autenticacao = FirebaseAuth.getInstance();

        nomeLogado = findViewById(R.id.txtv_nomeusuario);
        emailLogado = findViewById(R.id.txtv_emailusuario);


        floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirApontamento();
            }
        });

        floatingActionButton = findViewById(R.id.fabmed);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirApontamentoMed();
            }
        });

        toolbar = findViewById(R.id.toobar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_drawer,R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView= findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {

        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_options,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id == R.id.opcoes){
            deslogarUsuario();
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_home:{
                Toast.makeText(this,"menu inicial",Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.nav_glicose:{
                abrirGlicose();
                break;
            }
            case R.id.nav_pressao:{
                abrirPressao();
                break;
            }

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void abrirApontamento(){
        Intent intent = new Intent(Pag_inicial.this, Apontamento.class);
        startActivity(intent);
    }

    private void abrirApontamentoMed(){
        Intent intent = new Intent(Pag_inicial.this, Apontamento_remedio.class);
        startActivity(intent);
    }

    private void deslogarUsuario(){
        autenticacao.signOut();
        Toast.makeText(Pag_inicial.this,"Usuarios desconectado",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Pag_inicial.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void abrirGlicose(){
        Intent intent = new Intent(Pag_inicial.this, Glicose.class);
        startActivity(intent);
    }

    private void abrirPressao(){
        Intent intent = new Intent(Pag_inicial.this, PressaoCardiaca.class);
        startActivity(intent);
    }


}

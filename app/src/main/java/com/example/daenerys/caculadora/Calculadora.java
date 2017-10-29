package com.example.daenerys.caculadora;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Calculadora extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

        String resposta = "";
        TextView tela;
        Integer resultado;
        String operando = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tela = (TextView) findViewById(R.id.textViewResultado);
        resultado = 0;

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }//onCreate


 //Códigos funcionalidade da calculadora

    public void um(View v){
        resposta +="1";
        tela.setText(resposta);
    }//um

    public void dois(View v){
        resposta +="2";
        tela.setText(resposta);
    }//dois

    public void tres(View v){
        resposta +="3";
        tela.setText(resposta);
    }//tres

    public void quatro(View v){
        resposta +="4";
        tela.setText(resposta);
    }//quatro

    public void cinco(View v){
        resposta +="5";
        tela.setText(resposta);
    }//cinco

    public void seis(View v){
        resposta +="6";
        tela.setText(resposta);
    }//seis

    public void sete(View v){
        resposta +="7";
        tela.setText(resposta);
    }//sete

    public void oito(View v){
        resposta +="8";
        tela.setText(resposta);
    }//oito

    public void nove(View v){
        resposta +="9";
        tela.setText(resposta);
    }//nove

    public void zero(View v){
        resposta +="0";
        tela.setText(resposta);
    }//nove


    //Operações//-------------------------------------------------------

    public void somar(View v){
        tela.setText("");
        operando = "+";
        resultado = Integer.parseInt(resposta);
        resposta = "";
    }//somar

    public void subtrair(View v){
        tela.setText("");
        resposta = "";
    }//subtrair

    public void multiplicar(View v){
        tela.setText("");
        resposta = "";
    }//multiplicar

    public void dividir(View v){
        tela.setText("");
        resposta = "";
    }//dividir

    public void igual(View v){
        if(operando.equals("+")){ //usar um case para operandos retratar o igual para cada operando
            resposta = tela.getText().toString();
            resultado += Integer.parseInt(resposta); //ifeal tirar essa funcionalidade para um método
                                                    //que recebe um operando
        }

        tela.setText(String.valueOf(resultado.toString()));
    }//igual


 //Parte responsável para o uso do Drawermenu//------------------------
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }//onBackPressed

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.calculadora, menu);
        return true;
    }//onCreateOptionMenu

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }//onOptionsItemSelected

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }//onNavigationItemSelected
}

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
import android.widget.Toast;

import java.util.ArrayList;

public class Calculadora extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

        String resposta = "";
        TextView tela;
        Integer acumulado;
        String operando = "";
        String historico = "";
        ArrayList<String> listaHistorico = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tela = (TextView) findViewById(R.id.textViewResultado);
        acumulado = 0;

        tela.setText("0");

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
        historico +="1";
        tela.setText(resposta);
    }//um

    public void dois(View v){
        resposta +="2";
        historico +="2";
        tela.setText(resposta);
    }//dois

    public void tres(View v){
        resposta +="3";
        historico +="3";
        tela.setText(resposta);
    }//tres

    public void quatro(View v){
        resposta +="4";
        historico +="4";
        tela.setText(resposta);
    }//quatro

    public void cinco(View v){
        resposta +="5";
        historico +="5";
        tela.setText(resposta);
    }//cinco

    public void seis(View v){
        resposta +="6";
        historico +="6";
        tela.setText(resposta);
    }//seis

    public void sete(View v){
        resposta +="7";
        historico +="7";
        tela.setText(resposta);
    }//sete

    public void oito(View v){
        resposta +="8";
        historico +="8";
        tela.setText(resposta);
    }//oito

    public void nove(View v){
        resposta +="9";
        historico +="9";
        tela.setText(resposta);
    }//nove

    public void zero(View v){
        resposta +="0";
        historico +="0";
        tela.setText(resposta);
    }//nove


    //Operações//-------------------------------------------------------

    public void somar(View v){
        historico +=" + ";
        calcula();
        //se você digitou algo na tela, resposta não será nula
        if(!resposta.equals("")){
            operando = "+";
        }

        resposta = "";
        tela.setText(resposta);
    }//somar

    public void subtrair(View v){
        historico +=" - ";
        calcula();

        if(!resposta.equals("")){
            operando = "-";
        }//if

        resposta = "";
        tela.setText(resposta);
    }//subtrair

    public void multiplicar(View v){
        calcula();

        if(!resposta.equals("")){
            operando = "*";
        }//if

        resposta = "";
        tela.setText(resposta);
    }//multiplicar

    public void dividir(View v){
        calcula();

        if(!resposta.equals("")){
            operando = "/";
        }//if

        resposta = "";
        tela.setText(resposta);
    }//dividir

    public void porcetagem(View v){
        calcula();

        if(!resposta.equals("")){
            operando = "%";
        }//if

        resposta = "";
        tela.setText(resposta);
    }//porcetagem

    public void raiz(View v){
        acumulado = (int) Math.sqrt(Double.parseDouble(resposta));
        resposta = String.valueOf(acumulado);
        tela.setText(resposta);
        operando = "";
    }//raiz

    public void potenciaDois(View v){
        acumulado = (int) Math.pow(Double.parseDouble(resposta), 2);
        resposta = String.valueOf(acumulado);
        tela.setText(resposta);
        operando = "";
    }

    public void igual(View v){
        calcula();
        resposta = String.valueOf(acumulado);
        historico += " = " + resposta;//detalhe a prestar atenção
        tela.setText(resposta);
        operando = "";
        Toast.makeText(this, historico,Toast.LENGTH_SHORT).show();
        historico = resposta;
    }//igual


    public void calcula(){
        if(operando.equals("+")){ //usar um case para operandos retratar o igual para cada operando
            acumulado += Integer.parseInt(resposta);
        }else if (operando.equals("-")){
            acumulado -= Integer.parseInt(resposta);
        }else if(operando.equals("*")){
            acumulado *= Integer.parseInt(resposta);
        }else if (operando.equals("/")){
            if (Integer.parseInt(resposta) > 0) acumulado = acumulado / Integer.parseInt(resposta);
        }else if (operando.equals("%")){
            int v = Integer.parseInt(resposta);
            acumulado = (acumulado * v)/100;
        }else{
            if(!resposta.equals("")) acumulado = Integer.parseInt(resposta);
        }

    }//calcula

    public void limpar(View v){
        resposta = "";
        operando = "";
        acumulado = 0;
        historico = "";
        tela.setText(resposta);
    } //limpar



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

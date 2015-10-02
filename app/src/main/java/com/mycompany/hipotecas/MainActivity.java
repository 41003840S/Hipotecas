package com.mycompany.hipotecas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText preuInmoble, estalvis,plaç, euribor, diferencial;
    private TextView mensual, total;
    private double capital, interes, plaç2, cuota;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preuInmoble = (EditText) findViewById(R.id.ed_preuInmoble);
        estalvis = (EditText) findViewById(R.id.ed_estalvis);
        plaç = (EditText) findViewById(R.id.ed_plaç);
        euribor = (EditText) findViewById(R.id.ed_euribor);
        diferencial = (EditText) findViewById(R.id.ed_diferencial);
        mensual = (TextView) findViewById(R.id.tv_mensual);
        total = (TextView) findViewById(R.id.tv_total);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

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
    }

    public void onClick(View view) {

        capital = Double.parseDouble(preuInmoble.getText().toString())-Double.parseDouble(estalvis.getText().toString());
        interes = Double.parseDouble(euribor.getText().toString())+Double.parseDouble(diferencial.getText().toString());
        plaç2 = Double.parseDouble(plaç.getText().toString())*12;

        cuota = (capital*(interes/12))/(100*(1-(Math.pow((1+(interes/12)/100), -plaç2))));

        float mens = (float) cuota;
        float tot = (float) (cuota*plaç2);

        mensual.setText(String.valueOf(mens));
        total.setText(String.valueOf(tot));
    }

}

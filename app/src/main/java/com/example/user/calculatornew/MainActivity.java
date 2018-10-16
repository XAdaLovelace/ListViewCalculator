package com.example.user.calculatornew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText x1Integer, dMulti;
    RadioButton Geo,Ari;
    double X1, multi;
    boolean type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dMulti = (EditText)findViewById(R.id.dMulti);
        x1Integer = (EditText)findViewById(R.id.x1Integer);
        Geo = (RadioButton)findViewById(R.id.Geo);
        Ari = (RadioButton)findViewById(R.id.Ari);

    }

    public void SecondActivity(View view) {
        //CHECK IF THE USER IS NOT FILLING THE NEEDED FIELDS
        //CHECK IF THE USER DOESN'T CHECK ANY RADIO-BOX
        if(x1Integer.getText().toString().equals("") || x1Integer.getText().toString().equals("-") || x1Integer.getText().toString().equals("+") ||  x1Integer.getText().toString().equals("-.") ||  x1Integer.getText().toString().equals("+.") ||
                dMulti.getText().toString().equals("") || dMulti.getText().toString().equals("-") || dMulti.getText().toString().equals("+") ||  dMulti.getText().toString().equals("-.") ||  dMulti.getText().toString().equals("+.") ||
                (!Geo.isChecked()&& !Ari.isChecked())){
            Toast.makeText(MainActivity.this,"Error" ,Toast.LENGTH_LONG).show();
        }else{
            X1 = Double.parseDouble(x1Integer.getText().toString());
            multi = Double.parseDouble(dMulti.getText().toString());
            //CHECKS WHICH ONE OF THE RADIOS IS CHECKED
            if (Geo.isChecked()) {
                type = true;
            }
            if (!Ari.isChecked()){
                type = false;
            }
            //BASIC DELIVERY
            Intent t = new Intent(this, SecondActivity.class);

            t.putExtra("x1", X1);
            t.putExtra("multi", multi);
            t.putExtra("type", type);

            startActivity(t);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){

        Toast.makeText(MainActivity.this,"Credit to the GOAT teacher Albert" ,Toast.LENGTH_LONG).show();

        return true;
    }

}
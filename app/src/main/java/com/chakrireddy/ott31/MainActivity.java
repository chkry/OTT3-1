package com.chakrireddy.ott31;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView mostImp = (TextView) findViewById(R.id.mostImportant);
//      //  Read SharedPreferences
//        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPref.edit();
//        editor.putString(getString(R.string.chkry_name),value1);
//        editor.commit();


        //Write SharedPreferences
//        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
//        String newValue = getResources().getString(R.string.chkry_name);
//        String finalValue = sharedPref.getString(getString(R.string.chkry_name),newValue);


        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        String newValue = "Most Important Value";
        String finalValue = sharedPref.getString("MOSTIMP", newValue);

        mostImp.setText(finalValue);


        mostImp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // WriteTempValue
                SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                String value1 = "This is updated Value";
                editor.putString("MOSTIMP", value1);
                editor.commit();


                //ReadAgain
                String newValue = "Most Important Value";
                String finalValue = sharedPref.getString("MOSTIMP", newValue);
                mostImp.setText(finalValue);
            }
        });
    }//E.O.OnCreate


}//E.O.Activity

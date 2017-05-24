package com.chakrireddy.ott31;

/*
  //Read SharedPreferences
       SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
       SharedPreferences.Editor editor = sharedPref.edit();
       editor.putString(getString(R.string.chkry_name),value1);
       editor.commit();
  //Write SharedPreferences
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        String newValue = getResources().getString(R.string.chkry_name);
        String finalValue = sharedPref.getString(getString(R.string.chkry_name),newValue);
* */
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView firstpref = (TextView) findViewById(R.id.firstImportant);
        final TextView secondpref = (TextView) findViewById(R.id.secondImportant);
        final TextView thirdpref = (TextView) findViewById(R.id.thirdImportant);
        final TextView mostImp = (TextView) findViewById(R.id.mostImportant);
        final TextView instructions = (TextView) findViewById(R.id.instructions);
        final TextView about = (TextView) findViewById(R.id.about);
        final TextView contact = (TextView) findViewById(R.id.contact);

        firstpref.setOnClickListener(this);
        secondpref.setOnClickListener(this);
        thirdpref.setOnClickListener(this);
        instructions.setOnClickListener(this);
        about.setOnClickListener(this);
        contact.setOnClickListener(this);

        readAllValues("1st Important Thing", "FIRSTPREFERENCE", firstpref);
        readAllValues("2nd Important Thing", "SECONDPREFERENCE", secondpref);
        readAllValues("3rd Important Thing", "THIRDPREFERENCE", thirdpref);
        readAllValues("Most Important Thing", "FIRSTPREFERENCE", mostImp);


    }//E.O.OnCreate

    @Override
    public void onClick(View view) {
        final int id = view.getId();
        switch (id) {
            case R.id.firstImportant:
                TextView firstpref = (TextView) findViewById(R.id.firstImportant);
                alertdialogupdater("First Important Thing", firstpref, "FIRSTPREFERENCE");

                break;
            case R.id.secondImportant:
                TextView secondpref = (TextView) findViewById(R.id.secondImportant);
                alertdialogupdater("Second Important Thing", secondpref, "SECONDPREFERENCE");
                break;
            case R.id.thirdImportant:
                TextView thirdpref = (TextView) findViewById(R.id.thirdImportant);
                alertdialogupdater("Third Important Thing", thirdpref, "THIRDPREFERENCE");
                break;
            case R.id.instructions:
                Intent instruction = new Intent(MainActivity.this, Instructions.class);
                startActivity(instruction);
                break;
            case R.id.about:
                Intent about = new Intent(MainActivity.this, About.class);
                startActivity(about);
                break;
            case R.id.contact:
                Intent contact = new Intent(MainActivity.this, Contact.class);
                startActivity(contact);
                break;
        }
    }

    public void alertdialogupdater(final String titlename, final TextView txtview, final String preferencename) {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle(titlename);
        final EditText input = new EditText(MainActivity.this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        input.setLayoutParams(lp);
        alertDialog.setView(input);
        alertDialog.setPositiveButton("Update",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        String textinput = input.getText().toString();

                        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putString(preferencename, textinput);
                        editor.apply();

                        if (preferencename.equals("FIRSTPREFERENCE")) {
                            String finalValue = sharedPref.getString(preferencename, titlename);
                            txtview.setText(finalValue);
                            TextView mostImp = (TextView) findViewById(R.id.mostImportant);
                            mostImp.setText(finalValue);
                        } else {
                            String finalValue = sharedPref.getString(preferencename, titlename);
                            txtview.setText(finalValue);
                        }
                    }
                });

        alertDialog.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        alertDialog.show();

    }


    public void readAllValues(String defaultValue, String preferenceValue, TextView txtview) {
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        String finalValue = sharedPref.getString(preferenceValue, defaultValue);
        txtview.setText(finalValue);
    }
}//E.O.Activity

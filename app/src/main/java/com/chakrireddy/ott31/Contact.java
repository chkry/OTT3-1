package com.chakrireddy.ott31;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

public class Contact extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_activity);

        LinearLayout website = (LinearLayout) findViewById(R.id.websitelayout);
        website.setOnClickListener(this);

        LinearLayout instagram = (LinearLayout) findViewById(R.id.instagramlayout);
        instagram.setOnClickListener(this);

        LinearLayout linkedin = (LinearLayout) findViewById(R.id.linkedinlayout);
        linkedin.setOnClickListener(this);

        LinearLayout email = (LinearLayout) findViewById(R.id.emaillayout);
        email.setOnClickListener(this);


    } //E.O.Oncreate

    @Override
    public void onClick(View view) {
        final int id = view.getId();

        switch (id) {
            case R.id.websitelayout:
                startBrowserActivity("http://www.chakrireddy.com", "empty");
                break;
            case R.id.instagramlayout:
                startBrowserActivity("http://www.instagram.com/chkry", "com.instagram.android");
                break;
            case R.id.linkedinlayout:
                startBrowserActivity("http://www.linkedin.com/in/chkry", "com.linkedin.android");
                break;
            case R.id.emaillayout:
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"chkry@icloud.com"});
                email.putExtra(Intent.EXTRA_SUBJECT, "OTT 3/1 - Email Response");
                //need this to prompts email client only
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email client :"));
                break;
        }

    } //E.o.OnClick


    public void startBrowserActivity(String str, String pack) {

        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(str));

        browserIntent.setPackage(pack);

        try {
            startActivity(browserIntent);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse(str)));
        }

    }
}

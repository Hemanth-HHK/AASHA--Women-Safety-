package com.example.Team7.Aasha;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Team7.Aasha.R;

import java.util.HashMap;


public class PeopleSecond extends AppCompatActivity {

    ImageButton backButton;


    SmsManager sm;
    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7;
    TextView tt1,tt2,tt3,tt4,tt5,tt6;
    ImageButton edit;


    // Session Manager Class
    SessionManager session;


    public static final String DEFAULT="N/A";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.people_second);
        Button btn = (Button) findViewById(R.id.button2);

        Toolbar tb = (Toolbar) findViewById(R.id.toolbar1);
        backButton = (ImageButton) findViewById(R.id.back);
        // title = (TextView) findViewById(R.id.toolbar_title);

        //  title.setText(R.string.welcome);
        backButton.setVisibility(View.VISIBLE);
        backButton.setImageResource(R.drawable.ic_keyboard_arrow_left_24dp);
//    notificationIcon.setImageResource(R.drawable.notification);
//    notificationIcon.setVisibility(View.VISIBLE);

        setSupportActionBar(tb);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.title);
        //  getSupportActionBar().setTitle("Help");
        TextView tv= (TextView) findViewById(R.id.ab);
        tv.setText(R.string.savedcontacts);
        // Session Manager
        session = new SessionManager(getApplicationContext());
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                send();
            }
        });
        // Email, Password input text
        tv1 = (TextView) findViewById(R.id.textview1);
        tv2 = (TextView) findViewById(R.id.textview2);
        tv3 = (TextView) findViewById(R.id.textview3);
        tv4 = (TextView) findViewById(R.id.textview4);
        tv5 = (TextView) findViewById(R.id.textview5);
        tv6 = (TextView) findViewById(R.id.textview6);
        //Toast.makeText(getApplicationContext(), "User Login Status: " + session.isLoggedIn(), Toast.LENGTH_LONG).show();

        tt1=(TextView) findViewById(R.id.contact1);
        tt2=(TextView) findViewById(R.id.contact2);
        tt3=(TextView) findViewById(R.id.contact3);
        tt4=(TextView) findViewById(R.id.contact4);
        tt5=(TextView) findViewById(R.id.contact5);
        tt6=(TextView) findViewById(R.id.contact6);


        // Login button
        edit = (ImageButton) findViewById(R.id.edit);
        session.checkStatusOfContactsAdd();

        HashMap<String, String> user = session.getUserDetails();

        String number1 = user.get(SessionManager.CONTACT1);
        // name
        String number2 = user.get(SessionManager.CONTACT2);

        // email
        String number3 = user.get(SessionManager.CONTACT3);
        String number4 = user.get(SessionManager.CONTACT4);
        String number5 = user.get(SessionManager.CONTACT5);
        String number6 = user.get(SessionManager.CONTACT6);

        String namee1 = user.get(SessionManager.nameee1);
        String namee2 = user.get(SessionManager.nameee2);
        String namee3 = user.get(SessionManager.nameee3);
        String namee4 = user.get(SessionManager.nameee4);
        String namee5 = user.get(SessionManager.nameee5);
        String namee6 = user.get(SessionManager.nameee6);


        // displaying user data
        tv1.setText(number1);
        tv2.setText(number2);
        tv3.setText(number3);
        tv4.setText(number4);
        tv5.setText(number5);
        tv6.setText(number6);

        tt1.setText(namee1);
        tt2.setText(namee2);
        tt3.setText(namee3);
        tt4.setText(namee4);
        tt5.setText(namee5);
        tt6.setText(namee6);


        // Login button click event
        edit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                session.logoutUser();

            }
        });



        //Location
        GPSTracker mGPS = new GPSTracker(this);

        tv7 = (TextView) findViewById(R.id.texts);
        if(mGPS.canGetLocation ){
            mGPS.getLocation();
            tv7.setText(  mGPS.getLatitude() + "," + mGPS.getLongitude());

        }else{
            tv7.setText("Unabletofind");
//            System.out.println("Unable");
        }



        tv1= (TextView) findViewById(R.id.textview1);


        tv2= (TextView) findViewById(R.id.textview2);

        tv3= (TextView) findViewById(R.id.textview3);

        tv4= (TextView) findViewById(R.id.textview4);

        tv5= (TextView) findViewById(R.id.textview5);

        tv6= (TextView) findViewById(R.id.textview6);

        tt1=(TextView) findViewById(R.id.contact1);
        tt2=(TextView) findViewById(R.id.contact2);
        tt3=(TextView) findViewById(R.id.contact3);
        tt4=(TextView) findViewById(R.id.contact4);
        tt5=(TextView) findViewById(R.id.contact5);
        tt6=(TextView) findViewById(R.id.contact6);





        sm=SmsManager.getDefault();



    }



    public void send(){

        sm.sendTextMessage(tv1.getText().toString(),null,"I'm in danger..My current location is http://maps.google.com/?q="+tv7.getText().toString(),null,null);
        sm.sendTextMessage(tv2.getText().toString(),null,"I'm in danger..My current location is http://maps.google.com/?q="+tv7.getText().toString(),null,null);
        sm.sendTextMessage(tv3.getText().toString(),null,"I'm in danger..My current location is http://maps.google.com/?q="+tv7.getText().toString(),null,null);
        sm.sendTextMessage(tv4.getText().toString(),null,"I'm in danger..My current location is http://maps.google.com/?q="+tv7.getText().toString(),null,null);
        sm.sendTextMessage(tv5.getText().toString(),null,"I'm in danger..My current location is http://maps.google.com/?q="+tv7.getText().toString(),null,null);
        sm.sendTextMessage(tv6.getText().toString(),null,"I'm in danger..My current location is http://maps.google.com/?q="+tv7.getText().toString(),null,null);

        Toast.makeText(this,"message sent",Toast.LENGTH_LONG).show();

    }
    public void back(View v) {

        Intent i = new Intent(getApplicationContext(), NavigationAlert.class);
        startActivity(i);


    }

}


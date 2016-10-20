package com.example.irfan.sharedpreferencestugas1;

import java.util.HashMap;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    SessionManager session;
    Button btnLogout, btnsubmit;
    EditText nim, nama;
    public static final String KEY_SHARED = "nim_key";
    public static final String KEY_SHARED_TWO = "nama_key";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        session = new SessionManager(getApplicationContext());
        TextView lblName = (TextView) findViewById(R.id.lblNama);
        TextView lblEmail = (TextView) findViewById(R.id.lblEmail);
        btnLogout = (Button) findViewById(R.id.btnLogout);
        Toast.makeText(getApplicationContext(), "User Login Status: " +
                session.isLoggedIn(), Toast.LENGTH_LONG).show();
        session.checkLogin();
        HashMap<String, String> user = session.getUserDetails();
        String name = user.get(SessionManager.KEY_NAME);
        String email = user.get(SessionManager.KEY_EMAIL);
        lblName.setText(Html.fromHtml("Name: <b>" + name + "</b>"));
        lblEmail.setText(Html.fromHtml("Email: <b>" + email + "</b>"));

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * misalnya kita akan ambil valuenya dari apa yang
                 * kita input di EditText
                 */
                String ni = nim.getText().toString();
                String na = nama.getText().toString();

                /**
                 * selanjutnya kita akan mengirim value ini ke Activity selanjutnya
                 */
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString(KEY_SHARED, ni);
                edit.putString(KEY_SHARED_TWO, na);
                edit.commit();

                Intent intent = new Intent(MainActivity.this, BiodataActivity.class);
                startActivity(intent);
            }
        });






        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                session.logoutUser();
                finish();
            }
        });


    }
}
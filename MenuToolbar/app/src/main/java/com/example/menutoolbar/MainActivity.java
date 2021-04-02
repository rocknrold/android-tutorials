package com.example.menutoolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    private TextView tvSpeed;
    private TextView tvThemeColor;
    private SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSpeed= (TextView) findViewById(R.id.tvSpeed);
        tvThemeColor = (TextView) findViewById(R.id.tvThemeColor);

        sharedPref = getSharedPreferences("mySettings", MODE_PRIVATE);
        if(sharedPref.getString("SPEED", null) != ""){
            tvSpeed.setText(sharedPref.getString("SPEED",null));
        }
        if(sharedPref.getString("THEME_COLOR",null) != ""){
            tvThemeColor.setText(sharedPref.getString("THEME_COLOR",null));
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.bar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.miContact:
                Toast.makeText(this,"Contacts", Toast.LENGTH_SHORT).show();
                break;
            case R.id.miFavorite:
                Toast.makeText(this,"Favorites", Toast.LENGTH_SHORT).show();
                break;
            case R.id.miSettings:
                Fragment settings = new Settings();
                getSupportFragmentManager().beginTransaction().add(R.id.fragmentSettings, settings , "settings").commit();
                Toast.makeText(this,"Settings", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

        return true;
    }
}
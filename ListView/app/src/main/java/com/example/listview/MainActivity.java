package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lvContent = (ListView) findViewById(R.id.lvContent);

        String[] names = new String[] {"Harold Aaaron", "Rene Gunayon", "Sai Navasca", "Vince Lingon", "Julz Manalo", "Adrian Pusana"};
        int[] photos = new int[] {R.drawable.forza4,R.drawable.forza5,R.drawable.horizon,R.drawable.horza3,R.drawable.osman,R.drawable.uwp};

        PhotoAdapter adapter = new PhotoAdapter(this, names,photos);
        lvContent.setAdapter(adapter);

    }
}
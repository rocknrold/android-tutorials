package com.example.others.RecycleViews;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivty_recycle_views);

        List<Todo> todos = new ArrayList<>();
        todos.add(new Todo("Learn android", false));
        todos.add(new Todo("Learn xamarin", false));
        todos.add(new Todo("Learn docker", true));
        todos.add(new Todo("Learn c#", false));
        todos.add(new Todo("Learn java", true));

        TodoAdapter adapter = new TodoAdapter(todos);

        RecyclerView rvTodos = (RecyclerView) findViewById(R.id.rvTodos);

        rvTodos.setHasFixedSize(true);
        rvTodos.setLayoutManager(new LinearLayoutManager(this));
        rvTodos.setAdapter(adapter);

        Button btnAdd = (Button) findViewById(R.id.button);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etTaskNote = (EditText) findViewById(R.id.etTaskNote);

                if(etTaskNote.getText().length() > 0 ){
                    todos.add(new Todo(etTaskNote.getText().toString(), false));
                    adapter.notifyItemChanged(todos.size() -1);
                }

                etTaskNote.setText("");
            }
        });
    }
}
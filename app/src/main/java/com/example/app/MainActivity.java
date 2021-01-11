package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.app.Adapter.studentAdapter;
import com.example.app.Object.Student;
import com.example.app.SQL.SQL;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    private List<Student> std=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listview);

        Log.d(String.valueOf(std.size()+10),"do dai mag");
        studentAdapter stdAdapter=new studentAdapter(std);
        listView.setAdapter(stdAdapter);



    }
}
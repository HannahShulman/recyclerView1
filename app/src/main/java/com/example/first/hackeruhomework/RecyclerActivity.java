package com.example.first.hackeruhomework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.gson.Gson;

import org.json.JSONObject;

public class RecyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        Intent i = getIntent();
        final String personStr = i.getStringExtra("person");
//        int index = person.indexOf("xyzyx");
//        String name = person.substring(0, index);
//        String lastName = person.substring(index+5);
//        Person p = new Person(name, lastName);

        RecyclerView rv = findViewById(R.id.rv);
        final PersonAdapter adapter = new PersonAdapter();
        rv.setAdapter(adapter);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Gson gson = new Gson();
                Person newPerson = gson.fromJson(personStr, Person.class);
                newPerson.setAge(23);
                newPerson.setGender('M');
                adapter.addPerson(newPerson);
            }
        }, 5000);
    }
}

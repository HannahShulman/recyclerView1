package com.example.first.hackeruhomework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

public class InsertContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_contact);

        Button btn = findViewById(R.id.btn_add);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person person = new Person("Chani", "Shulman");


                Gson gson = new Gson();
                String personString = gson.toJson(person);


                JSONObject object = new JSONObject();
                try {
                    object.put("name", person.getName());
                    object.put("lastName", person.getLastName());
                } catch (JSONException e) {
                    e.printStackTrace();
                }



                Intent intent = new Intent(InsertContactActivity.this, RecyclerActivity.class);
                intent.putExtra("person", personString);
                startActivity(intent);

            }
        });
    }
}

package com.example.projectsrule;

import static android.widget.Toast.makeText;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

public class WeightGrid extends AppCompatActivity {
    Button home_button;
    Button button_delete;
    GridView grid_weight;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);

        grid_weight = findViewById(R.id.Weight_Grid);
        button_delete = findViewById(R.id.delete_button);


        home_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                makeText(getApplicationContext(), "Going Home", Toast.LENGTH_SHORT).show();
            }

        });

    }

}

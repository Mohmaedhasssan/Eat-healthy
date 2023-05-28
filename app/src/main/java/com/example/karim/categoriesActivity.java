package com.example.karim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class categoriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        findViewById(R.id.btn_categoriy_diabits).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(categoriesActivity.this,diabetic_foodActivity.class);
                startActivity(i);
            }
        });
        findViewById(R.id.btn_categoriy_Hypertunsive).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(categoriesActivity.this,hypertensives_foodActivity.class);
                startActivity(i2);
            }
        });
        findViewById(R.id.btn_categoriy_fitness).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3 = new Intent(categoriesActivity.this,fitness_foodActivity.class);
                startActivity(i3);
            }
        });
        findViewById(R.id.btn_categoriy_diet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i4 = new Intent(categoriesActivity.this,diet_foodActivity.class);
                startActivity(i4);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.f,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case  R.id.f:
                findViewById(R.id.f).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i2 = new Intent(categoriesActivity.this,favouriteActivity.class);
                        startActivity(i2);
                    }
                });

        }
        return super.onOptionsItemSelected(item);
    }
}
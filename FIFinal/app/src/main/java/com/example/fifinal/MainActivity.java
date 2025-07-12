package com.example.fifinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btSoru1, btSoru2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btSoru1 = findViewById(R.id.button);
        btSoru2 = findViewById(R.id.button2);

        btSoru1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(MainActivity.this, Soru1.class);
                startActivity(x);
            }
        });

        btSoru2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(MainActivity.this, Soru2.class);
                startActivity(x);
            }
        });


    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.new_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id= item.getItemId();

        if (id == R.id.home){
            Intent a = new Intent(MainActivity.this,MainActivity.class);
            startActivity(a);

            return true; }

        if (id == R.id.hakkinda){
            Toast.makeText(this, "Faruk İLHAN - NÖ", Toast.LENGTH_SHORT).show();
            return true; }

        return super.onOptionsItemSelected(item);
    }

}
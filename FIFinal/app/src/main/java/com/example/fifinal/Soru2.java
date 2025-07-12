package com.example.fifinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Soru2 extends AppCompatActivity {

    veriTabani vt;
    EditText etTurkce, etEng, etAlm;
    Button btKayit;

    ListView lv;



    int i = 0;
    String no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soru2);

        vt = new veriTabani(this);

        etTurkce = findViewById(R.id.etTurkce);
        etEng = findViewById(R.id.etEng);
        etAlm = findViewById(R.id.etAlm);

        btKayit = findViewById(R.id.btKayit);
        lv = findViewById(R.id.sozluk);


        btKayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(etTurkce.getText().toString().trim().length() != 0 && etAlm.getText().toString().trim().length() != 0 && etEng.getText().toString().trim().length() != 0)
                {
                    no = Integer.toString(i);
                    SQLiteDatabase db = vt.getWritableDatabase();
                    ContentValues cv = new ContentValues();
                    cv.put("kelimeno", no);
                    cv.put("tr", etTurkce.getText().toString());
                    cv.put("en", etEng.getText().toString());
                    cv.put("alm", etAlm.getText().toString());
                    db.insert("kelimeler", null, cv);
                    etTurkce.setText("");
                    etEng.setText("");
                    etAlm.setText("");
                    i++;

                    Toast.makeText(Soru2.this, "Kayıt Başarılı!", Toast.LENGTH_SHORT).show();



                    String[] sutunlar = {"id","tr","en","alm"};
                    SQLiteDatabase dboku = vt.getReadableDatabase();
                    Cursor cursor =  dboku.query("kelimeler", sutunlar, null, null, null,null, null);
                    ArrayList<String> liste =  new ArrayList<String >();

                    while(cursor.moveToNext())
                        liste.add(cursor.getString(1) + " | " + cursor.getString(2) + " | " + cursor.getString(3));

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, liste);
                    lv.setAdapter(adapter);

                }
                else
                {
                    Toast.makeText(Soru2.this, "Tüm boşlukları doldur!", Toast.LENGTH_SHORT).show();
                }



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
            Intent a = new Intent(Soru2.this,MainActivity.class);
            startActivity(a);

            return true; }

        if (id == R.id.hakkinda){
            Toast.makeText(this, "Faruk İLHAN - NÖ", Toast.LENGTH_SHORT).show();
            return true; }

        return super.onOptionsItemSelected(item);
    }

}
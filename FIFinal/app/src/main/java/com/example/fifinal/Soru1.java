package com.example.fifinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class Soru1 extends AppCompatActivity {

    EditText etVizeYuzde, etVizePuan, etFinalYuzde, etFinalPuan, etProjeYuzde, etProjePuan;
    CheckBox cbVize, cbFinal, cbProje;
    Button btHesapla;

    double vizeYuzdeSay, finalYuzdeSay, projeYuzdeSay, toplamYuzdeSay, vizePuanSay, finalPuanSay, projePuanSay, toplamPuanSay;;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soru1);

        etVizeYuzde = findViewById(R.id.etVizeYuzde);
        etVizePuan = findViewById(R.id.etVizePuan);
        etFinalYuzde = findViewById(R.id.etFinalYuzde);
        etFinalPuan = findViewById(R.id.etFinalPuan);
        etProjeYuzde = findViewById(R.id.etProjeYuzde);
        etProjePuan= findViewById(R.id.etProjePuan);

        cbVize = findViewById(R.id.cbVize);
        cbFinal = findViewById(R.id.cbFinal);
        cbProje = findViewById(R.id.cbProje);

        btHesapla = findViewById(R.id.btHesapla);






        cbVize.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(!cbVize.isChecked())
                {
                    etVizeYuzde.setVisibility(View.INVISIBLE);
                    etVizePuan.setVisibility(View.INVISIBLE);
                }
                else
                {
                    etVizeYuzde.setText("");
                    etVizePuan.setText("");
                    etVizeYuzde.setVisibility(View.VISIBLE);
                    etVizePuan.setVisibility(View.VISIBLE);
                }
            }
        });

        cbFinal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(!cbFinal.isChecked())
                {
                    etFinalPuan.setVisibility(View.INVISIBLE);
                    etFinalYuzde.setVisibility(View.INVISIBLE);
                }
                else
                {
                    etFinalYuzde.setText("");
                    etFinalPuan.setText("");
                    etFinalPuan.setVisibility(View.VISIBLE);
                    etFinalYuzde.setVisibility(View.VISIBLE);
                }
            }
        });

        cbProje.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(!cbProje.isChecked())
                {
                    etProjeYuzde.setVisibility(View.INVISIBLE);
                    etProjePuan.setVisibility(View.INVISIBLE);
                }
                else
                {
                    etProjePuan.setText("");
                    etProjeYuzde.setText("");
                    etProjeYuzde.setVisibility(View.VISIBLE);
                    etProjePuan.setVisibility(View.VISIBLE);
                }
            }
        });


        btHesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                toplamPuanSay = 0;
                toplamYuzdeSay = 0;

                if(cbVize.isChecked())
                {
                    if(etVizePuan.getText().toString().trim().length() != 0 && etVizeYuzde.getText().toString().trim().length() != 0)
                    {
                        vizePuanSay = Double.parseDouble(etVizePuan.getText().toString());
                        vizeYuzdeSay = Double.parseDouble(etVizeYuzde.getText().toString());

                        if(vizePuanSay < 0 || vizePuanSay > 100)
                        {
                            Toast.makeText(Soru1.this, "Geçerli bir puan giriniz.", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        else
                        {
                            toplamYuzdeSay += vizeYuzdeSay;
                            toplamPuanSay += vizePuanSay * (vizeYuzdeSay / 100);

                        }
                    }
                    else
                    {
                        Toast.makeText(Soru1.this, "Tüm boşlukları doldurunuz!", Toast.LENGTH_SHORT).show();
                        return;
                    }




                }
                if(cbFinal.isChecked())
                {
                    if(etFinalPuan.getText().toString().trim().length() != 0 && etFinalYuzde.getText().toString().trim().length() != 0)
                    {
                        finalPuanSay = Double.parseDouble(etFinalPuan.getText().toString());
                        finalYuzdeSay = Double.parseDouble(etFinalYuzde.getText().toString());

                        if(finalPuanSay < 0 || finalPuanSay > 100)
                        {
                            Toast.makeText(Soru1.this, "Geçerli bir puan giriniz.", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        else{
                            toplamYuzdeSay += finalYuzdeSay;
                            toplamPuanSay += finalPuanSay * (finalYuzdeSay / 100);
                        }
                    }
                    else
                    {
                        Toast.makeText(Soru1.this, "Tüm boşlukları doldurunuz!", Toast.LENGTH_SHORT).show();
                        return;
                    }


                }
                if(cbProje.isChecked())
                {
                    if(etFinalPuan.getText().toString().trim().length() != 0 && etFinalYuzde.getText().toString().trim().length() != 0)
                    {
                        projePuanSay = Double.parseDouble(etProjePuan.getText().toString());
                        projeYuzdeSay = Double.parseDouble(etProjeYuzde.getText().toString());

                        if(projePuanSay < 0 || projePuanSay > 100)
                        {
                            Toast.makeText(Soru1.this, "Geçerli bir puan giriniz.", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        else
                        {

                            toplamYuzdeSay += projeYuzdeSay;
                            toplamPuanSay += projePuanSay * (projeYuzdeSay / 100);

                        }
                    }
                    else
                    {
                        Toast.makeText(Soru1.this, "Tüm boşlukları doldurunuz!", Toast.LENGTH_SHORT).show();
                        return;
                    }


                }


                if(projeYuzdeSay + vizeYuzdeSay + finalYuzdeSay == 100)
                {
                    Toast.makeText(Soru1.this, "Ortalamanız: " +toplamPuanSay, Toast.LENGTH_SHORT).show();
                    etProjeYuzde.setText("");
                    etProjePuan.setText("");
                    etVizeYuzde.setText("");
                    etVizePuan.setText("");
                    etFinalYuzde.setText("");
                    etFinalPuan.setText("");
                }
                else
                {
                    Toast.makeText(Soru1.this, "Ağırlıkların toplamı 100 olmalıdır!: ", Toast.LENGTH_SHORT).show();
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
            Intent a = new Intent(Soru1.this,MainActivity.class);
            startActivity(a);

            return true; }

        if (id == R.id.hakkinda){
            Toast.makeText(this, "Faruk İLHAN - NÖ", Toast.LENGTH_SHORT).show();
            return true; }

        return super.onOptionsItemSelected(item);
    }

}
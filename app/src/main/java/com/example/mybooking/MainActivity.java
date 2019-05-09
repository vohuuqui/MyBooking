package com.example.mybooking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner currenciesspinner;
    String[] currenciesitems;
    ArrayAdapter<String> adapter;
    Button myexitbutton;
    Button mybutton;
    TextView mytext;
    EditText nametext;
    EditText phonetext;
    RadioButton seatcheck;
    RadioButton beathcheck;
    CheckBox checkVip;
    String member = "Normal";
    Integer priceseat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currenciesspinner = findViewById(R.id.currenciesspinner);
        currenciesitems = new String[]{"VND","USD"};
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, currenciesitems);
        currenciesspinner.setAdapter(adapter);
        myexitbutton = findViewById(R.id.myexitbutton);
        myexitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
        nametext = findViewById(R.id.nametext);
        phonetext = findViewById(R.id.phonetext);
        mytext = findViewById(R.id.mytext);
        checkVip = findViewById(R.id.checkVip);
        checkVip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkVip.isChecked()){
                    member = "Vip";
                }
                else {
                    member = "Normal";
                }
            }
        });
        seatcheck = findViewById(R.id.seatcheck);
        seatcheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(seatcheck.isChecked()){
                    priceseat = 600000;
                }
            }
        });
        beathcheck = findViewById(R.id.beathcheck);
        beathcheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(beathcheck.isChecked()){
                    priceseat = 1200000;
                }
            }
        });
        mybutton = findViewById(R.id.mybutton);
        mybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                if (nametext.length() == 0){
                    Toast.makeText(MainActivity.this,"Nhập Tên!",Toast.LENGTH_LONG).show();
                }
                else if (phonetext.length() == 0){
                    Toast.makeText(MainActivity.this,"Nhập Số Điện Thoại!",Toast.LENGTH_LONG).show();
                }
                else if (priceseat == null){
                    Toast.makeText(MainActivity.this,"Chọn Seat Type!",Toast.LENGTH_LONG).show();
                }
                else{
                    if (currenciesspinner.getSelectedItem().toString() == "VND") {
                        if (member == "Normal") {
                            mytext.setText("Name: " + nametext.getText().toString() + "\n" + "Phone: " + phonetext.getText().toString() + "\n" + "Member: " + member + "\n" + "Price: " + priceseat);
                        } else {
                            mytext.setText("Name: " + nametext.getText().toString() + "\n" + "Phone: " + phonetext.getText().toString() + "\n" + "Member: " + member + "\n" + "Price: " + priceseat * 0.8);
                        }
                    } else {
                        if (member == "Normal") {
                            mytext.setText("Name: " + nametext.getText().toString() + "\n" + "Phone: " + phonetext.getText().toString() + "\n" + "Member: " + member + "\n" + "Price: " + priceseat / 20000);
                        } else {
                            mytext.setText("Name: " + nametext.getText().toString() + "\n" + "Phone: " + phonetext.getText().toString() + "\n" + "Member: " + member + "\n" + "Price: " + 0.8 * priceseat / 20000);
                        }
                    }
                }
            }
        });
    }
}

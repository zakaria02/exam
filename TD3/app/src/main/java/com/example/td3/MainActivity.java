package com.example.td3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button rollBtn;
    TextView rollTextView;

    TextView rollTextView2;

    String randomValue;
    Random random;

    EditText nbrFaces;
    int nbrFacesText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rollBtn = (Button) findViewById(R.id.rollBtn);
        rollTextView = (TextView) findViewById(R.id.rollText);

        rollTextView2 = (TextView) findViewById(R.id.rolltext2);
        nbrFaces = (EditText) findViewById(R.id.NbrText);

        rollBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nbrFaces.getText().toString() != null && !nbrFaces.getText().toString().isEmpty()){
                    nbrFacesText = Integer.parseInt(nbrFaces.getText().toString());
                    if(nbrFacesText > 0){
                        random = new Random();
                        randomValue = Integer.toString(random.nextInt(nbrFacesText)+1);
                        rollTextView.setText(randomValue);
                        random = new Random();
                        randomValue = Integer.toString(random.nextInt(nbrFacesText)+1);
                        rollTextView2.setText(randomValue);
                    }else{
                        Toast.makeText(MainActivity.this, "Veuillez entrer une valeur supérieur à 0 !", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(MainActivity.this, "Veuillez saisir un nombre", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
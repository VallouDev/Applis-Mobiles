package com.example.calculatriceofficielle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Optional;


public class MainActivity<string> extends AppCompatActivity {
    TextView result;
    TextView T_CALC;
    TextView T_MEM;
    private double chiffre1;
    private boolean clicOperateur = false;
    private boolean update = false;
    private String operateur = "";
    public int memoire = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button B0 = findViewById(R.id.B0);
        final Button B1 = findViewById(R.id.B1);
        final Button B2 = findViewById(R.id.B2);
        final Button B3 = findViewById(R.id.B3);
        final Button B4 = findViewById(R.id.B4);
        final Button B5 = findViewById(R.id.B5);
        final Button B6 = findViewById(R.id.B6);
        final Button B7 = findViewById(R.id.B7);
        final Button B8 = findViewById(R.id.B8);
        final Button B9 = findViewById(R.id.B9);

        final Button divise = findViewById(R.id.slash);
        final Button x = findViewById(R.id.x);
        final Button moins = findViewById(R.id.moins);
        final Button plus = findViewById(R.id.plus);

        final Button MC = findViewById(R.id.MC);
        final Button MR = findViewById(R.id.MR);
        final Button MPlus = findViewById(R.id.MPlus);
        final Button Mmoins = findViewById(R.id.Mmoins);
        final Button C = findViewById(R.id.C);
        final Button DEL = findViewById(R.id.DEL);
        final Button point = findViewById(R.id.point);
        final Button egal = findViewById(R.id.egal);


        result = findViewById(R.id.result);
        T_CALC = findViewById(R.id.T_CALC);
        T_MEM = findViewById(R.id.T_MEM);


        B0.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                OnClickChiffre("0");
            }

        });

        B1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                OnClickChiffre("1");
            }

        });
        B2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                OnClickChiffre("2");
            }

        });
        B3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                OnClickChiffre("3");
            }

        });
        B4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                OnClickChiffre("4");
            }

        });
        B5.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                OnClickChiffre("5");
            }

        });
        B6.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                OnClickChiffre("6");
            }

        });
        B7.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                OnClickChiffre("7");
            }

        });
        B8.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                OnClickChiffre("8");
            }

        });
        B9.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                OnClickChiffre("9");
            }

        });
        plus.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                OnclickPlus();
            }

        });
        moins.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                OnclickMoins();
            }

        });
        divise.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                OnclickDivise();
            }

        });
        x.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                OnclickFois();
            }

        });
        egal.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                OnclickEquals();
            }

        });
        point.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                OnClickChiffre(".");
            }

        });
        MC.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                OnCLickMC();
            }

        });
        MR.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                OnCLickMR();
            }

        });
        Mmoins.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                OnClickMMoins();
            }

        });
        MPlus.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                OnClickMPlus();
            }

        });
        C.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                OnClickC();
            }

        });
        DEL.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                OnCLickDel();
            }

        });

    }

    private void OnCLickDel() {
        try {
            String nom = result.getText().toString();
            nom = nom.substring(0, nom.length() - 1);
            result.setText(nom);
        } catch(Exception e) {
           Toast.makeText(getApplicationContext(), "Pas possible que ce soit en dessous de 0 caractères", Toast.LENGTH_SHORT).show();
       }

    }

    private void OnCLickMC() {
        T_MEM.setText("");
        T_CALC.setText("");
        memoire = 0;
    }

    private void OnCLickMR() {
        T_CALC.setText(result.getText());
        memoire = 0;
    }

    public void OnClickMPlus() {
        try {
        String MP = result.getText() + "+";
        T_CALC.append(MP);
        T_CALC.setText(MP);
        result.setText(Integer.parseInt((String) result.getText()) + Integer.parseInt((String) result.getText()));
        T_MEM.setText("M");
        } catch(Exception e) {
            Toast.makeText(getApplicationContext(), "Une erreur est survenue", Toast.LENGTH_SHORT).show();

        }
    }

    public void OnClickMMoins() {
        try {
            String MP = result.getText() + "-";
            T_CALC.append(MP);
            T_CALC.setText(MP);
            result.setText(Integer.parseInt((String) result.getText()) - Integer.parseInt((String) result.getText()));
            T_MEM.setText("M");
        } catch(Exception e) {
            Toast.makeText(getApplicationContext(), "Une erreur est survenue", Toast.LENGTH_SHORT).show();

        }
    }




    private void OnclickDivise () {
        String caclcmagique = result.getText() + "/";
        T_CALC.append(caclcmagique);
        T_CALC.setText(T_CALC.getText());
            if(clicOperateur){
                T_CALC.setText(result.getText());
                calcul();
                result. setText (String.valueOf(chiffre1));
            }else{
                chiffre1 = Double.valueOf(result.getText().toString()).doubleValue();
                clicOperateur = true;
            }
            operateur = "/";
            update = true;
        }


        private void OnclickFois () {
            String caclcmagique = result.getText() + "*";
            T_CALC.append(caclcmagique);
            T_CALC.setText(T_CALC.getText());
            if(clicOperateur){

                calcul();
                result. setText (String.valueOf(chiffre1));
            }else{
                chiffre1 = Double.valueOf(result.getText().toString()).doubleValue();
                clicOperateur = true;
            }
            operateur = "*";
            update = true;
        }

        private void OnclickMoins () {
            String caclcmagique = result.getText() + "-";
            T_CALC.append(caclcmagique);
            T_CALC.setText(T_CALC.getText());
            if(clicOperateur){

                calcul();
                result. setText (String.valueOf(chiffre1));
            }else{
                chiffre1 = Double.valueOf(result.getText().toString()).doubleValue();
                clicOperateur = true;
            }
            operateur = "-";
            update = true;
        }

    private void calcul() {
        if (operateur.equals("-")){
            chiffre1 = chiffre1 - Double.valueOf(result.getText().toString()).doubleValue();
            result.setText(String.valueOf(chiffre1));
        }
        if (operateur.equals("+")){
            chiffre1 = chiffre1 + Double.valueOf(result.getText().toString()).doubleValue();
            result.setText(String.valueOf(chiffre1));
        }
        if (operateur.equals("/")){
            chiffre1 = chiffre1 / Double.valueOf(result.getText().toString()).doubleValue();
            result.setText(String.valueOf(chiffre1));
            if(Double.valueOf(result.getText().toString()).doubleValue() == 0){
                result.setText("Erreur /0");
            }
        }
        if (operateur.equals("*")){
            chiffre1 = chiffre1 * Double.valueOf(result.getText().toString()).doubleValue();
            result.setText(String.valueOf(chiffre1));
        }
    }


    private void OnclickEquals () {
        String caclcmagique = result.getText() + "=";
        T_CALC.append(caclcmagique);
        T_CALC.setText(T_CALC.getText());
        calcul ();
        update = true;
        clicOperateur = false;
        }

        private void OnClickC () {
            chiffre1 = 0;
            operateur = "";
            result.setText ("");
        }

        private void OnclickPlus () {
        String caclcmagique = result.getText() + "+";
        T_CALC.append(caclcmagique);
        T_CALC.setText(T_CALC.getText());
            if(clicOperateur){
                calcul();
                result. setText (String.valueOf(chiffre1));
            }else{
                chiffre1 = Double.valueOf(result.getText().toString()).doubleValue();
                clicOperateur = true;
            }
            operateur = "+";
            update = true;
            }

        private void OnClickChiffre (String s){
            if (update) {
                update = false;
            } else {
                if (! result.getText().equals("0")) {
                    s = result.getText() + s;

                }
            }
            result.setText(s);
        }
    }







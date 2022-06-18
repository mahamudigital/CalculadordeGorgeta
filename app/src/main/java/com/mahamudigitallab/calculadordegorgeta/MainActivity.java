package com.mahamudigitallab.calculadordegorgeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editValor;
    private TextView textPorcentagem;
    private TextView textGogeta;
    private TextView textTotal;
    private SeekBar seekBarGorgeta;
    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValor = findViewById(R.id.editValor);
        textPorcentagem = findViewById(R.id.textPorcentagem);
        textGogeta = findViewById(R.id.textGorgeta);
        textTotal = findViewById(R.id.textTotal);
        seekBarGorgeta = findViewById(R.id.seekBarGorgeta);
        SeekBarListener();  // extraido para um método

    }

    //Adicionar listener SeekBar
    private void SeekBarListener() {
        seekBarGorgeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override // captura o progresso da seekBar
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                porcentagem = progress;
                textPorcentagem.setText(Math.round(porcentagem) + "%"); //muda o texto conforme o progresso da seekBar
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void calcular() {
        String valorRecuperado = editValor.getText().toString();
        if (valorRecuperado == null || valorRecuperado.equals("")) { //verifica se foi digitado algo
            Toast.makeText(getApplicationContext(),
                    "Digite um valor paa fazer o cálculo!",
                    Toast.LENGTH_LONG).show();
        } else {
            //converter string para double
            double valorDigitado = Double.parseDouble(valorRecuperado);
            //calculo da gorgeta total
            double gorgeta = valorDigitado * (porcentagem/100);
            // exibe gorgeta
            textGogeta.setText("R$ " + Math.round(gorgeta));
            // exibe total
            double total =   gorgeta + valorDigitado;
            textTotal.setText("R$ " + total);

        }

    }
}
package br.com.senai.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class tela2  extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela2);

        TextView txtNotas = (TextView) findViewById(R.id.media);
        TextView nome = (TextView) findViewById(R.id.nome);
        TextView resultado = (TextView) findViewById(R.id.resultado);
        Intent it = getIntent();

        Double soma;
        if(it != null){
            Bundle params = it.getExtras();
            if(params != null) {
            soma = params.getDouble("nota1") + params.getDouble("nota2") +
                    params.getDouble("nota3") + params.getDouble("nota4") / 4;

            if(soma <= 6.9){
                resultado.setText("REPROVADO");
            }
            if(soma >= 7){
                resultado.setText("APROVADO");
            }
            if(soma == 10){
                resultado.setText("APROVADO COM MÉRITO");
            }

            nome.setText(params.getString("nome"));
            txtNotas.setText(soma.toString());
            }
        }

        Button btnRetornar = (Button)  findViewById(R.id.btnRetornar);
        btnRetornar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent it = new Intent(this,MainActivity.class);
        startActivity(it);
    }
}

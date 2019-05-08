package br.unama.adonias.appsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase bd;
    private Button btCadastro, btnListar;
    private TextInputEditText txtNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btCadastro = findViewById(R.id.btCadastro);
        btnListar = findViewById(R.id.btnListaNomes);
        txtNome = findViewById(R.id.txtNm);
        //Criar o banco
        bd = this.openOrCreateDatabase("Pessoas", Context.MODE_PRIVATE, null);
        //Criar as tabelas
        bd.execSQL("CREATE TABLE IF NOT EXISTS Pessoa (_id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT)");

        //Parte Dinâmica - Inserção dos dados.
        btCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Criamos o registro para ser inserido no bd, a partir do input
                ContentValues reg  = new ContentValues();
                reg.put("nome", txtNome.getText().toString());
                bd.insert("Pessoa", null, reg);
                Toast.makeText(getApplicationContext(), "Cadastro com sucesso", Toast.LENGTH_LONG).show();
            }
        });
        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(i);
            }
        });
    }
}

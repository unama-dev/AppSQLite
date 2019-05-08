package br.unama.adonias.appsqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Main2Activity extends AppCompatActivity {

    private ListView listaNome;
    private SQLiteDatabase bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listaNome = findViewById(R.id.listaNome);
        bd = this.openOrCreateDatabase("Pessoas", Context.MODE_PRIVATE, null);

        //Colunas da tabela
        String colunas[] = new String[]{"_id", "nome"};
        //Ids do widgets do layout da lista
        int campos[] = new int[]{R.id.idPessoa, R.id.lTxtNome};

        //Realiza a consulta na tabela
        Cursor resultado = bd.query("Pessoa", null, null, null, null, null, null, null);
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                getApplicationContext(), R.layout.layout_list,
                resultado,
                colunas,
                campos, 1);
        listaNome.setAdapter(adapter);
    }
}

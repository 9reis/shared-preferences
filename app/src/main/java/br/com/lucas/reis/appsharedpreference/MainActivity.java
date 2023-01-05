package br.com.lucas.reis.appsharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "App_aulaSP";
    private static final String PREF_NOME = "App_aulaSP_pref";

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor dados;

    String nomeProduto;
    int codigoProduto;
    float precoProduto;
    boolean estoque;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "onCreate: APP RODANDO... ");

        sharedPreferences = getSharedPreferences(PREF_NOME, Context.MODE_PRIVATE);
        Log.i(TAG, "onCreate: PASTA SHARED CRIADA... ");

        dados = sharedPreferences.edit();
        nomeProduto = "Nootebook";
        codigoProduto = 123456;
        precoProduto =999.94f;
        estoque = true;

        dados.putString("nomeProduto",nomeProduto);
        dados.putInt("codigoProduti",codigoProduto);
        dados.putFloat("precoProduto",precoProduto);
        dados.putBoolean("estoque",estoque);

        dados.apply();

        //MODO DEBUG
        Log.i(TAG, "onCreate: DADOS PARA SEREM SALVO ");
        Log.i(TAG, "onCreate: PRODUTO: " + nomeProduto);
        Log.i(TAG, "onCreate: CODIGO: " + codigoProduto);
        Log.i(TAG, "onCreate: PRECO: " + precoProduto);
        Log.i(TAG, "onCreate: TEM NO ESTOQUE: " + estoque);

        //dados.clear();
        //dados.apply();

        //dados.remove("estoque");

        Log.d(TAG, "onCreate: DADOS RECUPERADOS ");
        Log.d(TAG, "onCreate: PRODUTO: " + sharedPreferences.getString("nomeProduto", "Fora de estoque") );
        Log.d(TAG, "onCreate: CODIGO: " + sharedPreferences.getInt( "codigoProduto", -1));
        Log.d(TAG, "onCreate: PRECO: " + sharedPreferences.getFloat("precoProduto",-1.0f));
        Log.d(TAG, "onCreate: TEM NO ESTOQUE: " + sharedPreferences.getBoolean("estoque",false));

    }
}
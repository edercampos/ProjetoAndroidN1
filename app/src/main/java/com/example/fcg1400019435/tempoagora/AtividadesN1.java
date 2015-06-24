package com.example.fcg1400019435.tempoagora;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Contacts;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@SuppressWarnings("deprecation")
public class AtividadesN1 extends ActionBarActivity {

    private ArrayAdapter<String> mAdaptador;

    private String[] detalhe = {
            "tempo chuvoso vamos tomas uma mineira",
            "tempo ensolarado tomar uma gelada",
            "tempestade ficar em casa",
            "tempestade ficar em casa",
            "tempestade mas é sexta vamos tomar uma",
            "muito quente ideal uma piscina",
            "dia de churrasco aconpanhado de uma gelada"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atividades_n1);

        String[] dados = {

                "segunda-feira - chuva",
                "terça-feira - sol",
                "quarta- feira - tempestade",
                "quinta-feira - tempestade",
                "sexta-feira - tempestade",
                "sabado - muito quente",
                "domingo - sol"
        };

        //Transforma dados em uma lista
        List<String> previsao = new ArrayList<>(Arrays.asList(dados) );

        //Cria o Adptador
        mAdaptador = new ArrayAdapter<>(
                getApplicationContext(), // Contexto atual
                R.layout.item_lista_principal, // Nome do ID do layout
                R.id.item_texto, // ID do TextView a ser preenchido
                previsao);

        // Conecta a lista ao adaptador
        ListView listView = (ListView) findViewById(R.id.lista_principal);
        listView.setAdapter(mAdaptador);

        listView.setOnItemClickListener(new ItemClicado());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_atividades_n1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //sub classe para dar função ao click
    private class ItemClicado implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            String texto = "sem previsão";

            if (detalhe.length > position) {
                texto = detalhe[position];
            }

            Intent detailIntent = new Intent(getApplication(), Detalhes.class);
            detailIntent.putExtra(Intent.EXTRA_TEXT, mAdaptador.getItem(position) + " " + texto);
            startActivity(detailIntent);
        }
    }


}

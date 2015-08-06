package com.example.fcg1400019435.tempoagora;

import android.content.Intent;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


@SuppressWarnings("deprecation")
public class Detalhes extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        Intent intent = getIntent();
        String detailText = intent.getStringExtra(Intent.EXTRA_TEXT);

        if (intent.hasExtra(Intent.EXTRA_TEXT)){
            TextView detailTextView = (TextView) findViewById(R.id.detalhe_item_texto);
            detailTextView.setText(detailText);
        }

        Button botao = (Button) findViewById(R.id.botao1);


        botao.setOnClickListener(new clique());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detalhes, menu);
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
            Intent detailIntent = new Intent(getApplication(), AtividadeConfiguracao.class);
            startActivity(detailIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    //utilizando uma intent
    private class clique implements View.OnClickListener{

        public void insertContact(String name) {
            Intent intent = new Intent(Intent.ACTION_INSERT);
            intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
            intent.putExtra(Contacts.Intents.Insert.NAME, name);

            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }

        @Override
        public void onClick(View v) {
            //acha o textview
            // usa o texto dele no contato
            TextView detailTextView = (TextView) findViewById(R.id.detalhe_item_texto);

            insertContact(detailTextView.getText().toString());
        }
    }
}

package br.com.fiap.mobintroducaoandroid_aula4_app2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ActivityPrincipal extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner sp = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sp = (Spinner) findViewById(R.id.sp);
        sp.setOnItemSelectedListener(this);
        carregarProdutos();
    }

    public void exibirPreco(View v){

        Produto item = (Produto) sp.getSelectedItem();
        Toast.makeText(this,"Preço: "+item.getPreco(),Toast.LENGTH_SHORT).show();

    }

    public void carregarProdutos(){

        Produto p1 = new Produto("Alface",5.0f);
        Produto p2 = new Produto("Repolho",3.0f);
        Produto p3 = new Produto("Tomate",7.0f);

        List<Produto> produtos = new ArrayList<Produto>();
        produtos.add(p1);
        produtos.add(p2);
        produtos.add(p3);

        ArrayAdapter<Produto> adaptador =
                new ArrayAdapter<Produto>(this,android.R.layout.simple_spinner_item,produtos);

        sp.setAdapter(adaptador);
        adaptador.add(new Produto("Cebola", 2.5f));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_principal, menu);
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

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //p1: lista
        //p2: spinner
        //p3: posição

        String pagamento = parent.getItemAtPosition(position).toString();
        Toast.makeText(this, pagamento, Toast.LENGTH_SHORT).show();

    }
}

package com.mischamichael.catchemall02.app;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Louis Michael on 4/26/14.
 */
public class PokeSelect extends Activity
{

    EditText name;
    EditText level;
    EditText percentHealth;
    public String pokemon;
    private String stat = "None";
    private Button par;
    private Button brn;
    private Button pos;
    private Button slp;
    private Button frz;
    private AutoCompleteTextView actv;


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.poke_select);
        par = (Button) findViewById(R.id.button2);
        brn = (Button) findViewById(R.id.button3);
        pos = (Button) findViewById(R.id.button4);
        slp = (Button) findViewById(R.id.button5);
        frz = (Button) findViewById(R.id.button6);
        actv = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
        String[] countries = getResources().
        getStringArray(R.array.list_of_pokemon_gen1);
        ArrayAdapter adapter = new ArrayAdapter
       (this,android.R.layout.simple_list_item_1,countries);
        actv.setAdapter(adapter);

    }
    public void setStatPar(View v)
    {
        stat = "Paralyzed";
        setAllColorWhite();
        par.setBackgroundColor(Color.YELLOW);
    }
    public void setStatBrn(View v)
    {
        stat = "Burned";
        setAllColorWhite();
        brn.setBackgroundColor(Color.RED);
    }
    public void setStatPos(View v)
    {
        stat = "Poisoned";
        setAllColorWhite();
        pos.setBackgroundColor(Color.GREEN);
    }
    public void setStatFrz(View v)
    {
        stat = "Frozen";

        setAllColorWhite();
        frz.setBackgroundColor(Color.BLUE);
    }
    public void setStatSlp(View v)
    {
        stat = "Asleep";
        setAllColorWhite();
        slp.setBackgroundColor(Color.CYAN);
    }
    public void setAllColorWhite()
    {
        par.setBackgroundColor(0x000000);
        brn.setBackgroundColor(0x000000);
        pos.setBackgroundColor(0x000000);
        slp.setBackgroundColor(0x000000);
        frz.setBackgroundColor(0x000000);
    }
    public void goPokeBall(View v)
    {
        name   = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView1);
        level = (EditText)findViewById(R.id.editText2);
        percentHealth = (EditText)findViewById(R.id.editText3);

        Intent intent = new Intent(getBaseContext(), PokeBall.class);

        intent.putExtra("pokemon", name.getText().toString());
        intent.putExtra("level", level.getText().toString());
        intent.putExtra("percentHealth", percentHealth.getText().toString());
        intent.putExtra("stat",stat);

        startActivity(intent);

    }
}

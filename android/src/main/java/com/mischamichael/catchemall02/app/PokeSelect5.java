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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by Louis Michael on 4/26/14.
 */
public class PokeSelect5 extends Activity
{

    EditText name;
    EditText level;
    EditText percentHealth;
    EditText pokedex;
    public String pokemon;
    private String stat = "None";
    private Button par;
    private Button brn;
    private Button pos;
    private Button slp;
    private Button frz;
    private AutoCompleteTextView actv;
    private String gen;
    private Spinner pokeball;
    private Spinner pokechose;
    private CheckBox darkGrass;



    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.genfive);
        par = (Button) findViewById(R.id.button2);
        brn = (Button) findViewById(R.id.button3);
        pos = (Button) findViewById(R.id.button4);
        slp = (Button) findViewById(R.id.button5);
        frz = (Button) findViewById(R.id.button6);
        actv = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
        Intent intent = getIntent();
        gen = intent.getStringExtra("gen");
        pokechose = (Spinner) findViewById(R.id.spinner1);
        if (gen.equals("2"))
        {
            String[] countries = getResources().
                    getStringArray(R.array.list_of_pokemon_gen2);
            ArrayAdapter adapter = new ArrayAdapter
                    (this,android.R.layout.simple_list_item_1,countries);
            actv.setAdapter(adapter);
            String[] countries1 = getResources().
                    getStringArray(R.array.list_of_balls_gen2);
            ArrayAdapter adapter1 = new ArrayAdapter
                    (this,android.R.layout.simple_list_item_1,countries1);
            pokechose.setAdapter(adapter1);
        }
        else if (gen.equals("3"))
        {
            String[] countries = getResources().
                    getStringArray(R.array.list_of_pokemon_gen3);
            ArrayAdapter adapter = new ArrayAdapter
                    (this,android.R.layout.simple_list_item_1,countries);
            actv.setAdapter(adapter);
            String[] countries1 = getResources().
                    getStringArray(R.array.list_of_balls_gen34);
            ArrayAdapter adapter1 = new ArrayAdapter
                    (this,android.R.layout.simple_list_item_1,countries1);
            pokechose.setAdapter(adapter1);
        }
        else if (gen.equals("4"))
        {
            String[] countries = getResources().
                    getStringArray(R.array.list_of_pokemon_gen4);
            ArrayAdapter adapter = new ArrayAdapter
                    (this,android.R.layout.simple_list_item_1,countries);
            actv.setAdapter(adapter);
            String[] countries1 = getResources().
                    getStringArray(R.array.list_of_balls_gen34);
            ArrayAdapter adapter1 = new ArrayAdapter
                    (this,android.R.layout.simple_list_item_1,countries1);
            pokechose.setAdapter(adapter1);
        }
        else
        {
            String[] countries = getResources().
                    getStringArray(R.array.list_of_pokemon_gen5);
            ArrayAdapter adapter = new ArrayAdapter
                    (this,android.R.layout.simple_list_item_1,countries);
            actv.setAdapter(adapter);
            String[] countries1 = getResources().
                    getStringArray(R.array.list_of_balls_gen5);
            ArrayAdapter adapter1 = new ArrayAdapter
                    (this,android.R.layout.simple_list_item_1,countries1);
            pokechose.setAdapter(adapter1);
        }

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
        pokechose = (Spinner) findViewById(R.id.spinner1);
        darkGrass = (CheckBox)findViewById(R.id.checkBox);
        pokedex = (EditText)findViewById(R.id.editText);
        int pokedexInt = Integer.parseInt(pokedex.getText().toString());


        Intent intent = new Intent(getBaseContext(), Stat2_5.class);

        intent.putExtra("pokemon", name.getText().toString());
        intent.putExtra("level", level.getText().toString());
        intent.putExtra("percentHealth", percentHealth.getText().toString());
        intent.putExtra("stat",stat);
        intent.putExtra("gen", gen);
        intent.putExtra("dg", darkGrass.isChecked());
        intent.putExtra("pokdex", pokedexInt);
        intent.putExtra("pokeball", pokechose.getSelectedItem().toString());

        startActivity(intent);

    }
}

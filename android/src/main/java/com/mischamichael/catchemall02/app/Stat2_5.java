package com.mischamichael.catchemall02.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Random;
import java.util.Scanner;
import java.util.HashMap;


/**
 * Created by Louis Michael on 4/29/14.
 */

public class Stat2_5 extends Activity {
    public String pokemon;
    public String levelString;
    public String percentHealth;
    public String pokeball;
    private String stat;
    private String gen;
    private int intGen;
    private boolean dg;
    private int pokdex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        pokemon = intent.getStringExtra("pokemon");
        levelString =  intent.getStringExtra("level");
        percentHealth = intent.getStringExtra("percentHealth");
        pokeball = intent.getStringExtra("pokeball");
        stat = intent.getStringExtra("stat");
        gen = intent.getStringExtra("gen");
        dg = intent.getBooleanExtra("dg", false);
        pokdex = intent.getIntExtra("pokedex", 300);
        intGen = Integer.parseInt(gen);

        int intLevel = Integer.parseInt(levelString);
        int intPercentHealth = Integer.parseInt(percentHealth);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.stat);

        TextView textView = (TextView) findViewById(R.id.mytextview);
        Gen2CatchRate catchRate =
                new Gen2CatchRate(pokemon, pokeball, intGen, stat, pokdex, intLevel, intPercentHealth, dg);


        textView.setText(Double.toString(catchRate.getRate()) + "%");
    }
}



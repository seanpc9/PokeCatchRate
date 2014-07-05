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

public class Stat extends Activity {
    public String pokemon;
    public String levelString;
    public String percentHealth;
    public String pokeball;
    private String stat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        pokemon = intent.getStringExtra("pokemon");
        levelString =  intent.getStringExtra("level");
        percentHealth = intent.getStringExtra("percentHealth");
        pokeball = intent.getStringExtra("pokeball");
        stat = intent.getStringExtra("stat");
        int intLevel = Integer.parseInt(levelString);
        int intPercentHealth = Integer.parseInt(percentHealth);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.stat);

        TextView textView = (TextView) findViewById(R.id.mytextview);
        CatchRate catchRate =
                new CatchRate(pokemon, intLevel, intPercentHealth, pokeball, stat);


        textView.setText(Double.toString(catchRate.getRate()) + "%");
    }
}



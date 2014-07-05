package com.mischamichael.catchemall02.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


/**
 * Created by Louis Michael on 4/29/14.
 */
public class PokeBall extends Activity{
public String pokemon;
public String level;
public String percentHealth;
private String pokeball;
private String stat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pokeball);

        Intent intent = getIntent();
        pokemon = intent.getStringExtra("pokemon");
        level = intent.getStringExtra("level");
        percentHealth = intent.getStringExtra("percentHealth");
        stat = intent.getStringExtra("stat");
    }
    public void setMaster(View v)
    {
        pokeball = "Master Ball";
        Intent intent = new Intent(this, Stat.class);
        intent.putExtra("pokemon", pokemon);
        intent.putExtra("level", level);
        intent.putExtra("percentHealth", percentHealth);
        intent.putExtra("pokeball", pokeball);
        intent.putExtra("stat", stat);

        startActivity(intent);

    }
    public void setUltra(View v)
    {
        pokeball = "Ultra Ball";
        Intent intent = new Intent(this, Stat.class);
        intent.putExtra("pokemon", pokemon);
        intent.putExtra("level", level);
        intent.putExtra("percentHealth", percentHealth);
        intent.putExtra("pokeball", pokeball);
        intent.putExtra("stat", stat);

        startActivity(intent);

    }
    public void setGreat(View v)
    {
        pokeball = "Great Ball";
        Intent intent = new Intent(this, Stat.class);
        intent.putExtra("pokemon", pokemon);
        intent.putExtra("level", level);
        intent.putExtra("percentHealth", percentHealth);
        intent.putExtra("pokeball", pokeball);
        intent.putExtra("stat", stat);

        startActivity(intent);

    }
    public void setPoke(View v)
    {
        pokeball = "Poke Ball";
        Intent intent = new Intent(this, Stat.class);
        intent.putExtra("pokemon", pokemon);
        intent.putExtra("level", level);
        intent.putExtra("percentHealth", percentHealth);
        intent.putExtra("pokeball", pokeball);
        intent.putExtra("stat", stat);

        startActivity(intent);

    }



}

package com.mischamichael.catchemall02.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


/**
 * Created by Louis Michael on 5/3/14.
 */
public class GenSel extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gensel);

    }

    public void goPokeSelect(View v)
    {
        Intent intent = new Intent(this, PokeSelect.class);
        startActivity(intent);

    }
    public void goGen2Select(View v)
    {


        Intent intent = new Intent(this, PokeSelect2_4.class);
        intent.putExtra("gen", "2");
        startActivity(intent);

    }
    public void goGen3Select(View v)
    {


        Intent intent = new Intent(this, PokeSelect2_4.class);
        intent.putExtra("gen", "3");
        startActivity(intent);

    }
    public void goGen4Select(View v)
    {


        Intent intent = new Intent(this, PokeSelect2_4.class);
        intent.putExtra("gen", "4");
        startActivity(intent);

    }
    public void goGen5Select(View v)
    {
        Intent intent = new Intent(this, PokeSelect5.class);
        intent.putExtra("gen", "5");
        startActivity(intent);
    }

}

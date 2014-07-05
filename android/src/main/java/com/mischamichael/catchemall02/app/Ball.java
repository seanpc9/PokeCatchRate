package com.mischamichael.catchemall02.app;

import java.util.HashMap;

public class Ball
{
    private HashMap<String, Double> map;
    private double ballMod;

    public Ball(String name, int gen)
    {
        map = new HashMap<String, Double>();
        initializeMap(gen);
        ballMod = map.get(name);
    }

    public double getBallMod()
    {
        return ballMod;
    }

    public void initializeMap(int gen)
    {
        if (gen == 1)
        {
            map.put("Poke Ball", 256.0);
            map.put("Great Ball", 201.0);
            map.put("Ultra Ball", 151.0);
            map.put("Safari Ball", 151.0);
            return;
        }

        if (gen == 2)
        {
            map.put("Poke Ball", 1.0);
            map.put("Friend Ball", 1.0);
            map.put("Great Ball", 1.5);
            map.put("Park Ball", 1.5);
            map.put("Ultra Ball", 2.0);
            map.put("Fast Ball", 1.0);
            map.put("Level Ball (4x level)", 8.0);
            map.put("Level Ball (2x level)", 4.0);
            map.put("Level Ball (greater level)", 2.0);
            map.put("Level Ball", 1.0); //
            map.put("Love Ball (same species)", 8.0);
            map.put("Love Ball", 1.0);
            map.put("Lure Ball (if fishing)", 3.0);
            map.put("Lure Ball", 1.0);
            map.put("Moon Ball", 1.0);
            map.put("Master Ball", -1.0);
            return;
        }

        if (gen == 3 || gen == 4)
        {
            map.put("Poke Ball", 1.0);
            map.put("Premier Ball", 1.0);
            map.put("Luxury Ball", 1.0);
            map.put("Heal Ball", 1.0);
            map.put("Cherish Ball", 1.0);
            map.put("Friend Ball", 1.0);
            map.put("Fast Ball", 1.0);
            map.put("Heavy Ball", 1.0);
            map.put("Level Ball", 1.0);
            map.put("Love Ball", 1.0);
            map.put("Lure Ball", 1.0);
            map.put("Moon Ball", 1.0);
            map.put("Great Ball", 1.5);
            map.put("Safari Ball", 1.5);
            map.put("Sport Ball", 1.5);
            map.put("Ultra Ball", 2.0);
            map.put("Net Ball (water/bug pokemon)", 3.0);
            map.put("Net Ball", 1.0);
            map.put("Dive Ball (underwater/fishing)", 3.5);
            map.put("Dive Ball", 1.0);
            map.put("Repeat Ball (pokemon in pokedex)", 3.0);
            map.put("Repeat Ball", 1.0);
            map.put("Quick Ball (on 1st turn)", 4.0);
            map.put("Quick Ball", 1.0);
            map.put("Dusk Ball (night/cave)", 3.5);
            map.put("Dusk Ball", 1.0);
            map.put("Master Ball", -1.0); //
            map.put("Park Ball", -1.0); //
            return;
        }

        if (gen == 5)
        {
            map.put("Poke Ball", 1.0);
            map.put("Premier Ball", 1.0);
            map.put("Luxury Ball", 1.0);
            map.put("Heal Ball", 1.0);
            map.put("Cherish Ball", 1.0);
            map.put("Great Ball", 1.5);
            map.put("Ultra Ball", 2.0);
            map.put("Net Ball (water/bug pokemon)", 3.0);
            map.put("Net Ball", 1.0);
            map.put("Dive Ball (underwater/fishing)", 3.5);
            map.put("Dive Ball", 1.0);
            map.put("Repeat Ball (pokemon in pokedex)", 3.0);
            map.put("Repeat Ball", 1.0);
            map.put("Quick Ball (on 1st turn)", 4.0);
            map.put("Quick Ball", 1.0);
            map.put("Dusk Ball (night/cave)", 3.5);
            map.put("Dusk Ball", 1.0);
            map.put("Master Ball", -1.0); //
            map.put("Dream Ball", -1.0); //
            return;
        }
    }
}
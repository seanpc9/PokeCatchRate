package com.mischamichael.catchemall02.app;

/**
 * Created by Louis Michael on 5/4/14.
 */
import java.lang.Math;
import java.util.HashMap;

public class Gen2CatchRate
{

    private String pokemonName;
    private Pokemon pokedex;
    private Ball pokeBall;
    private int gen;

    private String stat;
    private int pokedexNum;
    private int level;
    private int percentHealth;
    private boolean dG;

    private int baseCatchRate;
    private int baseHP;
    private int maxHP;

    private double statBonus;
    private double darkGrass;

    public Gen2CatchRate(String pokemonName, String pokeBallName, int generation,
                         String stat, int pokedexNum, int level, int percentHealth, boolean dG)
    {
        this.pokemonName = pokemonName;
        this.pokedex = new Pokemon(pokemonName);
        this.pokeBall = new Ball(pokeBallName, generation);
        this.gen = generation;

        this.stat = stat;
        this.pokedexNum = pokedexNum;
        this.level = level;
        this.percentHealth = percentHealth;
        this.dG = dG;

        this.baseCatchRate = pokedex.getBaseCatchRate();
        this.baseHP = pokedex.getMaxHP();
    }

    public double getRate()
    {

        maxHP = calcMaxHP();
        int currentHealth = (percentHealth*maxHP/100);
        double catchRate = 0;
        double b = 0; //used to determine percentage of catch rate
        statBonus = 0;
        darkGrass = 1;
        double cc = 0;


        if (gen == 5)
        {

            if (pokedexNum > 600)
            {
                if (dG)
                    darkGrass = 1;
                cc = 2.5;
            }
            else if (pokedexNum > 450)
            {
                if (dG)
                    darkGrass = .9;
                cc = 2;
            }
            else if (pokedexNum > 300)
            {
                if (dG)
                    darkGrass = .8;
                cc = 1.5;
            }
            else if (pokedexNum > 150)
            {
                if (dG)
                    darkGrass = .5;
                cc = 1;
            }
            else if (pokedexNum >= 30)
            {
                if (dG)
                    darkGrass = .5;
                cc = .5;
            }
            else
            {
                if (dG)
                    darkGrass = .3;
                cc = 0;
            }
        }

        if (stat.equals("Frozen") || stat.equals("Asleep"))
        {
            if (gen == 2)
            {
                statBonus = 10;
            }
            else if (gen < 5)
            {
                statBonus = 2;
            }
            else
            {
                statBonus = 2.5;
            }
        }
        else if (stat.equals("Poisoned") || stat.equals("Burned") || stat.equals("Paralyzed"))
        {
            if (gen == 2)
            {
                statBonus = 0;
            }
            else
            {
                statBonus = 1.5;
            }
        }
        else
        {
            if (gen == 2)
            {
                statBonus = 0;
            }
            else
            {
                statBonus = 1;
            }
        }

        if (pokeBall.equals("Master Ball"))
        {
            return 100;
        }

        else if (gen == 2)
        {
            catchRate = (Math.max(((3*maxHP-2*currentHealth)*baseCatchRate*pokeBall.getBallMod())/(3*maxHP), 1) + statBonus);

            System.out.println(maxHP + " " + currentHealth + " " + baseCatchRate);


            return ((catchRate+1)/256)*100;
        }
        else if (gen < 5)
        {
            catchRate = ((3*maxHP-2*currentHealth)*(baseCatchRate*pokeBall.getBallMod())/(3*maxHP)) * statBonus;

            b = Math.round((65535) / Math.pow((255/catchRate), .25));
            if (catchRate >= 255)
            {
                return 100;
            }
            return (Math.pow(b, 4)/Math.pow(65536.0, 4)) * 100;
        }
        else
        {
            if (dG)
            {
                darkGrass = Math.round((3*maxHP-2*currentHealth)*darkGrass);
                catchRate = Math.floor(Math.round(Math.floor(Math.round(Math.round(darkGrass*(baseCatchRate*pokeBall.getBallMod())/(3*maxHP)*statBonus)))));
            }
            else
            {
                catchRate = (((3*maxHP - 2*currentHealth) * baseCatchRate * pokeBall.getBallMod()) / (3*maxHP))*statBonus;
            }
            if (catchRate >= 255)
            {
                return 100;
            }
            double CC = (Math.min(255,catchRate)*cc/6);
            b = Math.round(65536.0 / Math.pow((255.0/catchRate),.25));
            return ((CC/256)*(b/65536)+(Math.pow(b,3)/Math.pow(65536.0,3)*(1-CC/256)))*100;
        }

    }

    public int calcMaxHP()
    {
        if (gen == 2)
        {
            int numerator = (8 + baseHP + 50) * level;
            int current = numerator / 50 + 10;
            return current;
        }
        else
        {
            int numerator = (8 + 2*baseHP + 100) * level;
            int current = numerator / 100 + 10;
            return current;
        }
    }
}
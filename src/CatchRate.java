  

        import java.util.Random;
        import java.util.Scanner;
        import java.util.HashMap;

public class CatchRate {

    private static Pokemon pokedex;
    private static String pokemonName;
    private int level;
    private int percentHP;
    private String pokeBall;
    private String status;

    private int baseCatchRate;
    private int baseHP;

    private int range;
    private int change;
    private int maxHP;
    private int currentHP;
    private int hpfactor;

    private double rate;

    public CatchRate(String pokemon, int level, int percentHealth, String pokeBall, String status)
    {
        
        this.pokemonName = pokemon;
        this.level = level;
        this.percentHP = percentHealth;
        this.pokeBall = pokeBall;
        this.status = status;

        pokedex = new Pokemon(pokemonName);
        baseCatchRate = pokedex.getBaseCatchRate();
        baseHP = pokedex.getMaxHP();

        if (pokeBall.equals("Master Ball"))
        {
            rate = 100;
        }
        else
        {
            setRange();
            setStatusChange();
            calcMaxHP();
            calcCurrentHP();
            calcHPFactor();
            setFinalRate();
        }

    }

    public void setRange()
    {
        if (pokeBall.equals("Poke Ball"))
        {
            range = 256;
        }
        else if (pokeBall.equals("Great Ball"))
        {
            range = 201;
        }
        else if (pokeBall.equals("Ultra Ball") || pokeBall.equals("Safari Ball"))
        {
            range = 151;
        }
    }

    public void setStatusChange()
    {
        if (status.equals("Asleep") || status.equals("Frozen"))
        {
            change = 25;
        }
        else if (status.equals("Poisoned") || status.equals("Burned") || status.equals("Paralyzed"))
        {
            change = 12;
        }
        else
        {
            change = 0;
        }
    }

    public void calcMaxHP()
    {
        int iv = 8;
        int numerator = (iv + baseHP + 50) * level;
        int max = numerator / 50 + 10;
        maxHP = max;
    }

    public void calcCurrentHP()
    {
        currentHP = (percentHP * maxHP) / 100;
    }

    public void calcHPFactor()
    {
        hpfactor = maxHP * 255;

        if (pokeBall.equals("Great Ball"))
        {
            hpfactor /= 8;
        }
        else
        {
            hpfactor /= 12;
        }

        if (currentHP > 0)
        {
            hpfactor /= (currentHP / 4);
        }

        if (hpfactor > 255)
        {
            hpfactor = 255;
        }   
    }

    public void setFinalRate()
    {
        double finalrate = 100 * ((double)change + (double)(baseCatchRate + 1) * (double)(hpfactor + 1)) / 256 / range;
        if (finalrate > 100.0)
        {
            finalrate = 100.0;
        }

        rate = finalrate;
    }

    public double getRate()
    {
        return rate;
    }
}

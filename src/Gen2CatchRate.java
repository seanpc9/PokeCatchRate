import java.lang.Math
import java.util.HashMap;

public class Gen2CatchRate 
{
	
	private static Pokemon pokedex;
    	private static String pokemonName;
    	
    	private static Ball 
    	
    	private int level;
    	private int percentHP;
    	private String pokeBall;
    	private String status;

    	private int baseCatchRate;
	private int baseHP;
	
    	private int maxHP;
    	private int currentHP;
    	private int hpfactor;
    	
    	private double statBonus;
    	private double darkGrass;


public double rate(String stat, int gen, int pokedexNum,int level, int percentHealth  /*number of pokeomn caught by trainer)*/ , boolean DG /* if battle is in dark grass*/ )
{
	
	
	pokedex = new PokemonStats("PokemonStatsTable.txt");
	
	maxHP = calcMaxHP(pokedex, level, gen);
	currentHealth = (percentHP/100)*maxHP;
	catchRate = 0;
	int b = 0; //used to determine percentage of catch rate
	statBonus = 0;
	darkGrass = 1;
	

	if (gen == 5)
	{
		if (DG)
		{
			if (pokedexNum > 600)
			{
				darkGrass = 1;
			}
			else if (pokedexNum > 450)
			{
				darkGrass = .9;
			}
			else if (pokedexNum > 300)
			{
				darkGrass = .8;
			}
			else if (pokedexNum > 150)
			{
				darkGrass = .5;
			}
			else if (pokedexNum >= 30)
			{
				darkGrass = .5;
			}
			else
			{
				darkGrass = .3;
			}
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
	
	
	
	
	if (pokeball.equals("Master Ball"))
	{
		System.out.println("Caught");
		return 100;
	}
	
	else if (gen == 2)
	{
		catchRate = (3*maxHP()-2*currentHealth)*(pokedex.getPokedex().get(pokename).getBaseRate()*ball.Bonus())/(3*maxHP() + statBonus);
		
		if ( catchRate < 2)
		{
			b = 63;
		}
		else if (catchRate < 3)
		{
			b = 75;
		}
		else if (catchRate < 4)
		{
			b = 84;
		}
		else if (catchRate < 5)
		{
			b = 90;
		}
		else if (catchRate < 6)
		{
			b = 95;
		}
		else if (catchRate < 8)
		{
			b = 103;
		}
		else if (catchRate < 11)
		{
			b = 113;
		}
		else if (catchRate < 16)
		{
			b = 126;
		}
		else if (catchRate < 21)
		{
			b = 134;
		}
		else if (catchRate < 31)
		{
			b = 149;
		}
		else if (catchRate < 41)
		{
			b = 160;
		}
		else if (catchRate < 51)
		{
			b = 169;
		}
		else if (catchRate < 61)
		{
			b = 177;
		}
		else if (catchRate < 81)
		{
			b = 191;
		}
		else if (catchRate < 101)
		{
			b = 201;
		}
		else if (catchRate < 121)
		{
			b = 211;
		}
		else if (catchRate < 141)
		{
			b = 220;
		}
		else if (catchRate < 161)
		{
			b = 227;
		}
		else if (catchRate < 181)
		{
			b = 234;
		}
		else if (catchRate < 201)
		{
			b = 240;
		}
		else if (catchRate < 221)
		{
			b = 246;
		}
		else if (catchRate < 241)
		{
			b = 251;
		}
		else if (catchRate < 255)
		{
			b = 253;
		}
		else
		{
			b = 255;
		}
		return (Math.pow(b,3)/Math.pow(255,3))*100;
	}
	else if (gen < 5)
	{
		catchRate = ((3*maxHP-2*currentHealth)*(pokedex.getPokedex().get(pokename).getBaseRate()*ball.Bonus())/(3*maxHP*statBonus);
		
		b = (Math.pow(2,16)-1)*Math.pow((catchRate/(Math.pow(2,8)-1)),.25);
		return (Math.pow(b,3)/Math.pow(65536,3))*100;
	}
	else
	{
		if (DG)
		{
			darkGrass = Math.round((3*maxHP-2*currentHealth)*darkGrass)
			catchRate = darkGrass*(pokedex.getPokedex().get(pokename).getBaseRate()*ball.Bonus())/(3*maxHP*statBonus);
		}
		else
		{
			catchRate = ((3*maxHP-2*currentHealth)*(pokedex.getPokedex().get(pokename).getBaseRate()*ball.Bonus())/(3*maxHP*statBonus);
		}
		
		b = 65536 / Math.pow((255/catchRate),.25);
		return (Math.pow(b,3)/Math.pow(65536,3))*100;
	}
	
	
	

}

public static int calcMaxHP(Pokestats pokedex, int lvl, int gen)
	{
		if (gen == 2)
		{
			int basehp = pokedex.getPokedex().get(pokename).getBaseHP();
			int numerator = (8 + basehp + 50) * lvl;
			int current = numerator / 50 + 10;
			return current;
		}
		else
		{
			int basehp = pokedex.getPokedex().get(pokename).getBaseHP();
			int numerator = (8 + 2*basehp + 100)*lvl;
			int current = numerator / 100 + 10;
			return current;
		}
	}
}




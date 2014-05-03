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

	private String status;

	private int baseCatchRate;
	private int baseHP;

	private int maxHP;
	private int currentHP;
	private int hpfactor;
	
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
	}

	public double rate()
	{
		
		baseCatchRate = pokedex.getBaseCatchRate();
        baseHP = pokedex.getMaxHP();
		
		maxHP = calcMaxHP(level, gen);
		int currentHealth = (percentHealth/100)*maxHP;
		double catchRate = 0;
		double b = 0; //used to determine percentage of catch rate
		statBonus = 0;
		darkGrass = 1;
		

		if (gen == 5)
		{
			if (dG)
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
		
		
		
		
		if (pokeBall.equals("Master Ball"))
		{
			System.out.println("Caught");
			return 100;
		}
		
		else if (gen == 2)
		{
			catchRate = (3*maxHP-2*currentHealth)*baseCatchRate*pokeBall.getBallMod()/(3*maxHP) + statBonus;
			
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
			catchRate = ((3*maxHP-2*currentHealth)*(baseCatchRate*pokeBall.getBallMod())/(3*maxHP*statBonus));
			
			b = (Math.pow(2,16)-1)*Math.pow((catchRate/(Math.pow(2,8)-1)),.25);
			return (Math.pow(b,3)/Math.pow(65536,3))*100;
		}
		else
		{
			if (dG)
			{
				darkGrass = Math.round((3*maxHP-2*currentHealth)*darkGrass);
				catchRate = darkGrass*(baseCatchRate*pokeBall.getBallMod())/(3*maxHP*statBonus);
			}
			else
			{
				catchRate = ((3*maxHP-2*currentHealth)*baseCatchRate*pokeBall.getBallMod())/(3*maxHP*statBonus);
			}
			
			b = 65536 / Math.pow((255/catchRate),.25);
			return (Math.pow(b,3)/Math.pow(65536,3))*100;
		}
		
		
		

	}

	public int calcMaxHP(int lvl, int gen)
		{
			if (gen == 2)
			{
				int numerator = (8 + baseHP + 50) * lvl;
				int current = numerator / 50 + 10;
				return current;
			}
			else
			{
				int numerator = (8 + 2*baseHP + 100)*lvl;
				int current = numerator / 100 + 10;
				return current;
			}
		}
}




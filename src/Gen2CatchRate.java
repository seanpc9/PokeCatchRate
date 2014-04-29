import java.lang.Math

public class Gen2CatchRate 
{

private double statBonus = 0;
private double darkGrass = 1;

public double rate(Pokemon pokemon, Ball ball, String stat, int gen, int pokedex, int percentHealth  /*number of pokeomn caught by trainer)*/ , boolean DG /* if battle is in dark grass*/ )
{
	int currentHealth = percentHealth*pokemon.maxHP();
	int catchRate = 0;
	int b = 0; //used to determine percentage of catch rate
	
	if (gen == 5)
	{
		if (DG)
		{
			if (pokedex > 600)
			{
				darkGrass = 1;
			}
			else if (pokedex > 450)
			{
				darkGrass = .9;
			}
			else if (pokedex > 300)
			{
				darkGrass = .8;
			}
			else if (pokedex > 150)
			{
				darkGrass = .5;
			}
			else if (pokedex >= 30)
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
		catchRate = 255;
	}
	
	if (gen == 2)
	{
		catchRate = (3*pokemon.maxHP()-2*currentHealth)*(pokemon.CatchRate()*ball.Bonus())/(3*pokemon.maxHP() + statBonus);
	}
	else if (gen < 5)
	{
		catchRate = ((3*pokemon.maxHP()-2*currentHealth)*(pokemon.CatchRate()*ball.Bonus())/(3*pokemon.maxHP())*statBonus);
	}
	else
	{
		//still have to incorporate capture power factor
		if (DG)
		{
			darkGrass = Math.round((3*pokemon.maxHP()-2*currentHealth)*darkGrass)
			catchRate = darkGrass*(pokemon.CatchRate()*ball.Bonus())/(3*pokemon.maxHP())*statBonus);
		}
		else
		{
			catchRate = ((3*pokemon.maxHP()-2*currentHealth)*(pokemon.CatchRate()*ball.Bonus())/(3*pokemon.maxHP())*statBonus);
		}
	}
	
	
	

}
}




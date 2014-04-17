public class Gen2CatchRate 
{

private double statBonus = 0;
private int gen = 1;

public double rate(Pokemon pokemon, Ball ball, String stat)
{
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
			statBonus = 1.5;
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
	
	if (gen == 2)
	{
		double catchRate = (3*pokemon.maxHP()-2*pokemon.HP())*(pokemon.CatchRate()*ball.Bonus())/(3*pokemon.maxHP() + statBonus);
		return catchRate;
	}
	else if (gen < 5)
	{
		double catchRate = ((3*pokemon.maxHP()-2*pokemon.HP())*(pokemon.CatchRate()*ball.Bonus())/(3*pokemon.maxHP())*statBonus);
		return catchRate;
	}
	else
	{
		//I don't yet understand this generations catching algorithm to write it
	}

}
}




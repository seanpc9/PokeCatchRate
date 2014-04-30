import java.util.Random;
import java.util.Scanner;
import java.util.HashMap;

public class CatchRate {
	
	private static String pokename;
	private static PokemonStats pokedex;

	public static void main(String args[]) {
		
		Scanner input = new Scanner(System.in);
		String pokeball;
		System.out.println("Enter the name of the poke ball that you are using.");
		pokeball = input.nextLine();
		System.out.println("Enter the name of the pokemon you want to catch.");
		pokename = input.nextLine();
		String stat;
		System.out.println("Enter the status ailment of the pokemon if there is one (Enter \"None\" if there is no ailment)");
		stat = input.nextLine();
		int level = 0;
		System.out.println("Enter the level of the pokemon");
		level = Integer.parseInt(input.nextLine());
		int percenthealth = 0;
		System.out.println("Enter the estimated percent health of the pokemon");
		percenthealth = Integer.parseInt(input.nextLine());
		
		int index = 0;
		pokedex = new PokemonStats("PokemonStatsTable.txt");
		/*
		System.out.println(pokename);
		System.out.println(pokedex.getPokedex().get(pokename).getNationalNumber());
		System.out.println(pokedex.getPokedex().get(pokename).getBaseRate());
		System.out.println(pokedex.getPokedex().get(pokename).getBaseHP());
		System.out.println(pokeball);
		System.out.println(stat);
		System.out.println(level);
		*/
		
		Random rand = new Random();
		int randnum = -1;
		int range = -1;
		// Step 1
		if (pokeball.equals("Master Ball"))
		{
			System.out.println("You have a 100% chance of catching the pokemon.");
			return;
		}
		
		// Step 2
		else if (pokeball.equals("Poke Ball"))
		{
			randnum = rand.nextInt(256);
			range = 256;
		}
		else if (pokeball.equals("Great Ball"))
		{
			randnum = rand.nextInt(201);
			range = 201;
		}
		else if (pokeball.equals("Ultra Ball") || pokeball.equals("Safari Ball"))
		{
			randnum = rand.nextInt(151);
			range = 151;
		}
		else
		{
			System.out.println("Please enter a valid name for a poke ball");
			return;
		}
		
		// Step 3
		int change = -1;
		if (stat.equals("Asleep") || stat.equals("Frozen"))
		{
			change = 25;
		}
		else if (stat.equals("Poisoned") || stat.equals("Burned") || stat.equals("Paralyzed"))
		{
			change = 12;
		}
		else
		{
			change = 0;
		}
		
		// Step 4
		/*int newr = randnum - change;
		
		// Step 5
		if (newr < 0)
		{
			System.out.println("It's caught!");
			return;
		}*/
		
		// Step 6
		int max = calcMaxHP(pokedex, level);
		int hpfactor = max * 255;
		if(pokeball.equals("Great Ball"))
		{
			hpfactor /= 8;
		}
		else
		{
			hpfactor /= 12;
		}
		
		int current = (percenthealth * max) / 100;
		current /= 4;
		if (current > 0)
		{
			hpfactor /= current;
		}
		
		if (hpfactor > 255)
		{
			hpfactor = 255;
		}
		
		// Step 7
		/*if (pokedex.getPokedex().get(pokename).getBaseRate() < newr)
		{
			System.out.println("The Pokemon breaks free!");
			return;
		}
		
		// Step 8
		int randnum2 = rand.nextInt(256);
		
		// Step 9
		if (randnum2 <= hpfactor)
		{
			System.out.println("Pokemon is caught!");
			return;
		}
		
		// Step 10
		// Part 1
		int wobble = pokedex.getPokedex().get(pokename).getBaseRate() * 100;
		
		// Part 2
	    if (pokeball.equals("Poke Ball"))
		{
			wobble /= 255;
		}
		else if (pokeball.equals("Great Ball"))
		{
			wobble /= 200;
		}
		else
		{
			wobble /= 150;
		}
	    
	    // Part 3
	    if (wobble > 255)
	    {
	    	System.out.println("The ball wobbled three times");
	    	return;
	    }
	    
	    // Part 4
	    wobble *= hpfactor;
	    
	    // Part 5
	    wobble /= 255;
	    
	    // Part 6
		if (stat.equals("Asleep") || stat.equals("Frozen"))
		{
			wobble += 10;
		}
		else if (stat.equals("Poisoned") || stat.equals("Burned") || stat.equals("Paralyzed"))
		{
			wobble += 5;
		}
		else
		{
			wobble += 0;
		}
		
		// Part 7
		if (wobble < 10)
		{
			System.out.println("The ball misses");
			//return;
		}
		else if (wobble >= 10 && wobble < 30)
		{
			System.out.println("The ball wobbles once");
			//return;
		}
		else if (wobble >= 30 && wobble < 70)
		{
			System.out.println("The ball wobbles twice");
			//return;
		}
		else
		{
			System.out.println("The ball wobbles three times");
			//return;
		}*/
		
		int basecatchrate = pokedex.getPokedex().get(pokename).getBaseRate();
		double finalrate = 100 * ((double)change + (double)(basecatchrate + 1) * (double)(hpfactor + 1)) / 256 / range;
		if (finalrate > 100)
		{
			finalrate = 100;
		}
		/*System.out.println(change);
		System.out.println(basecatchrate);
		System.out.println(hpfactor);
		System.out.println(range);*/
		System.out.println("You have a " + finalrate + " percent chance of catching the pokemon");
	}
	
	public static int calcMaxHP(PokemonStats poked, int lvl)
	{
		int iv = 8;
		int basehp = poked.getPokedex().get(pokename).getBaseHP();
		int numerator = (iv + basehp + 50) * lvl;
		int current = numerator / 50 + 10;
		return current;
	}
}

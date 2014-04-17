public class Pokemon
{
	private int nationalNumber;
	private int baseRate;
	private int baseHP;

	public Pokemon(int index, int rate, int hp)
	{
		baseRate = rate;
		baseHP = hp;
		nationalNumber = index;
	}

	public int getNationalNumber()
	{
		return nationalNumber;
	}

	public int getBaseRate()
	{
		return baseRate;
	}

	public int getBaseHP()
	{
		return baseHP;
	}

}
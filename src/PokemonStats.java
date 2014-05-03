import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Reads the PokemonStatsTable.txt into a HashMap to store Pokemon information.
 */
public class PokemonStats
{
    private File statsFile;
    private Scanner scanner;
    private HashMap<String, Pokemon> pokedex;

    /**
     * Creates a PokemonStats object.
     */
    public PokemonStats(String fileName)
    {
        statsFile = new File(fileName);
        pokedex = new HashMap<String, Pokemon>();
		readStats();
    }
    
    /**
     * Scans the .txt file for the Pokemon names and statistics.
     */
    public void readStats()
    {
        try 
        {
            scanner = new Scanner(statsFile);
            
            while (scanner.hasNext()) // until the file has no more data
            {
                String pokemonName = "";
                int i = 0;
                
                while (!scanner.hasNextInt())
                {
                    if (i > 0) // if the name has multiple parts to read
                    {
                        pokemonName += " "; // adds space to name
                    }
                    
                    pokemonName += scanner.next();
                    
                    i++;
                }
                
                pokedex.put(pokemonName, new Pokemon(scanner.nextInt(), 
                    scanner.nextInt(), scanner.nextInt()));
            }
        }
        catch (FileNotFoundException e)
        {
            throw new FileNotFoundException("Cannot find file.");
        }
    }

    /**
     * @return pokedex Map of all Pokemon and their relavant statistics
     */
    public HashMap<String, Pokemon> getPokedex()
    {
        return pokedex;
    }
    
}

// Stole job from Ryan, forgot what I was actually supposed to do, copied Pokemon classes in Pokeball format

import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class BallStats
{
    private File statsFile;
    private Scanner scan;
    private HashMap<String, Ball> list;

    public BallStats()
    {
        statsFile = new File("BallStats.txt");
        list = new HashMap<String, Ball>();
    }

    public void readStats()
    {
        try
        {
            scan = new Scanner(statsFile);

            while (scan.hasNext()) // until the file has no more data
            {
                String ballName = "";
                int i = 0;

                while (!scan.hasNextInt())
                {
                    if (i > 0) // if the name has multiple parts to read
                    {
                        ballName += " "; // adds space to name
                    }

                    ballName += scan.next();

                    i++;
                }

                list.put(ballName, new Ball(scan.nextDouble()));
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Cannot find file");
        }
    }

    public HashMap<String, Ball> getBalls()
    {
        return list;
    }
}

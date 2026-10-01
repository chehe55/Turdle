import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Wordle
{

    private String                 correctWord;
    private String                 guess;
    private static HashSet<String> words = new HashSet<String>(8000);
    private int[]                  arr;
    private String                 yellowLetters;
    private String                 grayLetters;

    public Wordle()
    {
        arr = new int[5];
        yellowLetters = "";
        grayLetters = "";
    }

    public void resetEverything()
    {
        arr = new int[5];
        yellowLetters = "";
        grayLetters = "";
    }


    public void makeList()
    {
        File text = new File("WordList.txt");
        try
        {
            Scanner scan = new Scanner(text);
            String str = "";
            while (scan.hasNextLine())
            {
                str = scan.nextLine();
                words.add(str);

            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("file not found");
        }
    }


    public void chooseWord()
    {
        int rand = 0;
        rand = (int)(Math.random() * 5757) + 1;
        List<String> list = new ArrayList<String>(words);
        correctWord = list.get(rand);
    }


    public void readGuess(String g)
    {
        /*Scanner scan = new Scanner(System.in);
        System.out.println("enter guess");
        guess = scan.nextLine();*/
        guess = g;
    }


    // not sure if we need
    public String getCorrectWord()
    {
        return correctWord;
    }


    // not sure if we need
    public String getGuess()
    {
        return guess;
    }


    public int[] getArray()
    {
        return arr;
    }


    public String getGrayLetters()
    {
        return grayLetters;
    }

    public String getYellowLetters()
    {
        return yellowLetters;
    }


    public boolean correctGuess()
    {
        return guess.equals(correctWord);
    }


    public boolean validGuess()
    {
        return actualWord() && greens() && yellows() && grays();
    }


    public boolean actualWord()
    {
        return words.contains(guess);
    }


    public boolean greens()
    {
        int[] tempA = new int[5];
        for (int i = 0; i < 5; i++)
        {
            tempA[i] = arr[i];
        }
        for (int i = 0; i < 5; i++)
        {
            if (tempA[i] == 2)
            {
                if (guess.charAt(i) != correctWord.charAt(i))
                {
                    return false;
                }
            }
        }
        return true;
    }


    public boolean yellows()
    {
        for (int i = 0; i < yellowLetters.length(); i++)
        {
            if (!guess.contains(yellowLetters.charAt(i) + ""))
            {
                return false;
            }

        }
        return true;

    }


    public boolean grays()
    {
        return true;
    }


    public void setColors()
    {
        String temp = correctWord;
        for (int i = 0; i < 5; i++)
        {
            if (guess.charAt(i) == correctWord.charAt(i))
            {
                arr[i] = 2;
                temp = temp.replaceFirst(guess.charAt(i) + "", "*");
            }
        }
        for (int i = 0; i < 5; i++)
        {
            if (arr[i] != 2 && !temp.contains(guess.charAt(i) + ""))
            {
                arr[i] = 0;
                grayLetters += guess.charAt(i);
            }
        }
        for (int i = 0; i < 5; i++)
        {
            if (arr[i] != 2 && temp.contains(guess.charAt(i) + ""))
            {
                arr[i] = 1;
                yellowLetters += guess.charAt(i);
                temp = temp.replaceFirst(guess.charAt(i) + "", "*");
            }
        }
    }

    //testing
    public void print()
    {
        for (int i = 0; i < 5; i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}

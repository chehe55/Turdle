import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Absurdle extends Wordle
{
    public boolean grays()
    {
        for (int i = 0; i < 5; i++)
        {
            if (getArray()[i] == 0 && getGrayLetters().contains(getGuess().charAt(i)+""))
            {
                return false;
            }
        }
        return true;
    }

}
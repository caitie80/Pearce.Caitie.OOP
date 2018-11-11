import javax.swing.*;
import java.util.Random;

public class CharacterSheetBuilder {
    public static void main(String[] args) {
        MyMenu gui = new MyMenu();

        Stat one = new Stat();
        one.setStat(generateStat());
        System.out.println(one.toString());
    }


    public static int generateStat(){
        Random rand = new Random();
        int[] rolls = new int[4];

        for (int x = 0; x < rolls.length; x++) {
            rolls[x] = rand.nextInt(6) + 1;
            System.out.println(rolls[x]);
        }

        //selection sort code here
        for (int i = 0; i < rolls.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < rolls.length; j++)
                if (rolls[j] > rolls[index])
                    index = j;

            int biggerNumber = rolls[index];
            rolls[index] = rolls[i];
            rolls[i] = biggerNumber;
        }

        int stat = (rolls[0] + rolls[1] + rolls[2]);
        return stat;
    }
}

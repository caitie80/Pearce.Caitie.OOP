import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.EventHandler;
import java.util.Random;

public class CharacterSheetBuilder implements ActionListener {
    public static void main(String[] args) {
        MyMenu gui = new MyMenu();
        Character character = new Character();

        gui.create.addActionListener(e -> {
            System.out.println("create pressed");

            gui.createSelected();
    });

        gui.submitScore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(gui.clicks<gui.abilities.length){
                    character.setAbility(gui.clicks, gui.abilities[gui.clicks], (int) gui.statScores.getSelectedItem());
                    System.out.println(character.getAbility(gui.clicks).toString());
                    gui.clicks++;
                    gui.statScores.removeItemAt(gui.statScores.getSelectedIndex());
                    if(gui.clicks<gui.abilities.length) {
                        gui.ability.setText(gui.abilities[gui.clicks]);

                    }
                    else{
                        System.out.println("all done");
                        gui.scoresDone();
                    }
                    gui.repaint();
                }
            }
        });

        gui.name.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                character.setName(gui.charName.getText());
                System.out.println(character.getName());
            }
        });
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
        System.out.println(stat);
        return stat;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

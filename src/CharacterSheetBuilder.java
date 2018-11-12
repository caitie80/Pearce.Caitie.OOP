import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class CharacterSheetBuilder implements ActionListener {
    public static void main(String[] args) {
        MyMenu gui = new MyMenu();
        Character character = new Character();



        gui.create.addActionListener(e -> {
            System.out.println("create pressed");

            gui.createCharacter();
        });

        //Button for assigning ability scores
        gui.submitScore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if(gui.clicks<6) {
                    switch (gui.clicks) {

                        case 0:
                            character.setStrength((int) gui.statScores.getSelectedItem());
                            gui.statScores.removeItemAt(gui.statScores.getSelectedIndex());
                            break;

                        case 1:
                            character.setDex((int) gui.statScores.getSelectedItem());
                            gui.statScores.removeItemAt(gui.statScores.getSelectedIndex());
                            break;

                        case 2:
                            character.setCon((int) gui.statScores.getSelectedItem());
                            gui.statScores.removeItemAt(gui.statScores.getSelectedIndex());
                            break;

                        case 3:
                            character.setIntel((int) gui.statScores.getSelectedItem());
                            gui.statScores.removeItemAt(gui.statScores.getSelectedIndex());
                            break;

                        case 4:
                            character.setWis((int) gui.statScores.getSelectedItem());
                            gui.statScores.removeItemAt(gui.statScores.getSelectedIndex());
                            break;

                        case 5:
                            character.setCha((int) gui.statScores.getSelectedItem());
                            gui.statScores.removeItemAt(gui.statScores.getSelectedIndex());
                            System.out.println("scores done");
                            gui.addDetails();
                            break;
                    }
                   if(gui.clicks<5) {
                       gui.ability.setText(gui.abilities[gui.clicks + 1]);
                       gui.repaint();
                   }
                   gui.clicks++;
                }
            }

        });

        gui.details.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                character.setName(gui.charName.getText());
                character.setRace((String)gui.raceBox.getSelectedItem());
                character.updateScores();

                JOptionPane.showMessageDialog(null,character.toString());
            }
        });
    }



    public static int generateStat(){
        Random rand = new Random();
        int[] rolls = new int[4];

        for (int x = 0; x < rolls.length; x++) {
            rolls[x] = rand.nextInt(6) + 1;
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

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class CharacterSheetBuilder {
    public static void main(String[] args) {
        MyMenu gui = new MyMenu();
        Character character = new Character();

        gui.create.addActionListener(e -> {
            gui.createCharacter();
        });

        //Button for assigning ability scores
        gui.submitScore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if(gui.scoreClicks<6) {
                    switch (gui.scoreClicks) {

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
                            gui.addDetails();
                            break;
                    }
                   if(gui.scoreClicks<5) {
                       gui.ability.setText(gui.abilities[gui.scoreClicks + 1]);
                       gui.repaint();
                   }
                   gui.scoreClicks++;
                }
            }

        });
        //button for name and race
        gui.details.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                character.setName(gui.charName.getText());
                character.setRace((String)gui.raceBox.getSelectedItem());
                character.updateScores();
                gui.chooseClass();


            }
        });

        //button for choosing class
        gui.confirmClass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                character.setCclass(gui.classBox.getSelectedItem().toString());

                gui.chooseSkills(character.getCclass().getSkills());
            }
        });

        //button for choosing skill proficiencies
        gui.confirmSkills.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(gui.skillsClicks<2){
                    character.setProfSkills((String)gui.skillsBox.getSelectedItem());
                    gui.skillsBox.removeItemAt(gui.skillsBox.getSelectedIndex());
                    gui.skillsClicks++;
                }
                if(gui.skillsClicks == 2){
                    character.updateChaSkills();
                    character.updateDexSkills();
                    character.updateIntSkills();
                    character.updateStrengthSkills();
                    character.updateWisSkills();

                    gui.showCharacter(character);
                }


            }
        });

        gui.save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                character.saveCharacter();
            }
        });

        gui.load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser chooser = new JFileChooser();
                File location =new File("C:\\Users\\Caitie\\IdeaProjects\\Pearce.Caitie.OOP");
                chooser.setCurrentDirectory(location);
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Characters", "ser");
                chooser.setFileFilter(filter);

                int returnVal = chooser.showOpenDialog(gui);
                if(returnVal == JFileChooser.APPROVE_OPTION)
                {
                    Character n= Character.loadCharacter(chooser.getSelectedFile());

                    gui.showLoadedCharacter(n);

                    //gui.removeAll();
                    //gui.add(gui.menu);
                }
            }
        });

        gui.menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.getContentPane().removeAll();
                //gui.setContentPane(gui.menu);
                gui.add(gui.create);
                gui.add(gui.load);

                gui.repaint();
                gui.pack();
                gui.setVisible(true);
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

}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MyMenu extends JFrame implements ActionListener{
    JTextField jTextField;
    JButton create;
    JButton load;

    public MyMenu()
    {
        FlowLayout layout = new FlowLayout();

        this.setLayout(layout);
        this.setTitle("Character Builder");

        Container container = this.getContentPane();

        container.setBackground(Color.LIGHT_GRAY);

        this.setSize(450,300);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        create = new MyButton("Create a character");
        create.addActionListener(this);
        this.add(create);

        load = new MyButton("Load a character");
        load.setBackground(Color.BLACK);
        load.setForeground(Color.WHITE);
        load.addActionListener(this);
        this.add(load);


        this.setLocationRelativeTo(null);
        this.setVisible(true);


    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==create) {
            System.out.println("create pressed");
            //Container parent = create.getParent();
            super.setTitle("Create a character");
            super.setContentPane(new CreateFrame());
        }

        else if(e.getSource()==load)
            System.out.println("load pressed");

        else
            System.out.println("idk what was pressed");
    }


    public class MyButton extends JButton{

        MyButton(String text){
            this.setText(text);
            this.setBackground(Color.white);
            this.setForeground(Color.black);
            this.setPreferredSize(new Dimension(200,250));
        }

    }
    public class CreateFrame extends Container implements ActionListener {
        Character character = new Character();
        int clicks=0;
        JComboBox<Integer> statScores;
        Integer[] scores = new Integer[6];
        JButton submit;
        JLabel ability;
        String[] abilities = {"Strength","Dexterity","Constitution","Intelligence","Wisdom","Charisma"};

        public CreateFrame(){
            FlowLayout flowLayout = new FlowLayout();
            this.setLayout(flowLayout);



            for(int i=0;i<scores.length;i++){
                scores[i] = generateStat();
            }

            statScores = new JComboBox<>(scores);

            submit = new JButton("Confirm");
            submit.setPreferredSize(new Dimension(250,30));
            submit.addActionListener(this);

            ability = new JLabel(abilities[0]);
            ability.setText(abilities[0]);

            this.add(ability);
            this.add(statScores);
            this.add(submit);
            this.setSize(450,300);

            this.setVisible(true);
        }

        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==submit && clicks<abilities.length) {
                character.setAbility(clicks, abilities[clicks], (int) statScores.getSelectedItem());
                System.out.println(character.getAbility(clicks).toString());
                clicks++;
                statScores.removeItemAt(statScores.getSelectedIndex());
                if(clicks<abilities.length) {
                    ability.setText(abilities[clicks]);
                    super.repaint();
                }
                else{
                    System.out.println("all done");
                    super.removeAll();
                    super.repaint();
                }
            }

            else{
                System.out.println("Idk what was pressed create edition");
            }
        }

        public int generateStat(){
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



    }
}

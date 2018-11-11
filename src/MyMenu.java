import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MyMenu extends JFrame implements ActionListener{


    JTextField charName;
    JButton name;
    JLabel nameChar;

    JComboBox<Integer> statScores;
    Integer[] scores = new Integer[6];
    JButton submitScore;
    JLabel ability;
    String[] abilities = {"Strength","Dexterity","Constitution","Intelligence","Wisdom","Charisma"};
    int clicks;

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

        //create components
        submitScore = new JButton("Confirm");

        //name components
        name = new JButton("Name Character");
        charName = new JTextField(20);

        create = new MyButton("Create a character");
        this.add(create);

        load = new MyButton("Load a character");
        load.setBackground(Color.BLACK);
        load.setForeground(Color.WHITE);
        load.addActionListener(e -> {
            System.out.println("load pressed");
        });
        this.add(load);

        /*ability = new JLabel(abilities[0]);
        ability.setText(abilities[0]);*/



        this.setLocationRelativeTo(null);
        this.setVisible(true);


    }

    public void actionPerformed(ActionEvent e)
    {
       System.out.println("idk what was pressed");
    }

    public void createSelected(){
        clicks=0;
        this.setTitle("Create a character");
        this.getContentPane().removeAll();
        this.repaint();
        this.setLayout(new FlowLayout());

        Integer[] scores = new Integer[6];

        for(int i=0;i<scores.length;i++){
            scores[i] = CharacterSheetBuilder.generateStat();
        }


        submitScore.setPreferredSize(new Dimension(350,30));

        statScores = new JComboBox<>(scores);

        String[] abilities = {"Strength","Dexterity","Constitution","Intelligence","Wisdom","Charisma"};
        ability = new JLabel(abilities[0]);

        this.add(ability);
        this.add(statScores);
        this.add(submitScore);
        this.repaint();
        this.setVisible(true);


    }

    public void scoresDone(){
        getContentPane().removeAll();
        this.setLayout(new FlowLayout());

        name.setPreferredSize(new Dimension(350,30));

        nameChar = new JLabel("Name:");

        add(nameChar);
        add(charName);
        add(name);
        this.repaint();
        this.setVisible(true);
    }


    public class MyButton extends JButton{

        MyButton(String text){
            this.setText(text);
            this.setBackground(Color.white);
            this.setForeground(Color.black);
            this.setPreferredSize(new Dimension(200,250));
        }

    }

}

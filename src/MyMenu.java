import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MyMenu extends JFrame{


    JTextField charName;
    JButton details;
    JLabel name;


    JComboBox<Integer> statScores;
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

        //details components
        details = new JButton("Name Character");
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

        this.setLocationRelativeTo(null);
        this.setVisible(true);
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

        details.setPreferredSize(new Dimension(350,30));

        name = new JLabel("Name:");

        add(name);
        add(charName);
        add(details);
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

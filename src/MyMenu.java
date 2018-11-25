import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class MyMenu extends JFrame{

    //JButton menu;

    JComboBox classBox;
    String[] classChoices = {"Barbarian","Cleric","Druid"};
    JButton confirmClass;

    JComboBox skillsBox;
    JButton confirmSkills;
    int skillsClicks;

    JPanel charInfo;
    JPanel skillInfo;
    JPanel statInfo;
    JButton save;

    JTextField charName;
    JButton details;
    JLabel name;
    JLabel race;
    JComboBox raceBox;
    String[] raceChoices = {"Elf","Human","Dwarf"};


    JComboBox<Integer> statScores;
    JButton submitScore;
    JLabel ability;
    String[] abilities = {"Strength","Dexterity","Constitution","Intelligence","Wisdom","Charisma"};
    int scoreClicks;

    JButton create;
    JButton load;
    JPanel menu;
    JButton menuButton;

    public MyMenu()
    {
        FlowLayout layout = new FlowLayout();
        this.setLayout(layout);
        this.setTitle("Character Builder");
        Container container = this.getContentPane();
        container.setBackground(Color.LIGHT_GRAY);
        this.setSize(450,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Ability components
        submitScore = new JButton("Confirm");

        //save button
        save = new JButton("Save");
        menuButton = new JButton("Back to menu");

        //Class components
        confirmClass = new JButton("Confirm Class");
        confirmSkills = new JButton("Confirm Skill");

        //details components
        details = new JButton("Name Character");
        charName = new JTextField(35);
        raceBox = new JComboBox(raceChoices);

        menu = new JPanel();
        menu.setLayout(new FlowLayout());

        create = new MyButton("Create a character");
        menu.add(create);

        load = new MyButton("Load a character");
        load.setBackground(Color.BLACK);
        load.setForeground(Color.WHITE);

        menu.add(load);

        this.setContentPane(menu);

        this.setLocationRelativeTo(null);
        this.setVisible(true);

        try {
            //icon code
            URL iconURL = getClass().getResource("Resources/icon.png");
            // iconURL is null when not found
            ImageIcon icon = new ImageIcon(iconURL);
            setIconImage(icon.getImage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void createCharacter(){
        scoreClicks=0;
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

    public void addDetails(){
        this.getContentPane().removeAll();
        this.setLayout(new FlowLayout());

        details.setPreferredSize(new Dimension(350,30));

        name = new JLabel("Name:");

        race = new JLabel("Character Race:");

        raceBox.setPreferredSize(charName.getPreferredSize());

        add(name);
        add(charName);
        add(race);
        add(raceBox);
        add(details);
        this.repaint();
        this.setVisible(true);
    }

    public void chooseClass(){
        this.getContentPane().removeAll();
        classBox = new JComboBox(classChoices);

        add(classBox);
        add(confirmClass);



        this.repaint();
        this.setVisible(true);
    }
    public void chooseSkills(String[] choices){
        this.getContentPane().removeAll();
        skillsBox = new JComboBox(choices);
        skillsClicks = 0;

        add(skillsBox);

        add(confirmSkills);



        this.repaint();
        this.setVisible(true);
    }

    public void showCharacter(Character c){
        this.getContentPane().removeAll();

        charInfo = new JPanel();
        charInfo.setMinimumSize(new Dimension(400,400));
        JTextArea info = new JTextArea(c.infoToString(),25,30);
        info.setEditable(false);
        charInfo.add(info);

        skillInfo = new JPanel();
        skillInfo.setMinimumSize(new Dimension(400,400));
        JTextArea stats = new JTextArea(c.statsToString(),25,30);
        stats.setEditable(false);
        skillInfo.add(stats);

        statInfo = new JPanel();
        statInfo.setMinimumSize(new Dimension(400,400));
        JTextArea skills = new JTextArea(c.skillsToString(),25,30);
        skills.setEditable(false);
        statInfo.add(skills);

        JTabbedPane tabs = new JTabbedPane();
        tabs.add("Info",charInfo);

        tabs.add("Stats",statInfo);

        tabs.add("Skills",skillInfo);

        this.setMaximumSize(new Dimension(400,600));

        this.setTitle(c.getName() + " Info");
        this.add(tabs);
        this.getContentPane().add(save);
        //this.getContentPane().add(menu);
        this.repaint();
        pack();
        this.setVisible(true);
    }

    public void showLoadedCharacter(Character c){
        this.getContentPane().removeAll();

        charInfo = new JPanel();
        charInfo.setMinimumSize(new Dimension(400,400));
        JTextArea info = new JTextArea(c.infoToString(),25,30);
        info.setEditable(false);
        charInfo.add(info);

        skillInfo = new JPanel();
        skillInfo.setMinimumSize(new Dimension(400,400));
        JTextArea stats = new JTextArea(c.statsToString(),25,30);
        stats.setEditable(false);
        skillInfo.add(stats);

        statInfo = new JPanel();
        statInfo.setMinimumSize(new Dimension(400,400));
        JTextArea skills = new JTextArea(c.skillsToString(),25,30);
        skills.setEditable(false);
        statInfo.add(skills);

        JTabbedPane tabs = new JTabbedPane();
        tabs.add("Info",charInfo);

        tabs.add("Stats",statInfo);

        tabs.add("Skills",skillInfo);

        this.setMaximumSize(new Dimension(400,600));

        this.setTitle(c.getName() + " Info");
        this.add(tabs);
        //this.getContentPane().add(save);
        this.getContentPane().add(menuButton);
        this.repaint();
        pack();
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

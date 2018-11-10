import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyMenu extends JFrame{
    JTextField jTextField;
    JButton create;
    JButton load;

    public MyMenu()
    {


        FlowLayout flowLayout = new FlowLayout();

        this.setLayout(flowLayout);

        Container container = this.getContentPane();

        container.setBackground(Color.LIGHT_GRAY);

        this.setSize(450,300);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        create = new MyButton("Create a character");
        this.add(create);

        load = new MyButton("Load a character");
        load.setBackground(Color.BLACK);
        load.setForeground(Color.WHITE);
        this.add(load);


        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    public class MyButton extends JButton{

        MyButton(String text){
            this.setText(text);
            this.setBackground(Color.white);
            this.setForeground(Color.black);
            this.setPreferredSize(new Dimension(200,250));
            EventHandler eh = new EventHandler();
            this.addActionListener(eh);

        }

    }

    private class EventHandler implements ActionListener {

        public void actionPerformed(ActionEvent e)
        {
          if(e.getSource()==create)
            System.out.println("create pressed");

          else if(e.getSource()==load)
              System.out.println("load pressed");

          else
              System.out.println("idk what was pressed");
        }
    }
}

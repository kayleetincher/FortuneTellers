
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrameDemo extends JFrame
{
    private ArrayList<String> fortunes;



    private int lastFortuneIndex = -1;

    private String getRandomFortune() {
        int index = lastFortuneIndex;

        while (index == lastFortuneIndex) {
            index = new Random().nextInt(fortunes.size());
        }
        lastFortuneIndex = index;
        return fortunes.get(index);
    }

    JPanel mainPnl;
    JPanel iconPnl;
    JPanel displayPnl;
    JPanel controlPnl;

    JTextArea displayTA;
    JScrollPane scroller;




    JLabel title;
    ImageIcon icon;

    JButton read;
    JButton quit;

    Random rnd = new Random();




    public FortuneTellerFrameDemo() {
        fortunes = new ArrayList<>();
        fortunes.add("Be careful on Tuesday.");
        fortunes.add("Blessed are the children for they shall inherit the national debt.");
        fortunes.add("Change is inevitable, except for vending machines.");
        fortunes.add("Come back later… I am sleeping.");
        fortunes.add("It’s okay to look at the past and future. Just don’t stare.");
        fortunes.add("It could be better but it’s good enough. ");
        fortunes.add("If at first you don’t succeed, skydiving is not for you.");
        fortunes.add("You will read this and say, “Geez, I could have come up with a better fortune than that.");
        fortunes.add("There is romance in your future. Remember to floss. ");
        fortunes.add("Your pet is planning to eat you.");
        fortunes.add("Be kind to pigeons. A statue will someday be made of you. ");
        fortunes.add("The easiest way to find a lost object is to buy a replacement.");



        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        createIconPanel();
        mainPnl.add(iconPnl, BorderLayout.NORTH);

        createDisplayPanel();
        mainPnl.add(displayPnl, BorderLayout.CENTER);

        createControlPanel();
        mainPnl.add(controlPnl, BorderLayout.SOUTH);

        add(mainPnl);

        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


    private void createIconPanel ()
    {
        iconPnl = new JPanel();
        icon = new ImageIcon("C:\\Users\\kayle\\Downloads\\Fortune-teller.png");

        title = new JLabel("Amazing Fortune Teller", icon, JLabel.CENTER);
        title.setVerticalTextPosition(JLabel.BOTTOM);
        title.setHorizontalTextPosition(JLabel.CENTER);


        iconPnl.add(title);
    }
    private void createControlPanel()
    {
        controlPnl = new JPanel();
        controlPnl.setLayout(new GridLayout());
        read = new JButton("Read my fortune");
        quit = new JButton("Quit");

        controlPnl.add(quit);
        controlPnl.add(read);
        quit.addActionListener((ActionEvent ae)-> System.exit(0));
        read.addActionListener((ActionEvent ae)->
        {
            String fortune = getRandomFortune();
            displayTA.append(fortune + "\n");
        });


    }
    private void createDisplayPanel()
    {
        displayPnl = new JPanel();
        displayTA = new JTextArea(15, 50);
        displayTA.setEditable(false);
        scroller = new JScrollPane(displayTA);
        displayPnl.add(scroller);
    }

}



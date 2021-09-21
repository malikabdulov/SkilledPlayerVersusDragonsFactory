import javax.swing.*;
import java.awt.*;

public class LobbyGUI extends JFrame {
    Player player;

    public LobbyGUI(Player player) throws HeadlessException {
        this.player = player;
        setName("Here's Johnny");
        setBounds(200,200,800,600);
        setMinimumSize(new Dimension(600,500));
        setResizable(true);
        setLayout(new BorderLayout(10,10));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //-------------Stats panel--------------
        JPanel statsPanel = new JPanel();
        statsPanel.setPreferredSize(new Dimension(0,30));
        statsPanel.setLayout(new GridLayout());


        JLabel nameLabel = new JLabel(player.name + " LVL" + player.lvl);
        nameLabel.setHorizontalAlignment(JLabel.LEFT);

        JProgressBar hpBar = new JProgressBar(0, 0, 100);
        hpBar.setValue(player.hp * 100 / player.maxHp);
        hpBar.setStringPainted(true);
        hpBar.setString(player.hp + "/" + player.maxHp);
        hpBar.setForeground(Color.RED);

        JProgressBar expBar = new JProgressBar(0, 0, 1000);
        expBar.setValue(player.exp);
        expBar.setStringPainted(true);
        expBar.setString(player.exp + "/" + 1000);
        expBar.setForeground(Color.BLUE);

        JLabel statsLabel = new JLabel("Str:" + player.str +
                " Agi:" + player.agi +
                " Gold:" + player.gold);
        statsLabel.setHorizontalAlignment(JLabel.RIGHT);

        statsPanel.add(nameLabel);
        statsPanel.add(hpBar);
        statsPanel.add(expBar);
        statsPanel.add(statsLabel);
        statsPanel.setBackground(Color.RED);
        //-------------Stats panel--------------
        //-------------Backpack panel-----------
        JPanel backpackPanel = new JPanel();
        backpackPanel.setPreferredSize(new Dimension(200,0));
        backpackPanel.setBackground(Color.green);
        //-------------Backpack panel-----------
        //-------------Scroll panel-----------
        JPanel scrollPanel = new JPanel();
        scrollPanel.setPreferredSize(new Dimension(400,400));
        scrollPanel.setBackground(Color.blue);
        scrollPanel.setLayout(new BorderLayout());
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPanel.add(scrollPane, BorderLayout.CENTER);
        //-------------Scroll panel-----------
        //-------------Empty right panel-----------
        JPanel rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(200,0));
        rightPanel.setBackground(Color.black);
        //-------------Empty right panel-----------
        //-------------Navigation panel-----------
        JPanel navPanel = new JPanel();
        navPanel.setPreferredSize(new Dimension(0,240));
        navPanel.setBackground(Color.yellow);
        navPanel.setLayout(new BorderLayout());
        JLabel questionLabel = new JLabel("Where you wanna go?");
        questionLabel.setPreferredSize(new Dimension(0,50));
        questionLabel.setHorizontalAlignment(JLabel.CENTER);
        navPanel.add(questionLabel, BorderLayout.NORTH);
        JPanel btnPanel = new JPanel();
        btnPanel.setBackground(Color.darkGray);
        btnPanel.setLayout(new BoxLayout(btnPanel, BoxLayout.Y_AXIS));
        navPanel.add(btnPanel, BorderLayout.CENTER);
        JButton navBtn1 = new JButton("Darkwood");
        JButton navBtn2 = new JButton("Merchant");
        JButton navBtn3 = new JButton("Dragon's Factory");
        navBtn1.setAlignmentX(Component.CENTER_ALIGNMENT);
        navBtn2.setAlignmentX(Component.CENTER_ALIGNMENT);
        navBtn3.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnPanel.add(Box.createVerticalStrut(15));
        btnPanel.add(navBtn1);
        btnPanel.add(Box.createVerticalStrut(10));
        btnPanel.add(navBtn2);
        btnPanel.add(Box.createVerticalStrut(10));
        btnPanel.add(navBtn3);
        if (!player.haveKey){
            navBtn3.setEnabled(false);
        }
        //-------------Navigation panel-----------


        add(statsPanel, BorderLayout.NORTH);
        add(backpackPanel, BorderLayout.WEST);
        add(scrollPanel, BorderLayout.CENTER);
        add(rightPanel, BorderLayout.EAST);
        add(navPanel, BorderLayout.SOUTH);
        setVisible(true);

    }

    public static void main(String[] args) {
        new LobbyGUI(new Player("Naruto"));
    }


}

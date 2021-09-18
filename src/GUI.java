import javax.swing.*;
import java.awt.*;

public class GUI extends Thread{

    private JFrame frame;
    private JPanel panel;
    private JProgressBar hpBar, expBar;
    private JLabel statsLabel, expLabel;
    Being player;
    private int offset;

    public GUI(Being player, int offset){
        this.player = player;
        this.offset = offset;

        frame = new JFrame();
        panel = new JPanel();

        JLabel nameLabel = new JLabel("Username:");
        JLabel nameValue = new JLabel(player.name);

        JLabel hpLabel = new JLabel("HitPoints:");
        hpBar = new JProgressBar(0,0, 100);
        hpBar.setValue(player.hp);
        hpBar.setStringPainted(true);
        hpBar.setString(player.hp + "/" + player.maxHp);
        hpBar.setForeground(Color.RED);

        expLabel = new JLabel("Level: " + player.lvl);
        expBar = new JProgressBar(0,0,1000);
        expBar.setValue(player.exp);
        expBar.setStringPainted(true);
        expBar.setString(player.exp + "/" + 1000);
        expBar.setForeground(Color.BLUE);

        statsLabel = new JLabel("str: " + player.str + " agi: " + player.agi + " gold: " + player.gold);

        panel.setBorder(BorderFactory.createEmptyBorder(20,10,30,30));
        panel.setLayout(new GridLayout(0, 2));
        panel.add(nameLabel);
        panel.add(nameValue);
        panel.add(hpLabel);
        panel.add(hpBar);
        panel.add(expLabel);
        panel.add(expBar);
        panel.add(statsLabel);

        frame.add(panel);
        frame.setTitle("Game GUI");
        frame.setBounds(800, 100 + offset, 0, 0);
        frame.pack();
        frame.setVisible(true);


    }

    @Override
    public void run() {
        while (player.isAlive()){
            try {
                sleep(200);
                hpBar.setValue(player.hp*100/player.maxHp);
                hpBar.setString(player.hp + "/" + player.maxHp);
                expLabel.setText("Level: " + player.lvl);
                statsLabel.setText("str: " + player.str + " agi: " + player.agi + " gold: " + player.gold);
                expBar.setValue(player.exp);
                expBar.setString(player.exp + "/" + 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        frame.dispose();
    }
}

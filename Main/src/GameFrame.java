import javax.swing.*;
public class GameFrame extends JFrame {

    GameFrame() {
        this.add(new GamePanel());
        this.setTitle("Jump King");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();

        GamePanel gamePanel = new GamePanel();

        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

}

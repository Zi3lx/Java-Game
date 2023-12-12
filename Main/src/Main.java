import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setTitle("Jump King");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        gamePanel.startGame();

        window.pack();
        window.setVisible(true);
        window.setLocationRelativeTo(null);
    }
}
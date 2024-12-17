import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Game implements KeyListener {

    public static void main(String[] args) {
        Game game = new Game();
    }

    private GamePanel gamePanel;

    public Game() {
        String[] options = new String[] {"100% WIN", "25% WIN"};
        
        String message = "100% WIN is Easy, \n25% WIN is Difficult.";
        ImageIcon icon = new ImageIcon("1.png");
        int difficultyChoice = JOptionPane.showOptionDialog(null, message,
        "Choose level",
        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
        icon, options, options[0]);
        
        JFrame frame = new JFrame("Battleship project");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        gamePanel = new GamePanel(difficultyChoice);
        frame.getContentPane().add(gamePanel);

        frame.addKeyListener(this);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        gamePanel.handleInput(e.getKeyCode());
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
}

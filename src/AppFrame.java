import javax.swing.*;
public class AppFrame extends JFrame {
    public AppFrame(String title, int w, int h) {
        setTitle(title);
        setSize(w, h);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

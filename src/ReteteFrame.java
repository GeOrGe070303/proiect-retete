import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ReteteFrame extends JFrame {

    public ReteteFrame() {

        setTitle("Retete");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridLayout(1,3));

        ArrayList<Reteta> retete =
                ComenziSQL.getTopRetete();

        for(Reteta r : retete) {

            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel,
                    BoxLayout.Y_AXIS));

            panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            panel.add(new JLabel("Reteta: " + r.getDenumire()));
            panel.add(new JLabel("Potriviri: " + r.getPotriviri()));

            JTextArea ingrediente =
                    new JTextArea(r.getIngrediente());

            ingrediente.setEditable(false);

            panel.add(ingrediente);

            panel.add(new JLabel("Timp: "
                    + r.getTimp() + " minute"));

            JTextArea pasi =
                    new JTextArea(r.getPasi());

            pasi.setEditable(false);

            panel.add(pasi);

            add(panel);
        }

        setVisible(true);
    }
}
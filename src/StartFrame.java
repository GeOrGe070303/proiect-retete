import javax.swing.*;

public class StartFrame extends AppFrame {

    private JButton startButton;
    private JTextField ingredientField;
    private JButton nextButton;
    private JButton finishButton;

    public StartFrame() {
        super("Introducere ingrediente", 500, 300);

        startButton = new JButton("Adauga ingrediente");
        startButton.setBounds(150, 40, 200, 40);
        add(startButton);

        ingredientField = new JTextField();
        ingredientField.setBounds(125, 100, 250, 35);
        ingredientField.setVisible(false);
        add(ingredientField);

        nextButton = new JButton("Ingredient urmator");
        nextButton.setBounds(80, 160, 160, 40);
        nextButton.setVisible(false);
        add(nextButton);

        finishButton = new JButton("Finalizare");
        finishButton.setBounds(260, 160, 160, 40);
        finishButton.setVisible(false);
        add(finishButton);

        startButton.addActionListener(e -> {
            ComenziSQL.clearIngredients();

            ingredientField.setVisible(true);
            nextButton.setVisible(true);
            finishButton.setVisible(true);

            startButton.setEnabled(false);
        });

        nextButton.addActionListener(e -> {
            String ingredient = ingredientField.getText();

            if (!ingredient.isEmpty()) {
                ComenziSQL.addIngredient(ingredient);
                ingredientField.setText("");
            }
        });


        finishButton.addActionListener(e -> {
            String ingredient = ingredientField.getText();

            if (!ingredient.isEmpty()) {
                ComenziSQL.addIngredient(ingredient);
            }

            dispose();

            ReteteFrame reteteframe = new ReteteFrame();
            //reteteframe.setVisible(true);
        });
    }
}
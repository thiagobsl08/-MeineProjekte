import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class QuizCardBuilder {
    private JFrame frame;
    private JPanel panel;
    private JLabel labelQuestion;
    private JLabel labelAnswer;
    private JButton buttonNext;
    private TextArea txtquestion;
    private TextArea txtAnswer;
    private JOptionPane messageBox;
    private int counting;
    private ArrayList<String> cardslist = new ArrayList<>(5);

    public static void main(String[] args) {
        QuizCardBuilder test = new QuizCardBuilder();
        test.go();
    }

    public void go() {
        //Build and display Gui
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        panel = new JPanel();

        labelQuestion = new JLabel("Question:");
        txtquestion = new TextArea();

        labelAnswer = new JLabel("Answer:");
        txtAnswer = new TextArea();

        buttonNext = new JButton("Next Card");
        buttonNext.addActionListener(e -> saveText());

        panel.add(labelQuestion);
        panel.add(txtquestion);
        panel.add(labelAnswer);
        panel.add(txtAnswer);
        panel.add(buttonNext);

        frame.add(panel);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    public void nextCard() {
        if (counting >= 1) {
            JOptionPane.showMessageDialog(frame, "Card Saved", "Sucess", JOptionPane.YES_OPTION);
            txtquestion.setText("");
            txtAnswer.setText("");
        }
    }

    public String saveText() {
        try {
            String name = String.format("Card %s.txt", counting);
            FileWriter writer = new FileWriter(name);
            if (counting < 5) {
                cardslist.add(name);
                BufferedWriter out = new BufferedWriter(writer); // To put the keywords in the next line
                String txtQ = txtquestion.getText();
                String txtA = txtAnswer.getText();
                out.write(txtQ);
                out.newLine();
                out.write(txtA);
                out.newLine();
                out.close();
                counting++;

                nextCard(); //So, it goes to the next

                return "Text saved";
            } else {
                JOptionPane.showMessageDialog(frame, "Card Saved. That's the card numbers limit.", "The End", JOptionPane.INFORMATION_MESSAGE);
                frame.dispose();
                return "It's Over";
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            return "Saving Text failed";
        }
    }
}
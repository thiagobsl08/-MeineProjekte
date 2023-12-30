import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class QuizCardPlayer {
    public static void main(String[] args) {
        QuizCardPlayer test = new QuizCardPlayer();
        test.go();
    }
    private JFrame frame;
    private JPanel panel;
    private JButton buttonShowCard;
    private TextArea txtquestion;
    private int count;
    private String locationCardsDirectory(int cardNumber){ // Method to get the card from the especific directory
        String name = String.format("Card %s.txt",cardNumber);
        String locationFile = String.format("C:\\Users\\thgbi\\IdeaProjects\\Chapter16SavingData\\%s",name);
        return locationFile;
    }
    private void go(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        panel = new JPanel();

        txtquestion = new TextArea();
        buttonShowCard = new JButton("Show Answer");

        txtquestion.setText(gettingQuestion());
        buttonShowCard.addActionListener(e -> showAnswer());

        panel.add(txtquestion);
        panel.add(buttonShowCard);

        frame.add(panel);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
    public void goQuizCardPlayer() {
        //Build and display Gui

        }
    public String gettingQuestion(){
        try {
            FileReader reader = new FileReader(locationCardsDirectory(count));
            //Create a scanner object from FileReader
            Scanner fileReaderScan = new Scanner(reader);
            BufferedReader bufferLine = new BufferedReader(reader);
            //Create a String that will store all text in the text file
            String storeText = "";
            //Putting text from txt to created string
            while (fileReaderScan.hasNextLine()) {
                String temp = fileReaderScan.nextLine();
                storeText = temp;
                System.out.println(temp);
                break; // Stopping in the first line
            }
            return storeText;
        }
        catch (Exception e){
            e.printStackTrace();
            return "Es gibt keinen karten";
        }
    }
    private void showAnswer(){
        try {
            FileReader reader = new FileReader(locationCardsDirectory(count));
            //Create a scanner object from FileReader
            Scanner fileReaderScan = new Scanner(reader);
            BufferedReader bufferLine = new BufferedReader(reader);
            //Create a String that will store all text in the text file
            String storeText = "";
            //Putting text from txt to created string
            while (fileReaderScan.hasNextLine()) {
                String temp = fileReaderScan.nextLine();
                storeText = temp;
                System.out.println(temp);
                txtquestion.setText(storeText);
            }
            JOptionPane.showMessageDialog(frame, "Mach weiter, meinen Freund!", "The End", JOptionPane.INFORMATION_MESSAGE);
            count++;
            frame.dispose();
            go();
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(frame, "Das ist alles!", "The End", JOptionPane.INFORMATION_MESSAGE);
            frame.dispose();
            e.printStackTrace();
        }
    }
}
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

class QuizCard {
    private String question;
    private String answer;

    private int count;
    public QuizCard(int count){
        System.out.println("Setzen der karten nummer ");
        this.count = count;
    }
    public static void main(String[] args) {
        QuizCard cardData = new QuizCard(5);
        System.out.println(cardData.getQuestion());
        System.out.println(cardData.getAnswer());
    }

    private String locationCardsDirectory(int cardNumber) { // Method to get the card from the especific directory
        String name = String.format("Card %s.txt", cardNumber);
        String locationFile = String.format("C:\\Users\\thgbi\\IdeaProjects\\Chapter16SavingData\\%s", name);
        return locationFile;
    }
    public String getAnswer() {
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
                // Stopping in the first line
            } return "Card" + " " + count + " " + "A" + " " + storeText;
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Es gibt keinen karten";
        }
    }
    public String getQuestion() {
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
                break; // Stopping in the first line
            }
            return "Card" + " " + count + " " + "Q" + " " + storeText;
        } catch (Exception e) {
            e.printStackTrace();
            return "Es gibt keinen karten";
        }
    }
}

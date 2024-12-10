import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.text.*;
import java.util.ArrayList;

/**
 * Class for the Blackjack game logic and GUI. Extends Application for JavaFX.
 * @author Carter Close, Luke Kedrowski
 * @version 3.0
 */
public class Blackjack extends Application {
    //JavaFX elements
    private Rectangle dealerC1, dealerC2, dealerC3, dealerC4, dealerC5;
    private Rectangle playerC1, playerC2, playerC3, playerC4, playerC5, sideBarRect;
    private Text dealerT1, dealerT2, dealerT3, dealerT4, dealerT5, playerT1, playerT2, playerT3, playerT4, playerT5;
    private Text resultText, escText, titleText, noteText;
    private Button hitButton, standButton;
    private TextField playerScore, dealerScore;
    private Font arial = new Font("Arial", 26);
    private Scene scene;
    private Group root;
    //Regular elements
    private DealerHand dealerHand = new DealerHand();
    private Hand playerHand = new Hand();
    private ArrayList<Card> deck;
    private Text[] dealerText = new Text[5];
    private Text[] playerText = new Text[5];
    private int hitCount = 0;
    private int dealCount = 0;

    /**
     * Standard JavaFX start method. Creates the root and scene, sets the stage, and calls methods for each part of the scene
     * @param stage is the stage for the GUI
     */
    @Override
    public void start(Stage stage) {
        root = new Group();
        scene = new Scene(root, 1000, 700);
        scene.setFill(Color.web("#4fa72e"));
        createCards();
        createCardText();
        createBottom();
        createSideBar();
        stage.setTitle("Blackjack");
        stage.setScene(scene);
        stage.show();
        makeDeck();
    }

    /**
     * Method to create each card for the dealer and player
     * @param root is the root group so it can be added to the scene
     */
    public void createCards() {
        dealerC1 = new Rectangle(25, 80, 125, 180);
        dealerC1.setFill(Color.WHITE);
        dealerC2 = new Rectangle(170, 80, 125, 180);
        dealerC2.setFill(Color.WHITE);
        dealerC3 = new Rectangle(315, 80, 125, 180);
        dealerC3.setFill(Color.WHITE);
        dealerC4 = new Rectangle(460, 80, 125, 180);
        dealerC4.setFill(Color.WHITE);
        dealerC5 = new Rectangle(605, 80, 125, 180);
        dealerC5.setFill(Color.WHITE);
        playerC1 = new Rectangle(25, 370, 125, 180);
        playerC1.setFill(Color.WHITE);
        playerC2 = new Rectangle(170, 370, 125, 180);
        playerC2.setFill(Color.WHITE);
        playerC3 = new Rectangle(315, 370, 125, 180);
        playerC3.setFill(Color.WHITE);
        playerC4 = new Rectangle(460, 370, 125, 180);
        playerC4.setFill(Color.WHITE);
        playerC5 = new Rectangle(605, 370, 125, 180);
        playerC5.setFill(Color.WHITE);
        root.getChildren().addAll(dealerC1, dealerC2, dealerC3, dealerC4, dealerC5, playerC1, playerC2, playerC3, playerC4, playerC5);
    }

    /**
     * Method for creating the card text that is shown each time the hit button is pressed
     * @param root is the root group so it can be added to the scene
     * Needs work, but as long as set text works, it'll do
     */
    public void createCardText() {
        dealerT1 = new Text(55,150,"");
        dealerText[0] = dealerT1;
        dealerT2 = new Text(200,150,"");
        dealerText[1] = dealerT2;
        dealerT3 = new Text(345,150,"");
        dealerText[2] = dealerT3;
        dealerT4 = new Text(490,150,"");
        dealerText[3] = dealerT4;
        dealerT5 = new Text(635,150,"");
        dealerText[4] = dealerT5;
        for(int i = 0;i < 5; i++) {
            dealerText[i].setFont(new Font(70));
            root.getChildren().addAll(dealerText[i]);
        }
        playerT1 = new Text(55,440,"");
        playerText[0] = playerT1;
        playerT2 = new Text(200,440,"");
        playerText[1] = playerT2;
        playerT3 = new Text(345,440,"");
        playerText[2] = playerT3;
        playerT4 = new Text(490,440,"");
        playerText[3] = playerT4;
        playerT5 = new Text(635,440,"");
        playerText[4] = playerT5;
        for(int i = 0;i < 5; i++) {
            playerText[i].setFont(new Font(70));
            root.getChildren().addAll(playerText[i]);
        }
    }

    /**
     * Method for creating the bottom area. Creates the two buttons and the score textFields
     * Also implements ActionEvents for both buttons, which call hit()/stand() respectively
     * @param root is the root group so it can be added to the scene
     */
    public void createBottom() {
        hitButton = new Button("Hit");
        hitButton.setPrefSize(250, 50);
        hitButton.setStyle("-fx-background-color: #c2f1c8; ");
        hitButton.setTextFill(Color.BLACK);
        hitButton.setFont(arial);
        hitButton.setLayoutX(250);
        hitButton.setLayoutY(650);
        hitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(!playerHand.getStand()) {
                    hit(playerHand,deck);
                }
                playerScore.setText("Your score: "  + playerHand.getValue());
                
                if(!dealerHand.getStand()) {
                    dealerHit(dealerHand,deck);
                }
                dealerScore.setText("Dealer score: "  + dealerHand.getValue());
                if(dealerHand.getStand() && playerHand.getStand()) {
                    winner(playerHand,dealerHand);
                }
            }
        });
        standButton = new Button("Stand");
        standButton.setPrefSize(250, 50);
        standButton.setStyle("-fx-background-color: #ff0002; ");
        standButton.setTextFill(Color.WHITE);
        standButton.setFont(arial);
        standButton.setLayoutX(500);
        standButton.setLayoutY(650);
        standButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                playerHand.stand();
            }
        });
        playerScore = new TextField("Your score: ");
        playerScore.setFont(arial);
        playerScore.setPrefSize(250, 50);
        playerScore.setLayoutX(0);
        playerScore.setLayoutY(650);
        dealerScore = new TextField("Dealer score: ");
        dealerScore.setFont(arial);
        dealerScore.setPrefSize(250, 50);
        dealerScore.setLayoutX(750);
        dealerScore.setLayoutY(650);
        root.getChildren().addAll(hitButton, standButton, playerScore, dealerScore);
    }

    /**
     * Method for creating the sidebar at the end that displays text
     * @param root is the root group so it can be added to the scene
     */
    public void createSideBar() {
        sideBarRect = new Rectangle(750, 0, 250, 650);
        sideBarRect.setFill(Color.web("#156183"));
        root.getChildren().add(sideBarRect);
        titleText = new Text("Blackjack");
        titleText.setFont(new Font("Arial", 40));
        titleText.setFill(Color.WHITE);
        titleText.setLayoutX(790);
        titleText.setLayoutY(50);
        root.getChildren().add(titleText);
        noteText = new Text("Press the Hit button to get a card, and the Stand button to end your turn.\n\nDealer must draw to 16 and stands on 17.");
        noteText.setFont(new Font("Arial", 20));
        noteText.setFill(Color.WHITE);
        noteText.setLayoutX(775);
        noteText.setLayoutY(105);
        noteText.setWrappingWidth(200);
        root.getChildren().add(noteText);
        Line line1 = new Line(770, 70, 980, 70);
        line1.setStrokeWidth(3);
        line1.setStroke(Color.WHITE);
        Line line2 = new Line(770, 270, 980, 270);
        line2.setStrokeWidth(3);
        line2.setStroke(Color.WHITE);
        root.getChildren().addAll(line1, line2);

    }

    /**
     * Method for creating the deck
     * Creates it as an ArrayList of Card objects, then adds a card for each rank of each suit
     * Deck making code may need some tweaks but the base logic works for what we need
     */
    public void makeDeck() {
        this.deck = new ArrayList<Card>();
        for(Suit s: Suit.values()) {
            for(Rank r: Rank.values()) {
                Card card = new Card(s,r);
                deck.add(card);
            }
        }
        return;
    }

    /**
     * Method for hitting the deck when pressing the button
     * @param hand is the player's hand that will then receive the card
     * @param deck is the deck built in buildDeck() method
     */
    public void hit(Hand hand, ArrayList<Card> deck) {
        Card drawn = hand.hit(deck);
        if(drawn.getSuit().ordinal()==1||drawn.getSuit().ordinal()==2) {
            playerText[hitCount].setFill(Color.RED);  
        }
        playerText[hitCount].setText(drawn.toString());
        hitCount++;
        if(hitCount >= 5) {
            playerHand.stand();
        }
    }

    /**
     * Method for the dealer hitting the deck when pressing the button
     * @param hand is the dealer's hand
     * @param deck is the deck built in buildDeck() method
     */
    public void dealerHit(Hand hand, ArrayList<Card> deck) {
        Card drawn = hand.hit(deck);
        if(drawn.getSuit().ordinal()==1||drawn.getSuit().ordinal()==2) {
            dealerText[dealCount].setFill(Color.RED);  
        }
        dealerText[dealCount].setText(drawn.toString());
        dealCount++;
        if(dealCount >= 5) {
            dealerHand.stand();
        }
    }

    /**
     * Method for determining who wins.
     * Uses the compareTo method, the result is what decides the winner.
     * Also adds the final text to the screen.
     * @param playerHand is the player's hand
     * @param dealerHand is the dealer's hand
     */
    public void winner(Hand playerHand, Hand dealerHand) {
        resultText = new Text("");
        if(playerHand.getValue() > 21) {
            resultText.setText("You\nbusted! Press ESC to exit.");
        }
        else if(dealerHand.getValue() > 21) {
            resultText.setText("Dealer busted! Press ESC to exit.");
        }
        else {
            int result = playerHand.compareTo(dealerHand);
            if (result > 0) {
                resultText.setText("You won! Press ESC to exit.");
            } else if (result < 0) {
                resultText.setText("You lost! Press ESC to exit.");
            } else if (result == 0) {
                resultText.setText("You tied the dealer! Press ESC to exit.");
            }
        }
        resultText.setFont(Font.font("arial", 40));
        resultText.setFill(Color.WHITE);
        resultText.setLayoutX(780);
        resultText.setLayoutY(400);
        resultText.setWrappingWidth(200);
        root.getChildren().add(resultText);
        exit();
    }

    /**
     * Method for exiting the program
     * Checks a KeyEvent for the ESC key, if it is, then the program quits
     */
    public void exit() {
        scene.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.ESCAPE)) {
                Platform.exit();
            }
        });
    }

    /**
     * Main method, calls the launch() method that JavaFX requires
     * @param args allows for CLI arguments, not really needed but it's a force of habit
     */
    public static void main(String[] args) {
        launch(args);
    }
}

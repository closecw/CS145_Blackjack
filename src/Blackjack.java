import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.text.*;

/*
    @Version 1.0, this is the base. I will increment it by .01 each time I push a new change
 */
public class Blackjack extends Application {
    private Button hitButton, standButton;
    private TextField playerScore, dealerScore;
    private Text winText, loseText;
    private Rectangle dealerC1, dealerC2, dealerC3, dealerC4, dealerC5, playerC1, playerC2, playerC3, playerC4, playerC5, sideBarRect;
    private Font arial = new Font("Arial", 26);

    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, 1000, 700);
        scene.setFill(Color.web("#4fa72e"));
        createCards(root);
        createBottom(root);
        createSideBar(root);
        stage.setTitle("Blackjack");
        stage.setScene(scene);
        stage.show();
    }

    public void createCards(Group root) {
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

    public void createBottom(Group root) {
        //TODO: Create event handlers for buttons, once logic is in, continuously update score shown
        hitButton = new Button("Hit");
        hitButton.setPrefSize(250, 50);
        hitButton.setStyle("-fx-background-color: #c2f1c8; ");
        hitButton.setTextFill(Color.BLACK);
        hitButton.setFont(arial);
        hitButton.setLayoutX(250);
        hitButton.setLayoutY(650);
        standButton = new Button("Stand");
        standButton.setPrefSize(250, 50);
        standButton.setStyle("-fx-background-color: #ff0002; ");
        standButton.setTextFill(Color.WHITE);
        standButton.setFont(arial);
        standButton.setLayoutX(500);
        standButton.setLayoutY(650);
        playerScore = new TextField("Your score: " /* + player.getScore()*/);
        playerScore.setFont(arial);
        playerScore.setPrefSize(250, 50);
        playerScore.setLayoutX(0);
        playerScore.setLayoutY(650);
        dealerScore = new TextField("Dealer score: "/* + dealer.getScore()*/);
        dealerScore.setFont(arial);
        dealerScore.setPrefSize(250, 50);
        dealerScore.setLayoutX(750);
        dealerScore.setLayoutY(650);
        root.getChildren().addAll(hitButton, standButton, playerScore, dealerScore);
    }

    public void createSideBar(Group root) {
        //TODO: Create win/lose message, again/exit buttons, event handlers
        sideBarRect = new Rectangle(750, 0, 250, 650);
        sideBarRect.setFill(Color.web("#156183"));
        root.getChildren().addAll(sideBarRect);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

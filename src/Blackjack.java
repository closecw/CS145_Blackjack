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

    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, 1000, 700);
        scene.setFill(Color.web("#4fa72e"));
        createCards();
        createButtons();
        sideBarRect = new Rectangle(750, 0, 455, 700);
        sideBarRect.setFill(Color.web("#156183"));
        root.getChildren().addAll(dealerC1, dealerC2, dealerC3, dealerC4, dealerC5, playerC1, playerC2, playerC3, playerC4, playerC5, sideBarRect);
        stage.setTitle("Blackjack");
        stage.setScene(scene);
        stage.show();
    }

    public void createCards() {
        dealerC1 = new Rectangle(25, 50, 110, 150);
        dealerC1.setFill(Color.WHITE);
        dealerC2 = new Rectangle(155, 50, 110, 150);
        dealerC2.setFill(Color.WHITE);
        dealerC3 = new Rectangle(285, 50, 110, 150);
        dealerC3.setFill(Color.WHITE);
        dealerC4 = new Rectangle(415, 50, 110, 150);
        dealerC4.setFill(Color.WHITE);
        dealerC5 = new Rectangle(545, 50, 110, 150);
        dealerC5.setFill(Color.WHITE);
        playerC1 = new Rectangle(25, 400, 110, 150);
        playerC1.setFill(Color.WHITE);
        playerC2 = new Rectangle(155, 400, 110, 150);
        playerC2.setFill(Color.WHITE);
        playerC3 = new Rectangle(285, 400, 110, 150);
        playerC3.setFill(Color.WHITE);
        playerC4 = new Rectangle(415, 400, 110, 150);
        playerC4.setFill(Color.WHITE);
        playerC5 = new Rectangle(545, 400, 110, 150);
        playerC5.setFill(Color.WHITE);
    }

    public void createButtons() {

    }

    public static void main(String[] args) {
        launch(args);
    }
}

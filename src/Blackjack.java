import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
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

    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, 500, 500);
        Rectangle r1 = new Rectangle(50, 50, 50, 50);
        root.getChildren().add(r1);
        stage.setTitle("Blackjack");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

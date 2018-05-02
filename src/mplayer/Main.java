package mplayer;
	
import javafx.application.Application;
import javafx.stage.Stage;
import mplayer.view.Player;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
	Player player = new Player("file:///C:/Users/Charles/eclipse-workspace/MPlayer/media/26.mp4");
	Scene scene = new Scene(player, 720, 400, Color.BLACK);
	primaryStage.setScene(scene);
	primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

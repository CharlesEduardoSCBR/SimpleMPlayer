package mplayer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import mplayer.view.Player;
import mplayer.view.menu.MenuBar;

public class Main extends Application {
	
	private Player player;
	private MenuBar menu;
	
	@Override
	public void start(Stage primaryStage) {

		menu = new MenuBar(primaryStage, player);
		
		player = new Player("file:///C:/Users/Charles/eclipse-workspace/MPlayer/media/26.mp4");
		player.setTop(menu);
		
		Scene scene = new Scene(player, 720, 510, Color.BLACK);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		player = menu.init(player);
	}

	public static void main(String[] args) {
		launch(args);
	}
}

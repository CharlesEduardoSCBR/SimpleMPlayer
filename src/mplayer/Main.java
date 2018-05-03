package mplayer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import mplayer.view.Player;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {

		MenuItem open = new MenuItem("Abrir");
		Menu file = new Menu("Arquivos");
		MenuBar menu = new MenuBar();
		
		file.getItems().add(open);
		menu.getMenus().add(file);
		
		Player player = new Player("file:///C:/Users/Charles/eclipse-workspace/MPlayer/media/26.mp4");
		player.setTop(menu);
		
		Scene scene = new Scene(player, 720, 510, Color.BLACK);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

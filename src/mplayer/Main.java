package mplayer;

import java.io.File;
import java.net.MalformedURLException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import mplayer.view.Player;

public class Main extends Application {
	
	private Player player;
	private FileChooser fileChooser;
	private File fileO;
	private Scene scene;
	
	@Override
	public void start(final Stage primaryStage) {

		MenuItem open = new MenuItem("Abrir");
		Menu file = new Menu("Arquivos");
		MenuBar menu = new MenuBar();
		
		file.getItems().add(open);
		menu.getMenus().add(file);
		
		fileChooser = new FileChooser();
		
		open.setOnAction(evt -> {
			fileO = fileChooser.showOpenDialog(primaryStage);
			
			if (fileO != null) {
				try {
					player = new Player(fileO.toURI().toURL().toExternalForm());
					scene = new Scene(player, 720, 510, Color.BLACK);
					primaryStage.setScene(scene);
					
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
			}
		});
		
		player = new Player("file:///C:/Users/Charles/eclipse-workspace/MPlayer/media/26.mp4");
		player.setTop(menu);
		
		Scene scene = new Scene(player, 720, 510, Color.BLACK);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

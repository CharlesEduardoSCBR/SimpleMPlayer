package mplayer.view.menu;

import java.io.File;
import java.net.MalformedURLException;

import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import mplayer.view.Player;

public class MenuBar extends javafx.scene.control.MenuBar {

	private Menu file;
	private MenuItemOpen open;
	private File fileMovie;
	private Player player;
	private Scene scene;
	private Stage stage;

	public MenuBar(Stage stage, Player player) {
		this.stage = stage;
		this.open = new MenuItemOpen(this.stage);
		this.file = new Menu("Arquivos");
		this.player = player;

		this.file.getItems().add(open);
		this.getMenus().add(file);
	}

	public Player init(Player player) {
		this.player = player;

		this.open.setOnAction(evt -> {
			try {
				player.setStopPlayer();
				this.fileMovie = this.open.getFile();
				this.player = new Player(fileMovie.toURI().toURL().toExternalForm());
				this.player.setTop(this);

				scene = new Scene(this.player, 720, 510, Color.BLACK);
				this.stage.setScene(scene);
				this.stage.show();

			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		});
		return this.player;
	}
}

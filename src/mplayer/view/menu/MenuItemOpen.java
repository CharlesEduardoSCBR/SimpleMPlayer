package mplayer.view.menu;

import java.io.File;
import java.net.MalformedURLException;

import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MenuItemOpen extends MenuItem {

	private FileChooser fileChooser;
	private File file;
	private Stage stage;
	
	public MenuItemOpen(Stage stage) {
		this.setText("Abrir");
	}
	
	protected File getFile() throws MalformedURLException {
		fileChooser = new FileChooser();
		file = fileChooser.showOpenDialog(stage);
		
		if (file == null) {
			throw new MalformedURLException("Arquivo Inválido");
		}
		return file;
	}
}

package mplayer.view;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class Player extends BorderPane {

	Media media;
	MediaPlayer player;
	MediaView view;
	Pane mPane;
	MediaBar bar;
	
	public Player(String file) {
		media = new Media(file);
		player = new MediaPlayer(media);
		view = new MediaView(player);
		mPane = new Pane();
		bar = new MediaBar(player);
		
		mPane.getChildren().add(view);
		
		setCenter(mPane);
		setBottom(bar);
		
		player.play();
	}
}

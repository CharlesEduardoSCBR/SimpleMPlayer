package mplayer.view;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;

public class MediaBar extends HBox {

	MediaPlayer player;

	Slider time = new Slider();
	Slider volume = new Slider();
	Button playButton = new Button("||");
	Label lbVolume = new Label("Volume .: ");

	public MediaBar(MediaPlayer play) {
		player = play;

		setAlignment(Pos.CENTER);
		setPadding(new Insets(5, 10, 5, 10));

		volume.prefWidth(70);
		volume.minWidth(30);
		volume.setValue(100);

		HBox.setHgrow(time, Priority.ALWAYS);

		playButton.setPrefWidth(30);

		getChildren().add(playButton);
		getChildren().add(time);
		getChildren().add(lbVolume);
		getChildren().add(volume);

		playButton.setOnAction(event -> {
			Status status = player.getStatus();

			if (status == Status.PLAYING) {
				if (player.getCurrentTime().greaterThanOrEqualTo(player.getTotalDuration())) {
					player.seek(player.getStartTime());
					player.play();
				} else {
					player.stop();
					playButton.setText(">");
				}
			}

			if (status == Status.PAUSED || status == Status.HALTED || status == Status.STOPPED) {
				player.play();
				playButton.setText("||");
			}
		});

		player.currentTimeProperty().addListener(event -> {
			upatesValue();
		});

		time.valueProperty().addListener(evt -> {
			if (time.isPressed()) {
				player.seek(player.getMedia().getDuration().multiply(time.getValue() / 100));
			}
		});
	}

	protected void upatesValue() {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				time.setValue(player.getCurrentTime().toMillis() / player.getTotalDuration().toMillis() * 100);
			}
		});

	}
}

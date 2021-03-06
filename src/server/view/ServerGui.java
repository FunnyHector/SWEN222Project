package server.view;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.util.Duration;

/**
 * this class represents the Server GUI which is just basically used to display
 * information about the server, like port number, name, ip address, which users
 * are currently on the server ect... this is info then can be used by the
 * client to connect to the game.NOTE: this GUI only outputs information it does
 * not actually takes any in.
 *
 * @author Dipen Patel (300304965)
 *
 */
public class ServerGui extends Application {

	private Stage window;
	private BorderPane borderPane;
	private Label textLabel;
	private FadeTransition ft;
	public static String ip;
	public static int port;

	/**
	 * This constructor for the ServerGui is just a place holder.
	 */
	public ServerGui() {
		// this is just a place holder constructor to stop the use of default
		// constructor
	}

	@Override
	public void start(Stage mainWindow) throws Exception {
		window = mainWindow;
		window.setTitle("Plague Game Server");
		borderPane = new BorderPane();
		textLabel = new Label();
		textLabel.getStyleClass().add("root-server");
		setText();
		ft = new FadeTransition(Duration.millis(4000), textLabel);
		ft.setFromValue(0.0);
		ft.setToValue(1.0);
		ft.play();
		textLabel.setWrapText(true);
		borderPane.setCenter(textLabel);
		Scene mainScene = new Scene(borderPane, 300, 300);
		window.setScene(mainScene);
		mainScene.getStylesheets().add(this.getClass().getResource("/main.css").toExternalForm());
		window.show();
		window.setOnCloseRequest(e -> Platform.exit());
		window.setOnCloseRequest(e -> System.exit(0));
	}

	/**
	 * this method is used to set the information about the server to the GUI
	 */
	public void setText() {
		textLabel.setText("Server Address: " + ip + " \nPort Number: " + port);
	}

	/**
	 * This main method is only here for testing the server Gui
	 */
	public static void main(String[] args) {
		launch(args);
	}
}

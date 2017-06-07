package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		for (int i = 0; i < 1; i++) {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("../comps/linechart/LineChartView.fxml"));
			BorderPane rootPane = loader.load();

			// get screen size
			GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
			int width = gd.getDisplayMode().getWidth();
			int height = gd.getDisplayMode().getHeight();

			Stage st = new Stage();
			st.setScene(new Scene(rootPane));
			st.setTitle("Solarcar Chart Test");
			st.setWidth(width / 2);
			st.setHeight(height / 2);
			st.show();
		}
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}

}
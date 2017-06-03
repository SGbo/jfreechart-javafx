package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		System.out.println("Series added");


		for (int i = 0; i < 1; i++) {
			BorderPane rootPane = FXMLLoader.load(getClass().getClassLoader().getResource("MainView.fxml"));

			Stage st = new Stage();
			st.setScene(new Scene(rootPane));
			st.setTitle("Solarcar Chart Test");
			st.setWidth(700);
			st.setHeight(390);
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

//package main;
//
//import java.awt.*;
//import java.util.Date;
//
//import javafx.application.Application;
//import javafx.application.Platform;
//import javafx.concurrent.Task;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//import org.jfree.chart.JFreeChart;
//import org.jfree.chart.axis.DateAxis;
//import org.jfree.chart.axis.NumberAxis;
//import org.jfree.chart.axis.ValueAxis;
//import org.jfree.chart.block.BlockBorder;
//import org.jfree.chart.fx.ChartViewer;
//import org.jfree.chart.labels.XYToolTipGenerator;
//import org.jfree.chart.plot.XYPlot;
//import org.jfree.chart.renderer.xy.SamplingXYLineRenderer;
//import org.jfree.chart.title.TextTitle;
//import org.jfree.chart.urls.XYURLGenerator;
//import org.jfree.data.time.Millisecond;
//import org.jfree.data.time.TimeSeries;
//import org.jfree.data.time.TimeSeriesCollection;
//import org.jfree.data.xy.XYDataset;
//import org.jfree.chart.ui.HorizontalAlignment;
//
//public class SolarCarTest extends Application {
//
//	private static boolean run = true;
//
//	private static JFreeChart createChart(XYDataset ds1, XYDataset ds2) {
//
//		ValueAxis timeAxis = new DateAxis("Test");
//		timeAxis.setLowerMargin(0.02); // reduce the default margins
//		timeAxis.setUpperMargin(0.02);
//		NumberAxis valueAxis = new NumberAxis("Test");
//		valueAxis.setAutoRangeIncludesZero(false); // override default
//		XYPlot plot = new XYPlot(ds1, timeAxis, valueAxis, null);
//
//		XYToolTipGenerator toolTipGenerator = null;
//
//		XYURLGenerator urlGenerator = null;
//
//		SamplingXYLineRenderer renderer = new SamplingXYLineRenderer();
//
//		// XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer(true,
//		// false);
//		renderer.setDefaultToolTipGenerator(toolTipGenerator);
//		renderer.setURLGenerator(urlGenerator);
//
//		plot.setRenderer(renderer);
//
//		JFreeChart chart = new JFreeChart("SolarCar Test", JFreeChart.DEFAULT_TITLE_FONT, plot, true);
//
//		String fontName = "Palatino";
//		chart.getTitle().setFont(new Font(fontName, Font.BOLD, 18));
//		chart.addSubtitle(new TextTitle("Source: http://www.ico.org/historical/2010-19/PDF/HIST-PRICES.pdf",
//				new Font(fontName, Font.PLAIN, 14)));
//
//		// XYPlot plot = (XYPlot) chart.getPlot();
//		plot.setDomainPannable(true);
//		plot.setRangePannable(true);
//		plot.setDomainCrosshairVisible(true);
//		plot.setRangeCrosshairVisible(true);
//
//		// x-axis
//		plot.getDomainAxis().setLowerMargin(0.0);
//		plot.getDomainAxis().setLabelFont(new Font(fontName, Font.BOLD, 14));
//		plot.getDomainAxis().setTickLabelFont(new Font(fontName, Font.PLAIN, 12));
//
//		// y-axis
//		plot.getRangeAxis().setLabelFont(new Font(fontName, Font.BOLD, 14));
//		plot.getRangeAxis().setTickLabelFont(new Font(fontName, Font.PLAIN, 12));
//
//		// legend
//		chart.getLegend().setItemFont(new Font(fontName, Font.PLAIN, 14));
//		chart.getLegend().setFrame(BlockBorder.NONE);
//		chart.getLegend().setHorizontalAlignment(HorizontalAlignment.CENTER);
//
//		final NumberAxis axis2 = new NumberAxis("Secondary");
//		plot.setRangeAxis(1, axis2);
//		plot.setDataset(1, ds2);
//		plot.mapDatasetToRangeAxis(1, 1);
//
//		return chart;
//
//	}
//
//	/**
//	 * Creates a dataset, consisting of two series of monthly data.
//	 *
//	 * @return the dataset.
//	 */
//	private static TimeSeriesCollection createDataset() {
//
//		TimeSeries s1 = new TimeSeries("Voltage");
//
//		TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();
//		timeSeriesCollection.addSeries(s1);
//
//		return timeSeriesCollection;
//	}
//
//	private static TimeSeriesCollection createDataset2() {
//		TimeSeries s2 = new TimeSeries("Speed");
//
//		TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();
//		timeSeriesCollection.addSeries(s2);
//
//		return timeSeriesCollection;
//	}
//
//	@Override
//	public void start(Stage stage) throws Exception {
//		System.out.println("Series added");
//		final TimeSeriesCollection ds1 = createDataset();
//		final TimeSeriesCollection ds2 = createDataset2();
//
//		JFreeChart chart = createChart(ds1, ds2);
//		ChartViewer viewer = new ChartViewer(chart);
//		stage.setScene(new Scene(viewer));
//		stage.setTitle("JFreeChart: TimeSeriesFXDemo1.java");
//		stage.setWidth(700);
//		stage.setHeight(390);
//		stage.show();
//
//		Task task = new Task() {
//			private int counter = 1;
//
//			@Override
//			protected Void call() throws Exception {
//				while (run) {
//					Platform.runLater(new Runnable() {
//						TimeSeries s1 = (TimeSeries) ds1.getSeries().get(0);
//						TimeSeries s2 = (TimeSeries) ds2.getSeries().get(0);
//
//						@Override
//						public void run() {
//							boolean notify = counter % 5 == 0;
//
//							Date date = new Date();
//							Millisecond millisecond = new Millisecond(date);
//
//							double value = 70.0 + Math.random() * 5.0;
//
//							s1.add(millisecond, value, false);
//							s2.add(millisecond, 150 + Math.random() * 3.0, notify);
//							counter++;
//						}
//					});
//
//					try {
//						Thread.sleep(200);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//
//				return null;
//			}
//		};
//
//		Thread th = new Thread(task);
//		th.setDaemon(true);
//		th.start();
//	}
//
//	/**
//	 * @param args
//	 *            the command line arguments
//	 */
//	public static void main(String[] args) {
//		launch(args);
//	}
//
//}
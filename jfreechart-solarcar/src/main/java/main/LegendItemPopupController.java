package main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import org.jfree.chart.entity.LegendItemEntity;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class LegendItemPopupController implements Initializable {
    @FXML
    private ChoiceBox axisChoiceBox;
    @FXML
    private ColorPicker colorPicker;

    private LegendItemEntity legendItemEntity;
    private XYPlot plot;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setPlot(XYPlot plot) {
        this.plot = plot;
    }

    public void setLegendItemEntity(LegendItemEntity legendItemEntity) {
        this.legendItemEntity = legendItemEntity;
    }

    @FXML
    private void onColorChanged() {
        javafx.scene.paint.Color fx = colorPicker.getValue();
        java.awt.Color color = new java.awt.Color((float) fx.getRed(),
                (float) fx.getGreen(),
                (float) fx.getBlue(),
                (float) fx.getOpacity());

        XYDataset dataset = (XYDataset)legendItemEntity.getDataset();

        int seriesIndex = dataset.indexOf(legendItemEntity.getSeriesKey());

        plot.getRendererForDataset(dataset).setSeriesPaint(seriesIndex, color);
    }
}

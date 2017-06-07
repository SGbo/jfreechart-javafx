package comps.legenditempopup;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import org.jfree.chart.entity.LegendItemEntity;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import utils.FxUtils;

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
        // not implemented yet
    }

    public void initController(XYPlot plot, LegendItemEntity legendItemEntity) {
        this.plot = plot;
        this.legendItemEntity = legendItemEntity;

        XYDataset dataSet = (XYDataset)legendItemEntity.getDataset();

        int seriesIndex = dataSet.indexOf(legendItemEntity.getSeriesKey());
        Paint paint = plot.getRendererForDataset(dataSet).getSeriesPaint(seriesIndex);

        if (paint instanceof Color) {
            colorPicker.setValue(FxUtils.fromAwtColor((Color)paint));
        }
//        colorPicker.setValue(Color.valueOf(color));
    }

    @FXML
    private void onColorChanged() {
        XYDataset dataSet = (XYDataset)legendItemEntity.getDataset();

        int seriesIndex = dataSet.indexOf(legendItemEntity.getSeriesKey());

        plot.getRendererForDataset(dataSet).setSeriesPaint(seriesIndex,
                FxUtils.toAwtColor(colorPicker.getValue()));
    }
}
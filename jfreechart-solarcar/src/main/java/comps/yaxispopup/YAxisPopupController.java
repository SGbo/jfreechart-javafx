package comps.yaxispopup;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import org.jfree.chart.axis.NumberAxis;

import java.net.URL;
import java.util.ResourceBundle;

public class YAxisPopupController implements Initializable {
    @FXML
    private TextField nameEdit;
    @FXML
    private CheckBox autoRangeCheckBox;
    @FXML
    private TextField lowerBoundEdit;
    @FXML
    private TextField upperBoundEdit;
    @FXML
    private CheckBox reverseDirectionCheckBox;

    private NumberAxis axis;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        autoRangeCheckBox.selectedProperty().addListener(ie -> {
            axis.setAutoRange(autoRangeCheckBox.isSelected());
            lowerBoundEdit.setDisable(autoRangeCheckBox.isSelected());
            upperBoundEdit.setDisable(autoRangeCheckBox.isSelected());
            updateRange();
        });
    }

    private void updateRange() {
        if (axis.isAutoRange()) {
            return;
        }

        String okStyle = "-fx-control-inner-background: white;";
        String errStyle = "-fx-control-inner-background: red;";

        try {
            double lowerBound = Double.parseDouble(lowerBoundEdit.getText());
            double upperBound = Double.parseDouble(upperBoundEdit.getText());

            if (lowerBound < upperBound) {
                axis.setRange(lowerBound, upperBound);
                lowerBoundEdit.setStyle(okStyle);
                upperBoundEdit.setStyle(okStyle);
            } else {
                lowerBoundEdit.setStyle(errStyle);
                upperBoundEdit.setStyle(errStyle);
            }
        } catch (NumberFormatException e) {
            lowerBoundEdit.setStyle(errStyle);
            upperBoundEdit.setStyle(errStyle);
        }
    }

    @FXML
    private void onNameChanged() {
        axis.setLabel(nameEdit.getText());
    }

    @FXML
    private void onReverseDirectionCheckBoxClicked() {
        axis.setInverted(reverseDirectionCheckBox.isSelected());
    }

    @FXML
    private void onAutoRangeCheckBoxClicked() {
        axis.setAutoRange(autoRangeCheckBox.isSelected());
    }

    @FXML
    private void onMinimumChanged() {
        try {
            updateRange();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onMaximumChanged() {
        try {
            updateRange();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void initController(NumberAxis axis) {
        this.axis = axis;
        reverseDirectionCheckBox.setSelected(axis.isInverted());
        lowerBoundEdit.setText(String.valueOf(axis.getLowerBound()));
        upperBoundEdit.setText(String.valueOf(axis.getUpperBound()));
        autoRangeCheckBox.setSelected(axis.isAutoRange());
        nameEdit.setText(axis.getLabel());
        updateRange();
    }
}
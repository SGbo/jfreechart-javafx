package comps.xaxispopup;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by sebo on 07.06.17.
 */
public class XAxisPopupController implements Initializable {
    @FXML
    ChoiceBox<String> hourChoiceBox;
    @FXML
    ChoiceBox<String> minuteChoiceBox;
    @FXML
    ChoiceBox<String> secondChoiceBox;

    ObservableList<String> hourChoiceList = FXCollections.observableArrayList();
    ObservableList<String> minuteChoiceList = FXCollections.observableArrayList();
    ObservableList<String> secondChoiceList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        hourChoiceList.add("00");
        hourChoiceList.add("01");
        hourChoiceBox.setItems(hourChoiceList);
    }
}

package controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashBoardController implements Initializable {
    @FXML
    private JFXButton btnStudetnForm;
    @FXML
    private JFXButton btnCourseForm;

    @FXML
    private AnchorPane dashBoardPane;

    @FXML
    private AnchorPane courseForm;

    @FXML
    private AnchorPane studentForm;


    private void setNode(Node node) {
        dashBoardPane.getChildren().clear();
        dashBoardPane.getChildren().add(node);

        FadeTransition fd = new FadeTransition(Duration.millis(1500));
        fd.setNode(node);
        fd.setFromValue(0.1);
        fd.setToValue(1);
        fd.setCycleCount(1);
        fd.setAutoReverse(false);
        fd.play();
    }

    @FXML
    void btnCourseFormClick(ActionEvent event) throws IOException {
        courseForm = FXMLLoader.load(getClass().getResource("../view/CourseForm.fxml"));
        setNode(courseForm);
    }

    @FXML
    void btnStudentFormClick(ActionEvent event) throws IOException {
        studentForm = FXMLLoader.load(getClass().getResource("../view/StudentForm.fxml"));
        setNode(studentForm);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

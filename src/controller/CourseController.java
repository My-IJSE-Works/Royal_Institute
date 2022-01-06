package controller;

import bo.custom.impl.CourseBoImpl;
import com.jfoenix.controls.JFXTextField;
import dto.CourseDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CourseController implements Initializable {
    ObservableList<CourseDTO> courseList;
    @FXML
    private TextField txtSearch;
    @FXML
    private JFXTextField txtcourseID;
    @FXML
    private JFXTextField txtcourseName;
    @FXML
    private JFXTextField txtfee;
    @FXML
    private JFXTextField txtduration;
    @FXML
    private TableView<CourseDTO> tblCOurses;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnClick;

    @FXML
    public void btnDeleteClick(ActionEvent event) {

    }

    @FXML
    public void btnSaveClick(ActionEvent event) {
        String id = txtcourseID.getText();
        String name = txtcourseName.getText();
        String duration = txtduration.getText();
        double fee = Double.parseDouble(txtfee.getText());

        CourseBoImpl courseBo = new CourseBoImpl();
        boolean b = courseBo.addCourse(new CourseDTO(id, name, fee, duration));
        loadAll();

    }


    @FXML
    public void btnUpdateClick(ActionEvent event) {

    }

    @FXML
    void btnClearClick(ActionEvent event) {
        txtduration.setText("");
        txtfee.setText("");
        txtcourseName.setText("");
        txtcourseID.setText("");
    }

    @FXML
    private void tblMouseClick(MouseEvent event) {
        CourseDTO c = tblCOurses.getSelectionModel().getSelectedItem();
        txtcourseID.setText(c.getCourseId());
        txtcourseName.setText(c.getCourseName());
        txtfee.setText(String.valueOf(c.getCourseFee()));
        txtduration.setText(c.getCourseDuration());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tblCOurses.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("courseId"));
        tblCOurses.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("courseName"));
        tblCOurses.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("courseFee"));
        tblCOurses.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("courseDuration"));
        loadAll();
    }

    private void loadAll() {
        CourseBoImpl courseBo = new CourseBoImpl();
        ArrayList<CourseDTO> courses = courseBo.getCourses();
        if(courses != null){
            tblCOurses.getItems().remove(0, tblCOurses.getItems().size());
            tblCOurses.setItems(FXCollections.observableArrayList(courses));
        }
    }
}

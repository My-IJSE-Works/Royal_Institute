package controller;

import bo.custom.impl.CourseBoImpl;
import bo.custom.impl.StudentBoImpl;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dto.CourseDTO;
import dto.StudentDTO;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class StudentController implements Initializable {
    @FXML
    private JFXTextField txtSid;

    @FXML
    private JFXTextField txtSName;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtnic;

    @FXML
    private JFXComboBox<String> comboCourseID;

    @FXML
    private JFXTextField txtCName;

    @FXML
    private JFXTextField txtGender;

    @FXML
    private TextField txtRegId;

    @FXML
    private JFXTextField txtContact;

    @FXML
    private TableView<StudentDTO> tblStudent;


    @FXML
    void btnSaveClick(ActionEvent event) {
        String regId = txtRegId.getText();
        String sId = txtSid.getText();
        String name = txtSName.getText();
        String address = txtAddress.getText();
        String nic = txtnic.getText();
        String contact = txtContact.getText();
        String gender = txtGender.getText();
        String id = comboCourseID.getSelectionModel().getSelectedItem();

        StudentBoImpl studentBo = new StudentBoImpl();
        boolean b = studentBo.addStudent(new StudentDTO(sId, name, address, nic, contact, gender), regId, id);
        loadAllStudents();
    }

    @FXML
    void ComoItemChange(ActionEvent event) {
        List<CourseDTO> customers = new CourseBoImpl().getCourses();
        String id = comboCourseID.getSelectionModel().getSelectedItem();
        for (CourseDTO customer : customers) {
            if(id.equals(customer.getCourseId())){
                txtCName.setText(customer.getCourseName());
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadComoId();
        loadAllStudents();
        tblStudent.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("studentId"));
        tblStudent.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("studentName"));
        tblStudent.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("studentAddress"));
        tblStudent.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("studentNIC"));
        tblStudent.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("studentContact"));
        tblStudent.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("studentGender"));
    }

    private void loadAllStudents() {
        StudentBoImpl studentBo = new StudentBoImpl();
        ArrayList<StudentDTO> students = studentBo.getStudents();
        if (students != null) {
            tblStudent.getItems().remove(0, tblStudent.getItems().size());
            tblStudent.setItems(FXCollections.observableArrayList(students));
        }
    }
//    private void loadAllRegisterDate() {
//        Re studentBo = new StudentBoImpl();
//        ArrayList<StudentDTO> students = studentBo.getStudents();
//        if (students != null) {
//            tblStudent.getItems().remove(0, tblStudent.getItems().size());
//            tblStudent.setItems(FXCollections.observableArrayList(students));
//        }
//    }


    private void loadComoId() {
        StudentBoImpl studentBo = new StudentBoImpl();
        ArrayList<CourseDTO> courses = studentBo.getCourses();
        if(courses != null){
            for (CourseDTO cours : courses) {
                comboCourseID.getItems().add(cours.getCourseId());
            }
        }
    }
}

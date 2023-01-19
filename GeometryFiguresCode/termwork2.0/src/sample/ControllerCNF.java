package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerCNF implements Initializable {
    @FXML  private Spinner s;
    @FXML  private ComboBox<String> comboBox;
    @FXML  private TextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12;
    @FXML  private Label l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l1a,l2a,l3a,l4a,l5a,l6a,l14c,l15c,l16c,l17c;
    @FXML  private TextField t17c,t18c,t19c;
    @FXML private Button add,cancel;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBox.getItems().add("Segment");
        comboBox.getItems().add("Polyline");
        comboBox.getItems().add("Circle");
        comboBox.getItems().add("NGon");
        comboBox.getItems().add("TGon");
        comboBox.getItems().add("QGon");
        comboBox.getItems().add("Rectangle");
        comboBox.getItems().add("Trapeze");
    }
    public void comboBoxEvent(ActionEvent actionEvent) {
        String selectedValue = comboBox.getSelectionModel().getSelectedItem();
        if(selectedValue=="Segment")
        {
            s.setVisible(false);
            t1.setVisible(true);
            t2.setVisible(true);
            t3.setVisible(true);
            t4.setVisible(true);
            t5.setVisible(false);
            t6.setVisible(false);
            t7.setVisible(false);
            t8.setVisible(false);
            t9.setVisible(false);
            t10.setVisible(false);
            t11.setVisible(false);
            t12.setVisible(false);
            //
            l1a.setVisible(true);
            l2a.setVisible(true);
            l3a.setVisible(false);
            l4a.setVisible(false);
            l5a.setVisible(false);
            l6a.setVisible(false);
            //
            l2.setVisible(true);
            l3.setVisible(true);
            l4.setVisible(true);
            l5.setVisible(true);
            l6.setVisible(false);
            l7.setVisible(false);
            l8.setVisible(false);
            l9.setVisible(false);
            l10.setVisible(false);
            l11.setVisible(false);
            l12.setVisible(false);
            l13.setVisible(false);
            //
            l14c.setVisible(false);
            l15c.setVisible(false);
            l16c.setVisible(false);
            l17c.setVisible(false);
            //
            t17c.setVisible(false);
            t18c.setVisible(false);
            t19c.setVisible(false);
        }
        if(selectedValue=="TGon")
        {
            s.setVisible(false);
            t1.setVisible(true);
            t2.setVisible(true);
            t3.setVisible(true);
            t4.setVisible(true);
            t5.setVisible(true);
            t6.setVisible(true);
            t7.setVisible(false);
            t8.setVisible(false);
            t9.setVisible(false);
            t10.setVisible(false);
            t11.setVisible(false);
            t12.setVisible(false);
            //
            l1a.setVisible(true);
            l2a.setVisible(true);
            l3a.setVisible(true);
            l4a.setVisible(false);
            l5a.setVisible(false);
            l6a.setVisible(false);
            //
            l2.setVisible(true);
            l3.setVisible(true);
            l4.setVisible(true);
            l5.setVisible(true);
            l6.setVisible(true);
            l7.setVisible(true);
            l8.setVisible(false);
            l9.setVisible(false);
            l10.setVisible(false);
            l11.setVisible(false);
            l12.setVisible(false);
            l13.setVisible(false);
            //
            l14c.setVisible(false);
            l15c.setVisible(false);
            l16c.setVisible(false);
            l17c.setVisible(false);
            //
            t17c.setVisible(false);
            t18c.setVisible(false);
            t19c.setVisible(false);
        }
        if(selectedValue=="Rectangle")
        {
            s.setVisible(false);
            t1.setVisible(true);
            t2.setVisible(true);
            t3.setVisible(true);
            t4.setVisible(true);
            t5.setVisible(true);
            t6.setVisible(true);
            t7.setVisible(true);
            t8.setVisible(true);
            t9.setVisible(false);
            t10.setVisible(false);
            t11.setVisible(false);
            t12.setVisible(false);
            //
            l1a.setVisible(true);
            l2a.setVisible(true);
            l3a.setVisible(true);
            l4a.setVisible(true);
            l5a.setVisible(false);
            l6a.setVisible(false);
            //
            l2.setVisible(true);
            l3.setVisible(true);
            l4.setVisible(true);
            l5.setVisible(true);
            l6.setVisible(true);
            l7.setVisible(true);
            l8.setVisible(true);
            l9.setVisible(true);
            l10.setVisible(false);
            l11.setVisible(false);
            l12.setVisible(false);
            l13.setVisible(false);
            //
            l14c.setVisible(false);
            l15c.setVisible(false);
            l16c.setVisible(false);
            l17c.setVisible(false);
            //
            t17c.setVisible(false);
            t18c.setVisible(false);
            t19c.setVisible(false);
        }
        if(selectedValue=="QGon")
        {
            s.setVisible(false);
            t1.setVisible(true);
            t2.setVisible(true);
            t3.setVisible(true);
            t4.setVisible(true);
            t5.setVisible(true);
            t6.setVisible(true);
            t7.setVisible(true);
            t8.setVisible(true);
            t9.setVisible(false);
            t10.setVisible(false);
            t11.setVisible(false);
            t12.setVisible(false);
            //
            l1a.setVisible(true);
            l2a.setVisible(true);
            l3a.setVisible(true);
            l4a.setVisible(true);
            l5a.setVisible(false);
            l6a.setVisible(false);
            //
            l2.setVisible(true);
            l3.setVisible(true);
            l4.setVisible(true);
            l5.setVisible(true);
            l6.setVisible(true);
            l7.setVisible(true);
            l8.setVisible(true);
            l9.setVisible(true);
            l10.setVisible(false);
            l11.setVisible(false);
            l12.setVisible(false);
            l13.setVisible(false);
            //
            l14c.setVisible(false);
            l15c.setVisible(false);
            l16c.setVisible(false);
            l17c.setVisible(false);
            //
            t17c.setVisible(false);
            t18c.setVisible(false);
            t19c.setVisible(false);
        }
        if(selectedValue=="Trapeze")
        {
            s.setVisible(false);
            t1.setVisible(true);
            t2.setVisible(true);
            t3.setVisible(true);
            t4.setVisible(true);
            t5.setVisible(true);
            t6.setVisible(true);
            t7.setVisible(true);
            t8.setVisible(true);
            t9.setVisible(false);
            t10.setVisible(false);
            t11.setVisible(false);
            t12.setVisible(false);
            //
            l1a.setVisible(true);
            l2a.setVisible(true);
            l3a.setVisible(true);
            l4a.setVisible(true);
            l5a.setVisible(false);
            l6a.setVisible(false);
            //
            l2.setVisible(true);
            l3.setVisible(true);
            l4.setVisible(true);
            l5.setVisible(true);
            l6.setVisible(true);
            l7.setVisible(true);
            l8.setVisible(true);
            l9.setVisible(true);
            l10.setVisible(false);
            l11.setVisible(false);
            l12.setVisible(false);
            l13.setVisible(false);
            //
            l14c.setVisible(false);
            l15c.setVisible(false);
            l16c.setVisible(false);
            l17c.setVisible(false);
            //
            t17c.setVisible(false);
            t18c.setVisible(false);
            t19c.setVisible(false);
        }
        if(selectedValue=="Circle")
        {
            s.setVisible(false);
            t1.setVisible(false);
            t2.setVisible(false);
            t3.setVisible(false);
            t4.setVisible(false);
            t5.setVisible(false);
            t6.setVisible(false);
            t7.setVisible(false);
            t8.setVisible(false);
            t9.setVisible(false);
            t10.setVisible(false);
            t11.setVisible(false);
            t12.setVisible(false);
            //
            l1a.setVisible(false);
            l2a.setVisible(false);
            l3a.setVisible(false);
            l4a.setVisible(false);
            l5a.setVisible(false);
            l6a.setVisible(false);
            //
            l2.setVisible(false);
            l3.setVisible(false);
            l4.setVisible(false);
            l5.setVisible(false);
            l6.setVisible(false);
            l7.setVisible(false);
            l8.setVisible(false);
            l9.setVisible(false);
            l10.setVisible(false);
            l11.setVisible(false);
            l12.setVisible(false);
            l13.setVisible(false);
            //
            l14c.setVisible(true);
            l15c.setVisible(true);
            l16c.setVisible(true);
            l17c.setVisible(true);
            //
            t17c.setVisible(true);
            t18c.setVisible(true);
            t19c.setVisible(true);
        }
        if(selectedValue=="NGon")
        {
            s.setVisible(true);
            SpinnerValueFactory<Integer> gradesValueFactory= new SpinnerValueFactory.IntegerSpinnerValueFactory(3,6,3);
            s.setValueFactory(gradesValueFactory);
            {t1.setVisible(true);
            t2.setVisible(true);
            t3.setVisible(true);
            t4.setVisible(true);
            t5.setVisible(true);
            t6.setVisible(true);
            t7.setVisible(false);
            t8.setVisible(false);
            t9.setVisible(false);
            t10.setVisible(false);
            t11.setVisible(false);
            t12.setVisible(false);
            //
            l1a.setVisible(true);
            l2a.setVisible(true);
            l3a.setVisible(true);
            l4a.setVisible(false);
            l5a.setVisible(false);
            l6a.setVisible(false);
            //
            l2.setVisible(true);
            l3.setVisible(true);
            l4.setVisible(true);
            l5.setVisible(true);
            l6.setVisible(true);
            l7.setVisible(true);
            l8.setVisible(false);
            l9.setVisible(false);
            l10.setVisible(false);
            l11.setVisible(false);
            l12.setVisible(false);
            l13.setVisible(false);
            //
            l14c.setVisible(false);
            l15c.setVisible(false);
            l16c.setVisible(false);
            l17c.setVisible(false);
            //
            t17c.setVisible(false);
            t18c.setVisible(false);
            t19c.setVisible(false);}
        }
        if(selectedValue=="Polyline")
        {
            s.setVisible(true);
            SpinnerValueFactory<Integer> gradesValueFactory= new SpinnerValueFactory.IntegerSpinnerValueFactory(3,6,3);
            s.setValueFactory(gradesValueFactory);
            {t1.setVisible(true);
                t2.setVisible(true);
                t3.setVisible(true);
                t4.setVisible(true);
                t5.setVisible(true);
                t6.setVisible(true);
                t7.setVisible(false);
                t8.setVisible(false);
                t9.setVisible(false);
                t10.setVisible(false);
                t11.setVisible(false);
                t12.setVisible(false);
                //
                l1a.setVisible(true);
                l2a.setVisible(true);
                l3a.setVisible(true);
                l4a.setVisible(false);
                l5a.setVisible(false);
                l6a.setVisible(false);
                //
                l2.setVisible(true);
                l3.setVisible(true);
                l4.setVisible(true);
                l5.setVisible(true);
                l6.setVisible(true);
                l7.setVisible(true);
                l8.setVisible(false);
                l9.setVisible(false);
                l10.setVisible(false);
                l11.setVisible(false);
                l12.setVisible(false);
                l13.setVisible(false);
                //
                l14c.setVisible(false);
                l15c.setVisible(false);
                l16c.setVisible(false);
                l17c.setVisible(false);
                //
                t17c.setVisible(false);
                t18c.setVisible(false);
                t19c.setVisible(false);}
        }
    }
    public void spinnerAdapter(){
    int v= (int) s.getValue();
        if(v==3){
            t1.setVisible(true);
            t2.setVisible(true);
            t3.setVisible(true);
            t4.setVisible(true);
            t5.setVisible(true);
            t6.setVisible(true);
            t7.setVisible(false);
            t8.setVisible(false);
            t9.setVisible(false);
            t10.setVisible(false);
            t11.setVisible(false);
            t12.setVisible(false);
            //
            l1a.setVisible(true);
            l2a.setVisible(true);
            l3a.setVisible(true);
            l4a.setVisible(false);
            l5a.setVisible(false);
            l6a.setVisible(false);
            //
            l2.setVisible(true);
            l3.setVisible(true);
            l4.setVisible(true);
            l5.setVisible(true);
            l6.setVisible(true);
            l7.setVisible(true);
            l8.setVisible(false);
            l9.setVisible(false);
            l10.setVisible(false);
            l11.setVisible(false);
            l12.setVisible(false);
            l13.setVisible(false);
            //
            l14c.setVisible(false);
            l15c.setVisible(false);
            l16c.setVisible(false);
            l17c.setVisible(false);
            //
            t17c.setVisible(false);
            t18c.setVisible(false);
            t19c.setVisible(false);
        }
        if(v==4) {
            t1.setVisible(true);
            t2.setVisible(true);
            t3.setVisible(true);
            t4.setVisible(true);
            t5.setVisible(true);
            t6.setVisible(true);
            t7.setVisible(true);
            t8.setVisible(true);
            t9.setVisible(false);
            t10.setVisible(false);
            t11.setVisible(false);
            t12.setVisible(false);
            //
            l1a.setVisible(true);
            l2a.setVisible(true);
            l3a.setVisible(true);
            l4a.setVisible(true);
            l5a.setVisible(false);
            l6a.setVisible(false);
            //
            l2.setVisible(true);
            l3.setVisible(true);
            l4.setVisible(true);
            l5.setVisible(true);
            l6.setVisible(true);
            l7.setVisible(true);
            l8.setVisible(true);
            l9.setVisible(true);
            l10.setVisible(false);
            l11.setVisible(false);
            l12.setVisible(false);
            l13.setVisible(false);
            //
            l14c.setVisible(false);
            l15c.setVisible(false);
            l16c.setVisible(false);
            l17c.setVisible(false);
            //
            t17c.setVisible(false);
            t18c.setVisible(false);
            t19c.setVisible(false);
        }
        if(v==5) {
            t1.setVisible(true);
            t2.setVisible(true);
            t3.setVisible(true);
            t4.setVisible(true);
            t5.setVisible(true);
            t6.setVisible(true);
            t7.setVisible(true);
            t8.setVisible(true);
            t9.setVisible(true);
            t10.setVisible(true);
            t11.setVisible(false);
            t12.setVisible(false);
            //
            l1a.setVisible(true);
            l2a.setVisible(true);
            l3a.setVisible(true);
            l4a.setVisible(true);
            l5a.setVisible(true);
            l6a.setVisible(false);
            //
            l2.setVisible(true);
            l3.setVisible(true);
            l4.setVisible(true);
            l5.setVisible(true);
            l6.setVisible(true);
            l7.setVisible(true);
            l8.setVisible(true);
            l9.setVisible(true);
            l10.setVisible(true);
            l11.setVisible(true);
            l12.setVisible(false);
            l13.setVisible(false);
            //
            l14c.setVisible(false);
            l15c.setVisible(false);
            l16c.setVisible(false);
            l17c.setVisible(false);
            //
            t17c.setVisible(false);
            t18c.setVisible(false);
            t19c.setVisible(false);
        }
        if(v==6) {
            t1.setVisible(true);
            t2.setVisible(true);
            t3.setVisible(true);
            t4.setVisible(true);
            t5.setVisible(true);
            t6.setVisible(true);
            t7.setVisible(true);
            t8.setVisible(true);
            t9.setVisible(true);
            t10.setVisible(true);
            t11.setVisible(true);
            t12.setVisible(true);
            //
            l1a.setVisible(true);
            l2a.setVisible(true);
            l3a.setVisible(true);
            l4a.setVisible(true);
            l5a.setVisible(true);
            l6a.setVisible(true);
            //
            l2.setVisible(true);
            l3.setVisible(true);
            l4.setVisible(true);
            l5.setVisible(true);
            l6.setVisible(true);
            l7.setVisible(true);
            l8.setVisible(true);
            l9.setVisible(true);
            l10.setVisible(true);
            l11.setVisible(true);
            l12.setVisible(true);
            l13.setVisible(true);
            //
            l14c.setVisible(false);
            l15c.setVisible(false);
            l16c.setVisible(false);
            l17c.setVisible(false);
            //
            t17c.setVisible(false);
            t18c.setVisible(false);
            t19c.setVisible(false);
        }
    }
    public void cancelButtonEvent()throws IOException{
        Stage stage = (Stage) add.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        Controller sampleController=loader.getController();

        Stage stage2= new Stage();
        stage2.setScene(new Scene(root));
        stage2.show();
    }
    @FXML
    private void sendToScene1(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        Controller sampleController=loader.getController();
        String selectedValue = comboBox.getSelectionModel().getSelectedItem();
        if(selectedValue=="Circle") {
            double R= Double.parseDouble(t19c.getText())*2;
            sampleController.showInformation("Circle", 0,t17c.getText(),t18c.getText(), String.valueOf(R),"0","0","0","0","0","0","0","0","0");
            sampleController.addFigure();
            //закрытие текущей формы
            Stage stage = (Stage) add.getScene().getWindow();
            stage.close();
            //
        }
        if(selectedValue=="Segment") {
            sampleController.showInformation("Segment", 0,t1.getText(),t2.getText(),t3.getText(),t4.getText(),"0","0","0","0","0","0","0","0");
            sampleController.addFigure();
            //закрытие текущей формы
            Stage stage = (Stage) add.getScene().getWindow();
            stage.close();
            //
        }
        if(selectedValue=="Polyline") {
            int v= (int) s.getValue();
            sampleController.showInformation("Polyline",v,t1.getText(),t2.getText(),t3.getText(),t4.getText(),t5.getText(),t6.getText(),t7.getText(),t8.getText(),t9.getText(),t10.getText(),t11.getText(),t12.getText());
            sampleController.addFigure();
            //закрытие текущей формы
            Stage stage = (Stage) add.getScene().getWindow();
            stage.close();
            //
        }
        if(selectedValue=="NGon") {
            int v= (int) s.getValue();
            sampleController.showInformation("NGon",v,t1.getText(),t2.getText(),t3.getText(),t4.getText(),t5.getText(),t6.getText(),t7.getText(),t8.getText(),t9.getText(),t10.getText(),t11.getText(),t12.getText());
            sampleController.addFigure();
            //закрытие текущей формы
            Stage stage = (Stage) add.getScene().getWindow();
            stage.close();
            //
        }
        if(selectedValue=="QGon") {
            sampleController.showInformation("QGon",0,t1.getText(),t2.getText(),t3.getText(),t4.getText(),t5.getText(),t6.getText(),t7.getText(),t8.getText(),t9.getText(),t10.getText(),t11.getText(),t12.getText());
            sampleController.addFigure();
            //закрытие текущей формы
            Stage stage = (Stage) add.getScene().getWindow();
            stage.close();
            //
        }
        if(selectedValue=="Rectangle") {
            sampleController.showInformation("Rectangle",0,t1.getText(),t2.getText(),t3.getText(),t4.getText(),t5.getText(),t6.getText(),t7.getText(),t8.getText(),t9.getText(),t10.getText(),t11.getText(),t12.getText());
            sampleController.addFigure();
            //закрытие текущей формы
            Stage stage = (Stage) add.getScene().getWindow();
            stage.close();
            //
        }
        if(selectedValue=="Trapeze") {
            sampleController.showInformation("Trapeze",0,t1.getText(),t2.getText(),t3.getText(),t4.getText(),t5.getText(),t6.getText(),t7.getText(),t8.getText(),t9.getText(),t10.getText(),t11.getText(),t12.getText());
            sampleController.addFigure();
            //закрытие текущей формы
            Stage stage = (Stage) add.getScene().getWindow();
            stage.close();
            //
        }
        if(selectedValue=="TGon") {
            sampleController.showInformation("TGon",0,t1.getText(),t2.getText(),t3.getText(),t4.getText(),t5.getText(),t6.getText(),t7.getText(),t8.getText(),t9.getText(),t10.getText(),t11.getText(),t12.getText());
            sampleController.addFigure();
            //закрытие текущей формы
            Stage stage = (Stage) add.getScene().getWindow();
            stage.close();
            //
        }
        Stage stage= new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
}

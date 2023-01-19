package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;

public class ControllerSaveFile {
    @FXML
    TextField t1;
    public void cancelButtonEvent()throws IOException {
        Stage stage = (Stage) t1.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        Controller sampleController=loader.getController();

        Stage stage2= new Stage();
        stage2.setScene(new Scene(root));
        stage2.show();
    }
    public void okButtonEvent() throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(new File("CASH.txt")));
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(t1.getText())));
        String curLine=null;
        while((curLine=reader.readLine())!=null) {
            writer.write(curLine);
            writer.newLine();
        }
        reader.close();
        writer.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        Controller sampleController=loader.getController();

        Stage stage= new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        Stage stage1 = (Stage) t1.getScene().getWindow();
        stage1.close();
    }
}

package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControllerDF implements Initializable {
    @FXML private ComboBox<String> comboBox;
    @FXML public TextField t1;
    @FXML public TextField t2;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            BufferedReader bfr=new BufferedReader(new FileReader("C:\\Users\\79021\\IdeaProjects\\termwork2.0\\CASHVALUE.txt"));
            int n=Integer.parseInt(bfr.readLine());
            bfr.close();
            BufferedReader bfr1=new BufferedReader(new FileReader("C:\\Users\\79021\\IdeaProjects\\termwork2.0\\CASH.txt"));

            bfr1.readLine();
            String line=null;
            while((line=bfr1.readLine())!=null) {
                if (line.equals("Circle")) {
                    String current = bfr1.readLine();
                    comboBox.getItems().add("Circle"+"("+current+")");
                }
                else
                    if (line.equals("Polyline")) {
                        String current = bfr1.readLine();
                        current = bfr1.readLine();
                        comboBox.getItems().add("Polyline"+"("+current+")");
                }
                    else
                    if (line.equals("NGon")) {
                        String current = bfr1.readLine();
                        current = bfr1.readLine();
                        comboBox.getItems().add("NGon"+"("+ current+")");
                    }
                    else
                    if (line.equals("QGon")) {
                        String current = bfr1.readLine();
                        comboBox.getItems().add("QGon"+"("+current+")");
                    }
                    else
                    if (line.equals("TGon")) {
                        String current = bfr1.readLine();
                        comboBox.getItems().add("TGon"+"("+current+")");
                    }
                    else
                    if (line.equals("Rectangle")) {
                        String current = bfr1.readLine();
                        comboBox.getItems().add("Rectangle"+"("+current+")");
                    }
                    else
                    if (line.equals("Trapeze")) {
                        String current = bfr1.readLine();
                        comboBox.getItems().add("Trapeze"+"("+current+")");
                    }
                else if (line.equals("Segment")) {
                    String current = bfr1.readLine();
                    comboBox.getItems().add("Segment"+"("+current+")");
                }


            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void comboBoxEvent(ActionEvent actionEvent)throws IOException {
        String selectedValue = comboBox.getSelectionModel().getSelectedItem();
        char[] cur = selectedValue.toCharArray();
        String l1="";
        String l2="";
        int j=0;
        for (; j < cur.length; j++)
            if(cur[j]!='(')
                l1+=cur[j];
            else
                break;
if(l1.equals("Polyline")||l1.equals("NGon")) {
    j++;
    for (; j < cur.length - 1; j++)
        l2 += cur[j];
}else {
    j++;
    for (; j < cur.length-1; j++)
        l2 += cur[j];
}
        t1.setText(l1);
        t2.setText(l2);
    }
    @FXML public void okButton()throws IOException
    {
        File inputFile = new File("CASH.txt");
        File tempFile = new File("CASH2.txt");

        BufferedReader reader = new BufferedReader(new FileReader(new File("CASH.txt")));
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("CASH2.txt")));

        String lineToRemove1 = t1.getText();
        String lineToRemove2=t2.getText();
        String currentLine;
int fl=1;
int fl2=1;
        while((currentLine = reader.readLine()) != null) {
            String trimmedLine = currentLine.trim();
            if(trimmedLine.equals(lineToRemove1)&&fl==1) {
                fl=0;
                continue;
            }
            if(lineToRemove1.equals("NGon")||lineToRemove1.equals("Polyline"))
            {
                continue;
            }
            if(trimmedLine.equals(lineToRemove2)&&fl2==1) {
                fl2=0;
                continue;
            }
            writer.write(currentLine + System.getProperty("line.separator"));


        }
        writer.close();
        reader.close();
        System.gc();
        try {
            Files.move(new File("CASH2.txt").toPath(), new File("CASH.txt").toPath(), java.nio.file.StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            Logger.getLogger(ControllerDF.class.getName()).log(Level.SEVERE, null, ex);
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        Controller sampleController=loader.getController();

        Stage stage= new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        Stage stage1 = (Stage) comboBox.getScene().getWindow();
        stage1.close();
    }
    public void cancelButtonEvent()throws IOException{
        Stage stage = (Stage) t1.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        Controller sampleController=loader.getController();

        Stage stage2= new Stage();
        stage2.setScene(new Scene(root));
        stage2.show();
    }
    public void deleteAll()throws IOException
    {
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("CASH.txt")));
        writer.newLine();
        Stage stage = (Stage) t1.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        Controller sampleController=loader.getController();

        Stage stage2= new Stage();
        stage2.setScene(new Scene(root));
        stage2.show();
    }
}

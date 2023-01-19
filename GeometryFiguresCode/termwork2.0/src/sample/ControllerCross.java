package sample;

import firstworkpackage.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerCross implements Initializable {
    @FXML
    private ComboBox<String> comboBox1;
    @FXML
    private ComboBox<String> comboBox2;
    @FXML public TextField t1;
    @FXML public TextField t2;
    @FXML public TextField t3;
    @FXML public TextField t4;
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
                    comboBox1.getItems().add("Circle"+"("+current+")");
                    comboBox2.getItems().add("Circle"+"("+current+")");
                }
                else
                if (line.equals("Polyline")) {
                    String current = bfr1.readLine();
                    current = bfr1.readLine();
                    comboBox1.getItems().add("Polyline"+"("+current+")");
                    comboBox2.getItems().add("Polyline"+"("+current+")");
                }
                else
                if (line.equals("NGon")) {
                    String current = bfr1.readLine();
                    current = bfr1.readLine();
                    comboBox1.getItems().add("NGon"+"("+ current+")");
                    comboBox2.getItems().add("NGon"+"("+current+")");
                }
                else
                if (line.equals("QGon")) {
                    String current = bfr1.readLine();
                    comboBox1.getItems().add("QGon"+"("+current+")");
                    comboBox2.getItems().add("QGon"+"("+current+")");
                }
                else
                if (line.equals("TGon")) {
                    String current = bfr1.readLine();
                    comboBox1.getItems().add("TGon"+"("+current+")");
                    comboBox2.getItems().add("TGon"+"("+current+")");
                }
                else
                if (line.equals("Rectangle")) {
                    String current = bfr1.readLine();
                    comboBox1.getItems().add("Rectangle"+"("+current+")");
                    comboBox2.getItems().add("Rectangle"+"("+current+")");
                }
                else
                if (line.equals("Trapeze")) {
                    String current = bfr1.readLine();
                    comboBox1.getItems().add("Trapeze"+"("+current+")");
                    comboBox2.getItems().add("Trapeze"+"("+current+")");
                }
                else if (line.equals("Segment")) {
                    String current = bfr1.readLine();
                    comboBox1.getItems().add("Segment"+"("+current+")");
                    comboBox2.getItems().add("Segment"+"("+current+")");
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void comboBoxEvent1(ActionEvent actionEvent)throws IOException {
        String selectedValue = comboBox1.getSelectionModel().getSelectedItem();
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
    public void comboBoxEvent2(ActionEvent actionEvent)throws IOException {
        String selectedValue = comboBox2.getSelectionModel().getSelectedItem();
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
        t3.setText(l1);
        t4.setText(l2);
    }
    @FXML public void okButton()throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        Controller sampleController=loader.getController();

        if(t1.getText().equals(t3.getText()))
        {
            if(t1.getText().equals("Circle"))
            {
                String current=t2.getText();
                String value = "";
                int K = 1;
                char[] cur = current.toCharArray();
                Point2D p1 = new Point2D();
                for (int j = 0; j < cur.length; j++) {
                    if (cur[j] != ',')
                        value += cur[j];
                    else {
                        if (K == 1) {
                            K++;
                            double m[] = {Double.parseDouble(value)};
                            p1.setX(m, 0);
                            value = "";
                        }
                        else if (K == 2) {
                            K++;
                            double m[] = {0, Double.parseDouble(value)};
                            p1.setX(m, 1);
                            value = "";
                        }
                    }
                }
                Circle c = new Circle(p1, Double.parseDouble(value)/2);
                current=t4.getText();
                value = "";
                K = 1;
                cur = current.toCharArray();
                p1 = new Point2D();
                for (int j = 0; j < cur.length; j++) {
                    if (cur[j] != ',')
                        value += cur[j];
                    else {
                        if (K == 1) {
                            K++;
                            double m[] = {Double.parseDouble(value)};
                            p1.setX(m, 0);
                            value = "";
                        }
                        else if (K == 2) {
                            K++;
                            double m[] = {0, Double.parseDouble(value)};
                            p1.setX(m, 1);
                            value = "";
                        }

                    }
                }
                Circle c2 = new Circle(p1, Double.parseDouble(value)/2);
                sampleController.crossWrite(c.cross(c2));
            }
            else if(t1.getText().equals("Segment"))
            {
                    String current = t2.getText();
                    String value = "";
                    int K = 1;
                    Point2D p1 = new Point2D();
                    Point2D p2 = new Point2D();
                    char[] cur = current.toCharArray();
                    for (int j = 0; j < cur.length; j++) {
                        if (cur[j] != ',')
                            value += cur[j];
                        else {
                            if (K == 1) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p1.setX(m, 0);
                                value = "";
                            }
                            else if (K == 2) {
                                K++;
                                double m[] = {0, Double.parseDouble(value)};
                                p1.setX(m, 1);
                                value = "";
                            }
                            else if (K == 3) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p2.setX(m, 0);
                                value = "";
                            }

                        }
                    }
                    double m[] = {0, Double.parseDouble(value)};
                    p2.setX(m, 1);
                    Segment c = new Segment(p1,p2);

                     current = t4.getText();
                     value = "";
                     K = 1;
                     p1 = new Point2D();
                     p2 = new Point2D();
                     cur = current.toCharArray();
                    for (int j = 0; j < cur.length; j++) {
                        if (cur[j] != ',')
                            value += cur[j];
                        else {
                            if (K == 1) {
                                K++;
                                 m = new double[]{Double.parseDouble(value)};
                                p1.setX(m, 0);
                                value = "";
                            }
                            else if (K == 2) {
                                K++;
                                 m= new double[]{0, Double.parseDouble(value)};
                                p1.setX(m, 1);
                                value = "";
                            }
                            else if (K == 3) {
                                K++;
                                m= new double[]{ Double.parseDouble(value)};
                                p2.setX(m, 0);
                                value = "";
                            }

                        }
                    }
                    m= new double[]{0, Double.parseDouble(value)};
                    p2.setX(m, 1);
                    Segment c2 = new Segment(p1,p2);

                    sampleController.crossWrite(c.cross(c2));
                }
            else if(t1.getText().equals("TGon"))
            {
                String current = t2.getText();
                String value = "";
                int K = 1;
                Point2D p1 = new Point2D();
                Point2D p2 = new Point2D();
                Point2D p3 = new Point2D();
                char[] cur = current.toCharArray();
                for (int j = 0; j < cur.length; j++) {
                    if (cur[j] != ',')
                        value += cur[j];
                    else {
                        if (K == 1) {
                            K++;
                            double m[] = {Double.parseDouble(value)};
                            p1.setX(m, 0);
                            value = "";
                        }
                        else if (K == 2) {
                            K++;
                            double m[] = {0, Double.parseDouble(value)};
                            p1.setX(m, 1);
                            value = "";
                        }
                        else if (K == 3) {
                            K++;
                            double m[] = {Double.parseDouble(value)};
                            p2.setX(m, 0);
                            value = "";
                        }
                        else if (K == 4) {
                            K++;
                            double m[] = {0,Double.parseDouble(value)};
                            p2.setX(m, 1);
                            value = "";
                        }
                        else if (K == 5) {
                            K++;
                            double m[] = {Double.parseDouble(value)};
                            p3.setX(m, 0);
                            value = "";
                        }

                    }
                }
                double m[] = {0, Double.parseDouble(value)};
                p3.setX(m, 1);
                Point2D mp[]={p1,p2,p3};
                TGon c = new TGon(mp);

                current = t4.getText();
                value = "";
                K = 1;
                p1 = new Point2D();
                p2 = new Point2D();
                cur = current.toCharArray();
                for (int j = 0; j < cur.length; j++) {
                    if (cur[j] != ',')
                        value += cur[j];
                    else {
                        if (K == 1) {
                            K++;
                            m = new double[]{Double.parseDouble(value)};
                            p1.setX(m, 0);
                            value = "";
                        }
                        else if (K == 2) {
                            K++;
                            m= new double[]{0, Double.parseDouble(value)};
                            p1.setX(m, 1);
                            value = "";
                        }
                        else if (K == 3) {
                            K++;
                            m= new double[]{ Double.parseDouble(value)};
                            p2.setX(m, 0);
                            value = "";
                        }
                        else if (K == 4) {
                            K++;
                             m = new double[]{0,Double.parseDouble(value)};
                            p2.setX(m, 1);
                            value = "";
                        }
                        else if (K == 5) {
                            K++;
                             m = new double[]{Double.parseDouble(value)};
                            p3.setX(m, 0);
                            value = "";
                        }
                    }
                }
                m= new double[]{0, Double.parseDouble(value)};
                p3.setX(m, 1);
                 mp=new Point2D[]{p1,p2,p3};
                TGon c2 = new TGon(mp);

                sampleController.crossWrite(c.cross(c2));
            }
            else if(t1.getText().equals("QGon"))
            {
                String current = t2.getText();
                String value = "";
                int K = 1;
                Point2D p1 = new Point2D();
                Point2D p2 = new Point2D();
                Point2D p3 = new Point2D();
                Point2D p4 = new Point2D();
                char[] cur = current.toCharArray();
                for (int j = 0; j < cur.length; j++) {
                    if (cur[j] != ',')
                        value += cur[j];
                    else {
                        if (K == 1) {
                            K++;
                            double m[] = {Double.parseDouble(value)};
                            p1.setX(m, 0);
                            value = "";
                        }
                        else if (K == 2) {
                            K++;
                            double m[] = {0, Double.parseDouble(value)};
                            p1.setX(m, 1);
                            value = "";
                        }
                        else if (K == 3) {
                            K++;
                            double m[] = {Double.parseDouble(value)};
                            p2.setX(m, 0);
                            value = "";
                        }
                        else if (K == 4) {
                            K++;
                            double m[] = {0,Double.parseDouble(value)};
                            p2.setX(m, 1);
                            value = "";
                        }
                        else if (K == 5) {
                            K++;
                            double m[] = {Double.parseDouble(value)};
                            p3.setX(m, 0);
                            value = "";
                        }
                        else if (K == 6) {
                            K++;
                            double m[] = {0,Double.parseDouble(value)};
                            p3.setX(m, 1);
                            value = "";
                        }
                        else if (K == 7) {
                            K++;
                            double m[] = {Double.parseDouble(value)};
                            p4.setX(m, 0);
                            value = "";
                        }

                    }
                }
                double m[] = {0, Double.parseDouble(value)};
                p4.setX(m, 1);
                Point2D mp[]={p1,p2,p3,p4};
                QGon c = new QGon(mp);

                current = t4.getText();
                value = "";
                K = 1;
                p1 = new Point2D();
                p2 = new Point2D();
                cur = current.toCharArray();
                for (int j = 0; j < cur.length; j++) {
                    if (cur[j] != ',')
                        value += cur[j];
                    else {
                        if (K == 1) {
                            K++;
                            m = new double[]{Double.parseDouble(value)};
                            p1.setX(m, 0);
                            value = "";
                        }
                        else if (K == 2) {
                            K++;
                            m= new double[]{0, Double.parseDouble(value)};
                            p1.setX(m, 1);
                            value = "";
                        }
                        else if (K == 3) {
                            K++;
                            m= new double[]{ Double.parseDouble(value)};
                            p2.setX(m, 0);
                            value = "";
                        }
                        else if (K == 4) {
                            K++;
                            m = new double[]{0,Double.parseDouble(value)};
                            p2.setX(m, 1);
                            value = "";
                        }
                        else if (K == 5) {
                            K++;
                            m = new double[]{Double.parseDouble(value)};
                            p3.setX(m, 0);
                            value = "";
                        }
                        else if (K == 6) {
                            K++;
                             m =new double[] {0,Double.parseDouble(value)};
                            p3.setX(m, 1);
                            value = "";
                        }
                        else if (K == 7) {
                            K++;
                             m = new double[]{Double.parseDouble(value)};
                            p4.setX(m, 0);
                            value = "";
                        }
                    }
                }
                m= new double[]{0, Double.parseDouble(value)};
                p4.setX(m, 1);
                mp=new Point2D[]{p1,p2,p3,p4};
                QGon c2 = new QGon(mp);

                sampleController.crossWrite(c.cross(c2));
            }
            else if(t1.getText().equals("Rectangle"))
            {
                String current = t2.getText();
                String value = "";
                int K = 1;
                Point2D p1 = new Point2D();
                Point2D p2 = new Point2D();
                Point2D p3 = new Point2D();
                Point2D p4 = new Point2D();
                char[] cur = current.toCharArray();
                for (int j = 0; j < cur.length; j++) {
                    if (cur[j] != ',')
                        value += cur[j];
                    else {
                        if (K == 1) {
                            K++;
                            double m[] = {Double.parseDouble(value)};
                            p1.setX(m, 0);
                            value = "";
                        }
                        else if (K == 2) {
                            K++;
                            double m[] = {0, Double.parseDouble(value)};
                            p1.setX(m, 1);
                            value = "";
                        }
                        else if (K == 3) {
                            K++;
                            double m[] = {Double.parseDouble(value)};
                            p2.setX(m, 0);
                            value = "";
                        }
                        else if (K == 4) {
                            K++;
                            double m[] = {0,Double.parseDouble(value)};
                            p2.setX(m, 1);
                            value = "";
                        }
                        else if (K == 5) {
                            K++;
                            double m[] = {Double.parseDouble(value)};
                            p3.setX(m, 0);
                            value = "";
                        }
                        else if (K == 6) {
                            K++;
                            double m[] = {0,Double.parseDouble(value)};
                            p3.setX(m, 1);
                            value = "";
                        }
                        else if (K == 7) {
                            K++;
                            double m[] = {Double.parseDouble(value)};
                            p4.setX(m, 0);
                            value = "";
                        }

                    }
                }
                double m[] = {0, Double.parseDouble(value)};
                p4.setX(m, 1);
                Point2D mp[]={p1,p2,p3,p4};
                Rectangle c = new Rectangle(mp);

                current = t4.getText();
                value = "";
                K = 1;
                p1 = new Point2D();
                p2 = new Point2D();
                cur = current.toCharArray();
                for (int j = 0; j < cur.length; j++) {
                    if (cur[j] != ',')
                        value += cur[j];
                    else {
                        if (K == 1) {
                            K++;
                            m = new double[]{Double.parseDouble(value)};
                            p1.setX(m, 0);
                            value = "";
                        }
                        else if (K == 2) {
                            K++;
                            m= new double[]{0, Double.parseDouble(value)};
                            p1.setX(m, 1);
                            value = "";
                        }
                        else if (K == 3) {
                            K++;
                            m= new double[]{ Double.parseDouble(value)};
                            p2.setX(m, 0);
                            value = "";
                        }
                        else if (K == 4) {
                            K++;
                            m = new double[]{0,Double.parseDouble(value)};
                            p2.setX(m, 1);
                            value = "";
                        }
                        else if (K == 5) {
                            K++;
                            m = new double[]{Double.parseDouble(value)};
                            p3.setX(m, 0);
                            value = "";
                        }
                        else if (K == 6) {
                            K++;
                            m =new double[] {0,Double.parseDouble(value)};
                            p3.setX(m, 1);
                            value = "";
                        }
                        else if (K == 7) {
                            K++;
                            m = new double[]{Double.parseDouble(value)};
                            p4.setX(m, 0);
                            value = "";
                        }
                    }
                }
                m= new double[]{0, Double.parseDouble(value)};
                p4.setX(m, 1);
                mp=new Point2D[]{p1,p2,p3,p4};
                Rectangle c2 = new Rectangle(mp);

                sampleController.crossWrite(c.cross(c2));
            }
            else if(t1.getText().equals("Trapeze"))
            {
                String current = t2.getText();
                String value = "";
                int K = 1;
                Point2D p1 = new Point2D();
                Point2D p2 = new Point2D();
                Point2D p3 = new Point2D();
                Point2D p4 = new Point2D();
                char[] cur = current.toCharArray();
                for (int j = 0; j < cur.length; j++) {
                    if (cur[j] != ',')
                        value += cur[j];
                    else {
                        if (K == 1) {
                            K++;
                            double m[] = {Double.parseDouble(value)};
                            p1.setX(m, 0);
                            value = "";
                        }
                        else if (K == 2) {
                            K++;
                            double m[] = {0, Double.parseDouble(value)};
                            p1.setX(m, 1);
                            value = "";
                        }
                        else if (K == 3) {
                            K++;
                            double m[] = {Double.parseDouble(value)};
                            p2.setX(m, 0);
                            value = "";
                        }
                        else if (K == 4) {
                            K++;
                            double m[] = {0,Double.parseDouble(value)};
                            p2.setX(m, 1);
                            value = "";
                        }
                        else if (K == 5) {
                            K++;
                            double m[] = {Double.parseDouble(value)};
                            p3.setX(m, 0);
                            value = "";
                        }
                        else if (K == 6) {
                            K++;
                            double m[] = {0,Double.parseDouble(value)};
                            p3.setX(m, 1);
                            value = "";
                        }
                        else if (K == 7) {
                            K++;
                            double m[] = {Double.parseDouble(value)};
                            p4.setX(m, 0);
                            value = "";
                        }

                    }
                }
                double m[] = {0, Double.parseDouble(value)};
                p4.setX(m, 1);
                Point2D mp[]={p1,p2,p3,p4};
                Trapeze c = new Trapeze(mp);

                current = t4.getText();
                value = "";
                K = 1;
                p1 = new Point2D();
                p2 = new Point2D();
                cur = current.toCharArray();
                for (int j = 0; j < cur.length; j++) {
                    if (cur[j] != ',')
                        value += cur[j];
                    else {
                        if (K == 1) {
                            K++;
                            m = new double[]{Double.parseDouble(value)};
                            p1.setX(m, 0);
                            value = "";
                        }
                        else if (K == 2) {
                            K++;
                            m= new double[]{0, Double.parseDouble(value)};
                            p1.setX(m, 1);
                            value = "";
                        }
                        else if (K == 3) {
                            K++;
                            m= new double[]{ Double.parseDouble(value)};
                            p2.setX(m, 0);
                            value = "";
                        }
                        else if (K == 4) {
                            K++;
                            m = new double[]{0,Double.parseDouble(value)};
                            p2.setX(m, 1);
                            value = "";
                        }
                        else if (K == 5) {
                            K++;
                            m = new double[]{Double.parseDouble(value)};
                            p3.setX(m, 0);
                            value = "";
                        }
                        else if (K == 6) {
                            K++;
                            m =new double[] {0,Double.parseDouble(value)};
                            p3.setX(m, 1);
                            value = "";
                        }
                        else if (K == 7) {
                            K++;
                            m = new double[]{Double.parseDouble(value)};
                            p4.setX(m, 0);
                            value = "";
                        }
                    }
                }
                m= new double[]{0, Double.parseDouble(value)};
                p4.setX(m, 1);
                mp=new Point2D[]{p1,p2,p3,p4};
                Trapeze c2 = new Trapeze(mp);

                sampleController.crossWrite(c.cross(c2));
            }
            else if(t1.getText().equals("Polyline"))
            {
                String current = t2.getText();
                String value = "";
                int K = 1;
                Point2D p1 = new Point2D();
                Point2D p2 = new Point2D();
                Point2D p3 = new Point2D();
                Point2D p4 = new Point2D();
                Point2D p5 = new Point2D();
                Point2D p6 = new Point2D();
                char[] cur = current.toCharArray();
int len=0;
                for(int j = 0; j < cur.length; j++)
                    if(cur[j]==',')len++;

                Polyline c=null;
                if(len==7) {
                    for (int j = 0; j < cur.length; j++) {
                        if (cur[j] != ',')
                            value += cur[j];
                        else {
                            if (K == 1) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p1.setX(m, 0);
                                value = "";
                            } else if (K == 2) {
                                K++;
                                double m[] = {0, Double.parseDouble(value)};
                                p1.setX(m, 1);
                                value = "";
                            } else if (K == 3) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p2.setX(m, 0);
                                value = "";
                            } else if (K == 4) {
                                K++;
                                double m[] = {0, Double.parseDouble(value)};
                                p2.setX(m, 1);
                                value = "";
                            } else if (K == 5) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p3.setX(m, 0);
                                value = "";
                            } else if (K == 6) {
                                K++;
                                double m[] = {0, Double.parseDouble(value)};
                                p3.setX(m, 1);
                                value = "";
                            } else if (K == 7) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p4.setX(m, 0);
                                value = "";
                            }

                        }
                    }
                    double m[] = {0, Double.parseDouble(value)};
                    p4.setX(m, 1);
                    Point2D mp[] = {p1, p2, p3, p4};
                     c = new Polyline(mp);
                }
                if(len==5) {
                    for (int j = 0; j < cur.length; j++) {
                        if (cur[j] != ',')
                            value += cur[j];
                        else {
                            if (K == 1) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p1.setX(m, 0);
                                value = "";
                            } else if (K == 2) {
                                K++;
                                double m[] = {0, Double.parseDouble(value)};
                                p1.setX(m, 1);
                                value = "";
                            } else if (K == 3) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p2.setX(m, 0);
                                value = "";
                            } else if (K == 4) {
                                K++;
                                double m[] = {0, Double.parseDouble(value)};
                                p2.setX(m, 1);
                                value = "";
                            } else if (K == 5) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p3.setX(m, 0);
                                value = "";
                            }

                        }
                    }
                    double m[] = {0, Double.parseDouble(value)};
                    p3.setX(m, 1);
                    Point2D mp[] = {p1, p2, p3};
                    c = new Polyline(mp);
                }
                if(len==9) {
                    for (int j = 0; j < cur.length; j++) {
                        if (cur[j] != ',')
                            value += cur[j];
                        else {
                            if (K == 1) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p1.setX(m, 0);
                                value = "";
                            } else if (K == 2) {
                                K++;
                                double m[] = {0, Double.parseDouble(value)};
                                p1.setX(m, 1);
                                value = "";
                            } else if (K == 3) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p2.setX(m, 0);
                                value = "";
                            } else if (K == 4) {
                                K++;
                                double m[] = {0, Double.parseDouble(value)};
                                p2.setX(m, 1);
                                value = "";
                            } else if (K == 5) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p3.setX(m, 0);
                                value = "";
                            } else if (K == 6) {
                                K++;
                                double m[] = {0, Double.parseDouble(value)};
                                p3.setX(m, 1);
                                value = "";
                            } else if (K == 7) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p4.setX(m, 0);
                                value = "";
                            }
                            else if (K == 8) {
                                K++;
                                double m[] = {0,Double.parseDouble(value)};
                                p4.setX(m, 1);
                                value = "";
                            }
                            else if (K == 9) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p5.setX(m, 0);
                                value = "";
                            }

                        }
                    }
                    double m[] = {0, Double.parseDouble(value)};
                    p5.setX(m, 1);
                    Point2D mp[] = {p1, p2, p3, p4,p5};
                    c = new Polyline(mp);
                }
                if(len==11) {
                    for (int j = 0; j < cur.length; j++) {
                        if (cur[j] != ',')
                            value += cur[j];
                        else {
                            if (K == 1) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p1.setX(m, 0);
                                value = "";
                            } else if (K == 2) {
                                K++;
                                double m[] = {0, Double.parseDouble(value)};
                                p1.setX(m, 1);
                                value = "";
                            } else if (K == 3) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p2.setX(m, 0);
                                value = "";
                            } else if (K == 4) {
                                K++;
                                double m[] = {0, Double.parseDouble(value)};
                                p2.setX(m, 1);
                                value = "";
                            } else if (K == 5) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p3.setX(m, 0);
                                value = "";
                            } else if (K == 6) {
                                K++;
                                double m[] = {0, Double.parseDouble(value)};
                                p3.setX(m, 1);
                                value = "";
                            } else if (K == 7) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p4.setX(m, 0);
                                value = "";
                            }
                            else if (K == 8) {
                                K++;
                                double m[] = {0,Double.parseDouble(value)};
                                p4.setX(m, 1);
                                value = "";
                            }
                            else if (K == 9) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p5.setX(m, 0);
                                value = "";
                            }
                            else if (K == 10) {
                                K++;
                                double m[] = {0,Double.parseDouble(value)};
                                p5.setX(m, 1);
                                value = "";
                            }
                            else if (K == 11) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p6.setX(m, 0);
                                value = "";
                            }
                        }
                    }
                    double m[] = {0, Double.parseDouble(value)};
                    p6.setX(m, 1);
                    Point2D mp[] = {p1, p2, p3, p4,p5,p6};
                    c = new Polyline(mp);
                }
                current = t4.getText();
                value = "";
                K = 1;
                p1 = new Point2D();
                p2 = new Point2D();
                p3 = new Point2D();
                p4 = new Point2D();
                p5= new Point2D();
                p6 = new Point2D();
                cur = current.toCharArray();
                len=0;
                for(int j = 0; j < cur.length; j++)
                    if(cur[j]==',')len++;
                Polyline c2 = null;
                if(len==7) {
                    double[] m;
                    for (int j = 0; j < cur.length; j++) {
                        if (cur[j] != ',')
                            value += cur[j];
                        else {
                            if (K == 1) {
                                K++;
                                m = new double[]{Double.parseDouble(value)};
                                p1.setX(m, 0);
                                value = "";
                            } else if (K == 2) {
                                K++;
                                m = new double[]{0, Double.parseDouble(value)};
                                p1.setX(m, 1);
                                value = "";
                            } else if (K == 3) {
                                K++;
                                m = new double[]{Double.parseDouble(value)};
                                p2.setX(m, 0);
                                value = "";
                            } else if (K == 4) {
                                K++;
                                m = new double[]{0, Double.parseDouble(value)};
                                p2.setX(m, 1);
                                value = "";
                            } else if (K == 5) {
                                K++;
                                m = new double[]{Double.parseDouble(value)};
                                p3.setX(m, 0);
                                value = "";
                            } else if (K == 6) {
                                K++;
                                m = new double[]{0, Double.parseDouble(value)};
                                p3.setX(m, 1);
                                value = "";
                            } else if (K == 7) {
                                K++;
                                m = new double[]{Double.parseDouble(value)};
                                p4.setX(m, 0);
                                value = "";
                            }
                        }
                    }
                    m = new double[]{0, Double.parseDouble(value)};
                    p4.setX(m, 1);
                    Point2D []mp = new Point2D[]{p1, p2, p3, p4};
                     c2 = new Polyline(mp);
                }
                if(len==5) {
                    double[] m;
                    for (int j = 0; j < cur.length; j++) {
                        if (cur[j] != ',')
                            value += cur[j];
                        else {
                            if (K == 1) {
                                K++;
                                m = new double[]{Double.parseDouble(value)};
                                p1.setX(m, 0);
                                value = "";
                            } else if (K == 2) {
                                K++;
                                m = new double[]{0, Double.parseDouble(value)};
                                p1.setX(m, 1);
                                value = "";
                            } else if (K == 3) {
                                K++;
                                m = new double[]{Double.parseDouble(value)};
                                p2.setX(m, 0);
                                value = "";
                            } else if (K == 4) {
                                K++;
                                m = new double[]{0, Double.parseDouble(value)};
                                p2.setX(m, 1);
                                value = "";
                            } else if (K == 5) {
                                K++;
                                m = new double[]{Double.parseDouble(value)};
                                p3.setX(m, 0);
                                value = "";
                            }
                        }
                    }
                    m = new double[]{0, Double.parseDouble(value)};
                    p3.setX(m, 1);
                    Point2D []mp = new Point2D[]{p1, p2, p3};
                    c2 = new Polyline(mp);
                }
                if(len==9) {
                    for (int j = 0; j < cur.length; j++) {
                        if (cur[j] != ',')
                            value += cur[j];
                        else {
                            if (K == 1) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p1.setX(m, 0);
                                value = "";
                            } else if (K == 2) {
                                K++;
                                double m[] = {0, Double.parseDouble(value)};
                                p1.setX(m, 1);
                                value = "";
                            } else if (K == 3) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p2.setX(m, 0);
                                value = "";
                            } else if (K == 4) {
                                K++;
                                double m[] = {0, Double.parseDouble(value)};
                                p2.setX(m, 1);
                                value = "";
                            } else if (K == 5) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p3.setX(m, 0);
                                value = "";
                            } else if (K == 6) {
                                K++;
                                double m[] = {0, Double.parseDouble(value)};
                                p3.setX(m, 1);
                                value = "";
                            } else if (K == 7) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p4.setX(m, 0);
                                value = "";
                            }
                            else if (K == 8) {
                                K++;
                                double m[] = {0,Double.parseDouble(value)};
                                p4.setX(m, 1);
                                value = "";
                            }
                            else if (K == 9) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p5.setX(m, 0);
                                value = "";
                            }

                        }
                    }
                    double m[] = {0, Double.parseDouble(value)};
                    p5.setX(m, 1);
                    Point2D mp[] = {p1, p2, p3, p4,p5};
                    c = new Polyline(mp);
                }
                if(len==11) {
                    for (int j = 0; j < cur.length; j++) {
                        if (cur[j] != ',')
                            value += cur[j];
                        else {
                            if (K == 1) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p1.setX(m, 0);
                                value = "";
                            } else if (K == 2) {
                                K++;
                                double m[] = {0, Double.parseDouble(value)};
                                p1.setX(m, 1);
                                value = "";
                            } else if (K == 3) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p2.setX(m, 0);
                                value = "";
                            } else if (K == 4) {
                                K++;
                                double m[] = {0, Double.parseDouble(value)};
                                p2.setX(m, 1);
                                value = "";
                            } else if (K == 5) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p3.setX(m, 0);
                                value = "";
                            } else if (K == 6) {
                                K++;
                                double m[] = {0, Double.parseDouble(value)};
                                p3.setX(m, 1);
                                value = "";
                            } else if (K == 7) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p4.setX(m, 0);
                                value = "";
                            }
                            else if (K == 8) {
                                K++;
                                double m[] = {0,Double.parseDouble(value)};
                                p4.setX(m, 1);
                                value = "";
                            }
                            else if (K == 9) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p5.setX(m, 0);
                                value = "";
                            }
                            else if (K == 10) {
                                K++;
                                double m[] = {0,Double.parseDouble(value)};
                                p5.setX(m, 1);
                                value = "";
                            }
                            else if (K == 11) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p6.setX(m, 0);
                                value = "";
                            }
                        }
                    }
                    double m[] = {0, Double.parseDouble(value)};
                    p6.setX(m, 1);
                    Point2D mp[] = {p1, p2, p3, p4,p5,p6};
                    c = new Polyline(mp);
                }

                sampleController.crossWrite(c.cross(c2));
            }
            else if(t1.getText().equals("NGon"))
            {
                String current = t2.getText();
                String value = "";
                int K = 1;
                Point2D p1 = new Point2D();
                Point2D p2 = new Point2D();
                Point2D p3 = new Point2D();
                Point2D p4 = new Point2D();
                Point2D p5 = new Point2D();
                Point2D p6 = new Point2D();
                char[] cur = current.toCharArray();
                int len=0;
                for(int j = 0; j < cur.length; j++)
                    if(cur[j]==',')len++;

                NGon c=null;
                if(len==7) {
                    for (int j = 0; j < cur.length; j++) {
                        if (cur[j] != ',')
                            value += cur[j];
                        else {
                            if (K == 1) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p1.setX(m, 0);
                                value = "";
                            } else if (K == 2) {
                                K++;
                                double m[] = {0, Double.parseDouble(value)};
                                p1.setX(m, 1);
                                value = "";
                            } else if (K == 3) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p2.setX(m, 0);
                                value = "";
                            } else if (K == 4) {
                                K++;
                                double m[] = {0, Double.parseDouble(value)};
                                p2.setX(m, 1);
                                value = "";
                            } else if (K == 5) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p3.setX(m, 0);
                                value = "";
                            } else if (K == 6) {
                                K++;
                                double m[] = {0, Double.parseDouble(value)};
                                p3.setX(m, 1);
                                value = "";
                            } else if (K == 7) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p4.setX(m, 0);
                                value = "";
                            }

                        }
                    }
                    double m[] = {0, Double.parseDouble(value)};
                    p4.setX(m, 1);
                    Point2D mp[] = {p1, p2, p3, p4};
                    c = new NGon(mp);
                }
                if(len==5) {
                    for (int j = 0; j < cur.length; j++) {
                        if (cur[j] != ',')
                            value += cur[j];
                        else {
                            if (K == 1) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p1.setX(m, 0);
                                value = "";
                            } else if (K == 2) {
                                K++;
                                double m[] = {0, Double.parseDouble(value)};
                                p1.setX(m, 1);
                                value = "";
                            } else if (K == 3) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p2.setX(m, 0);
                                value = "";
                            } else if (K == 4) {
                                K++;
                                double m[] = {0, Double.parseDouble(value)};
                                p2.setX(m, 1);
                                value = "";
                            } else if (K == 5) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p3.setX(m, 0);
                                value = "";
                            }

                        }
                    }
                    double m[] = {0, Double.parseDouble(value)};
                    p3.setX(m, 1);
                    Point2D mp[] = {p1, p2, p3};
                    c = new NGon(mp);
                }
                if(len==9) {
                    for (int j = 0; j < cur.length; j++) {
                        if (cur[j] != ',')
                            value += cur[j];
                        else {
                            if (K == 1) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p1.setX(m, 0);
                                value = "";
                            } else if (K == 2) {
                                K++;
                                double m[] = {0, Double.parseDouble(value)};
                                p1.setX(m, 1);
                                value = "";
                            } else if (K == 3) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p2.setX(m, 0);
                                value = "";
                            } else if (K == 4) {
                                K++;
                                double m[] = {0, Double.parseDouble(value)};
                                p2.setX(m, 1);
                                value = "";
                            } else if (K == 5) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p3.setX(m, 0);
                                value = "";
                            } else if (K == 6) {
                                K++;
                                double m[] = {0, Double.parseDouble(value)};
                                p3.setX(m, 1);
                                value = "";
                            } else if (K == 7) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p4.setX(m, 0);
                                value = "";
                            }
                            else if (K == 8) {
                                K++;
                                double m[] = {0,Double.parseDouble(value)};
                                p4.setX(m, 1);
                                value = "";
                            }
                            else if (K == 9) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p5.setX(m, 0);
                                value = "";
                            }

                        }
                    }
                    double m[] = {0, Double.parseDouble(value)};
                    p5.setX(m, 1);
                    Point2D mp[] = {p1, p2, p3, p4,p5};
                    c = new NGon(mp);
                }
                if(len==11) {
                    for (int j = 0; j < cur.length; j++) {
                        if (cur[j] != ',')
                            value += cur[j];
                        else {
                            if (K == 1) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p1.setX(m, 0);
                                value = "";
                            } else if (K == 2) {
                                K++;
                                double m[] = {0, Double.parseDouble(value)};
                                p1.setX(m, 1);
                                value = "";
                            } else if (K == 3) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p2.setX(m, 0);
                                value = "";
                            } else if (K == 4) {
                                K++;
                                double m[] = {0, Double.parseDouble(value)};
                                p2.setX(m, 1);
                                value = "";
                            } else if (K == 5) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p3.setX(m, 0);
                                value = "";
                            } else if (K == 6) {
                                K++;
                                double m[] = {0, Double.parseDouble(value)};
                                p3.setX(m, 1);
                                value = "";
                            } else if (K == 7) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p4.setX(m, 0);
                                value = "";
                            }
                            else if (K == 8) {
                                K++;
                                double m[] = {0,Double.parseDouble(value)};
                                p4.setX(m, 1);
                                value = "";
                            }
                            else if (K == 9) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p5.setX(m, 0);
                                value = "";
                            }
                            else if (K == 10) {
                                K++;
                                double m[] = {0,Double.parseDouble(value)};
                                p5.setX(m, 1);
                                value = "";
                            }
                            else if (K == 11) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p6.setX(m, 0);
                                value = "";
                            }
                        }
                    }
                    double m[] = {0, Double.parseDouble(value)};
                    p6.setX(m, 1);
                    Point2D mp[] = {p1, p2, p3, p4,p5,p6};
                    c = new NGon(mp);
                }
                current = t4.getText();
                value = "";
                K = 1;
                p1 = new Point2D();
                p2 = new Point2D();
                p3 = new Point2D();
                p4 = new Point2D();
                p5= new Point2D();
                p6 = new Point2D();
                cur = current.toCharArray();
                len=0;
                for(int j = 0; j < cur.length; j++)
                    if(cur[j]==',')len++;
                NGon c2 = null;
                if(len==7) {
                    double[] m;
                    for (int j = 0; j < cur.length; j++) {
                        if (cur[j] != ',')
                            value += cur[j];
                        else {
                            if (K == 1) {
                                K++;
                                m = new double[]{Double.parseDouble(value)};
                                p1.setX(m, 0);
                                value = "";
                            } else if (K == 2) {
                                K++;
                                m = new double[]{0, Double.parseDouble(value)};
                                p1.setX(m, 1);
                                value = "";
                            } else if (K == 3) {
                                K++;
                                m = new double[]{Double.parseDouble(value)};
                                p2.setX(m, 0);
                                value = "";
                            } else if (K == 4) {
                                K++;
                                m = new double[]{0, Double.parseDouble(value)};
                                p2.setX(m, 1);
                                value = "";
                            } else if (K == 5) {
                                K++;
                                m = new double[]{Double.parseDouble(value)};
                                p3.setX(m, 0);
                                value = "";
                            } else if (K == 6) {
                                K++;
                                m = new double[]{0, Double.parseDouble(value)};
                                p3.setX(m, 1);
                                value = "";
                            } else if (K == 7) {
                                K++;
                                m = new double[]{Double.parseDouble(value)};
                                p4.setX(m, 0);
                                value = "";
                            }
                        }
                    }
                    m = new double[]{0, Double.parseDouble(value)};
                    p4.setX(m, 1);
                    Point2D []mp = new Point2D[]{p1, p2, p3, p4};
                    c2 = new NGon(mp);
                }
                if(len==5) {
                    double[] m;
                    for (int j = 0; j < cur.length; j++) {
                        if (cur[j] != ',')
                            value += cur[j];
                        else {
                            if (K == 1) {
                                K++;
                                m = new double[]{Double.parseDouble(value)};
                                p1.setX(m, 0);
                                value = "";
                            } else if (K == 2) {
                                K++;
                                m = new double[]{0, Double.parseDouble(value)};
                                p1.setX(m, 1);
                                value = "";
                            } else if (K == 3) {
                                K++;
                                m = new double[]{Double.parseDouble(value)};
                                p2.setX(m, 0);
                                value = "";
                            } else if (K == 4) {
                                K++;
                                m = new double[]{0, Double.parseDouble(value)};
                                p2.setX(m, 1);
                                value = "";
                            } else if (K == 5) {
                                K++;
                                m = new double[]{Double.parseDouble(value)};
                                p3.setX(m, 0);
                                value = "";
                            }
                        }
                    }
                    m = new double[]{0, Double.parseDouble(value)};
                    p3.setX(m, 1);
                    Point2D []mp = new Point2D[]{p1, p2, p3};
                    c2 = new NGon(mp);
                }
                if(len==9) {
                    for (int j = 0; j < cur.length; j++) {
                        if (cur[j] != ',')
                            value += cur[j];
                        else {
                            if (K == 1) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p1.setX(m, 0);
                                value = "";
                            } else if (K == 2) {
                                K++;
                                double m[] = {0, Double.parseDouble(value)};
                                p1.setX(m, 1);
                                value = "";
                            } else if (K == 3) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p2.setX(m, 0);
                                value = "";
                            } else if (K == 4) {
                                K++;
                                double m[] = {0, Double.parseDouble(value)};
                                p2.setX(m, 1);
                                value = "";
                            } else if (K == 5) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p3.setX(m, 0);
                                value = "";
                            } else if (K == 6) {
                                K++;
                                double m[] = {0, Double.parseDouble(value)};
                                p3.setX(m, 1);
                                value = "";
                            } else if (K == 7) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p4.setX(m, 0);
                                value = "";
                            }
                            else if (K == 8) {
                                K++;
                                double m[] = {0,Double.parseDouble(value)};
                                p4.setX(m, 1);
                                value = "";
                            }
                            else if (K == 9) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p5.setX(m, 0);
                                value = "";
                            }

                        }
                    }
                    double m[] = {0, Double.parseDouble(value)};
                    p5.setX(m, 1);
                    Point2D mp[] = {p1, p2, p3, p4,p5};
                    c = new NGon(mp);
                }
                if(len==11) {
                    for (int j = 0; j < cur.length; j++) {
                        if (cur[j] != ',')
                            value += cur[j];
                        else {
                            if (K == 1) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p1.setX(m, 0);
                                value = "";
                            } else if (K == 2) {
                                K++;
                                double m[] = {0, Double.parseDouble(value)};
                                p1.setX(m, 1);
                                value = "";
                            } else if (K == 3) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p2.setX(m, 0);
                                value = "";
                            } else if (K == 4) {
                                K++;
                                double m[] = {0, Double.parseDouble(value)};
                                p2.setX(m, 1);
                                value = "";
                            } else if (K == 5) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p3.setX(m, 0);
                                value = "";
                            } else if (K == 6) {
                                K++;
                                double m[] = {0, Double.parseDouble(value)};
                                p3.setX(m, 1);
                                value = "";
                            } else if (K == 7) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p4.setX(m, 0);
                                value = "";
                            }
                            else if (K == 8) {
                                K++;
                                double m[] = {0,Double.parseDouble(value)};
                                p4.setX(m, 1);
                                value = "";
                            }
                            else if (K == 9) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p5.setX(m, 0);
                                value = "";
                            }
                            else if (K == 10) {
                                K++;
                                double m[] = {0,Double.parseDouble(value)};
                                p5.setX(m, 1);
                                value = "";
                            }
                            else if (K == 11) {
                                K++;
                                double m[] = {Double.parseDouble(value)};
                                p6.setX(m, 0);
                                value = "";
                            }
                        }
                    }
                    double m[] = {0, Double.parseDouble(value)};
                    p6.setX(m, 1);
                    Point2D mp[] = {p1, p2, p3, p4,p5,p6};
                    c = new NGon(mp);
                }
                sampleController.crossWrite(c.cross(c2));
            }

        }
        Stage stage= new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        Stage s = (Stage) t1.getScene().getWindow();
        s.close();
    }
    @FXML public void cancel()throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        Controller sampleController=loader.getController();


        Stage stage= new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        Stage s = (Stage) t1.getScene().getWindow();
        s.close();
    }
}

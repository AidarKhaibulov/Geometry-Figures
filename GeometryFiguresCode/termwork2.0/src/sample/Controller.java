package sample;

import firstworkpackage.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    @FXML  private TextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10,tf11,tf12;
    @FXML  public TextField type,spinnerCount,square;
    @FXML  public Button btnOK;

    public void createNewFigure() throws IOException {
        Stage newWindow = new Stage();
        newWindow.setTitle("Creating new figure");
        Parent root1 = FXMLLoader.load(getClass().getResource("createNewFigure.fxml"));
        newWindow.setTitle("Creating new figure");
        newWindow.setScene(new Scene(root1, 655,430 ));
        newWindow.show();
        closeForm();
    }
    public void deleteFigure()throws IOException{
        Stage newWindow = new Stage();
        newWindow.setTitle("Delete figure");
        Parent root1 = FXMLLoader.load(getClass().getResource("deleteFigure.fxml"));
        newWindow.setTitle("Delete figure");
        newWindow.setScene(new Scene(root1, 500,300 ));
        newWindow.show();
        closeForm();
    }
    public void crossFigures()throws IOException
    {
        Stage newWindow = new Stage();
        newWindow.setTitle("Cross figure");
        Parent root1 = FXMLLoader.load(getClass().getResource("crossFigures.fxml"));
        newWindow.setTitle("Cross figure");
        newWindow.setScene(new Scene(root1, 500,300 ));
        newWindow.show();
        closeForm();
    }
    public void saveFile()throws IOException
    {
        Stage newWindow = new Stage();
        newWindow.setTitle("Save file");
        Parent root1 = FXMLLoader.load(getClass().getResource("saveFile.fxml"));
        newWindow.setTitle("Save file");
        newWindow.setScene(new Scene(root1, 400,300 ));
        newWindow.show();
        closeForm();
    }
    public void loadFile()throws IOException
    {
        Stage newWindow = new Stage();
        newWindow.setTitle("Load file");
        Parent root1 = FXMLLoader.load(getClass().getResource("loadFile.fxml"));
        newWindow.setTitle("Load file");
        newWindow.setScene(new Scene(root1, 400,300 ));
        newWindow.show();
        closeForm();
    }
    @FXML private Canvas fxCanvas;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        GraphicsContext gc = fxCanvas.getGraphicsContext2D();
        {
            int x1 = 250;
            int y1 = 500;
            int x2 = 250;
            int y2 = 0;
            gc.strokeLine(x1, y1, x2, y2);
            x1=0;
            y1=250;
            x2=500;
            y2=250;
            gc.strokeLine(x1, y1, x2, y2);
        }//задание осей координат

        try {
            BufferedReader bfr=new BufferedReader(new FileReader("C:\\Users\\79021\\IdeaProjects\\termwork2.0\\CASHVALUE.txt"));
            int n=Integer.parseInt(bfr.readLine());
            bfr.close();
            BufferedReader bfr1=new BufferedReader(new FileReader("C:\\Users\\79021\\IdeaProjects\\termwork2.0\\CASH.txt"));

            //цикл чтения фигур из кэша при запуске приложения(обновления)
            bfr1.readLine();//пропустил первую пустую строку в файле
            String line=null;
                while((line=bfr1.readLine())!=null) {
                    if (line.equals("Circle")) {
                        type.setText("Circle");
                        //i++;
                        String current = bfr1.readLine();
                        String value = "";
                        int K=1;
                        char[] cur = current.toCharArray();
                        for (int j = 0; j < cur.length; j++) {
                            if (cur[j] != ',')
                                value += cur[j];
                            else {
                                if (K == 1) {
                                    tf1.setText(String.valueOf(value));
                                    K++;
                                    value = "";
                                }
                                else
                                    if (K == 2) {
                                    tf2.setText(String.valueOf(value));
                                    K++;
                                    value = "";
                                }
                            }
                            if(K==3)
                                tf3.setText(String.valueOf(value));
                        }
                        GraphicsContext gc1 = fxCanvas.getGraphicsContext2D();
                        addCircle(gc1);
                    }
                    else
                    if (line.equals("Segment")) {
                        type.setText("Segment");
                        //i++;
                        String current = bfr1.readLine();
                        String value = "";
                        int K=1;
                        char[] cur = current.toCharArray();
                        for (int j = 0; j < cur.length; j++) {
                            if (cur[j] != ',')
                                value += cur[j];
                            else {
                                if (K == 1) {
                                    tf1.setText(value);
                                    K++;
                                    value = "";
                                }
                                else
                                if (K == 2) {
                                    tf2.setText(value);
                                    K++;
                                    value = "";
                                }
                                else
                                if (K == 3) {
                                    tf3.setText(value);
                                    K++;
                                    value = "";
                                }
                            }
                            if(K==4)
                                tf4.setText(value);
                        }
                        GraphicsContext gc1 = fxCanvas.getGraphicsContext2D();
                        addSegment(gc1);
                    }
                    else
                    if (line.equals("QGon")) {
                        type.setText("QGon");
                        //i++;
                        String current = bfr1.readLine();
                        String value = "";
                        int K=1;
                        char[] cur = current.toCharArray();
                        for (int j = 0; j < cur.length; j++) {
                            if (cur[j] != ',')
                                value += cur[j];
                            else {
                                if (K == 1) {
                                    tf1.setText(value);
                                    K++;
                                    value = "";
                                }
                                else
                                if (K == 2) {
                                    tf2.setText(value);
                                    K++;
                                    value = "";
                                }
                                else
                                if (K == 3) {
                                    tf3.setText(value);
                                    K++;
                                    value = "";
                                }
                                else
                                if (K == 4) {
                                    tf4.setText(value);
                                    K++;
                                    value = "";
                                }
                                else
                                if (K == 5) {
                                    tf5.setText(value);
                                    K++;
                                    value = "";
                                }
                                else
                                if (K == 6) {
                                    tf6.setText(value);
                                    K++;
                                    value = "";
                                }
                                else
                                if (K == 7) {
                                    tf7.setText(value);
                                    K++;
                                    value = "";
                                }
                            }
                            if(K==8)
                                tf8.setText(value);
                        }
                        GraphicsContext gc1 = fxCanvas.getGraphicsContext2D();
                        addQGon(gc1);
                    }
                    else
                    if (line.equals("Rectangle")) {
                        type.setText("Rectangle");
                        //i++;
                        String current = bfr1.readLine();
                        String value = "";
                        int K=1;
                        char[] cur = current.toCharArray();
                        for (int j = 0; j < cur.length; j++) {
                            if (cur[j] != ',')
                                value += cur[j];
                            else {
                                if (K == 1) {
                                    tf1.setText(value);
                                    K++;
                                    value = "";
                                }
                                else
                                if (K == 2) {
                                    tf2.setText(value);
                                    K++;
                                    value = "";
                                }
                                else
                                if (K == 3) {
                                    tf3.setText(value);
                                    K++;
                                    value = "";
                                }
                                else
                                if (K == 4) {
                                    tf4.setText(value);
                                    K++;
                                    value = "";
                                }
                                else
                                if (K == 5) {
                                    tf5.setText(value);
                                    K++;
                                    value = "";
                                }
                                else
                                if (K == 6) {
                                    tf6.setText(value);
                                    K++;
                                    value = "";
                                }
                                else
                                if (K == 7) {
                                    tf7.setText(value);
                                    K++;
                                    value = "";
                                }
                            }
                            if(K==8)
                                tf8.setText(value);
                        }
                        GraphicsContext gc1 = fxCanvas.getGraphicsContext2D();
                        addRectangle(gc1);
                    }
                    else
                    if (line.equals("Trapeze")) {
                        type.setText("Trapeze");
                       // i++;
                        String current = bfr1.readLine();
                        String value = "";
                        int K=1;
                        char[] cur = current.toCharArray();
                        for (int j = 0; j < cur.length; j++) {
                            if (cur[j] != ',')
                                value += cur[j];
                            else {
                                if (K == 1) {
                                    tf1.setText(value);
                                    K++;
                                    value = "";
                                }
                                else
                                if (K == 2) {
                                    tf2.setText(value);
                                    K++;
                                    value = "";
                                }
                                else
                                if (K == 3) {
                                    tf3.setText(value);
                                    K++;
                                    value = "";
                                }
                                else
                                if (K == 4) {
                                    tf4.setText(value);
                                    K++;
                                    value = "";
                                }
                                else
                                if (K == 5) {
                                    tf5.setText(value);
                                    K++;
                                    value = "";
                                }
                                else
                                if (K == 6) {
                                    tf6.setText(value);
                                    K++;
                                    value = "";
                                }
                                else
                                if (K == 7) {
                                    tf7.setText(value);
                                    K++;
                                    value = "";
                                }
                            }
                            if(K==8)
                                tf8.setText(value);
                        }
                        GraphicsContext gc1 = fxCanvas.getGraphicsContext2D();
                        addTrapeze(gc1);
                    }
                    else
                    if (line.equals("TGon")) {
                        type.setText("TGon");
                        //i++;
                        String current = bfr1.readLine();
                        String value = "";
                        int K=1;
                        char[] cur = current.toCharArray();
                        for (int j = 0; j < cur.length; j++) {
                            if (cur[j] != ',')
                                value += cur[j];
                            else {
                                if (K == 1) {
                                    tf1.setText(value);
                                    K++;
                                    value = "";
                                }
                                else
                                if (K == 2) {
                                    tf2.setText(value);
                                    K++;
                                    value = "";
                                }
                                else
                                if (K == 3) {
                                    tf3.setText(value);
                                    K++;
                                    value = "";
                                }
                                else
                                if (K == 4) {
                                    tf4.setText(value);
                                    K++;
                                    value = "";
                                }
                                else
                                if (K == 5) {
                                    tf5.setText(value);
                                    K++;
                                    value = "";
                                }

                            }
                            if(K==6)
                                tf6.setText(value);
                        }
                        GraphicsContext gc1 = fxCanvas.getGraphicsContext2D();
                        addTGon(gc1);
                    }
                    else
                    if (line.equals("Polyline")) {
                        type.setText("Polyline");
                        //i++;
                       String spin=bfr1.readLine();
                        if(spin.equals("3")) {
                            spinnerCount.setText("3");
                            String current = bfr1.readLine();
                            String value = "";
                            int K = 1;
                            char[] cur = current.toCharArray();
                            for (int j = 0; j < cur.length; j++) {
                                if (cur[j] != ',')
                                    value += cur[j];
                                else {
                                    if (K == 1) {
                                        tf1.setText(value);
                                        K++;
                                        value = "";
                                    } else if (K == 2) {
                                        tf2.setText(value);
                                        K++;
                                        value = "";
                                    } else if (K == 3) {
                                        tf3.setText(value);
                                        K++;
                                        value = "";
                                    } else if (K == 4) {
                                        tf4.setText(value);
                                        K++;
                                        value = "";
                                    } else if (K == 5) {
                                        tf5.setText(value);
                                        K++;
                                        value = "";
                                    }

                                }
                                if (K == 6)
                                    tf6.setText(value);
                            }
                        }

                        if(spin.equals("4")) {
                            spinnerCount.setText("4");
                            String current = bfr1.readLine();
                            String value = "";
                            int K = 1;
                            char[] cur = current.toCharArray();
                            for (int j = 0; j < cur.length; j++) {
                                if (cur[j] != ',')
                                    value += cur[j];
                                else {
                                    if (K == 1) {
                                        tf1.setText(value);
                                        K++;
                                        value = "";
                                    } else if (K == 2) {
                                        tf2.setText(value);
                                        K++;
                                        value = "";
                                    } else if (K == 3) {
                                        tf3.setText(value);
                                        K++;
                                        value = "";
                                    } else if (K == 4) {
                                        tf4.setText(value);
                                        K++;
                                        value = "";
                                    } else if (K == 5) {
                                        tf5.setText(value);
                                        K++;
                                        value = "";
                                    }
                                    else if (K == 6) {
                                        tf6.setText(value);
                                        K++;
                                        value = "";
                                    }
                                    else if (K == 7) {
                                        tf7.setText(value);
                                        K++;
                                        value = "";
                                    }

                                }
                                if (K == 8)
                                    tf8.setText(value);
                            }
                        }
                        if(spin.equals("5")) {
                            spinnerCount.setText("5");
                            String current = bfr1.readLine();
                            String value = "";
                            int K = 1;
                            char[] cur = current.toCharArray();
                            for (int j = 0; j < cur.length; j++) {
                                if (cur[j] != ',')
                                    value += cur[j];
                                else {
                                    if (K == 1) {
                                        tf1.setText(value);
                                        K++;
                                        value = "";
                                    } else if (K == 2) {
                                        tf2.setText(value);
                                        K++;
                                        value = "";
                                    } else if (K == 3) {
                                        tf3.setText(value);
                                        K++;
                                        value = "";
                                    } else if (K == 4) {
                                        tf4.setText(value);
                                        K++;
                                        value = "";
                                    } else if (K == 5) {
                                        tf5.setText(value);
                                        K++;
                                        value = "";
                                    }
                                    else if (K == 6) {
                                        tf6.setText(value);
                                        K++;
                                        value = "";
                                    }
                                    else if (K == 7) {
                                        tf7.setText(value);
                                        K++;
                                        value = "";
                                    }
                                    else if (K == 8) {
                                        tf8.setText(value);
                                        K++;
                                        value = "";
                                    }
                                    else if (K == 9) {
                                        tf9.setText(value);
                                        K++;
                                        value = "";
                                    }

                                }
                                if (K == 10)
                                    tf10.setText(value);
                            }
                        }
                        if(spin.equals("6")) {
                            spinnerCount.setText("6");
                            String current = bfr1.readLine();
                            String value = "";
                            int K = 1;
                            char[] cur = current.toCharArray();
                            for (int j = 0; j < cur.length; j++) {
                                if (cur[j] != ',')
                                    value += cur[j];
                                else {
                                    if (K == 1) {
                                        tf1.setText(value);
                                        K++;
                                        value = "";
                                    } else if (K == 2) {
                                        tf2.setText(value);
                                        K++;
                                        value = "";
                                    } else if (K == 3) {
                                        tf3.setText(value);
                                        K++;
                                        value = "";
                                    } else if (K == 4) {
                                        tf4.setText(value);
                                        K++;
                                        value = "";
                                    } else if (K == 5) {
                                        tf5.setText(value);
                                        K++;
                                        value = "";
                                    }
                                    else if (K == 6) {
                                        tf6.setText(value);
                                        K++;
                                        value = "";
                                    }
                                    else if (K == 7) {
                                        tf7.setText(value);
                                        K++;
                                        value = "";
                                    }
                                    else if (K == 8) {
                                        tf8.setText(value);
                                        K++;
                                        value = "";
                                    }
                                    else if (K == 9) {
                                        tf9.setText(value);
                                        K++;
                                        value = "";
                                    }
                                    else if (K == 10) {
                                        tf10.setText(value);
                                        K++;
                                        value = "";
                                    }
                                    else if (K == 11) {
                                        tf11.setText(value);
                                        K++;
                                        value = "";
                                    }

                                }
                                if (K == 12)
                                    tf12.setText(value);
                            }
                        }
                        GraphicsContext gc1 = fxCanvas.getGraphicsContext2D();
                        addPolyline(gc1);
                    }
                    if (line.equals("NGon")) {
                        type.setText("NGon");
                       // i++;
                        String spin=bfr1.readLine();
                        if(spin.equals("3")) {
                            spinnerCount.setText("3");
                            String current = bfr1.readLine();
                            String value = "";
                            int K = 1;
                            char[] cur = current.toCharArray();
                            for (int j = 0; j < cur.length; j++) {
                                if (cur[j] != ',')
                                    value += cur[j];
                                else {
                                    if (K == 1) {
                                        tf1.setText(value);
                                        K++;
                                        value = "";
                                    } else if (K == 2) {
                                        tf2.setText(value);
                                        K++;
                                        value = "";
                                    } else if (K == 3) {
                                        tf3.setText(value);
                                        K++;
                                        value = "";
                                    } else if (K == 4) {
                                        tf4.setText(value);
                                        K++;
                                        value = "";
                                    } else if (K == 5) {
                                        tf5.setText(value);
                                        K++;
                                        value = "";
                                    }

                                }
                                if (K == 6)
                                    tf6.setText(value);
                            }
                        }

                        if(spin.equals("4")) {
                            spinnerCount.setText("4");
                            String current = bfr1.readLine();
                            String value = "";
                            int K = 1;
                            char[] cur = current.toCharArray();
                            for (int j = 0; j < cur.length; j++) {
                                if (cur[j] != ',')
                                    value += cur[j];
                                else {
                                    if (K == 1) {
                                        tf1.setText(value);
                                        K++;
                                        value = "";
                                    } else if (K == 2) {
                                        tf2.setText(value);
                                        K++;
                                        value = "";
                                    } else if (K == 3) {
                                        tf3.setText(value);
                                        K++;
                                        value = "";
                                    } else if (K == 4) {
                                        tf4.setText(value);
                                        K++;
                                        value = "";
                                    } else if (K == 5) {
                                        tf5.setText(value);
                                        K++;
                                        value = "";
                                    }
                                    else if (K == 6) {
                                        tf6.setText(value);
                                        K++;
                                        value = "";
                                    }
                                    else if (K == 7) {
                                        tf7.setText(value);
                                        K++;
                                        value = "";
                                    }

                                }
                                if (K == 8)
                                    tf8.setText(value);
                            }
                        }
                        if(spin.equals("5")) {
                            spinnerCount.setText("5");
                            String current = bfr1.readLine();
                            String value = "";
                            int K = 1;
                            char[] cur = current.toCharArray();
                            for (int j = 0; j < cur.length; j++) {
                                if (cur[j] != ',')
                                    value += cur[j];
                                else {
                                    if (K == 1) {
                                        tf1.setText(value);
                                        K++;
                                        value = "";
                                    } else if (K == 2) {
                                        tf2.setText(value);
                                        K++;
                                        value = "";
                                    } else if (K == 3) {
                                        tf3.setText(value);
                                        K++;
                                        value = "";
                                    } else if (K == 4) {
                                        tf4.setText(value);
                                        K++;
                                        value = "";
                                    } else if (K == 5) {
                                        tf5.setText(value);
                                        K++;
                                        value = "";
                                    }
                                    else if (K == 6) {
                                        tf6.setText(value);
                                        K++;
                                        value = "";
                                    }
                                    else if (K == 7) {
                                        tf7.setText(value);
                                        K++;
                                        value = "";
                                    }
                                    else if (K == 8) {
                                        tf8.setText(value);
                                        K++;
                                        value = "";
                                    }
                                    else if (K == 9) {
                                        tf9.setText(value);
                                        K++;
                                        value = "";
                                    }

                                }
                                if (K == 10)
                                    tf10.setText(value);
                            }
                        }
                        if(spin.equals("6")) {
                            spinnerCount.setText("6");
                            String current = bfr1.readLine();
                            String value = "";
                            int K = 1;
                            char[] cur = current.toCharArray();
                            for (int j = 0; j < cur.length; j++) {
                                if (cur[j] != ',')
                                    value += cur[j];
                                else {
                                    if (K == 1) {
                                        tf1.setText(value);
                                        K++;
                                        value = "";
                                    } else if (K == 2) {
                                        tf2.setText(value);
                                        K++;
                                        value = "";
                                    } else if (K == 3) {
                                        tf3.setText(value);
                                        K++;
                                        value = "";
                                    } else if (K == 4) {
                                        tf4.setText(value);
                                        K++;
                                        value = "";
                                    } else if (K == 5) {
                                        tf5.setText(value);
                                        K++;
                                        value = "";
                                    }
                                    else if (K == 6) {
                                        tf6.setText(value);
                                        K++;
                                        value = "";
                                    }
                                    else if (K == 7) {
                                        tf7.setText(value);
                                        K++;
                                        value = "";
                                    }
                                    else if (K == 8) {
                                        tf8.setText(value);
                                        K++;
                                        value = "";
                                    }
                                    else if (K == 9) {
                                        tf9.setText(value);
                                        K++;
                                        value = "";
                                    }
                                    else if (K == 10) {
                                        tf10.setText(value);
                                        K++;
                                        value = "";
                                    }
                                    else if (K == 11) {
                                        tf11.setText(value);
                                        K++;
                                        value = "";
                                    }

                                }
                                if (K == 12)
                                    tf12.setText(value);
                            }
                        }
                        GraphicsContext gc1 = fxCanvas.getGraphicsContext2D();
                        addNGon(gc1);
                    }
                }
            //
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*if(type.getText().equals("Circle"))
            addCircle(gc);
        if(type.getText().equals("Segment"))
            addSegment(gc);
        if(type.getText().equals("Polyline"))
            addPolyline(gc);
        if(type.getText().equals("NGon"))
            addNGon(gc);
        if(type.getText().equals("QGon"))
            addQGon(gc);
        if(type.getText().equals("Rectangle"))
            addRectangle(gc);
        if(type.getText().equals("Trapeze"))
            addTrapeze(gc);
        if(type.getText().equals("TGon"))
            addTGon(gc);*/

    }
    @FXML
    void addFigure() throws IOException {
        BufferedReader bfr=new BufferedReader(new FileReader("C:\\Users\\79021\\IdeaProjects\\termwork2.0\\CASHVALUE.txt"));
        int kol= Integer.parseInt(bfr.readLine());

        //
        BufferedWriter bfv = new BufferedWriter(new FileWriter("CASHVALUE.txt"));
        kol++;
        bfv.write(String.valueOf(kol));
        bfv.close();
        BufferedWriter bf = new BufferedWriter(new FileWriter("CASH.txt",true));
        bf.close();
        //увеличивается счетчик количества фигур в кэше

        GraphicsContext gc = fxCanvas.getGraphicsContext2D();
        if(type.getText().equals("Circle"))
        {
            FileWriter fw=new FileWriter("CASH.txt",true);
            bf= new BufferedWriter(fw);
            bf.newLine();
            bf.write("Circle");
            bf.newLine();
            bf.write(tf1.getText()+","+tf2.getText()+","+tf3.getText());
            bf.close();
            addCircle(gc);
        }
        if(type.getText().equals("Segment"))
        {
            FileWriter fw=new FileWriter("CASH.txt",true);
            bf= new BufferedWriter(fw);
            bf.newLine();
            bf.write("Segment");
            bf.newLine();
            bf.write(tf1.getText()+","+tf2.getText()+","+tf3.getText()+","+ tf4.getText());
            bf.close();
            addSegment(gc);
        }
        if(type.getText().equals("Polyline"))
        {
            if(spinnerCount.getText().equals("6")) {
                FileWriter fw=new FileWriter("CASH.txt",true);
                bf= new BufferedWriter(fw);
                bf.newLine();
                bf.write("Polyline");
                bf.newLine();
                bf.write(spinnerCount.getText());
                bf.newLine();
                bf.write(tf1.getText()+","+tf2.getText()+","+tf3.getText()+","+ tf4.getText()+","+ tf5.getText()+","+ tf6.getText()+","+ tf7.getText()+","+ tf8.getText()+","+ tf9.getText()+","+ tf10.getText()+","+ tf11.getText()+","+ tf12.getText());
                bf.close();
                addPolyline(gc);
            }
            if(spinnerCount.getText().equals("5")) {
                FileWriter fw=new FileWriter("CASH.txt",true);
                bf= new BufferedWriter(fw);
                bf.newLine();
                bf.write("Polyline");
                bf.newLine();
                bf.write(spinnerCount.getText());
                bf.newLine();
                bf.write(tf1.getText()+","+tf2.getText()+","+tf3.getText()+","+ tf4.getText()+","+ tf5.getText()+","+ tf6.getText()+","+ tf7.getText()+","+ tf8.getText()+","+ tf9.getText()+","+ tf10.getText());
                bf.close();
                addPolyline(gc);
            }
            if(spinnerCount.getText().equals("4")) {
                FileWriter fw=new FileWriter("CASH.txt",true);
                bf= new BufferedWriter(fw);
                bf.newLine();
                bf.write("Polyline");
                bf.newLine();
                bf.write(spinnerCount.getText());
                bf.newLine();
                bf.write(tf1.getText()+","+tf2.getText()+","+tf3.getText()+","+ tf4.getText()+","+ tf5.getText()+","+ tf6.getText()+","+ tf7.getText()+","+ tf8.getText());
                bf.close();
                addPolyline(gc);
            }
            if(spinnerCount.getText().equals("3")) {
                FileWriter fw=new FileWriter("CASH.txt",true);
                bf= new BufferedWriter(fw);
                bf.newLine();
                bf.write("Polyline");
                bf.newLine();
                bf.write(spinnerCount.getText());
                bf.newLine();
                bf.write(tf1.getText()+","+tf2.getText()+","+tf3.getText()+","+ tf4.getText()+","+ tf5.getText()+","+ tf6.getText());
                bf.close();
                addPolyline(gc);
            }

        }
        if(type.getText().equals("NGon"))
        {
            if(spinnerCount.getText().equals("6")) {
                FileWriter fw=new FileWriter("CASH.txt",true);
                bf= new BufferedWriter(fw);
                bf.newLine();
                bf.write("NGon");
                bf.newLine();
                bf.write(spinnerCount.getText());
                bf.newLine();
                bf.write(tf1.getText()+","+tf2.getText()+","+tf3.getText()+","+ tf4.getText()+","+ tf5.getText()+","+ tf6.getText()+","+ tf7.getText()+","+ tf8.getText()+","+ tf9.getText()+","+ tf10.getText()+","+ tf11.getText()+","+ tf12.getText());
                bf.close();
                addPolyline(gc);
            }
            if(spinnerCount.getText().equals("5")) {
                FileWriter fw=new FileWriter("CASH.txt",true);
                bf= new BufferedWriter(fw);
                bf.newLine();
                bf.write("NGon");
                bf.newLine();
                bf.write(spinnerCount.getText());
                bf.newLine();
                bf.write(tf1.getText()+","+tf2.getText()+","+tf3.getText()+","+ tf4.getText()+","+ tf5.getText()+","+ tf6.getText()+","+ tf7.getText()+","+ tf8.getText()+","+ tf9.getText()+","+ tf10.getText());
                bf.close();
                addPolyline(gc);
            }
            if(spinnerCount.getText().equals("4")) {
                FileWriter fw=new FileWriter("CASH.txt",true);
                bf= new BufferedWriter(fw);
                bf.newLine();
                bf.write("NGon");
                bf.newLine();
                bf.write(spinnerCount.getText());
                bf.newLine();
                bf.write(tf1.getText()+","+tf2.getText()+","+tf3.getText()+","+ tf4.getText()+","+ tf5.getText()+","+ tf6.getText()+","+ tf7.getText()+","+ tf8.getText());
                bf.close();
                addPolyline(gc);
            }
            if(spinnerCount.getText().equals("3")) {
                FileWriter fw=new FileWriter("CASH.txt",true);
                bf= new BufferedWriter(fw);
                bf.newLine();
                bf.write("NGon");
                bf.newLine();
                bf.write(spinnerCount.getText());
                bf.newLine();
                bf.write(tf1.getText()+","+tf2.getText()+","+tf3.getText()+","+ tf4.getText()+","+ tf5.getText()+","+ tf6.getText());
                bf.close();
                addPolyline(gc);
            }

        }
        if(type.getText().equals("QGon"))
        {
            FileWriter fw=new FileWriter("CASH.txt",true);
            bf= new BufferedWriter(fw);
            bf.newLine();
            bf.write("QGon");
            bf.newLine();
            bf.write(tf1.getText()+","+tf2.getText()+","+tf3.getText()+","+ tf4.getText()+","+ tf5.getText()+","+ tf6.getText()+","+ tf7.getText()+","+ tf8.getText());
            bf.close();
            addQGon(gc);
        }
        if(type.getText().equals("Rectangle"))
        {
            FileWriter fw=new FileWriter("CASH.txt",true);
            bf= new BufferedWriter(fw);
            bf.newLine();
            bf.write("Rectangle");
            bf.newLine();
            bf.write(tf1.getText()+","+tf2.getText()+","+tf3.getText()+","+ tf4.getText()+","+ tf5.getText()+","+ tf6.getText()+","+ tf7.getText()+","+ tf8.getText());
            bf.close();
            addRectangle(gc);
        }
        if(type.getText().equals("Trapeze"))
        {
            FileWriter fw=new FileWriter("CASH.txt",true);
            bf= new BufferedWriter(fw);
            bf.newLine();
            bf.write("Trapeze");
            bf.newLine();
            bf.write(tf1.getText()+","+tf2.getText()+","+tf3.getText()+","+ tf4.getText()+","+ tf5.getText()+","+ tf6.getText()+","+ tf7.getText()+","+ tf8.getText());
            bf.close();
            addTrapeze(gc);
        }
        if(type.getText().equals("TGon"))
        {
            FileWriter fw=new FileWriter("CASH.txt",true);
            bf= new BufferedWriter(fw);
            bf.newLine();
            bf.write("TGon");
            bf.newLine();
            bf.write(tf1.getText()+","+tf2.getText()+","+tf3.getText()+","+ tf4.getText()+","+ tf5.getText()+","+ tf6.getText());
            bf.close();
            addTGon(gc);
        }
    }
    private void addCircle(GraphicsContext gc)
    {
        double x1= Double.parseDouble(tf1.getText())-Double.parseDouble(tf3.getText())/2+250;
        double y1=- Double.parseDouble(tf2.getText())-Double.parseDouble(tf3.getText())/2+250;
        double r= Double.parseDouble(tf3.getText());
        gc.strokeOval(x1,y1,r,r);

    }
    private void addSegment(GraphicsContext gc)
    {
        double x1= Double.parseDouble(tf1.getText())+250;
        double y1= -Double.parseDouble(tf2.getText())+250;
        double x2= Double.parseDouble(tf3.getText())+250;
        double y2= -Double.parseDouble(tf4.getText())+250;
        gc.strokeLine(x1,y1,x2,y2);

    }
    private void addPolyline(GraphicsContext gc)
    {
        if(spinnerCount.getText().equals("6")) {
            double x1 = Double.parseDouble(tf1.getText()) + 250;
            double y1 = -Double.parseDouble(tf2.getText()) + 250;
            double x2 = Double.parseDouble(tf3.getText()) + 250;
            double y2 = -Double.parseDouble(tf4.getText()) + 250;
            gc.strokeLine(x1, y1, x2, y2);
            double x3 = Double.parseDouble(tf5.getText()) + 250;
            double y3 = -Double.parseDouble(tf6.getText()) + 250;
            gc.strokeLine(x2, y2, x3, y3);
            double x4 = Double.parseDouble(tf7.getText()) + 250;
            double y4 = -Double.parseDouble(tf8.getText()) + 250;
            gc.strokeLine(x3, y3, x4, y4);
            double x5 = Double.parseDouble(tf9.getText()) + 250;
            double y5 = -Double.parseDouble(tf10.getText()) + 250;
            gc.strokeLine(x4, y4, x5, y5);
            double x6 = Double.parseDouble(tf11.getText()) + 250;
            double y6 = -Double.parseDouble(tf12.getText()) + 250;
            gc.strokeLine(x5, y5, x6, y6);
        }
        if(spinnerCount.getText().equals("5")) {
            double x1 = Double.parseDouble(tf1.getText()) + 250;
            double y1 = -Double.parseDouble(tf2.getText()) + 250;
            double x2 = Double.parseDouble(tf3.getText()) + 250;
            double y2 = -Double.parseDouble(tf4.getText()) + 250;
            gc.strokeLine(x1, y1, x2, y2);
            double x3 = Double.parseDouble(tf5.getText()) + 250;
            double y3 = -Double.parseDouble(tf6.getText()) + 250;
            gc.strokeLine(x2, y2, x3, y3);
            double x4 = Double.parseDouble(tf7.getText()) + 250;
            double y4 = -Double.parseDouble(tf8.getText()) + 250;
            gc.strokeLine(x3, y3, x4, y4);
            double x5 = Double.parseDouble(tf9.getText()) + 250;
            double y5 = -Double.parseDouble(tf10.getText()) + 250;
            gc.strokeLine(x4, y4, x5, y5);
        }
        if(spinnerCount.getText().equals("4")) {
            double x1 = Double.parseDouble(tf1.getText()) + 250;
            double y1 = -Double.parseDouble(tf2.getText()) + 250;
            double x2 = Double.parseDouble(tf3.getText()) + 250;
            double y2 = -Double.parseDouble(tf4.getText()) + 250;
            gc.strokeLine(x1, y1, x2, y2);
            double x3 = Double.parseDouble(tf5.getText()) + 250;
            double y3 = -Double.parseDouble(tf6.getText()) + 250;
            gc.strokeLine(x2, y2, x3, y3);
            double x4 = Double.parseDouble(tf7.getText()) + 250;
            double y4 = -Double.parseDouble(tf8.getText()) + 250;
            gc.strokeLine(x3, y3, x4, y4);
        }
        if(spinnerCount.getText().equals("3")) {
            double x1 = Double.parseDouble(tf1.getText()) + 250;
            double y1 = -Double.parseDouble(tf2.getText()) + 250;
            double x2 = Double.parseDouble(tf3.getText()) + 250;
            double y2 = -Double.parseDouble(tf4.getText()) + 250;
            gc.strokeLine(x1, y1, x2, y2);
            double x3 = Double.parseDouble(tf5.getText()) + 250;
            double y3 = -Double.parseDouble(tf6.getText()) + 250;
            gc.strokeLine(x2, y2, x3, y3);
        }
    }
    private void addNGon(GraphicsContext gc)
    {
        if(spinnerCount.getText().equals("6")) {
            double x1 = Double.parseDouble(tf1.getText()) + 250;
            double y1 = -Double.parseDouble(tf2.getText()) + 250;
            double x2 = Double.parseDouble(tf3.getText()) + 250;
            double y2 = -Double.parseDouble(tf4.getText()) + 250;
            gc.strokeLine(x1, y1, x2, y2);
            double x3 = Double.parseDouble(tf5.getText()) + 250;
            double y3 = -Double.parseDouble(tf6.getText()) + 250;
            gc.strokeLine(x2, y2, x3, y3);
            double x4 = Double.parseDouble(tf7.getText()) + 250;
            double y4 = -Double.parseDouble(tf8.getText()) + 250;
            gc.strokeLine(x3, y3, x4, y4);
            double x5 = Double.parseDouble(tf9.getText()) + 250;
            double y5 = -Double.parseDouble(tf10.getText()) + 250;
            gc.strokeLine(x4, y4, x5, y5);
            double x6 = Double.parseDouble(tf11.getText()) + 250;
            double y6 = -Double.parseDouble(tf12.getText()) + 250;
            gc.strokeLine(x5, y5, x6, y6);
            gc.strokeLine(x1, y1, x6, y6);
        }
        if(spinnerCount.getText().equals("5")) {
            double x1 = Double.parseDouble(tf1.getText()) + 250;
            double y1 = -Double.parseDouble(tf2.getText()) + 250;
            double x2 = Double.parseDouble(tf3.getText()) + 250;
            double y2 = -Double.parseDouble(tf4.getText()) + 250;
            gc.strokeLine(x1, y1, x2, y2);
            double x3 = Double.parseDouble(tf5.getText()) + 250;
            double y3 = -Double.parseDouble(tf6.getText()) + 250;
            gc.strokeLine(x2, y2, x3, y3);
            double x4 = Double.parseDouble(tf7.getText()) + 250;
            double y4 = -Double.parseDouble(tf8.getText()) + 250;
            gc.strokeLine(x3, y3, x4, y4);
            double x5 = Double.parseDouble(tf9.getText()) + 250;
            double y5 = -Double.parseDouble(tf10.getText()) + 250;
            gc.strokeLine(x4, y4, x5, y5);
            gc.strokeLine(x1, y1, x5, y5);
        }
        if(spinnerCount.getText().equals("4")) {
            double x1 = Double.parseDouble(tf1.getText()) + 250;
            double y1 = -Double.parseDouble(tf2.getText()) + 250;
            double x2 = Double.parseDouble(tf3.getText()) + 250;
            double y2 = -Double.parseDouble(tf4.getText()) + 250;
            gc.strokeLine(x1, y1, x2, y2);
            double x3 = Double.parseDouble(tf5.getText()) + 250;
            double y3 = -Double.parseDouble(tf6.getText()) + 250;
            gc.strokeLine(x2, y2, x3, y3);
            double x4 = Double.parseDouble(tf7.getText()) + 250;
            double y4 = -Double.parseDouble(tf8.getText()) + 250;
            gc.strokeLine(x3, y3, x4, y4);
            gc.strokeLine(x1, y1, x4, y4);
        }
        if(spinnerCount.getText().equals("3")) {
            double x1 = Double.parseDouble(tf1.getText()) + 250;
            double y1 = -Double.parseDouble(tf2.getText()) + 250;
            double x2 = Double.parseDouble(tf3.getText()) + 250;
            double y2 = -Double.parseDouble(tf4.getText()) + 250;
            gc.strokeLine(x1, y1, x2, y2);
            double x3 = Double.parseDouble(tf5.getText()) + 250;
            double y3 = -Double.parseDouble(tf6.getText()) + 250;
            gc.strokeLine(x2, y2, x3, y3);
            gc.strokeLine(x1, y1, x3, y3);
        }
    }
    private void addQGon(GraphicsContext gc)
    {
        double x1 =  Double.parseDouble(tf1.getText()) + 250;
        double y1 = - Double.parseDouble(tf2.getText()) + 250;
        double x2 =  Double.parseDouble(tf3.getText()) + 250;
        double y2 = - Double.parseDouble(tf4.getText()) + 250;
            gc.strokeLine(x1, y1, x2, y2);
        double x3 =  Double.parseDouble(tf5.getText()) + 250;
        double y3 = - Double.parseDouble(tf6.getText()) + 250;
            gc.strokeLine(x2, y2, x3, y3);
        double x4 =  Double.parseDouble(tf7.getText()) + 250;
            double y4 = - Double.parseDouble(tf8.getText()) + 250;
            gc.strokeLine(x3, y3, x4, y4);
            gc.strokeLine(x1, y1, x4, y4);
    }
    private void addRectangle(GraphicsContext gc)
    {
        double x1 = Double.parseDouble(tf1.getText()) + 250;
        double y1 = -Double.parseDouble(tf2.getText()) + 250;
        double x2 = Double.parseDouble(tf3.getText()) + 250;
        double y2 = -Double.parseDouble(tf4.getText()) + 250;
        gc.strokeLine(x1, y1, x2, y2);
        double x3 = Double.parseDouble(tf5.getText()) + 250;
        double y3 = -Double.parseDouble(tf6.getText()) + 250;
        gc.strokeLine(x2, y2, x3, y3);
        double x4 = Double.parseDouble(tf7.getText()) + 250;
        double y4 = -Double.parseDouble(tf8.getText()) + 250;
        gc.strokeLine(x3, y3, x4, y4);
        gc.strokeLine(x1, y1, x4, y4);
    }
    private void addTrapeze(GraphicsContext gc)
    {
        double x1 = Double.parseDouble(tf1.getText()) + 250;
        double y1 = -Double.parseDouble(tf2.getText()) + 250;
        double x2 = Double.parseDouble(tf3.getText()) + 250;
        double y2 = -Double.parseDouble(tf4.getText()) + 250;
        gc.strokeLine(x1, y1, x2, y2);
        double x3 = Double.parseDouble(tf5.getText()) + 250;
        double y3 = -Double.parseDouble(tf6.getText()) + 250;
        gc.strokeLine(x2, y2, x3, y3);
        double x4 = Double.parseDouble(tf7.getText()) + 250;
        double y4 = -Double.parseDouble(tf8.getText()) + 250;
        gc.strokeLine(x3, y3, x4, y4);
        gc.strokeLine(x1, y1, x4, y4);
    }
    private void addTGon(GraphicsContext gc)
    {
        double x1 = Double.parseDouble(tf1.getText()) + 250;
        double y1 = -Double.parseDouble(tf2.getText()) + 250;
        double x2 = Double.parseDouble(tf3.getText()) + 250;
        double y2 = -Double.parseDouble(tf4.getText()) + 250;
        gc.strokeLine(x1, y1, x2, y2);
        double x3 = Double.parseDouble(tf5.getText()) + 250;
        double y3 = -Double.parseDouble(tf6.getText()) + 250;
        gc.strokeLine(x2, y2, x3, y3);
        gc.strokeLine(x1, y1, x3, y3);
    }
    public void showInformation(String typep,int spinnerCountP,String v1 ,String v2,String v3,String v4,String v5,String v6,String v7,String v8,String v9,String v10,String v11,String v12) throws IOException
    {
        type.setText(typep);
        spinnerCount.setText(String.valueOf(spinnerCountP));
        tf1.setText(v1);
        tf2.setText(v2);
        tf3.setText(v3);
        tf4.setText(v4);
        tf5.setText(v5);
        tf6.setText(v6);
        tf7.setText(v7);
        tf8.setText(v8);
        tf9.setText(v9);
        tf10.setText(v10);
        tf11.setText(v11);
        tf12.setText(v12);
    }
    public void closeForm() {
            Stage stage = (Stage) btnOK.getScene().getWindow();
            stage.close();
    }
    public void square()throws IOException
    {
        try {
            BufferedReader bfr=new BufferedReader(new FileReader("C:\\Users\\79021\\IdeaProjects\\termwork2.0\\CASHVALUE.txt"));
            int n=Integer.parseInt(bfr.readLine());
            bfr.close();
            BufferedReader bfr1=new BufferedReader(new FileReader("C:\\Users\\79021\\IdeaProjects\\termwork2.0\\CASH.txt"));

            //цикл чтения фигур из кэша при запуске приложения(обновления)
            bfr1.readLine();//пропустил первую пустую строку в файле
            String line=null;
            double squ=0;
            while((line=bfr1.readLine())!=null) {
                if (line.equals("Circle")) {
                    type.setText("Circle");
                    String current = bfr1.readLine();
                    String value = "";
                    int K = 1;
                    char[] cur = current.toCharArray();
                    for (int j = 0; j < cur.length; j++) {
                        if (cur[j] != ',')
                            value += cur[j];
                        else {
                            if (K == 1) {
                                K++;
                                value = "";
                            }
                            else
                            if (K == 2) {
                                K++;
                                value = "";
                            }
                        }

                    }

                        Point2D p = new Point2D();
                        Circle c = new Circle(p, Double.parseDouble(value));
                        squ+=c.square();
                }
                else
                if (line.equals("QGon")) {
                    type.setText("QGon");
                    String current = bfr1.readLine();
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
                                double m[]={Double.parseDouble(value)};
                                p1.setX(m,0);
                                value = "";
                            }
                            else
                            if (K == 2) {
                                K++;
                                double m[]={0,Double.parseDouble(value)};
                                p1.setX(m,1);
                                value = "";
                            }
                            else
                            if (K == 3) {
                                K++;
                                double m[]={Double.parseDouble(value)};
                                p2.setX(m,0);
                                value = "";
                            }
                            else
                            if (K == 4) {
                                K++;
                                double m[]={0,Double.parseDouble(value)};
                                p2.setX(m,1);
                                value = "";
                            }
                            else
                            if (K == 5) {
                                K++;
                                double m[]={Double.parseDouble(value)};
                                p3.setX(m,0);
                                value = "";
                            }
                            else
                            if (K == 6) {
                                K++;
                                double m[]={0,Double.parseDouble(value)};
                                p3.setX(m,1);
                                value = "";
                            }
                            else
                            if (K == 7) {
                                K++;
                                double m[]={Double.parseDouble(value)};
                                p4.setX(m,0);
                                value = "";
                            }
                        }

                    }
                    double m[]={0,Double.parseDouble(value)};
                    p4.setX(m,1);
                    System.out.println(value);
                    Point2D [] p = {p1,p2,p3,p4};
                    QGon c = new QGon(p);
                    squ+=c.square();

                }
                else
                if (line.equals("Rectangle")) {
                    type.setText("Rectangle");
                    String current = bfr1.readLine();
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
                                double m[]={Double.parseDouble(value)};
                                p1.setX(m,0);
                                value = "";
                            }
                            else
                            if (K == 2) {
                                K++;
                                double m[]={0,Double.parseDouble(value)};
                                p1.setX(m,1);
                                value = "";
                            }
                            else
                            if (K == 3) {
                                K++;
                                double m[]={Double.parseDouble(value)};
                                p2.setX(m,0);
                                value = "";
                            }
                            else
                            if (K == 4) {
                                K++;
                                double m[]={0,Double.parseDouble(value)};
                                p2.setX(m,1);
                                value = "";
                            }
                            else
                            if (K == 5) {
                                K++;
                                double m[]={Double.parseDouble(value)};
                                p3.setX(m,0);
                                value = "";
                            }
                            else
                            if (K == 6) {
                                K++;
                                double m[]={0,Double.parseDouble(value)};
                                p3.setX(m,1);
                                value = "";
                            }
                            else
                            if (K == 7) {
                                K++;
                                double m[]={Double.parseDouble(value)};
                                p4.setX(m,0);
                                value = "";
                            }
                        }

                    }
                    double m[]={0,Double.parseDouble(value)};
                    p4.setX(m,1);
                    System.out.println(value);
                    Point2D [] p = {p1,p2,p3,p4};
                    Rectangle c = new Rectangle(p);
                    squ+=c.square();
                }
                else
                if (line.equals("Trapeze")) {
                    type.setText("Trapeze");
                    String current = bfr1.readLine();
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
                                double m[]={Double.parseDouble(value)};
                                p1.setX(m,0);
                                value = "";
                            }
                            else
                            if (K == 2) {
                                K++;
                                double m[]={0,Double.parseDouble(value)};
                                p1.setX(m,1);
                                value = "";
                            }
                            else
                            if (K == 3) {
                                K++;
                                double m[]={Double.parseDouble(value)};
                                p2.setX(m,0);
                                value = "";
                            }
                            else
                            if (K == 4) {
                                K++;
                                double m[]={0,Double.parseDouble(value)};
                                p2.setX(m,1);
                                value = "";
                            }
                            else
                            if (K == 5) {
                                K++;
                                double m[]={Double.parseDouble(value)};
                                p3.setX(m,0);
                                value = "";
                            }
                            else
                            if (K == 6) {
                                K++;
                                double m[]={0,Double.parseDouble(value)};
                                p3.setX(m,1);
                                value = "";
                            }
                            else
                            if (K == 7) {
                                K++;
                                double m[]={Double.parseDouble(value)};
                                p4.setX(m,0);
                                value = "";
                            }
                        }

                    }
                    double m[]={0,Double.parseDouble(value)};
                    p4.setX(m,1);
                    System.out.println(value);
                    Point2D [] p = {p1,p2,p3,p4};
                    Trapeze c = new Trapeze(p);
                    squ+=c.square();
                }
                else
                if (line.equals("TGon")) {
                    type.setText("TGon");
                    String current = bfr1.readLine();
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
                                double m[]={Double.parseDouble(value)};
                                p1.setX(m,0);
                                value = "";
                            }
                            else
                            if (K == 2) {
                                K++;
                                double m[]={0,Double.parseDouble(value)};
                                p1.setX(m,1);
                                value = "";
                            }
                            else
                            if (K == 3) {
                                K++;
                                double m[]={Double.parseDouble(value)};
                                p2.setX(m,0);
                                value = "";
                            }
                            else
                            if (K == 4) {
                                K++;
                                double m[]={0,Double.parseDouble(value)};
                                p2.setX(m,1);
                                value = "";
                            }
                            else
                            if (K == 5) {
                                K++;
                                double m[]={Double.parseDouble(value)};
                                p3.setX(m,0);
                                value = "";
                            }

                        }

                    }
                    double m[]={0,Double.parseDouble(value)};
                    p3.setX(m,1);
                    System.out.println(value);
                    Point2D [] p = {p1,p2,p3};
                    TGon c = new TGon(p);
                    squ+=c.square();
                }
                else
                if (line.equals("NGon")) {
                    type.setText("NGon");
                    type.setText("Polyline");
                    //i++;
                    String spin=bfr1.readLine();
                    if(spin.equals("3")) {
                        spinnerCount.setText("3");
                        String current = bfr1.readLine();
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
                                    double m[]={Double.parseDouble(value)};
                                    p1.setX(m,0);
                                    value = "";
                                }
                                else
                                if (K == 2) {
                                    K++;
                                    double m[]={0,Double.parseDouble(value)};
                                    p1.setX(m,1);
                                    value = "";
                                }
                                else
                                if (K == 3) {
                                    K++;
                                    double m[]={Double.parseDouble(value)};
                                    p2.setX(m,0);
                                    value = "";
                                }
                                else
                                if (K == 4) {
                                    K++;
                                    double m[]={0,Double.parseDouble(value)};
                                    p2.setX(m,1);
                                    value = "";
                                }
                                else
                                if (K == 5) {
                                    K++;
                                    double m[]={Double.parseDouble(value)};
                                    p3.setX(m,0);
                                    value = "";
                                }

                            }

                        }
                        double m[]={0,Double.parseDouble(value)};
                        p3.setX(m,1);
                        System.out.println(value);
                        Point2D [] p = {p1,p2,p3};
                        NGon c = new NGon(p);
                        squ+=c.square();
                    }
                    if(spin.equals("4")) {
                        spinnerCount.setText("4");
                        String current = bfr1.readLine();
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
                                    double m[]={Double.parseDouble(value)};
                                    p1.setX(m,0);
                                    value = "";
                                }
                                else
                                if (K == 2) {
                                    K++;
                                    double m[]={0,Double.parseDouble(value)};
                                    p1.setX(m,1);
                                    value = "";
                                }
                                else
                                if (K == 3) {
                                    K++;
                                    double m[]={Double.parseDouble(value)};
                                    p2.setX(m,0);
                                    value = "";
                                }
                                else
                                if (K == 4) {
                                    K++;
                                    double m[]={0,Double.parseDouble(value)};
                                    p2.setX(m,1);
                                    value = "";
                                }
                                else
                                if (K == 5) {
                                    K++;
                                    double m[]={Double.parseDouble(value)};
                                    p3.setX(m,0);
                                    value = "";
                                }
                                else
                                if (K == 6) {
                                    K++;
                                    double m[]={0,Double.parseDouble(value)};
                                    p3.setX(m,1);
                                    value = "";
                                }
                                else
                                if (K == 7) {
                                    K++;
                                    double m[]={Double.parseDouble(value)};
                                    p4.setX(m,0);
                                    value = "";
                                }

                            }

                        }
                        double m[]={0,Double.parseDouble(value)};
                        p4.setX(m,1);
                        System.out.println(value);
                        Point2D [] p = {p1,p2,p3,p4};
                        NGon c = new NGon(p);
                        squ+=c.square();
                    }
                    if(spin.equals("5")) {
                        spinnerCount.setText("5");
                        String current = bfr1.readLine();
                        String value = "";
                        int K = 1;
                        Point2D p1 = new Point2D();
                        Point2D p2 = new Point2D();
                        Point2D p3 = new Point2D();
                        Point2D p4 = new Point2D();
                        Point2D p5 = new Point2D();
                        char[] cur = current.toCharArray();
                        for (int j = 0; j < cur.length; j++) {
                            if (cur[j] != ',')
                                value += cur[j];
                            else {
                                if (K == 1) {
                                    K++;
                                    double m[]={Double.parseDouble(value)};
                                    p1.setX(m,0);
                                    value = "";
                                }
                                else
                                if (K == 2) {
                                    K++;
                                    double m[]={0,Double.parseDouble(value)};
                                    p1.setX(m,1);
                                    value = "";
                                }
                                else
                                if (K == 3) {
                                    K++;
                                    double m[]={Double.parseDouble(value)};
                                    p2.setX(m,0);
                                    value = "";
                                }
                                else
                                if (K == 4) {
                                    K++;
                                    double m[]={0,Double.parseDouble(value)};
                                    p2.setX(m,1);
                                    value = "";
                                }
                                else
                                if (K == 5) {
                                    K++;
                                    double m[]={Double.parseDouble(value)};
                                    p3.setX(m,0);
                                    value = "";
                                }
                                else
                                if (K == 6) {
                                    K++;
                                    double m[]={0,Double.parseDouble(value)};
                                    p3.setX(m,1);
                                    value = "";
                                }
                                else
                                if (K == 7) {
                                    K++;
                                    double m[]={Double.parseDouble(value)};
                                    p4.setX(m,0);
                                    value = "";
                                }
                                else
                                if (K == 8) {
                                    K++;
                                    double m[]={0,Double.parseDouble(value)};
                                    p4.setX(m,1);
                                    value = "";
                                }
                                else
                                if (K == 9) {
                                    K++;
                                    double m[]={Double.parseDouble(value)};
                                    p5.setX(m,0);
                                    value = "";
                                }

                            }

                        }
                        double m[]={0,Double.parseDouble(value)};
                        p5.setX(m,1);
                        System.out.println(value);
                        Point2D [] p = {p1,p2,p3,p4,p5};
                        NGon c = new NGon(p);
                        squ+=c.square();
                    }
                    if(spin.equals("6")) {
                        spinnerCount.setText("6");
                        String current = bfr1.readLine();
                        String value = "";
                        int K = 1;
                        Point2D p1 = new Point2D();
                        Point2D p2 = new Point2D();
                        Point2D p3 = new Point2D();
                        Point2D p4 = new Point2D();
                        Point2D p5 = new Point2D();
                        Point2D p6 = new Point2D();
                        char[] cur = current.toCharArray();
                        for (int j = 0; j < cur.length; j++) {
                            if (cur[j] != ',')
                                value += cur[j];
                            else {
                                if (K == 1) {
                                    K++;
                                    double m[]={Double.parseDouble(value)};
                                    p1.setX(m,0);
                                    value = "";
                                }
                                else
                                if (K == 2) {
                                    K++;
                                    double m[]={0,Double.parseDouble(value)};
                                    p1.setX(m,1);
                                    value = "";
                                }
                                else
                                if (K == 3) {
                                    K++;
                                    double m[]={Double.parseDouble(value)};
                                    p2.setX(m,0);
                                    value = "";
                                }
                                else
                                if (K == 4) {
                                    K++;
                                    double m[]={0,Double.parseDouble(value)};
                                    p2.setX(m,1);
                                    value = "";
                                }
                                else
                                if (K == 5) {
                                    K++;
                                    double m[]={Double.parseDouble(value)};
                                    p3.setX(m,0);
                                    value = "";
                                }
                                else
                                if (K == 6) {
                                    K++;
                                    double m[]={0,Double.parseDouble(value)};
                                    p3.setX(m,1);
                                    value = "";
                                }
                                else
                                if (K == 7) {
                                    K++;
                                    double m[]={Double.parseDouble(value)};
                                    p4.setX(m,0);
                                    value = "";
                                }
                                else
                                if (K == 8) {
                                    K++;
                                    double m[]={0,Double.parseDouble(value)};
                                    p4.setX(m,1);
                                    value = "";
                                }
                                else
                                if (K == 9) {
                                    K++;
                                    double m[]={Double.parseDouble(value)};
                                    p5.setX(m,0);
                                    value = "";
                                }
                                else
                                if (K == 10) {
                                    K++;
                                    double m[]={0,Double.parseDouble(value)};
                                    p5.setX(m,1);
                                    value = "";
                                }
                                else
                                if (K == 11) {
                                    K++;
                                    double m[]={Double.parseDouble(value)};
                                    p6.setX(m,0);
                                    value = "";
                                }

                            }

                    }
                        double m[]={0,Double.parseDouble(value)};
                        p6.setX(m,1);
                        System.out.println(value);
                        Point2D [] p = {p1,p2,p3,p4,p5,p6};
                        NGon c = new NGon(p);
                        squ+=c.square();
                    }


                }
            }
            square.setText(String.valueOf(squ));
            //
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
  public void lenght()throws IOException
    {
        try {
            BufferedReader bfr=new BufferedReader(new FileReader("C:\\Users\\79021\\IdeaProjects\\termwork2.0\\CASHVALUE.txt"));
            int n=Integer.parseInt(bfr.readLine());
            bfr.close();
            BufferedReader bfr1=new BufferedReader(new FileReader("C:\\Users\\79021\\IdeaProjects\\termwork2.0\\CASH.txt"));


            bfr1.readLine();
            String line=null;
            double squ=0;
            while((line=bfr1.readLine())!=null) {
                if (line.equals("Circle")) {
                    type.setText("Circle");
                    String current = bfr1.readLine();
                    String value = "";
                    int K = 1;
                    char[] cur = current.toCharArray();
                    for (int j = 0; j < cur.length; j++) {
                        if (cur[j] != ',')
                            value += cur[j];
                        else {
                            if (K == 1) {
                                K++;
                                value = "";
                            } else if (K == 2) {
                                K++;
                                value = "";
                            }
                        }

                    }

                    Point2D p = new Point2D();
                    Circle c = new Circle(p, Double.parseDouble(value));
                    squ += c.length();
                }
                else if (line.equals("QGon")) {
                    type.setText("QGon");
                    String current = bfr1.readLine();
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
                    System.out.println(value);
                    Point2D[] p = {p1, p2, p3, p4};
                    QGon c = new QGon(p);
                    squ += c.length();

                }
                else if (line.equals("Rectangle")) {
                    type.setText("Rectangle");
                    String current = bfr1.readLine();
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
                    System.out.println(value);
                    Point2D[] p = {p1, p2, p3, p4};
                    Rectangle c = new Rectangle(p);
                    squ += c.length();
                }
                else if (line.equals("Trapeze")) {
                    type.setText("Trapeze");
                    String current = bfr1.readLine();
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
                    System.out.println(value);
                    Point2D[] p = {p1, p2, p3, p4};
                    Trapeze c = new Trapeze(p);
                    squ += c.length();
                }
                else if (line.equals("TGon")) {
                    type.setText("TGon");
                    String current = bfr1.readLine();
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
                    System.out.println(value);
                    Point2D[] p = {p1, p2, p3};
                    TGon c = new TGon(p);
                    squ += c.length();
                }
                else if (line.equals("Polyline")) {
                    type.setText("Polyline");
                    //i++;
                    String spin = bfr1.readLine();
                    if (spin.equals("3")) {
                        spinnerCount.setText("3");
                        String current = bfr1.readLine();
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
                        System.out.println(value);
                        Point2D[] p = {p1, p2, p3};
                        Polyline c = new Polyline(p);
                        squ += c.length();
                    }
                    if (spin.equals("4")) {
                        spinnerCount.setText("4");
                        String current = bfr1.readLine();
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
                        System.out.println(value);
                        Point2D[] p = {p1, p2, p3, p4};
                        Polyline c = new Polyline(p);
                        squ += c.length();
                    }
                    if (spin.equals("5")) {
                        spinnerCount.setText("5");
                        String current = bfr1.readLine();
                        String value = "";
                        int K = 1;
                        Point2D p1 = new Point2D();
                        Point2D p2 = new Point2D();
                        Point2D p3 = new Point2D();
                        Point2D p4 = new Point2D();
                        Point2D p5 = new Point2D();
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
                                } else if (K == 8) {
                                    K++;
                                    double m[] = {0, Double.parseDouble(value)};
                                    p4.setX(m, 1);
                                    value = "";
                                } else if (K == 9) {
                                    K++;
                                    double m[] = {Double.parseDouble(value)};
                                    p5.setX(m, 0);
                                    value = "";
                                }

                            }

                        }
                        double m[] = {0, Double.parseDouble(value)};
                        p5.setX(m, 1);
                        System.out.println(value);
                        Point2D[] p = {p1, p2, p3, p4, p5};
                        Polyline c = new Polyline(p);
                        squ += c.length();
                    }
                    if (spin.equals("6")) {
                        spinnerCount.setText("6");
                        String current = bfr1.readLine();
                        String value = "";
                        int K = 1;
                        Point2D p1 = new Point2D();
                        Point2D p2 = new Point2D();
                        Point2D p3 = new Point2D();
                        Point2D p4 = new Point2D();
                        Point2D p5 = new Point2D();
                        Point2D p6 = new Point2D();
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
                                } else if (K == 8) {
                                    K++;
                                    double m[] = {0, Double.parseDouble(value)};
                                    p4.setX(m, 1);
                                    value = "";
                                } else if (K == 9) {
                                    K++;
                                    double m[] = {Double.parseDouble(value)};
                                    p5.setX(m, 0);
                                    value = "";
                                } else if (K == 10) {
                                    K++;
                                    double m[] = {0, Double.parseDouble(value)};
                                    p5.setX(m, 1);
                                    value = "";
                                } else if (K == 11) {
                                    K++;
                                    double m[] = {Double.parseDouble(value)};
                                    p6.setX(m, 0);
                                    value = "";
                                }

                            }

                        }
                        double m[] = {0, Double.parseDouble(value)};
                        p6.setX(m, 1);
                        System.out.println(value);
                        Point2D[] p = {p1, p2, p3, p4, p5, p6};
                        Polyline c = new Polyline(p);
                        squ += c.length();
                    }
                }
                else if (line.equals("NGon")) {
                    type.setText("NGon");
                    type.setText("Polyline");
                    //i++;
                    String spin = bfr1.readLine();
                    if (spin.equals("3")) {
                        spinnerCount.setText("3");
                        String current = bfr1.readLine();
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
                        System.out.println(value);
                        Point2D[] p = {p1, p2, p3};
                        NGon c = new NGon(p);
                        squ += c.length();
                    }
                    if (spin.equals("4")) {
                        spinnerCount.setText("4");
                        String current = bfr1.readLine();
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
                        System.out.println(value);
                        Point2D[] p = {p1, p2, p3, p4};
                        NGon c = new NGon(p);
                        squ += c.length();
                    }
                    if (spin.equals("5")) {
                        spinnerCount.setText("5");
                        String current = bfr1.readLine();
                        String value = "";
                        int K = 1;
                        Point2D p1 = new Point2D();
                        Point2D p2 = new Point2D();
                        Point2D p3 = new Point2D();
                        Point2D p4 = new Point2D();
                        Point2D p5 = new Point2D();
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
                                } else if (K == 8) {
                                    K++;
                                    double m[] = {0, Double.parseDouble(value)};
                                    p4.setX(m, 1);
                                    value = "";
                                } else if (K == 9) {
                                    K++;
                                    double m[] = {Double.parseDouble(value)};
                                    p5.setX(m, 0);
                                    value = "";
                                }

                            }

                        }
                        double m[] = {0, Double.parseDouble(value)};
                        p5.setX(m, 1);
                        System.out.println(value);
                        Point2D[] p = {p1, p2, p3, p4, p5};
                        NGon c = new NGon(p);
                        squ += c.length();
                    }
                    if (spin.equals("6")) {
                        spinnerCount.setText("6");
                        String current = bfr1.readLine();
                        String value = "";
                        int K = 1;
                        Point2D p1 = new Point2D();
                        Point2D p2 = new Point2D();
                        Point2D p3 = new Point2D();
                        Point2D p4 = new Point2D();
                        Point2D p5 = new Point2D();
                        Point2D p6 = new Point2D();
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
                                } else if (K == 8) {
                                    K++;
                                    double m[] = {0, Double.parseDouble(value)};
                                    p4.setX(m, 1);
                                    value = "";
                                } else if (K == 9) {
                                    K++;
                                    double m[] = {Double.parseDouble(value)};
                                    p5.setX(m, 0);
                                    value = "";
                                } else if (K == 10) {
                                    K++;
                                    double m[] = {0, Double.parseDouble(value)};
                                    p5.setX(m, 1);
                                    value = "";
                                } else if (K == 11) {
                                    K++;
                                    double m[] = {Double.parseDouble(value)};
                                    p6.setX(m, 0);
                                    value = "";
                                }

                            }

                        }
                        double m[] = {0, Double.parseDouble(value)};
                        p6.setX(m, 1);
                        System.out.println(value);
                        Point2D[] p = {p1, p2, p3, p4, p5, p6};
                        NGon c = new NGon(p);
                        squ += c.length();
                    }


                }
                else if (line.equals("Segment")) {
                    type.setText("Segment");
                    String current = bfr1.readLine();
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
                    squ += c.length();
                }
                square.setText(String.valueOf(squ));
                //
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void crossWrite(boolean c)
    {
        if(c==true)
        square.setText("True");
        if(c==false)
            square.setText("False");
    }
}

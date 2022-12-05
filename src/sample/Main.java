package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import project.MyLinkedList;
import project.Node;
import project.Student;

import java.io.*;
import java.util.Scanner;

public class Main extends Application {
    File file;
    //int flag = 0 ;

    @Override
    public void start(Stage stage) throws Exception, FileNotFoundException {

        ///////////////////////////// PAGE NUMBER ONE ///////////////////////////////////

        Group page1 = new Group();
        Scene scene1 = new Scene(page1, 612.5, 800, Color.GRAY.darker());

        //lbl student tawjihi system
        Label lblWelcom = new Label();
        lblWelcom.setText("Student Tawjihi System");
        lblWelcom.setLayoutY(50);
        lblWelcom.setLayoutX(82);
        lblWelcom.setFont(Font.font("Bookman", 40));
        lblWelcom.setTextFill(Color.web("#F2E336"));
        lblWelcom.setStyle("-fx-font-weight: bold");
        lblWelcom.setBackground(new Background((new BackgroundFill(Color.BLACK, new CornerRadii(0), Insets.EMPTY))));
        page1.getChildren().add(lblWelcom);

        //photo of tawjihi
        InputStream stream = new FileInputStream("C:\\Users\\twitter\\IdeaProjects\\testJavaFX\\src\\sample\\unnamed.jpg");
        Image imageTawjihi = new Image(stream);
        ImageView imageViewTawjihi = new ImageView();
        imageViewTawjihi.setImage(imageTawjihi);
        imageViewTawjihi.setX(173);
        imageViewTawjihi.setY(150);
        imageViewTawjihi.setFitWidth(250);
        imageViewTawjihi.setPreserveRatio(true);
        imageViewTawjihi.smoothProperty();
        page1.getChildren().add(imageViewTawjihi);

        //Rectangle1 -Black-
        Rectangle rectangle = new Rectangle();
        rectangle.setX(40);
        rectangle.setY(455);
        rectangle.setWidth(520);
        rectangle.setHeight(200);
        //rectangle.setArcHeight(30);
        page1.getChildren().add(rectangle);

        //label Next and exit
        Label lblNext = new Label();
        lblNext.setText("Go to the next page");
        lblNext.setTextFill(Color.WHITE);
        lblNext.setFont(Font.font("Comic Sans MS", 25));
        lblNext.setBackground(new Background((new BackgroundFill(Color.GRAY, new CornerRadii(0), Insets.EMPTY))));
        Label lblExit = new Label();
        lblExit.setText("Exit the program");
        lblExit.setTextFill(Color.WHITE);
        lblExit.setFont(Font.font("Comic Sans MS", 25));
        lblExit.setBackground(new Background((new BackgroundFill(Color.GRAY, new CornerRadii(0), Insets.EMPTY))));

        //-----Vbox for next and close -label-
        VBox vBoxNextExit = new VBox(lblNext, lblExit);
        vBoxNextExit.setSpacing(50);
        vBoxNextExit.setLayoutX(120);
        vBoxNextExit.setLayoutY(490);
        page1.getChildren().add(vBoxNextExit);

        //Image for next button
        InputStream stream1 = new FileInputStream("C:\\Users\\twitter\\IdeaProjects\\testJavaFX\\src\\sample\\N.png");
        Image imgNext = new Image(stream1);
        ImageView viewNext = new ImageView(imgNext);
        viewNext.setFitHeight(80);
        viewNext.setFitWidth(40);
        viewNext.setPreserveRatio(true);
        //Image for exit button
        InputStream stream2 = new FileInputStream("C:\\Users\\twitter\\IdeaProjects\\testJavaFX\\src\\sample\\Exit.png");
        Image imgExit = new Image(stream2);
        ImageView viewExit = new ImageView(imgExit);
        viewExit.setFitHeight(80);
        viewExit.setFitWidth(40);
        viewExit.setPreserveRatio(true);

        //Button Next and Exit
        Button btnNext = new Button();
        btnNext.setGraphic(viewNext);
        Button btnExit = new Button();
        btnExit.setGraphic(viewExit);
        //Vbox for next and exit -button-
        VBox vBoxbtnNextExit = new VBox(btnNext, btnExit);
        vBoxbtnNextExit.setLayoutX(430);
        vBoxbtnNextExit.setLayoutY(490);
        vBoxbtnNextExit.setSpacing(40);
        page1.getChildren().add(vBoxbtnNextExit);

        //Button Exit set on action
        btnExit.setOnAction(actionEvent -> {
            System.exit(0);
        });

        ///////////////////////////// PAGE NUMBER TWO ///////////////////////////////////

        Stage stage2 = new Stage();
        Group page3 = new Group();
        Scene scene3 = new Scene(page3, 600, 700, Color.GRAY.darker());
        stage2.setScene(scene3);
        stage2.setMaxHeight(850);
        stage2.setMinHeight(850);
        stage2.setMaxWidth(612.5);
        stage2.setMinWidth(612.5);

        //Button Next set on action
        btnNext.setOnAction(actionEvent -> {
            stage2.show();
            stage.close();
        });

        stage.setScene(scene1);
        stage.setTitle("Tawjihi Recorde");
        stage.setMaxHeight(850);
        stage.setMinHeight(850);
        stage.setMinWidth(612.5);
        stage.setMaxWidth(612.5);
        stage.setTitle("Welcome");
        stage.show();

        //Rectangle
        Rectangle rec = new Rectangle();
        rec.setFill(Color.BLACK);
        rec.setHeight(140);
        rec.setWidth(550);
        rec.setY(65);
        rec.setX(30);
        page3.getChildren().add(rec);

        //Label for explain the program
        Label lblExplain = new Label();
        lblExplain.setText("This program reads a file containing  the\n results of  the scientific and literary \n Tawjihi students in the West Bank and Gaza");
        lblExplain.setLayoutX(44);
        lblExplain.setLayoutY(80);
        lblExplain.setTextFill(Color.WHITE);
        lblExplain.setFont(Font.font("Comic Sans MS", 25));
        lblExplain.setBackground(new Background((new BackgroundFill(Color.GRAY, new CornerRadii(0), Insets.EMPTY))));
        page3.getChildren().add(lblExplain);

        //Label -> File selection
        Label lblFileSel = new Label();
        lblFileSel.setText("File Selection");
        lblFileSel.setFont(Font.font("Bookman", 35));
        lblFileSel.setTextFill(Color.YELLOW);
        //lblFileSel.setBackground(new Background((new BackgroundFill(Color.GRAY , new CornerRadii(0) , Insets.EMPTY))));
        lblFileSel.setStyle("-fx-font-weight: bold");
        lblFileSel.setLayoutY(230);
        lblFileSel.setLayoutX(55);
        page3.getChildren().add(lblFileSel);

        //Rectangle
        Rectangle rec1 = new Rectangle();
        rec1.setFill(Color.BLACK);
        rec1.setHeight(140);
        rec1.setWidth(550);
        rec1.setY(300);
        rec1.setX(30);
        page3.getChildren().add(rec1);

        //Label -> file choose between GAZA or WEST BANK
        Label lblFile = new Label();
        lblFile.setText("Choose a file to read results of Twajij \n from ( West Bank file or Gaza file ) .... ");
        lblFile.setFont(Font.font("Comic Sans MS", 25));
        lblFile.setTextFill(Color.WHITE);
        lblFile.setBackground(new Background((new BackgroundFill(Color.GRAY, new CornerRadii(0), Insets.EMPTY))));
        lblFile.setLayoutY(330);
        lblFile.setLayoutX(70);
        page3.getChildren().add(lblFile);

        //Rectangle browse
        Rectangle rec2 = new Rectangle();
        rec2.setFill(Color.BLACK);
        rec2.setHeight(63);
        rec2.setWidth(550);
        rec2.setY(500);
        rec2.setX(30);
        page3.getChildren().add(rec2);

        //Button Browse and the txt field of file
        Button btnBrowse = new Button();
        btnBrowse.setText("Browse");
        btnBrowse.setMaxHeight(30);
        btnBrowse.setMinHeight(30);
        btnBrowse.setMinWidth(80);
        btnBrowse.setMaxWidth(80);
        btnBrowse.setTextFill(Color.YELLOW);
        btnBrowse.setBackground(new Background((new BackgroundFill(Color.GRAY, new CornerRadii(0), Insets.EMPTY))));
        btnBrowse.setFont(Font.font("Copperplate", 17));
        //btnBrowse.setStyle("-fx-font-weight: bold");
        TextField txtBrowse = new TextField();
        txtBrowse.setText("");
        txtBrowse.setPrefColumnCount(33);

        //Hbox for button browse and txt Browse
        HBox hBoxBrowse = new HBox(btnBrowse, txtBrowse);
        hBoxBrowse.setSpacing(20);
        hBoxBrowse.setLayoutX(55);
        hBoxBrowse.setLayoutY(520);
        page3.getChildren().add(hBoxBrowse);

        ToggleGroup tg = new ToggleGroup();


        //Radio button for West Bank
        RadioButton radioButtonWest = new RadioButton();
        radioButtonWest.setMaxWidth(5);
        radioButtonWest.setMinWidth(5);
        radioButtonWest.setMaxHeight(5);
        radioButtonWest.setMinHeight(5);
        radioButtonWest.setToggleGroup(tg);

        //Radio button for Gaza
        RadioButton radioButtonGaza = new RadioButton();
        radioButtonGaza.setMaxWidth(5);
        radioButtonGaza.setMinWidth(5);
        radioButtonGaza.setMaxHeight(5);
        radioButtonGaza.setMinHeight(5);
        radioButtonGaza.setToggleGroup(tg);

        tg.selectToggle(radioButtonWest);

        //Hbox for radio button west bank and gaza
        HBox hBoxRad = new HBox(radioButtonWest, radioButtonGaza);
        hBoxRad.setSpacing(20);
        hBoxRad.setLayoutX(95);
        hBoxRad.setLayoutY(468);
        hBoxRad.setSpacing(300);
        page3.getChildren().add(hBoxRad);

        //lbl for radio button west bank
        Label lblWestBank = new Label();
        lblWestBank.setText("West Bank");
        lblWestBank.setFont(Font.font("Comic Sans MS", 15));
        lblWestBank.setTextFill(Color.BLACK);
        lblWestBank.setBackground(new Background((new BackgroundFill(Color.YELLOW, new CornerRadii(0), Insets.EMPTY))));

        //lbl for radio button Gaza
        Label lblGaza = new Label();
        lblGaza.setText("Gaza");
        lblGaza.setFont(Font.font("Comic Sans MS", 15));
        lblGaza.setTextFill(Color.BLACK);
        lblGaza.setBackground(new Background((new BackgroundFill(Color.YELLOW, new CornerRadii(0), Insets.EMPTY))));

        //Hbox for radio button west bank and gaza
        HBox hBoxlbl = new HBox(lblWestBank, lblGaza);
        hBoxlbl.setSpacing(20);
        hBoxlbl.setLayoutX(120);
        hBoxlbl.setLayoutY(460);
        hBoxlbl.setSpacing(165);
        page3.getChildren().add(hBoxlbl);
/*
        radioButtonWest.setOnAction(actionEvent -> {
            if (radioButtonWest.isSelected()){
                radioButtonGaza.setSelected(false);
            }
        });

        radioButtonGaza.setOnAction(actionEvent -> {
            if (radioButtonGaza.isSelected()){
                radioButtonWest.setSelected(false);
            }
        });
*/


        //Rectangle read file
        Rectangle rec3 = new Rectangle();
        rec3.setFill(Color.BLACK);
        rec3.setHeight(80);
        rec3.setWidth(140);
        rec3.setY(576);
        rec3.setX(225);
        page3.getChildren().add(rec3);

        //Button for Upload
        Button btnUpload = new Button();
        btnUpload.setText("Read File");
        btnUpload.setMaxHeight(50);
        btnUpload.setMinHeight(50);
        btnUpload.setMinWidth(120);
        btnUpload.setMaxWidth(120);
        btnUpload.setLayoutX(235);
        btnUpload.setLayoutY(590);
        btnUpload.setTextFill(Color.YELLOW);
        btnUpload.setBackground(new Background((new BackgroundFill(Color.GRAY, new CornerRadii(0), Insets.EMPTY))));
        btnUpload.setFont(Font.font("Copperplate", 20));
        page3.getChildren().add(btnUpload);


        ///////////////////////////////////////////////////////
        Stage stage3 = new Stage();
        Group page4 = new Group();
        Scene scene4 = new Scene(page4, 1200, 800, Color.GRAY.darker());
        stage3.setScene(scene4);
        stage3.setMaxHeight(850);
        stage3.setMinHeight(850);
        stage3.setMaxWidth(1200);
        stage3.setMinWidth(1200);


        MyLinkedList Gaza_literary = new MyLinkedList();
        MyLinkedList WestBank_literary = new MyLinkedList();
        MyLinkedList Gaza_scientific = new MyLinkedList();
        MyLinkedList WestBank_scientific = new MyLinkedList();


        //Browse set on action
        btnBrowse.setOnAction(actionEvent -> {

            FileChooser fileChooser = new FileChooser();
            file = fileChooser.showOpenDialog(stage2);
            txtBrowse.setText(String.valueOf(file));


        });


        //button upload set on action
        btnUpload.setOnAction(actionEvent -> {


            String fileName = txtBrowse.getText();
            int lastFileName = fileName.lastIndexOf("\\");
            String newFileName = fileName.substring(lastFileName + 1);


            try {
                Scanner scan = new Scanner(file);


                while (scan.hasNext()) {

                    String line = scan.nextLine();
                    int quotation1 = line.indexOf(',');
                    int quotation2 = line.lastIndexOf(',');
                    String Branch = line.substring(quotation1 + 1, quotation2).trim();

                    double Grade = Double.parseDouble(line.substring(quotation2 + 1).trim());
                    Long SeatNumber = Long.parseLong(line.substring(0, quotation1).trim());
                    if (Branch.equalsIgnoreCase("Scientific") && radioButtonGaza.isSelected()) {
                        Gaza_scientific.sort(new Student(SeatNumber, Branch, Grade));
                    } else if (Branch.equalsIgnoreCase("Literary") && radioButtonGaza.isSelected()) {
                        Gaza_literary.sort(new Student(SeatNumber, Branch, Grade));
                    } else if (Branch.equalsIgnoreCase("Literary") && radioButtonWest.isSelected()) {
                        WestBank_literary.sort(new Student(SeatNumber, Branch, Grade));
                    } else {
                        WestBank_scientific.sort(new Student(SeatNumber, Branch, Grade));
                    }
                }

                stage2.close();
                stage3.show();


                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("To be able to see the results\nPleas select between Scientific or Literary radio buttons");
                alert.showAndWait();


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (NullPointerException e1) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erorr");
                alert.setHeaderText(null);
                alert.setContentText(e1.getMessage() + "\nFile not selected\nYou must select a file to read");
                alert.showAndWait();
            }


        });

        stage2.setScene(scene3);
        stage2.setMaxHeight(850);
        stage2.setMinHeight(850);
        stage2.setMaxWidth(612.5);
        stage2.setMinWidth(612.5);
        stage2.setTitle("File chooser");


        stage3.setScene(scene4);
        stage3.setMaxHeight(850);
        stage3.setMinHeight(850);
        stage3.setMaxWidth(1200);
        stage3.setMinWidth(1200);
        stage3.setTitle("Tawjihi system");

        //Rectangle Yellow
        Rectangle rect1 = new Rectangle();
        rect1.setFill(Color.YELLOW);
        rect1.setHeight(10000);
        rect1.setWidth(23);
        rect1.setY(0);
        rect1.setX(706);
        page4.getChildren().add(rect1);

        //Rectangle Black
        Rectangle rect = new Rectangle();
        rect.setFill(Color.BLACK);
        rect.setHeight(10000);
        rect.setWidth(15);
        rect.setY(0);
        rect.setX(710);
        page4.getChildren().add(rect);

        //Image graduation
        InputStream streamG = new FileInputStream("C:\\Users\\twitter\\IdeaProjects\\testJavaFX\\src\\sample\\Graduation.jpg");
        Image imgGraduation = new Image(streamG);
        ImageView imageViewG = new ImageView();
        imageViewG.setImage(imgGraduation);
        imageViewG.setX(810);
        imageViewG.setY(150);
        imageViewG.setFitWidth(300);
        imageViewG.setFitHeight(150);
        page4.getChildren().add(imageViewG);

        //Rectangle Yellow for the result
        Rectangle rect3 = new Rectangle();
        rect3.setFill(Color.YELLOW);
        rect3.setHeight(70);
        rect3.setWidth(160);
        rect3.setY(55);
        rect3.setX(870);
        page4.getChildren().add(rect3);

        //Rectangle Black for the result
        Rectangle rect2 = new Rectangle();
        rect2.setFill(Color.BLACK);
        rect2.setHeight(60);
        rect2.setWidth(150);
        rect2.setY(60);
        rect2.setX(875);
        page4.getChildren().add(rect2);

        //Label for The Result
        Label lblTheResutl = new Label();
        lblTheResutl.setText("The Result");
        lblTheResutl.setFont(Font.font("Comic Sans MS", 25));
        lblTheResutl.setTextFill(Color.WHITE);
        lblTheResutl.setBackground(new Background((new BackgroundFill(Color.GRAY, new CornerRadii(0), Insets.EMPTY))));
        lblTheResutl.setLayoutY(72);
        lblTheResutl.setLayoutX(887);
        page4.getChildren().add(lblTheResutl);

        //Rectangle Black
        Rectangle rect4 = new Rectangle();
        rect4.setFill(Color.BLACK);
        rect4.setHeight(190);
        rect4.setWidth(400);
        rect4.setY(320);
        rect4.setX(760);
        page4.getChildren().add(rect4);

        //Lable for student id and student grade
        Label lblStudentId = new Label();
        lblStudentId.setText("Student ID");
        lblStudentId.setFont(Font.font("Comic Sans MS", 20));
        lblStudentId.setTextFill(Color.WHITE);
        lblStudentId.setBackground(new Background((new BackgroundFill(Color.GRAY, new CornerRadii(0), Insets.EMPTY))));
        //lblStudentId.setLayoutY(72);
        //lblStudentId.setLayoutX(887);
        //page4.getChildren().add(lblStudentId);

        //Label for student grade
        Label lblStudentGrade = new Label();
        lblStudentGrade.setText("Student Grade");
        lblStudentGrade.setFont(Font.font("Comic Sans MS", 20));
        lblStudentGrade.setTextFill(Color.WHITE);
        lblStudentGrade.setBackground(new Background((new BackgroundFill(Color.GRAY, new CornerRadii(0), Insets.EMPTY))));
        //lblStudentGrade.setLayoutY(72);
        //lblStudentGrade.setLayoutX(887);
        //page4.getChildren().add(lblStudentGrade);

        //Vbox for student id and student grade
        VBox vBoxStudent = new VBox(lblStudentId, lblStudentGrade);
        vBoxStudent.setLayoutY(350);
        vBoxStudent.setLayoutX(800);
        vBoxStudent.setSpacing(30);
        page4.getChildren().add(vBoxStudent);

        //Text Field for id and grade
        TextField txtGrade = new TextField();
        txtGrade.setPrefColumnCount(12);
        txtGrade.setEditable(false);
        TextField txtId = new TextField();
        txtId.setPrefColumnCount(12);
        txtId.setEditable(false);

        //Hbox for txt id and grade
        VBox vBoxGradeId = new VBox(txtId, txtGrade);
        vBoxGradeId.setSpacing(30);
        vBoxGradeId.setLayoutX(970);
        vBoxGradeId.setLayoutY(352);
        page4.getChildren().add(vBoxGradeId);


        //Rectangle Black
        Rectangle rect5 = new Rectangle();
        rect5.setFill(Color.BLACK);
        rect5.setHeight(95);
        rect5.setWidth(400);
        rect5.setY(530);
        rect5.setX(760);
        page4.getChildren().add(rect5);

        //Label for Scientific
        Label lblScientific = new Label();
        lblScientific.setText("Scientific");
        lblScientific.setFont(Font.font("Comic Sans MS", 15));
        lblScientific.setTextFill(Color.WHITE);
        lblScientific.setBackground(new Background((new BackgroundFill(Color.GRAY, new CornerRadii(0), Insets.EMPTY))));

        //Label for Literary
        Label lblLiterary = new Label();
        lblLiterary.setText("Literary");
        lblLiterary.setFont(Font.font("Comic Sans MS", 15));
        lblLiterary.setTextFill(Color.WHITE);
        lblLiterary.setBackground(new Background((new BackgroundFill(Color.GRAY, new CornerRadii(0), Insets.EMPTY))));

        //Hbox for Literary and Scientific
        HBox hBoxLC = new HBox(lblScientific, lblLiterary);
        hBoxLC.setLayoutX(810);
        hBoxLC.setLayoutY(589);
        hBoxLC.setSpacing(140);
        page4.getChildren().add(hBoxLC);

        ToggleGroup tg2 = new ToggleGroup();


        //Radio button for Scientific
        RadioButton radioButtonScientific = new RadioButton();
        radioButtonScientific.setMaxWidth(5);
        radioButtonScientific.setMinWidth(5);
        radioButtonScientific.setMaxHeight(5);
        radioButtonScientific.setMinHeight(5);
        radioButtonScientific.setToggleGroup(tg2);


        //Radio button for Literary
        RadioButton radioButtonLiterary = new RadioButton();
        radioButtonLiterary.setMaxWidth(5);
        radioButtonLiterary.setMinWidth(5);
        radioButtonLiterary.setMaxHeight(5);
        radioButtonLiterary.setMinHeight(5);
        radioButtonLiterary.setToggleGroup(tg2);

        //Hbox for radio button Lit and sci
        HBox hBoxRadio = new HBox(radioButtonScientific, radioButtonLiterary);
        hBoxRadio.setSpacing(200);
        hBoxRadio.setLayoutY(598);
        hBoxRadio.setLayoutX(900);
        page4.getChildren().add(hBoxRadio);


        //radio button Scientific is on action
        radioButtonScientific.setOnAction(actionEvent -> {
            if (radioButtonScientific.isSelected()) {
                radioButtonLiterary.setSelected(false);
            }

        });

        //radio button Literary set on action
        radioButtonLiterary.setOnAction(actionEvent -> {
            if (radioButtonLiterary.isSelected()) {
                radioButtonScientific.setSelected(false);
            }
        });

        //Rectangle Yellow
        Rectangle rect6 = new Rectangle();
        rect6.setFill(Color.YELLOW);
        rect6.setHeight(120);
        rect6.setWidth(160);
        rect6.setY(650);
        rect6.setX(870);
        page4.getChildren().add(rect6);

        //Rectangle Black
        Rectangle rect7 = new Rectangle();
        rect7.setFill(Color.BLACK);
        rect7.setHeight(110);
        rect7.setWidth(150);
        rect7.setY(655);
        rect7.setX(875);
        page4.getChildren().add(rect7);

        //Text Field for search
        TextField txtSearch = new TextField();
        txtSearch.setBackground(new Background((new BackgroundFill(Color.GRAY, new CornerRadii(20), Insets.EMPTY))));
        txtSearch.setLayoutX(140);
        txtSearch.setLayoutY(303);
        txtSearch.setPrefColumnCount(40);
        txtSearch.setPromptText("Search , seat number");
        page4.getChildren().add(txtSearch);

        //Image for search button
        InputStream inputStreamSearch = new FileInputStream("C:\\Users\\twitter\\IdeaProjects\\testJavaFX\\src\\sample\\Search.png");
        Image imageSearch = new Image(inputStreamSearch);
        ImageView imageViewSearch = new ImageView(imageSearch);
        imageViewSearch.setFitHeight(20);
        imageViewSearch.setFitWidth(20);

        //Button search
        Button btnSearch = new Button();
        btnSearch.setGraphic(imageViewSearch);
        btnSearch.setLayoutX(90);
        btnSearch.setLayoutY(300);
        btnSearch.setMinWidth(30);
        btnSearch.setMaxWidth(30);
        btnSearch.setMinHeight(30);
        btnSearch.setMaxHeight(30);
        btnSearch.setBackground(new Background((new BackgroundFill(Color.BLACK, new CornerRadii(60), Insets.EMPTY))));
        page4.getChildren().add(btnSearch);

        //Tawjihi label
        Label lblTaw = new Label();
        lblTaw.setText("Tawjihi Palestine");
        lblTaw.setFont(Font.font("Brush Script MT", 60));
        lblTaw.setTextFill(Color.BLACK);
        lblTaw.setStyle("-fx-font-weight: bold");
        page4.getChildren().add(lblTaw);

        //2021 Label
        Label lbl2021 = new Label();
        lbl2021.setText("    2020-2021");
        lbl2021.setFont(Font.font("Brush Script MT", 55));
        lbl2021.setTextFill(Color.YELLOW);
        lbl2021.setStyle("-fx-font-weight: bold");
        page4.getChildren().add(lbl2021);

        //Vbox for tawjihi 2021
        VBox vBox2021 = new VBox(lblTaw, lbl2021);
        vBox2021.setSpacing(0);
        vBox2021.setLayoutX(300);
        vBox2021.setLayoutY(12);
        page4.getChildren().add(vBox2021);

        //Rectangle yellow for cap graduation
        Rectangle rectangleCapY = new Rectangle();
        rectangleCapY.setX(55);
        rectangleCapY.setY(0);
        rectangleCapY.setWidth(200);
        rectangleCapY.setHeight(220);
        rectangleCapY.setFill(Color.YELLOW);
        page4.getChildren().add(rectangleCapY);

        //Rectangle Gray for cap graduation
        Rectangle rectangleCapG = new Rectangle();
        rectangleCapG.setX(60);
        rectangleCapG.setY(0);
        rectangleCapG.setWidth(190);
        rectangleCapG.setHeight(215);
        rectangleCapG.setFill(Color.GRAY);
        page4.getChildren().add(rectangleCapG);

        //Rectangle Black for cap graduation
        Rectangle rectangleCap = new Rectangle();
        rectangleCap.setX(65);
        rectangleCap.setY(0);
        rectangleCap.setWidth(180);
        rectangleCap.setHeight(210);
        rectangleCap.setFill(Color.BLACK);
        page4.getChildren().add(rectangleCap);

        //Image for hat graduation
        InputStream streamCap = new FileInputStream("C:\\Users\\twitter\\IdeaProjects\\testJavaFX\\src\\sample\\CapCap.png");
        Image imgCap = new Image(streamCap);
        ImageView imageViewCap = new ImageView(imgCap);
        imageViewCap.setY(10);
        imageViewCap.setX(85);
        imageViewCap.setFitWidth(140);
        imageViewCap.setFitHeight(200);
        page4.getChildren().add(imageViewCap);

        //Rectangle Black
        Rectangle re = new Rectangle();
        re.setX(40);
        re.setY(360);
        re.setWidth(620);
        re.setHeight(470);
        re.setFill(Color.BLACK);
        page4.getChildren().add(re);

        //Label for  the number and percentage
        Label lblPer = new Label();
        lblPer.setText("The number and percentage");
        lblPer.setTextFill(Color.WHITE);
        lblPer.setFont(Font.font("Comic Sans MS", 25));
        lblPer.setBackground(new Background((new BackgroundFill(Color.GRAY, new CornerRadii(0), Insets.EMPTY))));
        lblPer.setLayoutY(375);
        lblPer.setLayoutX(90);
        page4.getChildren().add(lblPer);

        //Button for show per
        Button btnShowPer = new Button();
        btnShowPer.setText("Show");
        btnShowPer.setMaxHeight(35);
        btnShowPer.setMinHeight(35);
        btnShowPer.setMinWidth(90);
        btnShowPer.setMaxWidth(90);
        btnShowPer.setLayoutX(460);
        btnShowPer.setLayoutY(375);
        btnShowPer.setTextFill(Color.YELLOW);
        btnShowPer.setBackground(new Background((new BackgroundFill(Color.BLACK, new CornerRadii(0), Insets.EMPTY))));
        btnShowPer.setFont(Font.font("Comic Sans MS", 18));
        btnShowPer.setStyle("-fx-border-color: #ffffff; -fx-border-width: 2px;");
        //btnShowAvg.setStyle("-fx-font-weight: bold");
        page4.getChildren().add(btnShowPer);

        Stage stage10 = new Stage();
        Group page10 = new Group();
        Scene scene10 = new Scene(page10, 500, 700, Color.GRAY.darker());


        stage10.setScene(scene10);
        stage10.setMaxHeight(700);
        stage10.setMinHeight(700);
        stage10.setMaxWidth(500);
        stage10.setMinWidth(500);
        stage10.setTitle("The number and percentage");
        ////////////////////////////////

        Label per = new Label();
        per.setText("The Grade");
        per.setTextFill(Color.WHITE);
        per.setFont(Font.font("Comic Sans MS", 20));
        per.setBackground(new Background((new BackgroundFill(Color.BLACK, new CornerRadii(0), Insets.EMPTY))));

        Label num = new Label();
        num.setText("The number\nThe percentage");
        num.setTextFill(Color.WHITE);
        num.setFont(Font.font("Comic Sans MS", 20));
        num.setBackground(new Background((new BackgroundFill(Color.BLACK, new CornerRadii(0), Insets.EMPTY))));


        VBox vBox7 = new VBox(per, num);
        vBox7.setSpacing(40);


        //Text Field for text number
        TextField txtPer = new TextField();
        txtPer.setPrefColumnCount(12);
        txtPer.setLayoutX(250);
        txtPer.setLayoutY(200);
        txtPer.setPromptText("Percentage");
        txtPer.setBackground(new Background((new BackgroundFill(Color.GRAY, new CornerRadii(20), Insets.EMPTY))));

        //lbl for per
        Label ansNum = new Label();
        ansNum.setText("");
        ansNum.setTextFill(Color.YELLOW);
        ansNum.setFont(Font.font("Comic Sans MS", 20));
        ansNum.setBackground(new Background((new BackgroundFill(Color.BLACK, new CornerRadii(0), Insets.EMPTY))));

        VBox vBox11 = new VBox(txtPer, ansNum);
        vBox11.setSpacing(5);

        HBox hBox9 = new HBox(vBox7, vBox11);
        hBox9.setLayoutX(140);
        hBox9.setLayoutY(120);
        hBox9.setSpacing(40);
        page10.getChildren().add(hBox9);

        Button btnGetNum = new Button();
        btnGetNum.setText("Get Number");
        btnGetNum.setLayoutX(153);
        btnGetNum.setLayoutY(230);
        btnGetNum.setMaxHeight(30);
        btnGetNum.setMinHeight(30);
        btnGetNum.setMinWidth(110);
        btnGetNum.setMaxWidth(135);
        btnGetNum.setTextFill(Color.BLACK);
        btnGetNum.setBackground(new Background((new BackgroundFill(Color.YELLOW, new CornerRadii(20), Insets.EMPTY))));
        btnGetNum.setFont(Font.font("Copperplate", 17));
        btnGetNum.setStyle("-fx-font-weight: bold");
        page10.getChildren().add(btnGetNum);


        //button show per set on action
        btnShowPer.setOnAction(actionEvent -> {

            if (radioButtonScientific.isSelected() || radioButtonLiterary.isSelected()) {
                stage10.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText(null);
                alert.setContentText("To be able to see the percentage and number\nYou must select between Scientific or Literary radio buttons");
                alert.showAndWait();
            }

        });


        btnGetNum.setOnAction(actionEvent -> {

            try {


                double grade = Double.parseDouble(txtPer.getText());

                if (grade < 0) {
                    throw new IllegalArgumentException("The grade cannot be negative");
                } else if (grade == 0) {
                    throw new IllegalArgumentException("The grade cannot be zero");
                }


                MyLinkedList selected = new MyLinkedList();
                if (radioButtonWest.isSelected()) {
                    if (radioButtonScientific.isSelected()) {
                        selected = WestBank_scientific;
                        ansNum.setText(selected.getNumberPercentage(grade) + "");


                    } else if (radioButtonLiterary.isSelected()) {
                        selected = WestBank_literary;
                        ansNum.setText(selected.getNumberPercentage(grade) + "");

                    } else {
                        ansNum.setText("");

                    }
                } else if (radioButtonGaza.isSelected()) {
                    if (radioButtonScientific.isSelected()) {
                        selected = Gaza_scientific;
                        ansNum.setText(selected.getNumberPercentage(grade) + "");

                    } else if (radioButtonLiterary.isSelected()) {
                        selected = Gaza_literary;
                        ansNum.setText(selected.getNumberPercentage(grade) + "");

                    } else {
                        ansNum.setText("");

                    }
                } else {
                    ansNum.setText("");

                }

            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }


        });


        //Label for show top student
        Label lblShow10 = new Label();
        lblShow10.setText("Top 10 Students");
        lblShow10.setTextFill(Color.WHITE);
        lblShow10.setFont(Font.font("Comic Sans MS", 25));
        lblShow10.setBackground(new Background((new BackgroundFill(Color.GRAY, new CornerRadii(0), Insets.EMPTY))));

        //Label for median
        Label lblMedian = new Label();
        lblMedian.setText("The median");
        lblMedian.setTextFill(Color.WHITE);
        lblMedian.setFont(Font.font("Comic Sans MS", 25));
        lblMedian.setBackground(new Background((new BackgroundFill(Color.GRAY, new CornerRadii(0), Insets.EMPTY))));

        //Label for Average
        Label lblAvg = new Label();
        lblAvg.setText("Average for the students");
        lblAvg.setTextFill(Color.WHITE);
        lblAvg.setFont(Font.font("Comic Sans MS", 25));
        lblAvg.setBackground(new Background((new BackgroundFill(Color.GRAY, new CornerRadii(0), Insets.EMPTY))));


        //Label for Mode
        Label lblMode = new Label();
        lblMode.setText("The most frequent sign");
        lblMode.setTextFill(Color.WHITE);
        lblMode.setFont(Font.font("Comic Sans MS", 25));
        lblMode.setBackground(new Background((new BackgroundFill(Color.GRAY, new CornerRadii(0), Insets.EMPTY))));

        //The standard deviation
        Label lblDev = new Label();
        lblDev.setText("Std , variance and percentage");
        lblDev.setTextFill(Color.WHITE);
        lblDev.setFont(Font.font("Comic Sans MS", 25));
        lblDev.setBackground(new Background((new BackgroundFill(Color.GRAY, new CornerRadii(0), Insets.EMPTY))));

        //Vbox for show1
        VBox vBoxShow1 = new VBox(lblAvg, lblMode, lblDev);
        vBoxShow1.setSpacing(20);
        vBoxShow1.setLayoutY(430);
        vBoxShow1.setLayoutX(90);
        page4.getChildren().add(vBoxShow1);

        //Vbox for show2
        VBox vBoxShow2 = new VBox(lblShow10, lblMedian);
        vBoxShow2.setSpacing(20);
        vBoxShow2.setLayoutY(600);
        vBoxShow2.setLayoutX(90);
        page4.getChildren().add(vBoxShow2);

        //Button for show average
        Button btnShowAvg = new Button();
        btnShowAvg.setText("Show");
        btnShowAvg.setMaxHeight(35);
        btnShowAvg.setMinHeight(35);
        btnShowAvg.setMinWidth(90);
        btnShowAvg.setMaxWidth(90);
        btnShowAvg.setLayoutX(235);
        btnShowAvg.setLayoutY(590);
        btnShowAvg.setTextFill(Color.YELLOW);
        btnShowAvg.setBackground(new Background((new BackgroundFill(Color.BLACK, new CornerRadii(0), Insets.EMPTY))));
        btnShowAvg.setFont(Font.font("Comic Sans MS", 18));
        btnShowAvg.setStyle("-fx-border-color: #ffffff; -fx-border-width: 2px;");
        //btnShowAvg.setStyle("-fx-font-weight: bold");
        page4.getChildren().add(btnShowAvg);

        //Button for show Mode
        Button btnShowMode = new Button();
        btnShowMode.setText("Show");
        btnShowMode.setMaxHeight(35);
        btnShowMode.setMinHeight(35);
        btnShowMode.setMinWidth(90);
        btnShowMode.setMaxWidth(90);
        btnShowMode.setLayoutX(235);
        btnShowMode.setLayoutY(590);
        btnShowMode.setTextFill(Color.YELLOW);
        btnShowMode.setStyle("-fx-border-color: #ffffff; -fx-border-width: 2px;");
        btnShowMode.setBackground(new Background((new BackgroundFill(Color.BLACK, new CornerRadii(0), Insets.EMPTY))));
        btnShowMode.setFont(Font.font("Comic Sans MS", 18));
        page4.getChildren().add(btnShowMode);


        //Button for showDiv
        Button btnShowDiv = new Button();
        btnShowDiv.setText("Show");
        btnShowDiv.setMaxHeight(35);
        btnShowDiv.setMinHeight(35);
        btnShowDiv.setMinWidth(90);
        btnShowDiv.setMaxWidth(90);
        btnShowDiv.setLayoutX(235);
        btnShowDiv.setLayoutY(590);
        btnShowDiv.setTextFill(Color.YELLOW);
        btnShowDiv.setStyle("-fx-border-color: #ffffff; -fx-border-width: 2px;");
        btnShowDiv.setBackground(new Background((new BackgroundFill(Color.BLACK, new CornerRadii(0), Insets.EMPTY))));
        btnShowDiv.setFont(Font.font("Comic Sans MS", 18));
        page4.getChildren().add(btnShowDiv);

        //Button for ShowTop
        Button btnShowTop = new Button();
        btnShowTop.setText("Show");
        btnShowTop.setMaxHeight(35);
        btnShowTop.setMinHeight(35);
        btnShowTop.setMinWidth(90);
        btnShowTop.setMaxWidth(90);
        btnShowTop.setLayoutX(235);
        btnShowTop.setLayoutY(590);
        btnShowTop.setTextFill(Color.YELLOW);
        btnShowTop.setStyle("-fx-border-color: #ffffff; -fx-border-width: 2px;");
        btnShowTop.setBackground(new Background((new BackgroundFill(Color.BLACK, new CornerRadii(0), Insets.EMPTY))));
        btnShowTop.setFont(Font.font("Comic Sans MS", 18));
        page4.getChildren().add(btnShowTop);

        //Button for showMedian
        Button btnShowMedian = new Button();
        btnShowMedian.setText("Show");
        btnShowMedian.setMaxHeight(35);
        btnShowMedian.setMinHeight(35);
        btnShowMedian.setMinWidth(90);
        btnShowMedian.setMaxWidth(90);
        btnShowMedian.setLayoutX(235);
        btnShowMedian.setLayoutY(590);
        btnShowMedian.setTextFill(Color.YELLOW);
        btnShowMedian.setStyle("-fx-border-color: #ffffff; -fx-border-width: 2px;");
        btnShowMedian.setBackground(new Background((new BackgroundFill(Color.BLACK, new CornerRadii(0), Insets.EMPTY))));
        btnShowMedian.setFont(Font.font("Comic Sans MS", 18));
        page4.getChildren().add(btnShowMedian);

        //Vbox show2btn
        VBox vBoxBtn = new VBox(btnShowAvg, btnShowMode, btnShowDiv);
        vBoxBtn.setSpacing(20);
        vBoxBtn.setLayoutY(430);
        vBoxBtn.setLayoutX(460);
        page4.getChildren().add(vBoxBtn);

        //Vbox show3 btn
        VBox vBoxbtn3 = new VBox(btnShowTop, btnShowMedian);
        vBoxbtn3.setLayoutX(460);
        vBoxbtn3.setLayoutY(603);
        vBoxbtn3.setSpacing(20);
        page4.getChildren().add(vBoxbtn3);

        //Button for insert new record
        Button btnInsertNew = new Button();
        btnInsertNew.setText("Insert");
        btnInsertNew.setMaxHeight(50);
        btnInsertNew.setMinHeight(50);
        btnInsertNew.setMinWidth(120);
        btnInsertNew.setMaxWidth(90);
        btnInsertNew.setLayoutX(100);
        btnInsertNew.setLayoutY(740);
        btnInsertNew.setStyle("-fx-font-weight: bold");
        btnInsertNew.setTextFill(Color.BLACK);
        btnInsertNew.setBackground(new Background((new BackgroundFill(Color.YELLOW, new CornerRadii(9), Insets.EMPTY))));
        btnInsertNew.setFont(Font.font("Comic Sans MS", 18));
        //btnShowAvg.setStyle("-fx-font-weight: bold");
        //page4.getChildren().add(btnInsertNew);

        //Button for export file
        Button btnExport = new Button();
        btnExport.setText("Export");
        btnExport.setMaxHeight(50);
        btnExport.setMinHeight(50);
        btnExport.setMinWidth(120);
        btnExport.setMaxWidth(90);
        btnExport.setLayoutX(210);
        btnExport.setLayoutY(740);
        btnExport.setStyle("-fx-font-weight: bold");
        btnExport.setTextFill(Color.BLACK);
        btnExport.setBackground(new Background((new BackgroundFill(Color.YELLOW, new CornerRadii(9), Insets.EMPTY))));
        btnExport.setFont(Font.font("Comic Sans MS", 18));
        //btnShowAvg.setStyle("-fx-font-weight: bold");
        //page4.getChildren().add(btnExport);

        //Button for delete
        Button btnDelete = new Button();
        btnDelete.setText("Delete");
        btnDelete.setMaxHeight(50);
        btnDelete.setMinHeight(50);
        btnDelete.setMinWidth(120);
        btnDelete.setMaxWidth(90);
        btnDelete.setLayoutX(210);
        btnDelete.setLayoutY(740);
        btnDelete.setStyle("-fx-font-weight: bold");
        btnDelete.setTextFill(Color.BLACK);
        btnDelete.setBackground(new Background((new BackgroundFill(Color.YELLOW, new CornerRadii(9), Insets.EMPTY))));
        btnDelete.setFont(Font.font("Comic Sans MS", 18));


        HBox hBoxForIED = new HBox(btnInsertNew, btnExport, btnDelete);
        hBoxForIED.setLayoutY(740);
        hBoxForIED.setLayoutX(130);
        hBoxForIED.setSpacing(30);
        page4.getChildren().add(hBoxForIED);


/*
        btnSearch.setOnAction(actionEvent -> {

           Long seatNumSearch = Long.parseLong(txtSearch.getText().trim());

           if (flag ==1) {
                Student studentS = WestBank_scientific.search(seatNumSearch);
               System.out.println("studentS = " + studentS);
                Student studentL = WestBank_literary.search(seatNumSearch);
               System.out.println("studentL = " + studentL);
               if (studentS.getSeatNum() != 0){
                   txtId.setText(String.valueOf(studentS.getSeatNum()));
                   txtGrade.setText(String.valueOf(studentS.getGrade()));
                   radioButtonWestBank.setSelected(true);
                   System.out.println("Radio");
                   return;
               }
               else if ( studentL.getSeatNum() != 0){
                   txtId.setText(String.valueOf(studentL.getSeatNum()));
                   txtGrade.setText(String.valueOf(studentL.getGrade()));
                   radioButtonWestBank.setSelected(true);
                   return;
               }
               else{
                   System.out.println("else");
               }

           }
           else if (flag == 2){
               Student studentS2 = WestBank_scientific.search(seatNumSearch);
               System.out.println("studentS2 = " + studentS2);
               Student studentL2 = WestBank_literary.search(seatNumSearch);
               System.out.println("studentL2 = " + studentL2);
               if (studentS2.getSeatNum() != 0){
                   txtId.setText(String.valueOf(studentS2.getSeatNum()));
                   txtGrade.setText(String.valueOf(studentS2.getGrade()));
                   radioButtonWestBank.setSelected(true);
                   return;
               }
               else if ( studentL2.getSeatNum() != 0){
                   txtId.setText(String.valueOf(studentL2.getSeatNum()));
                   txtGrade.setText(String.valueOf(studentL2.getGrade()));
                   radioButtonWestBank.setSelected(true);
                   return;
               }
               else{
                    System.out.println();
               }
           }










        });
*/

        //label for the show average
        Label lblAverage = new Label();
        lblAverage.setLayoutX(580);
        lblAverage.setLayoutY(431);
        lblAverage.setTextFill(Color.YELLOW);
        lblAverage.setFont(Font.font("Comic Sans MS", 25));
        //lblAverage.setText("AVG");
        page4.getChildren().add(lblAverage);

        //label for the standard divation
        Label lblStandard = new Label();
        lblStandard.setLayoutX(580);
        lblStandard.setLayoutY(545);
        lblStandard.setTextFill(Color.YELLOW);
        lblStandard.setFont(Font.font("Comic Sans MS", 25));
        //lblStandard.setText("S");
        page4.getChildren().add(lblStandard);

        //label for the show mode
        Label lblMode2 = new Label();
        lblMode2.setLayoutX(580);
        lblMode2.setLayoutY(480);
        lblMode2.setTextFill(Color.YELLOW);
        lblMode2.setFont(Font.font("Comic Sans MS", 25));
        //lblMode2.setText("Mode");
        page4.getChildren().add(lblMode2);

        //label for the show median
        Label lblMedian2 = new Label();
        lblMedian2.setLayoutX(580);
        lblMedian2.setLayoutY(660);
        lblMedian2.setTextFill(Color.YELLOW);
        lblMedian2.setFont(Font.font("Comic Sans MS", 25));
        //lblMedian2.setText("Median");
        page4.getChildren().add(lblMedian2);

        //Show avg on action
        btnShowAvg.setOnAction(actionEvent -> {

            if (radioButtonScientific.isSelected() || radioButtonLiterary.isSelected()) {

                if (radioButtonWest.isSelected()) {
                    if (radioButtonScientific.isSelected()) {
                        Node node = new Node();
                        Double avg = WestBank_scientific.getAverage();
                        String strAvg = String.format("%.02f", avg);
                        lblAverage.setText(strAvg);
                    } else if (radioButtonLiterary.isSelected()) {
                        Node node = new Node();
                        Double avg = WestBank_literary.getAverage();
                        String strAvg = String.format("%.02f", avg);
                        lblAverage.setText(strAvg);
                    } else {
                        lblAverage.setText("");
                    }
                }

                if (radioButtonGaza.isSelected()) {
                    if (radioButtonScientific.isSelected()) {
                        Node node = new Node();
                        Double avg = Gaza_scientific.getAverage();
                        String strAvg = String.format("%.02f", avg);
                        lblAverage.setText(strAvg);
                    } else if (radioButtonLiterary.isSelected()) {
                        Node node = new Node();
                        Double avg = Gaza_literary.getAverage();
                        String strAvg = String.format("%.02f", avg);
                        lblAverage.setText(strAvg);
                    } else {
                        lblAverage.setText("");
                    }
                }
            } else {

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText(null);
                alert.setContentText("To be able to see the Average\nYou must select between Scientific or Literary radio buttons");
                alert.showAndWait();

            }
        });


        Stage stage4 = new Stage();
        Group page5 = new Group();
        Scene scene5 = new Scene(page5, 500, 700, Color.GRAY.darker());

        Label top10 = new Label();
        top10.setLayoutX(70);
        top10.setLayoutY(200);
        top10.setTextFill(Color.YELLOW);
        top10.setFont(Font.font("Comic Sans MS", 15));
        page5.getChildren().add(top10);

        stage4.setScene(scene5);
        stage4.setMaxHeight(700);
        stage4.setMinHeight(700);
        stage4.setMaxWidth(500);
        stage4.setMinWidth(500);
        stage4.setTitle("Top 10 student's");


        //show top 10 on action
        btnShowTop.setOnAction(actionEvent -> {

            if (radioButtonScientific.isSelected() || radioButtonLiterary.isSelected()) {

                if (radioButtonWest.isSelected()) {
                    if (radioButtonScientific.isSelected()) {
                        String str3 = WestBank_scientific.topTen();
                        top10.setText(str3);

                    } else if (radioButtonLiterary.isSelected()) {
                        String str4 = WestBank_scientific.topTen();
                        top10.setText(str4);
                    } else {
                        return;
                    }
                }

                if (radioButtonGaza.isSelected()) {
                    if (radioButtonScientific.isSelected()) {
                        String str = Gaza_scientific.topTen();
                        top10.setText(str);
                    } else if (radioButtonLiterary.isSelected()) {
                        String str2 = Gaza_literary.topTen();
                        top10.setText(str2);
                    } else {
                        return;
                    }
                }
                stage4.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText(null);
                alert.setContentText("To be able to see the top 10\nYou must select between Scientific or Literary radio buttons");
                alert.showAndWait();
            }
        });

        Stage stage5 = new Stage();
        Group page6 = new Group();
        Scene scene6 = new Scene(page6, 500, 450, Color.GRAY.darker());

        stage5.setScene(scene6);
        stage5.setMaxHeight(500);
        stage5.setMinHeight(500);
        stage5.setMaxWidth(450);
        stage5.setMinWidth(450);
        stage5.setTitle("Insert a new student");


        //Text Field for text seat
        TextField txtSeat = new TextField();
        txtSeat.setPrefColumnCount(15);
        txtSeat.setLayoutX(250);
        txtSeat.setLayoutY(200);
        txtSeat.setPromptText("Insert Seat Number");
        txtSeat.setBackground(new Background((new BackgroundFill(Color.GRAY, new CornerRadii(20), Insets.EMPTY))));


        //Text field for txt grade
        TextField txtGrade2 = new TextField();
        txtGrade2.setPrefColumnCount(15);
        txtGrade2.setLayoutX(250);
        txtGrade2.setLayoutY(200);
        txtGrade2.setPromptText("Insert grade");
        txtGrade2.setBackground(new Background((new BackgroundFill(Color.GRAY, new CornerRadii(20), Insets.EMPTY))));

        VBox vBoxInsert = new VBox(txtSeat, txtGrade2);
        vBoxInsert.setSpacing(30);
        vBoxInsert.setLayoutY(200);
        vBoxInsert.setLayoutX(135);
        page6.getChildren().add(vBoxInsert);

        Button btnInsertData = new Button();
        btnInsertData.setText("Insert");
        btnInsertData.setLayoutX(185);
        btnInsertData.setLayoutY(350);
        btnInsertData.setMaxHeight(30);
        btnInsertData.setMinHeight(30);
        btnInsertData.setMinWidth(80);
        btnInsertData.setMaxWidth(80);
        btnInsertData.setTextFill(Color.BLACK);
        btnInsertData.setBackground(new Background((new BackgroundFill(Color.YELLOW, new CornerRadii(20), Insets.EMPTY))));
        btnInsertData.setFont(Font.font("Copperplate", 17));
        btnInsertData.setStyle("-fx-font-weight: bold");
        page6.getChildren().add(btnInsertData);

        //Button insert set on action
        btnInsertNew.setOnAction(actionEvent -> {


            if (radioButtonScientific.isSelected() || radioButtonLiterary.isSelected()) {
                stage5.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText(null);
                alert.setContentText("To be able to search for a student\nYou must select between Scientific or Literary radio buttons");
                alert.showAndWait();
            }


        });

        //button insert2 set on action
        btnInsertData.setOnAction(actionEvent1 -> {

            try {
                Double doubleGrade = Double.parseDouble(txtGrade2.getText().trim());
                Long seatNumber = Long.parseLong(txtSeat.getText().trim());

                if (seatNumber == 0) {
                    throw new IllegalArgumentException("The seat number cannot be zero");
                } else if (seatNumber < 0) {
                    throw new IllegalArgumentException("The seat number cannot be negative");
                } else if (doubleGrade == 0) {
                    throw new IllegalArgumentException("The grade cannot be zero");
                } else if (doubleGrade < 0) {
                    throw new IllegalArgumentException("The grade cannot be negative");
                }


                Student studentS = new Student(seatNumber, "Scientific", doubleGrade);
                Student studentL = new Student(seatNumber, "Literary", doubleGrade);

                //west bank
                if (radioButtonWest.isSelected()) {
                    if (radioButtonScientific.isSelected()) {
                        WestBank_scientific.sort(studentS);
                    } else {
                        WestBank_literary.sort(studentL);
                    }
                }//Gaza
                else if (radioButtonGaza.isSelected()) {
                    if (radioButtonScientific.isSelected()) {
                        Gaza_scientific.sort(studentS);
                    } else {
                        Gaza_literary.sort(studentL);
                    }
                } else {
                    stage5.close();
                }
                stage5.close();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("The Student has been inserted");
                alert.showAndWait();
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            } catch (IllegalArgumentException exception) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText(exception.getMessage());
                alert.showAndWait();
            }


        });


        Stage stage7 = new Stage();
        Group page7 = new Group();
        Scene scene7 = new Scene(page7, 400, 400, Color.GRAY.darker());

        TextField txtDelete = new TextField();
        txtDelete.setPrefColumnCount(15);
        txtDelete.setLayoutX(110);
        txtDelete.setLayoutY(170);
        txtDelete.setPromptText("Insert Seat Number");
        txtDelete.setBackground(new Background((new BackgroundFill(Color.GRAY, new CornerRadii(20), Insets.EMPTY))));
        page7.getChildren().add(txtDelete);

        stage7.setScene(scene7);
        stage7.setMaxHeight(400);
        stage7.setMinHeight(400);
        stage7.setMaxWidth(400);
        stage7.setMinWidth(400);
        stage7.setTitle("Delete a student");


        btnDelete.setOnAction(actionEvent1 -> {

            if (radioButtonScientific.isSelected() || radioButtonLiterary.isSelected()) {
                stage7.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText(null);
                alert.setContentText("To be able to delete a student\nYou must select between Scientific or Literary radio buttons");
                alert.showAndWait();
            }


        });

        Button btnDELET = new Button();
        btnDELET.setText("Delete");
        btnDELET.setLayoutX(153);
        btnDELET.setLayoutY(230);
        btnDELET.setMaxHeight(30);
        btnDELET.setMinHeight(30);
        btnDELET.setMinWidth(80);
        btnDELET.setMaxWidth(80);
        btnDELET.setTextFill(Color.BLACK);
        btnDELET.setBackground(new Background((new BackgroundFill(Color.YELLOW, new CornerRadii(20), Insets.EMPTY))));
        btnDELET.setFont(Font.font("Copperplate", 17));
        btnDELET.setStyle("-fx-font-weight: bold");
        page7.getChildren().add(btnDELET);

        btnDELET.setOnAction(actionEvent -> {

            try {


                Long seat = Long.parseLong(txtDelete.getText().trim());
                if (seat < 0) {
                    throw new IllegalArgumentException("The seat number cannot be negative");
                } else if (seat == 0) {
                    throw new IllegalArgumentException("The seat number cannot be zero");
                }
                MyLinkedList selected = new MyLinkedList();
                if (radioButtonWest.isSelected()) {
                    if (radioButtonScientific.isSelected()) {
                        selected = WestBank_scientific;

                    } else if (radioButtonLiterary.isSelected()) {
                        selected = WestBank_literary;

                    }
                } else if (radioButtonGaza.isSelected()) {
                    if (radioButtonScientific.isSelected()) {
                        selected = Gaza_scientific;

                    } else if (radioButtonLiterary.isSelected()) {
                        selected = Gaza_literary;
                    }
                }

                selected.deleteAtSeat(seat);
                stage7.close();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("The student has been deleted");
                alert.showAndWait();
            } catch (NumberFormatException e1) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText(e1.getMessage());
                alert.showAndWait();
            } catch (IllegalArgumentException e2) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText(e2.getMessage());
                alert.showAndWait();
            }

        });

        //image for 90
        InputStream stream5 = new FileInputStream("C:\\Users\\twitter\\IdeaProjects\\testJavaFX\\src\\sample\\90.png");
        Image image90 = new Image(stream5);
        ImagePattern imagePattern90 = new ImagePattern(image90);

        //image for 80
        InputStream stream6 = new FileInputStream("C:\\Users\\twitter\\IdeaProjects\\testJavaFX\\src\\sample\\80.png");
        Image image80 = new Image(stream6);
        ImagePattern imagePattern80 = new ImagePattern(image80);

        //image for 70
        InputStream stream7 = new FileInputStream("C:\\Users\\twitter\\IdeaProjects\\testJavaFX\\src\\sample\\70.png");
        Image image70 = new Image(stream7);
        ImagePattern imagePattern70 = new ImagePattern(image70);

        //image for 60
        InputStream stream8 = new FileInputStream("C:\\Users\\twitter\\IdeaProjects\\testJavaFX\\src\\sample\\60.jpg");
        Image image60 = new Image(stream8);
        ImagePattern imagePattern60 = new ImagePattern(image60);

        //image for 50
        InputStream stream9 = new FileInputStream("C:\\Users\\twitter\\IdeaProjects\\testJavaFX\\src\\sample\\50.jpg");
        Image image50 = new Image(stream9);
        ImagePattern imagePattern50 = new ImagePattern(image50);

        btnSearch.setOnAction(e -> {

            try {

                if (radioButtonScientific.isSelected() || radioButtonLiterary.isSelected()) {

                    MyLinkedList selected = new MyLinkedList();
                    if (radioButtonWest.isSelected()) {
                        if (radioButtonScientific.isSelected()) {
                            selected = WestBank_scientific;
                        } else if (radioButtonLiterary.isSelected()) {
                            selected = WestBank_literary;
                        }
                    } else if (radioButtonGaza.isSelected()) {
                        if (radioButtonScientific.isSelected()) {
                            selected = Gaza_scientific;
                        } else if (radioButtonLiterary.isSelected()) {
                            selected = Gaza_literary;
                        }
                    }

                    long number = Long.parseLong(txtSearch.getText().trim());
                    if (number < 0) {
                        throw new IllegalArgumentException("The seat number cannot be negative");
                    } else if (number == 0) {
                        throw new IllegalArgumentException("The seat number cannot be zero");
                    }
                    Student std_found = selected.search(number);


                    txtId.setText(std_found.getSeatNum() + "");
                    txtGrade.setText(std_found.getGrade() + "");

                    if (Double.parseDouble(txtGrade.getText()) >= 90) {
                        rect7.setFill(imagePattern90);
                    } else if (Double.parseDouble(txtGrade.getText()) >= 80) {
                        rect7.setFill(imagePattern80);
                    } else if (Double.parseDouble(txtGrade.getText()) >= 70) {
                        rect7.setFill(imagePattern70);
                    } else if (Double.parseDouble(txtGrade.getText()) >= 60) {
                        rect7.setFill(imagePattern60);
                    } else {
                        rect7.setFill(imagePattern50);
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning");
                    alert.setHeaderText(null);
                    alert.setContentText("To be able to search for a student\nYou must select between Scientific or Literary radio buttons");
                    alert.showAndWait();
                }
            } catch (NumberFormatException exception) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText(exception.getMessage());
                alert.showAndWait();
            } catch (IllegalArgumentException exception) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText(exception.getMessage());
                alert.showAndWait();
            }

        });

        btnShowMode.setOnAction(actionEvent -> {

            if (radioButtonScientific.isSelected() || radioButtonLiterary.isSelected()) {


                MyLinkedList selected = new MyLinkedList();
                if (radioButtonWest.isSelected()) {
                    if (radioButtonScientific.isSelected()) {
                        selected = WestBank_scientific;
                        lblMode2.setText(selected.getMode() + "");
                    } else if (radioButtonLiterary.isSelected()) {
                        selected = WestBank_literary;
                        lblMode2.setText(selected.getMode() + "");

                    } else {
                        lblMode2.setText("");
                    }


                } else if (radioButtonGaza.isSelected()) {
                    if (radioButtonScientific.isSelected()) {
                        selected = Gaza_scientific;
                        lblMode2.setText(selected.getMode() + "");

                    } else if (radioButtonLiterary.isSelected()) {
                        selected = Gaza_literary;
                        lblMode2.setText(selected.getMode() + "");

                    } else {
                        lblMode2.setText("");
                    }

                } else {
                    lblMode2.setText("");
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText(null);
                alert.setContentText("To be able to see the Mode\nYou must select between Scientific or Literary radio buttons");
                alert.showAndWait();
            }


        });

        btnShowMedian.setOnAction(actionEvent -> {

            if (radioButtonScientific.isSelected() || radioButtonLiterary.isSelected()) {

                MyLinkedList selected = new MyLinkedList();
                if (radioButtonWest.isSelected()) {
                    if (radioButtonScientific.isSelected()) {
                        selected = WestBank_scientific;
                        lblMedian2.setText(selected.getMedian() + "");

                    } else if (radioButtonLiterary.isSelected()) {
                        selected = WestBank_literary;
                        lblMedian2.setText(selected.getMedian() + "");

                    } else {
                        lblMedian2.setText("");
                    }
                } else if (radioButtonGaza.isSelected()) {
                    if (radioButtonScientific.isSelected()) {
                        selected = Gaza_scientific;
                        lblMedian2.setText(selected.getMedian() + "");

                    } else if (radioButtonLiterary.isSelected()) {
                        selected = Gaza_literary;
                        lblMedian2.setText(selected.getMedian() + "");

                    } else {
                        lblMedian2.setText("");
                    }
                } else {
                    lblMedian2.setText("");
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText(null);
                alert.setContentText("To be able to see the median\nYou must select between Scientific or Literary radio buttons");
                alert.showAndWait();
            }
        });

        Stage stage8 = new Stage();
        Group page8 = new Group();
        Scene scene9 = new Scene(page8, 400, 600, Color.GRAY.darker());

        Label Div = new Label();
        Div.setText("The standard deviation");
        Div.setTextFill(Color.WHITE);
        Div.setFont(Font.font("Comic Sans MS", 20));
        Div.setBackground(new Background((new BackgroundFill(Color.BLACK, new CornerRadii(0), Insets.EMPTY))));

        Label Var = new Label();
        Var.setText("The variance");
        Var.setTextFill(Color.WHITE);
        Var.setFont(Font.font("Comic Sans MS", 20));
        Var.setBackground(new Background((new BackgroundFill(Color.BLACK, new CornerRadii(0), Insets.EMPTY))));


        VBox vBox = new VBox(Div, Var);
        vBox.setSpacing(40);

        Label ansDiv = new Label();
        ansDiv.setText("");
        ansDiv.setTextFill(Color.YELLOW);
        ansDiv.setFont(Font.font("Comic Sans MS", 20));
        ansDiv.setBackground(new Background((new BackgroundFill(Color.BLACK, new CornerRadii(0), Insets.EMPTY))));

        Label ansVar = new Label();
        ansVar.setText("");
        ansVar.setTextFill(Color.YELLOW);
        ansVar.setFont(Font.font("Comic Sans MS", 20));
        ansVar.setBackground(new Background((new BackgroundFill(Color.BLACK, new CornerRadii(0), Insets.EMPTY))));


        VBox vBox2 = new VBox(ansDiv, ansVar);
        vBox2.setSpacing(40);

        HBox hBox6 = new HBox(vBox, vBox2);
        hBox6.setLayoutX(140);
        hBox6.setLayoutY(120);
        hBox6.setSpacing(40);
        page8.getChildren().add(hBox6);

        stage8.setScene(scene9);
        stage8.setMaxHeight(400);
        stage8.setMinHeight(400);
        stage8.setMaxWidth(600);
        stage8.setMinWidth(600);
        stage8.setTitle("The variance , standard deviation and percentage");

        btnShowDiv.setOnAction(actionEvent -> {

            if (radioButtonScientific.isSelected() || radioButtonLiterary.isSelected()) {


                MyLinkedList selected = new MyLinkedList();
                if (radioButtonWest.isSelected()) {
                    if (radioButtonScientific.isSelected()) {
                        selected = WestBank_scientific;
                        ansVar.setText(selected.getVariance() + "");
                        ansDiv.setText(selected.getStandardDeviation() + "");

                    } else if (radioButtonLiterary.isSelected()) {
                        selected = WestBank_literary;
                        ansVar.setText(selected.getVariance() + "");
                        ansDiv.setText(selected.getStandardDeviation() + "");

                    } else {
                        ansVar.setText("");
                        ansDiv.setText("");
                    }
                } else if (radioButtonGaza.isSelected()) {
                    if (radioButtonScientific.isSelected()) {
                        selected = Gaza_scientific;
                        ansVar.setText(selected.getVariance() + "");
                        ansDiv.setText(selected.getStandardDeviation() + "");

                    } else if (radioButtonLiterary.isSelected()) {
                        selected = Gaza_literary;
                        ansVar.setText(selected.getVariance() + "");
                        ansDiv.setText(selected.getStandardDeviation() + "");

                    } else {
                        ansVar.setText("");
                        ansDiv.setText("");
                    }
                } else {
                    ansVar.setText("");
                    ansDiv.setText("");
                }
                stage8.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText(null);
                alert.setContentText("To be able to see the variance and standard deviation\nYou must select between Scientific or Literary radio buttons");
                alert.showAndWait();
            }
        });


        btnExport.setOnAction(actionEvent -> {

            if (radioButtonScientific.isSelected() || radioButtonLiterary.isSelected()) {

                try {

                    MyLinkedList selected = new MyLinkedList();
                    if (radioButtonWest.isSelected()) {
                        if (radioButtonScientific.isSelected()) {
                            selected = WestBank_scientific;
                        } else if (radioButtonLiterary.isSelected()) {
                            selected = WestBank_literary;

                        }

                    } else if (radioButtonGaza.isSelected()) {
                        if (radioButtonScientific.isSelected()) {
                            selected = Gaza_scientific;
                        } else if (radioButtonLiterary.isSelected()) {
                            selected = Gaza_literary;
                        }
                    }
                    String print = "            Tawjihi System Result\n" + "=======================================================\n" + "Top 10 student :\n" + selected.topTen() + "=======================================================\n" + "\navg: " + selected.getAverage() + "\nmode: " + selected.getMode() + "\nvariance: " + selected.getVariance()
                            + " \nmedian: " + selected.getMedian() + "\nstd deviation :" + selected.getStandardDeviation() +
                            "\n=======================================================\n" + "Percentage : " + 90 + "\nNumber of student : " + selected.getNumberPercentage(90) + "\n=======================================================\n";

                    FileChooser fileChooser1 = new FileChooser();
                    FileChooser.ExtensionFilter ext = new FileChooser.ExtensionFilter("TXT files (' txt')", "txt");
                    fileChooser1.getExtensionFilters().add(ext);


                    File file2 = fileChooser1.showSaveDialog(stage3);
                    System.out.println();

                    PrintWriter writer = new PrintWriter(file2);
                    writer.print(print);
                    writer.close();

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information");
                    alert.setHeaderText(null);
                    alert.setContentText("The information has been saved to the location you chose");
                    alert.showAndWait();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText(null);
                alert.setContentText("To be able to export the results to file\nYou must select between Scientific or Literary radio buttons");
                alert.showAndWait();
            }

        });


        //Image for prev button
        InputStream strem = new FileInputStream("C:\\Users\\twitter\\ideaProjects\\testJavaFX\\src\\sample\\prev.png");
        Image imgPrev = new Image(strem);
        ImageView viewPrev = new ImageView(imgPrev);
        viewPrev.setFitHeight(80);
        viewPrev.setFitWidth(40);
        viewPrev.setPreserveRatio(true);

        //Button Next and Exit
        Button btnPrev = new Button();
        btnPrev.setGraphic(viewPrev);
        btnPrev.setLayoutX(435);
        btnPrev.setLayoutY(185);
        page4.getChildren().add(btnPrev);

        //Btn prev set on action
        btnPrev.setOnAction(actionEvent -> {
            stage3.close();
            stage2.show();
        });


    }


    public static void main(String[] args) {
        launch(args);
    }
}

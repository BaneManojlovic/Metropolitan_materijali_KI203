/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak3;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author ladmin
 */
public class Zadatak3FX extends Application {

    Label mestoPolaska = new Label("Mesto polaska");
    Label mestoDolaska = new Label("Mesto dolaska");
    Label prevoznik = new Label("Prevoznik");
    Label cena = new Label("Cena");
    Label brojSedista = new Label("Sediste");
    Label datum = new Label("Datum");
    TextField mestoPolaskaTxt = new TextField();
    TextField mestoDolaskaTxt = new TextField();
    TextField prevoznikTxt = new TextField();
    TextField cenaTxt = new TextField();
    TextField sedisteTxt = new TextField();
    DatePicker datumDate = new DatePicker();
    Button save = new Button("Sacuvaj");
    TableView<AutobuskaKarta> table = new TableView();

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        VBox leftBox = new VBox(mestoPolaska, mestoPolaskaTxt, mestoDolaska, mestoDolaskaTxt, prevoznik, prevoznikTxt,
                cena, cenaTxt, brojSedista, sedisteTxt, datum, datumDate, save);
        leftBox.setSpacing(10);
        leftBox.setPadding(new Insets(10));
        root.setLeft(leftBox);
        try {

            table.setItems(DBUtil.getAllForTable());
            TableColumn idCol = new TableColumn<>("ID");
            idCol.setCellValueFactory(
                    new PropertyValueFactory<>("id"));
            
            
            TableColumn mestoPolaskaCol = new TableColumn<>("Mesto polaska");
            mestoPolaskaCol.setCellValueFactory(
                    new PropertyValueFactory<>("mestoPolaska"));
            
            TableColumn mestoDolaskaCol = new TableColumn<>("Mesto dolaska");
            mestoDolaskaCol.setCellValueFactory(
                    new PropertyValueFactory<>("mestoDolaska"));
            
            
            table.getColumns().addAll(idCol,mestoPolaskaCol, mestoDolaskaCol);

        } catch (SQLException ex) {
            Logger.getLogger(Zadatak3FX.class.getName()).log(Level.SEVERE, null, ex);
        }
        root.setCenter(table);

        Scene scene = new Scene(root, 600, 600);

        save.setOnAction(e -> {
            AutobuskaKarta karta = new AutobuskaKarta(mestoPolaska.getText(), mestoDolaska.getText(), prevoznik.getText(),
                    Integer.parseInt(sedisteTxt.getText()), Double.parseDouble(cenaTxt.getText()),
                    new Timestamp(System.currentTimeMillis()));

            try {
                DBUtil.addKarta(karta);
                table.refresh();
            } catch (SQLException ex) {
                Logger.getLogger(Zadatak3FX.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

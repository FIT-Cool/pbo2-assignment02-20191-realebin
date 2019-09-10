package com.febrina.controller;

import com.febrina.entity.Item;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class TokoController implements Initializable {

    @FXML
    private TextField txtNama;
    @FXML
    private TextField txtHarga;
    @FXML
    private ComboBox cbxKategori;
    @FXML
    private Button btSave;
    @FXML
    private Button btReset;
    @FXML
    private Button btUpdate;
    @FXML
    private TextField txtKategori;
    @FXML
    private Button btKategori;
    @FXML
    private TableView<Item> tbToko;
    @FXML
    private TableColumn<Item,String> colNama;
    @FXML
    private TableColumn<Item,Double> colPrice;
    @FXML
    private TableColumn<Item,String> colCategory;

    private ObservableList<Item> _items;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        _items = FXCollections.observableArrayList();
        tbToko.setItems(_items);
        colNama.setCellValueFactory(data ->{
            Item i = data.getValue();
            return new SimpleStringProperty(i.get_name());
        });
        colPrice.setCellValueFactory(data ->{
            Item i = data.getValue();
            return new SimpleDoubleProperty(i.get_price()).asObject();
        });

    }

    @FXML
    private void tableClicked(MouseEvent mouseEvent) {
        btSave.setDisable(true);
        btUpdate.setDisable(false);
        Item t = tbToko.getSelectionModel().getSelectedItem();
        txtNama.setText(t.get_name());
    }

    @FXML
    private void FSave(MouseEvent mouseEvent) {
        btSave.setDisable(false);
        btUpdate.setDisable(true);
    }

    @FXML
    private void FReset(MouseEvent mouseEvent) {
        txtHarga.clear();
        txtKategori.clear();
        txtNama.clear();

    }

    @FXML
    private void FUpdate(MouseEvent mouseEvent) {

    }
}

package com.febrina.controller;

import com.febrina.entity.Category;
import com.febrina.entity.Item;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Class TokoController
 * @author Febrina 1772006
 */

public class TokoController implements Initializable {

    @FXML
    private TextField txtNama;
    @FXML
    private TextField txtHarga;
    @FXML
    private ComboBox<Category> cbxKategori;
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
    private ObservableList<Category> _cat;
    private Item selectedItems;

    /**
     * Class initialize
     * @author Febrina 1772006
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        _cat = FXCollections.observableArrayList();
        cbxKategori.setItems(_cat);
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
        colCategory.setCellValueFactory(data ->{
            Item i = data.getValue();
            return new SimpleStringProperty(i.get_category().get_namaCat());
        });
        btUpdate.setDisable(true);
    }

    /**
     * Class tableClicked
     * @author Febrina 1772006
     */
    @FXML
    private void tableClicked(MouseEvent mouseEvent) {
        selectedItems = tbToko.getSelectionModel().getSelectedItem();
        if(selectedItems!=null){
            txtNama.setText(tbToko.getSelectionModel().getSelectedItem().get_name());
            txtHarga.setText(String.valueOf(tbToko.getSelectionModel().getSelectedItem().get_price()));
            cbxKategori.setValue(tbToko.getSelectionModel().getSelectedItem().get_category());
            btSave.setDisable(true);
            btUpdate.setDisable(false);
        }
   }

    /**
     * Class FSave
     * @author Febrina 1772006
     */
    @FXML
    private void FSave(MouseEvent mouseEvent) {
        int count = (int) _items.stream().filter(p -> p.get_name().
                equalsIgnoreCase(txtNama.getText())).count();
        if(count>0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Duplicate Name");
            alert.showAndWait();
        }else if(!txtNama.getText().trim().isEmpty()||!txtHarga.getText().trim().isEmpty()||cbxKategori.getValue()!=null){
            Item i = new Item();
            i.set_name(txtNama.getText().trim());
            Category category = new Category();
            category.set_namaCat(cbxKategori.getValue().toString());
            i.set_category(category);
            i.set_price(Double.parseDouble(txtHarga.getText()));
            _items.add(i);
            txtHarga.clear();
            txtNama.clear();
        }else if (txtNama.getText().trim().isEmpty()||txtHarga.getText().trim().isEmpty()||cbxKategori.getValue()==null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Field Name / Price / Category must be filled");
            alert.showAndWait();
        }
    }

    /**
     * Class FReset
     * @author Febrina 1772006
     */
    @FXML
    private void FReset(MouseEvent mouseEvent) {
        txtHarga.clear();
        txtKategori.clear();
        txtNama.clear();

    }

    /**
     * Class FUpdate
     * @author Febrina 1772006
     */
    @FXML
    private void FUpdate(MouseEvent mouseEvent) {
        int count = (int) _items.stream().filter(p -> p.get_name().
                equalsIgnoreCase(txtNama.getText())).count();
        if(count>1){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Duplicate Name");
            alert.showAndWait();
        }else if(!txtNama.getText().trim().isEmpty()||!txtHarga.getText().trim().isEmpty()||cbxKategori.getValue()!=null){
            selectedItems.set_name(txtNama.getText().trim());
            System.out.println(txtHarga.getText().trim());
            selectedItems.set_price(Double.parseDouble(txtHarga.getText().trim()));
            selectedItems.set_category(cbxKategori.getValue());
            txtHarga.clear();
            txtNama.clear();
        }else if (txtNama.getText().trim().isEmpty()||txtHarga.getText().trim().isEmpty()||cbxKategori.getValue()==null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Field Name / Price / Category must be filled");
            alert.showAndWait();
        }
        tbToko.refresh();
        btUpdate.setDisable(true);
        btSave.setDisable(false);
    }


    /**
     * Class btnSaveCategory
     * @author Febrina 1772006
     */
    @FXML
    private void btnSaveCategory(ActionEvent actionEvent) {
        int count = (int) _cat.stream().filter(p -> p.get_namaCat().
                equalsIgnoreCase(txtKategori.getText())).count();
        if(count>0){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Category Name duplicate");
            alert.showAndWait();
        }else if (!txtKategori.getText().trim().isEmpty()){
            Category kategori = new Category();
            kategori.set_namaCat(txtKategori.getText());
            _cat.add(kategori);
            txtKategori.clear();
        } else if(txtKategori.getText().trim().isEmpty()){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Field Category Name must be filled");
            alert.showAndWait();
        }
    }
}

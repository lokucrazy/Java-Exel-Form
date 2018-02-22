package com.javaexel;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController implements Initializable {
    
    @FXML
    private Button exp_button;
    @FXML
    private Button add_button;
    @FXML
    private TextField name_field;
    @FXML
    private TextField cond_field;
    @FXML
    private TextField quan_field;
    @FXML
    private TextArea item_field;
    
    private ArrayList<SurplusItem> items = new ArrayList<>();
    private String itemText;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        try {
            items.add(new SurplusItem(name_field.getText(),cond_field.getText(),quan_field.getText()));
            itemText += items.get(items.size()-1).toString() + "\n";
            item_field.setText(itemText);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        itemText="";
    }    
}

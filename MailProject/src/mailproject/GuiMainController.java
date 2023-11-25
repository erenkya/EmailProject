/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author z004ty7u
 */
public class GuiMainController implements Initializable {

    @FXML
    private TextField toTextField;
    @FXML
    private TextField subjectTextField;
    @FXML
    private TextArea messageTextField;
    @FXML
    private TextField pathTextField;
    @FXML
    private Label warnLabel;
    
    
    
    //true ise attachment yollamayacak
    boolean toggleAtc = true;
    
    sendEmailSsl sender = new sendEmailSsl();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        pathTextField.setDisable(true);
        this.warnLabel.setText("Attachment is not active");
    }    

    
      @FXML
    void togglePathOnAction(ActionEvent event) {
        this.toggleAtc = !this.toggleAtc;
        pathTextField.setDisable(this.toggleAtc);
        
        
        
        if(!toggleAtc){
            this.warnLabel.setText("Attachment is active");
        }else{
            this.warnLabel.setText("Attachment is not active");
        }
        
        
        
        
        

    }
    
    
    
    
    
    @FXML
    private void sendOnAction(ActionEvent event) {
        String to = toTextField.getText();
        String subject = subjectTextField.getText();
        String message = messageTextField.getText();
        
        //"C:\\Users\\z004ty7u\\OneDrive - Siemens AG\\Desktop\\sending\\aaa.xlsx"
        
        //Disabled attch
        if(this.toggleAtc){
            sender.sendMessage(to, subject, message );
        
        }//Enabled attchment
        else{
            String path = this.pathTextField.getText();
            
            if(path.equals("")){
                this.warnLabel.setText("Enter file path!!!");
            }else{
                sender.sendAtcMessage(to, subject, message ,path);
            }
  
        }
         
        
    }
    
    
    
    
    
}

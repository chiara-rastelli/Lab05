
package it.polito.tdp.anagrammi;
import it.polito.tdp.anagrammi.DAO.ParoleDAO;
import it.polito.tdp.anagrammi.model.Model;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Model model;
	
	public void setModel(Model m) {
    	this.model = m;
	} 
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInput;

    @FXML
    private Button btnCercaAnagrammi;

    @FXML
    private TextArea txtAnagrammiCorretti;

    @FXML
    private TextArea txtAnagrammiErrati;

    @FXML
    private Button btnReset;

    @FXML
    void doCercaAnagrammi(ActionEvent event) {
    //	System.out.println(this.txtInput.getText());
    	String daCercare = this.txtInput.getText();
    	System.out.println("Anagrammi parola "+daCercare+":\n");
    	List<String> listaAnagrammi = model.anagrammi(daCercare);
    	
    	List<String> anagrammiCorretti = model.paroleCorrette(listaAnagrammi);
    	List<String> anagrammiErrati = model.paroleErrate(listaAnagrammi);
    	
    	for (String s: anagrammiCorretti) {
    		this.txtAnagrammiCorretti.appendText(s+"\n");
    	}
    	
    	for (String s: anagrammiErrati) {
    		this.txtAnagrammiErrati.appendText(s+"\n");
    	}
    	
    }

    @FXML
    void doReset(ActionEvent event) {
    	this.txtInput.clear();
    	this.txtAnagrammiErrati.clear();
    	this.txtAnagrammiCorretti.clear();
    }

    @FXML
    void initialize() {
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaAnagrammi != null : "fx:id=\"btnCercaAnagrammi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAnagrammiCorretti != null : "fx:id=\"txtAnagrammiCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAnagrammiErrati != null : "fx:id=\"txtAnagrammiErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}


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
    	String daCercare = this.txtInput.toString();
    	List<String> listaAnagrammi = model.anagrammi(daCercare);
    	for (String s: listaAnagrammi) {
    	//	this.txtAnagrammiCorretti.appendText(s+"\n");
    		
    		// al posto che restituire la lista degli anagrammi sulla scena, che appunto si bloccava
    		// ho provato a vedere se stampandola su console il problema persistesse, ed in effetti
    		// l'interfaccia grafica continua a "bloccarsi" lo stesso
    		
    		System.out.println(s+"\n");
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

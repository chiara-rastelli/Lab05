package it.polito.tdp.anagrammi.model;

import java.util.List;

public class TestModel {

	public static void main(String[] args) {
		
		Model modello = new Model() ;
		
		List<String> anagrammiMamma = modello.anagrammi("mamma") ;
		System.out.println("Gli algoritmi della parola 'mamma' sono:\n");
		for (int i = 0; i<anagrammiMamma.size(); i++) {
			System.out.println(anagrammiMamma.get(i));
			}
	}
}

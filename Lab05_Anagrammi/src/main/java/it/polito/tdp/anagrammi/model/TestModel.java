package it.polito.tdp.anagrammi.model;

import java.util.List;

public class TestModel {

	public static void main(String[] args) {
		Model mod = new Model() ;
		
		List<String> ana_dog = mod.anagrammi("mamma") ;
		System.out.println(ana_dog) ;
		
		//List<String> ana_vac = mod.anagrammi("vacanze") ;
		//System.out.println(ana_vac) ;

	}
}

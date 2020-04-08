package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.anagrammi.DAO.ParoleDAO;

public class Model {
	
	ParoleDAO dbParole = new ParoleDAO();
	List<String> dizionario = this.dbParole.getTutteLeParole();
	
	private List<String> soluzione ;

	/**
	 * Restituisce gli anagrammi della parola passata come parametro
	 * @param parola da anagrammare
	 * @return lista degli anagrammi della parola data
	 */
	public List<String> anagrammi(String parola) {
		
		this.soluzione = new ArrayList<>() ;
		parola=parola.toUpperCase() ;
		
		List<Character> lettereRimanenti = new ArrayList<>() ;
		
		for(int i=0; i<parola.length(); i++) {
			lettereRimanenti.add(parola.charAt(i)) ;
		}
		
		cerca("", 0, lettereRimanenti) ; 
		System.out.println(soluzione);
		return this.soluzione ;
	}
	
	/**
	 * @param parziale anagramma parziale (numero di lettere pari al livello)
	 * @param livello livello della ricorsione
	 * @param lettereRimanenti non ancora utilizzate
	 */
	private void cerca(String parziale, int livello, List<Character> lettereRimanenti) {
		
		if(lettereRimanenti.size()==0) { 
			//ho esaurito tutte le lettere disponibili, sono nel caso finale
			//prima di restituire il risultato, verifico pero' che non sia gia' presente
			//nella soluzione, tenendo conto della possibile ripetizione di alcune lettere
			if (!this.soluzione.contains(parziale))
				this.soluzione.add(parziale) ;
		}
		
		// non mi trovo nel caso terminale, provo ad aggiungere una lettera delle rimanenti
		for(Character ch: lettereRimanenti) {
			
			//per ogni carattere rimasto faccio una prova aggiungendolo alla
			//fine dell'anagramma parziale
			
			String prova = parziale+ch;
			
			List<Character> rimanenti = new ArrayList<>(lettereRimanenti) ;
			rimanenti.remove(ch) ;
			
			//su ogni prova invoco di nuovo l'algoritmo ricorsivo, poi chiudo il for
			cerca(prova, livello+1, rimanenti);}
		}
	/**
	 * ritorna true se la parola passata come parametro (daCercare) e' presente nel dizionario, false altrimenti
	 * @param daCercare
	 * @return
	 */
	public boolean contenutaNelDizionario(String daCercare) {
		
		for(String s: this.dizionario)
			if (s.compareTo(daCercare)==0)
				return true;
		return false;
	}
	
	/**
	 * ritorna una lista contenente le sole parole corrette (presenti nel dizionario)
	 * a partire da una lista di stringhe passata come parametro
	 * @param daVerificare
	 * @return
	 */
	public List<String> paroleCorrette(List<String> daVerificare){
		List<String> corrette = new LinkedList<String>();
		for (String s : daVerificare)
			if (this.contenutaNelDizionario(s)==true)
				corrette.add(s);
		return corrette;
	}
	
	public List<String> paroleErrate(List<String> daVerificare){
		List<String> errate = new LinkedList<String>();
		for (String s : daVerificare)
			if (!this.contenutaNelDizionario(s)==true)
				errate.add(s);
		return errate;
	}
	
}
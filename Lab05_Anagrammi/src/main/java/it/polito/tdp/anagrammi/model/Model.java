package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

public class Model {
	
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
}
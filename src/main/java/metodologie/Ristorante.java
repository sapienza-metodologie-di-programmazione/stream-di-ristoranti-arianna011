package metodologie;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Classe che rappresenta un ristorante (codice da completare)
 */
public class Ristorante {
	public enum TipoRistorante {
		PIZZERIA, RISTO, BISTRO, VEGETARIANO
	}

	private String nome;
	private TipoRistorante tipo;
	private int coperti;

	public Ristorante(String nome, TipoRistorante tipo, int coperti) {
		this.nome = nome;
		this.coperti = coperti;
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public TipoRistorante getTipo() {
		return tipo;
	}

	public int getCoperti() {
		return coperti;
	}

	@Override
	public String toString() {
		return nome + ":" + tipo + ":" + coperti;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || o.getClass() != this.getClass())
			return false;
		Ristorante r = (Ristorante) o;
		return r.getNome().equals(nome) && r.getTipo().equals(tipo) && r.getCoperti() == coperti;
	}

	/**
	 * Metodo che, data in input una lista di ristoranti, stampa una riga per ogni
	 * ristorante (con nome e numero coperti), in ordine decrescente di numero di
	 * coperti
	 */
	public static void stampaPerCoperti(List<Ristorante> l) {
		// implementare
	}

	/**
	 * Metodo che, data in input una lista di ristoranti e un intero n, restituisce
	 * l’insieme dei ristoranti che hanno almeno n coperti
	 */
	public static Set<Ristorante> filtraPerCoperti(List<Ristorante> l, int n) {
		// implementare;
		return null;
	}

	/**
	 * Metodo che, data in input una lista di ristoranti, restituisce una mappa da
	 * tipo di ristorante a lista dei ristoranti di quel tipo, dove tale lista è
	 * ordinata per numero di coperti dei ristoranti
	 */
	public static Map<TipoRistorante, List<Ristorante>> mappaPerTipo(List<Ristorante> l) {
		// implementare;
		return null;
	}

	/**
	 * Metodo che, data in input una lista di ristoranti, stampa i nomi dei
	 * ristoranti in ordine alfabetico, separati da virgola
	 */
	public static void stampaNomi(List<Ristorante> l) {
		// implementare;
	}

	/**
	 * Metodo che, data in input una lista di ristoranti, restituisce la somma
	 * totale di tutti i coperti dei ristoranti nella lista
	 */
	public static int sommaCoperti(List<Ristorante> l) {
		// implementare;
		return -1;
	}

}

package metodologie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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
		l.stream().sorted(Comparator.comparing(x -> ((Ristorante) x).getCoperti()).reversed())
				.forEach(r -> System.out.println(r));
	}

	/**
	 * Metodo che, data in input una lista di ristoranti e un intero n, restituisce
	 * l’insieme dei ristoranti che hanno almeno n coperti
	 */
	public static Set<Ristorante> filtraPerCoperti(List<Ristorante> l, int n) {
		return l.stream().filter(r -> r.getCoperti() >= n).collect(Collectors.toSet());
	}

	/**
	 * Metodo che, data in input una lista di ristoranti, restituisce una mappa da
	 * tipo di ristorante a lista dei ristoranti di quel tipo, dove tale lista è
	 * ordinata per numero di coperti dei ristoranti
	 */
	public static Map<TipoRistorante, List<Ristorante>> mappaPerTipo(List<Ristorante> l) {
		return l.stream().collect(Collectors.toMap(Ristorante::getTipo, r -> List.of(r), (l1, l2) -> {
			List<Ristorante> l3 = new ArrayList<Ristorante>();
			l3.addAll(l1);
			l3.addAll(l2);
			l3.sort(Comparator.comparing(x -> ((Ristorante) x).getCoperti()));
			return l3;
		}, () -> new HashMap<TipoRistorante, List<Ristorante>>()));
	}

	/**
	 * Metodo che, data in input una lista di ristoranti, stampa i nomi dei
	 * ristoranti in ordine alfabetico, separati da virgola
	 */
	public static void stampaNomi(List<Ristorante> l) {
		System.out.println(l.stream().map(Ristorante::getNome).reduce((s, r) -> s + ", " + r).orElse(""));
	}

	/**
	 * Metodo che, data in input una lista di ristoranti, restituisce la somma
	 * totale di tutti i coperti dei ristoranti nella lista
	 */
	public static int sommaCoperti(List<Ristorante> l) {
		return l.stream().mapToInt(Ristorante::getCoperti).sum();
	}

	public static void main(String[] args) {
		List<Ristorante> risto = Arrays.asList(new Ristorante("La pergola", TipoRistorante.RISTO, 55),
				new Ristorante("L’etico", TipoRistorante.PIZZERIA, 25),
				new Ristorante("Da Rossi", TipoRistorante.RISTO, 47),
				new Ristorante("Da Gigi", TipoRistorante.PIZZERIA, 42),
				new Ristorante("Giggetto", TipoRistorante.PIZZERIA, 80),
				new Ristorante("Da Ivo", TipoRistorante.PIZZERIA, 150),
				new Ristorante("Romolo e Luigi", TipoRistorante.PIZZERIA, 50),
				new Ristorante("La terrazza", TipoRistorante.RISTO, 40));

		stampaPerCoperti(risto);
		System.out.println(filtraPerCoperti(risto, 50));
		System.out.println(mappaPerTipo(risto));
		stampaNomi(risto);
		System.out.println(sommaCoperti(risto));
	}

}


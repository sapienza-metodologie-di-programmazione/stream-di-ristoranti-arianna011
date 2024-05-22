package metodologie;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import junit.framework.TestCase;
import metodologie.Ristorante.TipoRistorante;

public class AppTest extends TestCase {

	private static final List<Ristorante> risto = Arrays.asList(new Ristorante("La pergola", TipoRistorante.RISTO, 55),
			new Ristorante("L’etico", TipoRistorante.PIZZERIA, 25),
			new Ristorante("Da Rossi", TipoRistorante.RISTO, 47),
			new Ristorante("Da Gigi", TipoRistorante.PIZZERIA, 42),
			new Ristorante("Giggetto", TipoRistorante.PIZZERIA, 80),
			new Ristorante("Da Ivo", TipoRistorante.PIZZERIA, 150),
			new Ristorante("Romolo e Luigi", TipoRistorante.PIZZERIA, 50),
			new Ristorante("La terrazza", TipoRistorante.RISTO, 40));

	private static final String print = "Da Ivo:PIZZERIA:150\r\n" + "Giggetto:PIZZERIA:80\r\n"
			+ "La pergola:RISTO:55\r\n" + "Romolo e Luigi:PIZZERIA:50\r\n" + "Da Rossi:RISTO:47\r\n"
			+ "Da Gigi:PIZZERIA:42\r\n" + "La terrazza:RISTO:40\r\n" + "L’etico:PIZZERIA:25\r\n";

	private static final String print2 = "La pergola, L’etico, Da Rossi, Da Gigi, Giggetto, Da Ivo, Romolo e Luigi, La terrazza\r\n";

	@org.junit.Test
	public void testStampaPerCoperti() {

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		Ristorante.stampaPerCoperti(risto);

		assertEquals(print, outContent.toString());
	}

	@org.junit.Test
	public void testFiltraPerCoperti() {
		Set<Ristorante> res = Ristorante.filtraPerCoperti(risto, 50);
		Set<Ristorante> sol = risto.stream().filter(r -> r.getCoperti() >= 50).collect(Collectors.toSet());

		assertEquals(res, sol);
	}

	@org.junit.Test
	public void testMappaPerTipo() {

		Map<TipoRistorante, List<Ristorante>> res = Ristorante.mappaPerTipo(risto);
		Map<TipoRistorante, List<Ristorante>> sol = risto.stream()
				.collect(Collectors.toMap(Ristorante::getTipo, r -> List.of(r), (l1, l2) -> {
					List<Ristorante> l3 = new ArrayList<Ristorante>();
					l3.addAll(l1);
					l3.addAll(l2);
					l3.sort(Comparator.comparing(x -> ((Ristorante) x).getCoperti()));
					return l3;
				}, () -> new HashMap<TipoRistorante, List<Ristorante>>()));

		assertEquals(res, sol);
	}

	@org.junit.Test
	public void testStampaNomi() {

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		Ristorante.stampaNomi(risto);

		assertEquals(print2, outContent.toString());
	}

	@org.junit.Test
	public void testSommaCoperti() {

		assertEquals(Ristorante.sommaCoperti(risto), 489);
	}

}

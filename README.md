# stream-di-ristoranti

Siano date la seguente enumerazione e la seguente classe:

```
public enum TipoRistorante
{
    PIZZERIA,
    RISTO,
    BISTRO,
    VEGETARIANO
}

public class Ristorante
{
    private String nome;
    private TipoRistorante tipo;
    private int coperti;

    public Ristorante(String nome, TipoRistorante tipo, int coperti)
    {
        this.nome = nome; this.coperti = coperti; this.tipo = tipo;
    }

    public String getNome() { return nome; }

    public TipoRistorante getTipo() { return tipo; }

    public int getCoperti() { return coperti; }

    @Override
    public String toString() { return nome+":"+tipo+":"+coperti; }
}
```

Scrivere i seguenti metodi:
- un metodo **stampaPerCoperti** che, data in input una lista di ristoranti, stampi una riga per ogni ristorante (con nome e numero coperti), in ordine decrescente di numero di coperti

- un metodo **filtraPerCoperti** che, data in input una lista di ristoranti e un intero *n*, restituisca l’insieme dei ristoranti che hanno almeno *n* coperti

- un metodo **mappaPerTipo** che, data in input una lista di ristoranti, restituisca una mappa da tipo di ristorante a lista dei ristoranti di quel tipo, dove tale lista è ordinata per numero di coperti dei ristoranti

- un metodo **stampaNomi** che, data in input una lista di ristoranti, stampi i nomi dei ristoranti in ordine alfabetico, separati da virgola

- un metodo **sommaCoperti** che, data in input una lista di ristoranti, restituisca la somma totale di tutti i coperti dei ristoranti nella lista
public class Ordinazione extends Piatto {

    private static int prezzoTotale;

    public Ordinazione(int prezzo) {
        super(prezzo);
        prezzoTotale = prezzoTotale + prezzo;
    }

    public static int getPrezzoTotale() {
        return prezzoTotale;
    }
}

import java.util.ArrayList;

public class Airline {
    private ArrayList<Airplane> aerei = new ArrayList<Airplane>();

    public ArrayList<Airplane> getAerei() {
        return aerei;
    }

    public void setAerei(ArrayList<Airplane> aerei) {
        this.aerei = aerei;
    }

    public void inserisciAereo(Airplane a) {
        aerei.add(a);
    }

    public void stampaAerei() {
        System.out.println("Ecco un elenco degli aerei presenti:");
        int i = 1;
        for (Airplane a : aerei) {
            System.out.println("\nAereo " + i + "\n" + a.toString());
            System.out.println("______________________________");
            i++;
        }
    }

    public void stampaAerei(int numeroPosti) {
        for (Airplane a : aerei) {
            if (a.getNumeroPosti() == numeroPosti) {
                System.out.println("\n" + a.toString());
                System.out.println("______________________________");
            }
        }
    }

    public void calcolaMaxCapacita() {
        int sommaCapacita = 0;
        for (Airplane a : aerei) {
            sommaCapacita = sommaCapacita + a.getCapacitaCarico();
        }
        System.out.println("La capacità di tutti gli aerei presenti in elenco è di " + sommaCapacita + "kg");
    }

    public void capacitaMassimaCargo(int capacita) {
        for (Airplane a : aerei) {
            if (a instanceof CargoPlane) {
                CargoPlane c = (CargoPlane) a;
                if (c.getMaxCapacitaCarico() > capacita) {
                    System.out.println("\n" + c.toString());
                    System.out.println("______________________________");
                }
            }
        }
    }

    public void rimuoviAereo(int indice) {
        aerei.remove(indice);
        System.out.println("Rimuovi Aereo");
    }
}

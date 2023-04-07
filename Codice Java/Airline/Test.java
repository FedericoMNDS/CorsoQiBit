import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {

    Scanner scanInt = new Scanner(System.in);
    Scanner scanString = new Scanner(System.in);

    Airline a = new Airline();

    public void menu() {
        boolean terminaProgramma = true;
        a.inserisciAereo(new CargoPlane("Cargo1", 20, 2000, 3000));
        a.inserisciAereo(new CargoPlane("Cargo2", 25, 2100, 4000));
        a.inserisciAereo(new PassengerPlane("Passeggeri1", 500, 5000, 10));
        a.inserisciAereo(new PassengerPlane("Passeggeri2", 200, 5100, 5));
        System.out.println(
                "Benvenuto nel programma Airline.");
        while (terminaProgramma) {
            try {
                System.out.println(
                        "\nScegli l'azione:\n1.Stampa aerei\n2.Inserisci un aereo\n3.Ottieni capacità di tutti gli aerei\n4.Stampa CARGO con capacità maggiore di...\n5.Rimuovi un aereo\n6.Esci");
                int scelta = scanInt.nextInt();
                switch (scelta) {
                    case 1:
                        a.stampaAerei();
                        break;
                    case 2:
                        System.out.println("Inserisci il nome:");
                        String nome = scanString.nextLine();
                        System.out.println("Inserisci il numero dei posti:");
                        int numeroPosti = scanInt.nextInt();
                        System.out.println("Inserisci la capacità di carico");
                        int capacitaCarico = scanInt.nextInt();
                        System.out.println("Che tipo di aereo vuoi inserire?\n1.Passeggeri\n2.Cargo");
                        int scelta2 = scanInt.nextInt();
                        if (scelta2 == 1) {
                            System.out.println("Inserisci il Numero di Servizi per il tuo Aereo Passggeri");
                            int numeroServizi = scanInt.nextInt();
                            a.inserisciAereo(new PassengerPlane(nome, numeroPosti, capacitaCarico, numeroServizi));
                            System.out.println("Aereo aggiunto!");
                        } else if (scelta2 == 2) {
                            System.out.println("Inserisci la capacità carico massimo del tuo cargo:");
                            int capacitaMassima = scanInt.nextInt();
                            a.inserisciAereo(new CargoPlane(nome, numeroPosti, capacitaCarico, capacitaMassima));
                            System.out.println("Aereo aggiunto!");
                        } else {
                            System.out.println("Scelta errata.");
                        }
                        break;
                    case 3:
                        a.calcolaMaxCapacita();
                        break;
                    case 4:
                        System.out.println("Inserisci la capacità maggiore da cercare");
                        int cercaCapacita = scanInt.nextInt();
                        a.capacitaMassimaCargo(cercaCapacita);
                        break;
                    case 5:
                        a.stampaAerei();
                        System.out.println("Scegli il numero dell'aereo che vuoi rimuovere");
                        int indice = scanInt.nextInt();
                        a.rimuoviAereo(indice - 1);
                        System.out.println("Aereo rimosso!");
                        break;
                    case 6:
                        terminaProgramma = false;
                        break;
                }
            } catch (Exception c) {
                if (c instanceof InputMismatchException)
                    System.out.println("Errore di input!");
                else
                    System.out.println("Errore nella selezione!");
                scanInt = new Scanner(System.in);
            }
        }
        System.out.println("PROGRAMMA TERMINATO!");
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.menu();
    }
}

import java.util.InputMismatchException;
import java.util.Scanner;

class Main {
    Scanner scanInt = new Scanner(System.in);
    Scanner scanString = new Scanner(System.in);
    Biblioteca biblioteca = new Biblioteca();
    Libro libro1 = new Libro("I promessi sposi", 4);
    Libro libro2 = new Libro("Drive", 5);
    Libro libro3 = new Libro("American Psyco", 1);

    public void menu() {
        biblioteca.aggiungiLibro(libro1);
        biblioteca.aggiungiLibro(libro2);
        biblioteca.aggiungiLibro(libro3);
        boolean esciProgramma = true;
        int indiceLibro;
        System.out.println("Salve Utente, benvenuto nel programma Biblioteca");
        while (esciProgramma) {
            try {
                System.out.println(
                        "\nSeleziona un'azione da compiere: \n1.Stampa libri\n2.Aggiungi libro\n3.Presta libro\n4.Restituisci libro\n5.Rimuovi Libro\n6.ESCI DAL PROGRAMMA.");
                int sceltaAzione = scanInt.nextInt();
                switch (sceltaAzione) {
                    case 1:
                        biblioteca.stampaLibriDisponibili();
                        break;
                    case 2:
                        System.out.println("Inserisci il nome del libro che vuoi inserire: ");
                        String nomeLibro = scanString.nextLine();
                        System.out.println("Inserisci quante copie inserire del libro: ");
                        int copieLibro = scanInt.nextInt();
                        biblioteca.aggiungiLibro(new Libro(nomeLibro, copieLibro));
                        break;
                    case 3:
                        biblioteca.stampaLibriDisponibili();
                        System.out.println("Scegli quale libro prestare dalla lista libri selezionando il suo numero:");
                        indiceLibro = scanInt.nextInt();
                        biblioteca.prestaLibro(indiceLibro - 1);
                        break;
                    case 4:
                        biblioteca.stampaLibriDisponibili();
                        System.out.println("Scegli quale libro restituire selezionando il suo numero: ");
                        indiceLibro = scanInt.nextInt();
                        biblioteca.restituisciLibro(indiceLibro - 1);
                        break;
                    case 5:
                        biblioteca.stampaLibriDisponibili();
                        System.out.println("Scegli quale libro vuoi eliminare selezionando il suo numero: ");
                        indiceLibro = scanInt.nextInt();
                        biblioteca.rimuoviLibro(indiceLibro - 1);
                        break;
                    case 6:
                        esciProgramma = false;
                        break;
                    default:
                        System.out.println("Inserimento comando errato, riprovare.");
            
                    }
                } catch (Exception c) {
                    if(c instanceof InputMismatchException)
                    System.out.println("Errore di input, riprovare!");
                    else
                    System.out.println("Errore di selezione!");
                    scanInt=new Scanner(System.in);
                }

        }
        System.out.println("Programma terminato.");

    }

    public static void main(String[] args) {
        Main m = new Main();
        m.menu();
    }
}
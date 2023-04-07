import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Menu {

    ArrayList<Piatto> piatti = new ArrayList<Piatto>();
    Scanner scanString = new Scanner(System.in);
    Scanner scanInt = new Scanner(System.in);

    public void inserisciIngredienti(String[] ingredienti) {
        int i = 0;
        for (String ingrediente : ingredienti) {
            System.out.println("Inserisci l'ingrediente numero " + (i + 1));
            ingrediente = scanString.next();
            ingredienti[i] = ingrediente;
            i++;
        }
        System.out.println("Ingredienti inseriti!");
    }

    public void stampaPiatti() {
        int i = 1;
        for (Piatto piatto : piatti) {
            System.out.println("Piatto " + i);
            System.out.print("Ingredienti: ");
            for (String ingrediente : piatto.getIngredienti()) {
                System.out.print(" | " + ingrediente + " | ");
            }
            System.out.println();
            System.out.println("Prezzo: " + piatto.getPrezzo() + " euro");
            System.out.println("Chef: " + piatto.getChef() + "\n");

            i++;
        }

    }

    public void creaPiatto() {
        System.out.println("Quanti ingredienti possiede?");
        int dimensione = scanInt.nextInt();
        String[] ingredienti = new String[dimensione];
        inserisciIngredienti(ingredienti);
        System.out.println("Inserisci il prezzo del piatto:");
        int prezzo = scanInt.nextInt();
        System.out.println("Inserisci lo Chef del piatto");
        String chef = scanString.next();
        piatti.add(new Piatto(ingredienti, prezzo, chef));
        System.out.println("Piatto creato!\n");
    }

    public void menuUtente() {
        
        boolean terminaProgramma = true;
        while (terminaProgramma) {
            try{
            System.out.println(
                    "Salve utente, scegli l'azione:\n1.Crea piatto\n2.Ordina piatto\n3.Esci e vedi il conto");
            int scelta = scanInt.nextInt();
            if (scelta == 1) {
                creaPiatto();
            } else if (scelta == 2) {
                System.out.println("\nI piatti disponibili sono: ");
                stampaPiatti();
                System.out.println("Inserisci il piatto da ordinare selezionando il suo numero");
                int ordine = scanInt.nextInt();
                Ordinazione o = new Ordinazione(piatti.get(ordine - 1).getPrezzo());
                System.out.println("Piatto ordinato!");
            } else if (scelta == 3) {
                terminaProgramma = false;
            } else {
                System.out.println("Fai una scelta corretta!");
            }
        }
        catch(Exception c){
            if(c instanceof InputMismatchException)
            System.out.println("Errore nell'input!");
            else
            System.out.println("Errore nella selezione!");
            scanInt=new Scanner(System.in);
        }
        }
        System.out.println("Il conto è: " + Ordinazione.getPrezzoTotale() + " euro");
    }

    public static void main(String[] args) {
        Menu m = new Menu();
        m.menuUtente();
    }
}
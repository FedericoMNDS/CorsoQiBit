import java.util.ArrayList;

class Biblioteca {
    private ArrayList<Libro> biblioteca = new ArrayList<Libro>();
    private ArrayList<Libro> libriPrestito = new ArrayList<Libro>();

    public ArrayList<Libro> getBiblioteca() {
        return biblioteca;
    }

    public ArrayList<Libro> getLibriPrestito() {
        return libriPrestito;
    }

    // SE IL LIBRO È DISPONIBILE TOGLIE LE COPIE DISPONIBILI E AUMENTA QUELLE
    // PRESTATE, POI SE IL LIBRO
    // NON È PRESENTE NELLA LISTA IN PRESTITO LO AGGIUNGE
    public void prestaLibro(int indiceLibro) {
        if (!biblioteca.isEmpty()) {
            if (biblioteca.get(indiceLibro).getCopieDisponibili() > 0) {
                biblioteca.get(indiceLibro).prestaLibroOperazioni();
                System.out.println("Libro prenotato!");
                if (!cercaLibro(biblioteca.get(indiceLibro), libriPrestito))
                    libriPrestito.add(biblioteca.get(indiceLibro));
            } else
                System.out.println("Non puoi prestare questo libro!");
        } else
            System.out.println("La tua biblioteca è attualmente vuota!");
    }

    // Cerca se quel libro è disponibile in quella determinata lista.
    public boolean cercaLibro(Libro libro, ArrayList<Libro> listaLibri) {
        boolean trovato = false;
        for (Libro l : listaLibri) {
            if (l.getNome().toLowerCase().equals(libro.getNome().toLowerCase())) {
                trovato = true;
                break;
            }
        }
        return trovato;
    }

    // Se il libro è presente nella lista dei libri in prestito, esegue le
    // operazioni, poi controlla anche quante copie in prestito ci sono
    // e se sono 0 lo toglie da quelli in prestito
    public void restituisciLibro(int indiceLibro) {
        if (cercaLibro(biblioteca.get(indiceLibro), libriPrestito)) {
            biblioteca.get(indiceLibro).restituisciLibroOperazioni();
            System.out.println("Libro restituito!");
            if (cercaLibro(biblioteca.get(indiceLibro), libriPrestito)
                    && biblioteca.get(indiceLibro).getCopiePrestito() <= 0) {
                libriPrestito.remove(biblioteca.get(indiceLibro));
            }
        } else
            System.out.println("Nessuna scelta corrispondente.");

    }

    // Mi aggiunge un libro alla biblioteca
    public void aggiungiLibro(Libro libro) {
        if (!cercaLibro(libro, biblioteca)) {
            biblioteca.add(libro);
            System.out.println("Libro aggiunto con successo!");
        } else
            System.out.println("Questo libro è già presente nella biblioteca!");
    }

    // Rimuove il libro in base all'indice
    public void rimuoviLibro(int indiceLibro) {
        biblioteca.remove(biblioteca.get(indiceLibro));
        System.out.println("Libro rimosso!");
    }

    public void stampaLibriDisponibili() {
        int indice = 1;
        if (!biblioteca.isEmpty()) {
            for (Libro l : biblioteca) {
                System.out.print("\n" + indice + ") \nNome: " + l.getNome());
                System.out.println(l.getCopieDisponibili() > 0 ? "\nCopie disponibili: " + l.getCopieDisponibili()
                        : "\nNON DISPONIBILE");
                indice++;
            }
            System.out.println();
        } else
            System.out.println("Nessun libro presente!");
    }
}
public class PassengerPlane extends Airplane {

    int numeroServizi;
    final String tipo = "PASSEGGERI";

    public PassengerPlane(String nome, int numeroPosti, int capacitaCarico, int numeroServizi) {
        super(nome, numeroPosti, capacitaCarico);
        this.numeroServizi = numeroServizi;
    }

    public int getNumeroServizi() {
        return numeroServizi;
    }

    public void setNumeroServizi(int numeroServizi) {
        this.numeroServizi = numeroServizi;
    }

    @Override
    public String toString() {
        String s = "Tipo: " + tipo +  "\n"
                + "Nome: " + nome + "\n"
                + "Numero Posti: " + numeroPosti + "\n"
                + "Capacità Carico: " + capacitaCarico + "kg\n"
                + "Numero di Servizi: " + numeroServizi;
        return s;
    }
    
}

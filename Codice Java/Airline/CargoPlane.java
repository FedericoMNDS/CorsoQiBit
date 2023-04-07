public class CargoPlane extends Airplane {

    private int maxCapacitaCarico;
    final private String tipo = "CARGO";

    public CargoPlane(String nome, int numeroPosti, int capacitaCarico, int maxCapacitaCarico) {
        super(nome, numeroPosti, capacitaCarico);
        this.maxCapacitaCarico = maxCapacitaCarico;
    } 

    public int getMaxCapacitaCarico() {
        return maxCapacitaCarico;
    }

    public void setMaxCapacitaCarico(int maxCapacitaCarico) {
        this.maxCapacitaCarico = maxCapacitaCarico;
    }

    @Override
    public String toString() {
        String s = "Tipo: " + tipo +  "\n"
                + "Nome: " + nome + "\n"
                + "Numero Posti: " + numeroPosti + "\n"
                + "Capacità Carico: " + capacitaCarico + "kg\n"
                + "Capacità Massima Carico: " + maxCapacitaCarico + "kg";
        return s;
    }

 

}
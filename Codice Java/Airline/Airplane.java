class Airplane{
    String nome;
    int numeroPosti;
    int capacitaCarico;
    
    public Airplane(String nome, int numeroPosti, int capacitaCarico) {
        this.nome = nome;
        this.numeroPosti = numeroPosti;
        this.capacitaCarico = capacitaCarico;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getNumeroPosti() {
        return numeroPosti;
    }
    public void setNumeroPosti(int numeroPosti) {
        this.numeroPosti = numeroPosti;
    }
    public int getCapacitaCarico() {
        return capacitaCarico;
    }
    public void setCapacitaCarico(int capacitaCarico) {
        this.capacitaCarico = capacitaCarico;
    }

    public String toString(){
        return " ";
    }

}
class Libro {
    private String nome;
    private int copieDisponibili;
    private int copiePrestito = 0;

    public Libro(String nome, int copieDisponibili) {
        this.nome = nome;
        this.copieDisponibili = copieDisponibili;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCopieDisponibili() {
        return copieDisponibili;
    }

    public void setCopieDisponibili(int copieDisponibili) {
        this.copieDisponibili = copieDisponibili;
    }

    public void prestaLibroOperazioni() {
        copieDisponibili--;
        copiePrestito++;
    }

    public void restituisciLibroOperazioni() {
        copiePrestito--;
        copieDisponibili++;
    }

    public int getCopiePrestito() {
        return copiePrestito;
    }

    public void setCopiePrestito(int copiePrestito) {
        this.copiePrestito = copiePrestito;
    }

}
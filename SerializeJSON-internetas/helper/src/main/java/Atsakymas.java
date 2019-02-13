public class Atsakymas {
    private String imonesKodas, pavadinimas;
    private double vidutinisAtlyginimas;
    private int darbuotojuSk;

    public int getDarbuotojuSk() {
        return darbuotojuSk;
    }

    public void setDarbuotojuSk(int darbuotojuSk) {
        this.darbuotojuSk = darbuotojuSk;
    }

    public String getImonesKodas() {
        return imonesKodas;
    }

    public void setImonesKodas(String imonesKodas) {
        this.imonesKodas = imonesKodas;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String paavadinimas) {
        this.pavadinimas = paavadinimas;
    }

    public double getVidutinisAtlyginimas() {
        return vidutinisAtlyginimas;
    }

    public void setVidutinisAtlyginimas(double vidutinisAtlyginimas) {
        this.vidutinisAtlyginimas = vidutinisAtlyginimas;
    }

    public Atsakymas() {
    }

    @Override
    public String toString() {
        return "Atsakymas{" +
                "imonesKodas='" + imonesKodas + '\'' +
                ", pavadinimas='" + pavadinimas + '\'' +
                ", vidutinisAtlyginimas=" + vidutinisAtlyginimas +
                ", darbuotojuSk=" + darbuotojuSk +
                '}';
    }
}

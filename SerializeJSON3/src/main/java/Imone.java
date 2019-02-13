import com.github.javafaker.Code;
import com.github.javafaker.Company;
import com.github.javafaker.Number;

public class Imone {
    private String pavadinimas;
    private String imonesKodas;
    private int darbuotojuSk;
    private double vidutinisAtlyginimas;

    public Imone(String pavadinimas, String imonesKodas, int darbuotojuSk, double vidutinisAtlyginimas) {
        this.pavadinimas = pavadinimas;
        this.imonesKodas = imonesKodas;
        this.darbuotojuSk = darbuotojuSk;
        this.vidutinisAtlyginimas = vidutinisAtlyginimas;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public String getImonesKodas() {
        return imonesKodas;
    }

    public void setImonesKodas(String imonesKodas) {
        this.imonesKodas = imonesKodas;
    }

    public int getDarbuotojuSk() {
        return darbuotojuSk;
    }

    public void setDarbuotojuSk(int darbuotojuSk) {
        this.darbuotojuSk = darbuotojuSk;
    }

    public double getVidutinisAtlyginimas() {
        return vidutinisAtlyginimas;
    }

    public void setVidutinisAtlyginimas(double vidutinisAtlyginimas) {
        this.vidutinisAtlyginimas = vidutinisAtlyginimas;
    }

    @Override
    public String toString() {
        return "Imone{" +
                "pavadinimas=" + pavadinimas +
                ", imonesKodas=" + imonesKodas +
                ", darbuotojuSk=" + darbuotojuSk +
                ", vidutinisAtlyginimas=" + vidutinisAtlyginimas +
                '}';
    }
}

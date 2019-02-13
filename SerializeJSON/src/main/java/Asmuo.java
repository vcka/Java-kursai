import java.io.Serializable;

public class Asmuo implements Serializable {
    private static final long serialVersionUID = -5845402267463913078L;
    private String vardas;
    private int amzius;

    public Asmuo() {
    }

    public Asmuo(String vardas, int amzius) {
        this.vardas = vardas;
        this.amzius = amzius;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public int getAmzius() {
        return amzius;
    }

    public void setAmzius(int amzius) {
        this.amzius = amzius;
    }

    @Override
    public String toString() {
        return "Asmuo{" +
                "vardas='" + vardas + '\'' +
                ", amzius=" + amzius +
                '}';
    }
}

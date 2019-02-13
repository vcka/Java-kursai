import com.fasterxml.jackson.annotation.JsonProperty;

public class Adresas {

    @JsonProperty("country")
    private Salis salis;
    @JsonProperty("city")
    private String miestas;
    private String gatve;
    private String namoNr;

    public Adresas() {
        // default konstruktorius bus reikalingas norint is JSON pagaminti Java objektą
    }

    public Adresas(Salis salis, String miestas, String gatve, String namoNr) {
        this.salis = salis;
        this.miestas = miestas;
        this.gatve = gatve;
        this.namoNr = namoNr;
    }

    // getteriai ir setteriai

    public Salis getSalis() {
        return salis;
    }

    public void setSalis(Salis salis) {
        this.salis = salis;
    }

    public String getMiestas() {
        return miestas;
    }

    public void setMiestas(String miestas) {
        this.miestas = miestas;
    }

    public String getGatve() {
        return gatve;
    }

    public void setGatve(String gatve) {
        this.gatve = gatve;
    }

    public String getNamoNr() {
        return namoNr;
    }

    public void setNamoNr(String namoNr) {
        this.namoNr = namoNr;
    }

    @Override
    public String toString() {
        return "Adresas{" +
                "salis=" + salis +
                ", miestas='" + miestas + '\'' +
                ", gatve='" + gatve + '\'' +
                ", namoNr='" + namoNr + '\'' +
                '}';
    }
}
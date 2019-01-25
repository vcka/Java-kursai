package lt.ok;

public class Info {
    private int id;
    private String tekstas;

    @Override
    public String toString() {
        return "Info{" +
                "id=" + id +
                ", tekstas='" + tekstas + '\'' +
                '}';
    }

    public Info(int id, String tekstas) {
        this.id = id;
        this.tekstas = tekstas;
    }

    public Info(int id) {
        this.id = id;
    }

    public Info(String tekstas) {
        this.tekstas = tekstas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTekstas() {
        return tekstas;
    }

    public void setTekstas(String tekstas) {
        this.tekstas = tekstas;
    }

    public boolean arYraTekste(String zodis) {
        if (this.tekstas.contains(zodis)) {
            return true;
        } else return false;
    }
}

public class Korta {

    public enum mostis {
        SIRDIS(1), KRYZIUS(2), VYNAS(3), bugnas(4);
        private int value;

        private mostis(int value) {
            this.value = value;
        }
    }

    private int mostis;
    private int reiksme;

    public Korta(int mostis, int reiksme) {
        this.mostis = mostis;
        this.reiksme = reiksme;
    }

    public int getMostis() {
        return mostis;
    }

    public void setMostis(int mostis) {
        this.mostis = mostis;
    }

    public int getReiksme() {
        return reiksme;
    }

    public void setReiksme(int reiksme) {
        this.reiksme = reiksme;
    }

    @Override
    public String toString() {
        return "Korta{" +
                "mostis=" + mostis +
                ", reiksme=" + reiksme +
                '}';
    }


}

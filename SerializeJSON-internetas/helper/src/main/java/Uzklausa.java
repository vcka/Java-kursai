public class Uzklausa {
    private String imonesKodas;

    public String getImonesKodas() {
        return imonesKodas;
    }

    public void setImonesKodas(String imonesKodas) {
        this.imonesKodas = imonesKodas;
    }

    public Uzklausa(String imonesKodas) {
        this.imonesKodas = imonesKodas;
    }

    public Uzklausa() {
    }

    @Override
    public String toString() {
        return "Uzklausa{" +
                "imonesKodas='" + imonesKodas + '\'' +
                '}';
    }
}

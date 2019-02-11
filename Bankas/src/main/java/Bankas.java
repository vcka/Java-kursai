import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bankas {
    private List<BankoSaskaita> bankas = new ArrayList();

    public void sukurtiBankoSaskaita(Asmuo accountHolder, double balance, Currency currency) {
        bankas.add(new BankoSaskaita(accountHolder, balance, currency));
    }

    public double gautiAsmensSaskaitosLikuti(Asmuo asmuo) {

        return bankas.stream()
                .filter(bankas -> bankas.getAccountHolder().getId() == (asmuo.getId()))
                .mapToDouble(BankoSaskaita::gautiLikuti)
                .sum();
    }

    public void pervestiPinigus(Asmuo siunejas, Asmuo gavejas, double sum, Currency currency) {
        if (gautiAsmensSaskaitosLikuti(siunejas) >= sum) {

            try {
                gautiBankoSaskaita(siunejas).nuskaiciuot(sum*currency.getRate()/gautiBankoSaskaita(siunejas).getCurrency().getRate());
                gautiBankoSaskaita(gavejas).ideti(sum*currency.getRate()/gautiBankoSaskaita(gavejas).getCurrency().getRate());
            } catch (SaskaitaNerastaException e) {
                System.out.println("Nera tokios saskaitos");
            }
        }else {
            System.out.println("Pinigu suma virsija likuti");
        }
    }

    public void inestiPiniguISaskaita(Asmuo asmuo, double sum){
        try {
            gautiBankoSaskaita(asmuo).ideti(sum);
        } catch (SaskaitaNerastaException e) {
            System.out.println("Neteisinga operacija");
        }
    }

    public void spausdintiSaskaituDuomenis(){
        System.out.println("SASKAITU DUOMENYS:");
        for (BankoSaskaita a:bankas) {
            System.out.println();
            System.out.println("Saskaitos nr.: " + a.getAccountNr());
            System.out.println("Vardas: " + a.getAccountHolder().getName());
            System.out.println("Pavarde: " + a.getAccountHolder().getLastName());
            System.out.println("Valiuta: " + a.getCurrency());
            System.out.println("Likutis: " + a.getBalance());

        }

    }

    public BankoSaskaita gautiBankoSaskaita(Asmuo asmuo) throws SaskaitaNerastaException {
        return bankas.stream()
                .filter(rasas -> asmuo.getId() == rasas.getAccountHolder().getId())
                .findFirst()
                .orElseThrow(SaskaitaNerastaException::new);
    }

    public int getId(Asmuo asmuo) {
        return asmuo.getId();
    }


    @Override
    public String toString() {
        return "Bankas{" +
                "bankas=" + bankas +
                '}';
    }
}

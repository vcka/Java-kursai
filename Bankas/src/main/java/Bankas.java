import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Bankas {
    private static final Logger LOG = LogManager.getLogger(Bankas.class);
    private List<BankoSaskaita> bankas = new ArrayList();

    public void sukurtiBankoSaskaita(Asmuo accountHolder, double balance, Currency currency) {
        bankas.add(new BankoSaskaita(accountHolder, balance, currency));
        try {
            LOG.info("Sukurta banko saskaita nr. {} asmeniui {} {}", gautiBankoSaskaita(accountHolder).getAccountNr(), accountHolder.getName(), accountHolder.getLastName());
        } catch (SaskaitaNerastaException e) {
            e.printStackTrace();
        }
    }

    public double gautiAsmensSaskaitosLikuti(Asmuo asmuo) {
        return bankas.stream()
                .filter(bankas -> bankas.getAccountHolder().getId() == (asmuo.getId()))
                .mapToDouble(BankoSaskaita::gautiLikuti)
                .sum();
    }

    public void pervestiPinigus(Asmuo siunejas, Asmuo gavejas, double sum, Currency currency) {
        try {
            LOG.info("Asmuo {} {} siuncia {}{} asmeniui {} {}", siunejas.getName(), siunejas.getLastName(), sum, gautiBankoSaskaita(siunejas).getCurrency(), gavejas.getName(), gavejas.getLastName());
        } catch (SaskaitaNerastaException e) {
            e.printStackTrace();
        }
        if (gautiAsmensSaskaitosLikuti(siunejas) >= sum) {
            try {
                gautiBankoSaskaita(siunejas).nuskaiciuoti(sum * currency.getRate() / gautiBankoSaskaita(siunejas).getCurrency().getRate());
                gautiBankoSaskaita(gavejas).ideti(sum * currency.getRate() / gautiBankoSaskaita(gavejas).getCurrency().getRate());
            } catch (SaskaitaNerastaException e) {
                LOG.info("Nera tokios saskaitos");
            }
        } else {
            LOG.info("Pinigu suma virsija likuti");
        }
    }

    public void inestiPiniguISaskaita(Asmuo asmuo, double sum) {
        try {
            gautiBankoSaskaita(asmuo).ideti(sum);
        } catch (SaskaitaNerastaException e) {
            LOG.info("Nera tokios saskaitos");
        }
    }

    public void spausdintiSaskaituDuomenis() {
        for (BankoSaskaita a : bankas) {
            LOG.info("-----------------------------------");
            LOG.info("SASKAITU DUOMENYS:");
            LOG.info("");
            LOG.info("Saskaitos nr.: {}", a.getAccountNr());
            LOG.info("Vardas: {}", a.getAccountHolder().getName());
            LOG.info("Pavarde: {}", a.getAccountHolder().getLastName());
            LOG.info("Valiuta: {}", a.getCurrency());
            LOG.info("Likutis: {}", new BigDecimal(a.getBalance()).setScale(2, RoundingMode.HALF_DOWN).doubleValue());
        }
    }

    public BankoSaskaita gautiBankoSaskaita(Asmuo asmuo) throws SaskaitaNerastaException {
        LOG.info("Ieskoma asmens {} {} banko saskaitos", asmuo.getName(), asmuo.getLastName());
        bankas.stream()
                .filter(bankoSaskaita -> asmuo.getId() == bankoSaskaita.getAccountHolder().getId())
                .findFirst()
                .ifPresent(log -> LOG.info("Saskaita {} rasta", log.getAccountNr()));
        return bankas.stream()
                .filter(rasas -> asmuo.getId() == rasas.getAccountHolder().getId())
                .findFirst()
                .orElseThrow(SaskaitaNerastaException::new);
    }
}

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BankoSaskaita {
    private static final Logger LOG = LogManager.getLogger(BankoSaskaita.class);
    private Asmuo accountHolder;
    private String accountNr;
    private double balance;
    private Currency currency;

    public BankoSaskaita(Asmuo accountHolder, double balance, Currency currency) {
        this.accountNr = generateAccount();
        this.balance = balance;
        this.accountHolder = accountHolder;
        this.currency = currency;
    }

    public double gautiLikuti(){
        return this.balance;
    }

    public void ideti(double sum){
        this.balance = Math.round(getBalance()+sum);
        LOG.info("I saskaita {} ideta {}{}", getAccountNr(), new BigDecimal(sum).setScale(2, RoundingMode.HALF_UP).doubleValue(), getCurrency());
    }

    public void nuskaiciuot(double sum){
        LOG.info("Nuo saskaitos {} nuskaiciuojama suma: {}{}", getAccountNr(), new BigDecimal(sum).setScale(2, RoundingMode.HALF_UP).doubleValue(), getCurrency());
        if(getBalance()-sum>=0){
            this.balance=getBalance()-sum;
        }else{
            LOG.info("Suma virsyja likuti!!!");
        }
    }

    public Asmuo getAccountHolder() {
        return accountHolder;
    }

    public String getAccountNr() {
        return accountNr;
    }

    public double getBalance() {
        return balance;
    }

    public Currency getCurrency() {
        return currency;
    }

    private String generateAccount(){
        return "LT" + RandomStringUtils.randomNumeric(18);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}

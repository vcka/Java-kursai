import org.apache.commons.lang3.RandomStringUtils;

public class BankoSaskaita {
    private Asmuo accountHolder;
    private String accountNr;
    private double balance;
    private Currency currency;

    public BankoSaskaita(Asmuo accountHolder, double balance, Currency currency) {
        this.accountNr = generateAccoutn();
        this.balance = balance;
        this.accountHolder = accountHolder;
        this.currency = currency;
    }

    public double gautiLikuti(){
        return this.balance;
    }

    public void ideti(double sum){
        this.balance = getBalance()+sum;
    }

    public void nuskaiciuot(double sum){
        if(getBalance()-sum>=0){
            this.balance=getBalance()-sum;
        }else{
            System.out.println("Suma virsyja likuti!!!");
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

    public void setBalance(double balance) {
        this.balance = balance;
    }



    private String generateAccoutn(){
        return "LT" + RandomStringUtils.randomNumeric(18);
    }

    @Override
    public String toString() {
        return "BankoSaskaita{" +
                "accountHolder=" + accountHolder +
                ", accountNr='" + accountNr + '\'' +
                ", balance=" + balance +
                ", currency=" + currency +
                '}';
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

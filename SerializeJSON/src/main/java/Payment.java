import java.io.Serializable;

public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;
    private Sender sender;
    private Reciever reciever;
    private int id;

    public Payment() {
    }

    public Payment(Sender sender, Reciever reciever) {
        this.sender = sender;
        this.reciever = reciever;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Sender getSender() {
        return sender;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }

    public Reciever getReciever() {
        return reciever;
    }

    public void setReciever(Reciever reciever) {
        this.reciever = reciever;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "sender=" + sender +
                ", reciever=" + reciever +
                ", id=" + id +
                '}';
    }
}

package com.company;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class Payment {
    private String id;
    private String name;
    private LocalDateTime paymentDate;
    private long recipientId;
    private long payerId;


    public static List<Payment> generate(int number) {
        String[] texts = {"Mokejismas", "Payment", "Skola", "Mokesciai", "Pasalpa", "Mistype", "Vagyste", "Dovana"};
        List<Payment> paymentList = new ArrayList<>(number);

        for (int i = 0; i < number; i++) {
            long paymentId = System.currentTimeMillis();
            int index = ThreadLocalRandom.current().nextInt(0, texts.length);
            String text = texts[index];
            //long paymentId = ThreadLocalRandom.current().nextInt(0, 2000 );
            paymentList.add(new Payment(UUID.randomUUID().toString(), text, LocalDateTime.now(), paymentId, (index * paymentId)));
        }
        return paymentList;
    }

    public Payment(String id, String name, LocalDateTime paymentDate, long recipientId, long payerId) {
        this.id = id;
        this.name = name;
        this.paymentDate = paymentDate;
        this.recipientId = recipientId;
        this.payerId = payerId;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", paymentDate=" + paymentDate +
                ", recipientId=" + recipientId +
                ", payerId=" + payerId +
                '}';
    }
}

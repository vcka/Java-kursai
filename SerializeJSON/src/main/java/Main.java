import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.*;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Payment payment1 = new Payment(new Sender("Jonas", 30), new Reciever("Juozas", 54));
//
//        System.out.println(payment1);
//
//        FileOutputStream fileOutputStream = new FileOutputStream("test.txt");
//        ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
//        oos.writeObject(payment1);
//        oos.close();


        FileInputStream fileInputStream = new FileInputStream("test.txt");
        ObjectInputStream ois = new ObjectInputStream(fileInputStream);
        Payment payment =(Payment) ois.readObject();
        ois.close();
        System.out.println(payment);
        System.out.println(payment.getSender());
        System.out.println(payment.getReciever());
//JSON
        Adresas adresas = new Adresas(Salis.LIETUVA, "Vilnius", "Sauletekio", "15");
        ObjectMapper mapper = new ObjectMapper();
        //Custom
        SimpleModule sm = new SimpleModule("adresoSerializatorius");
        sm.addSerializer(Adresas.class, new adresoSerializatorius());
        mapper.registerModule(sm);
        //END
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //i Stringa
        String s = mapper.writeValueAsString(adresas);
        System.out.println(s);
        Object o = mapper.readValue(s, Adresas.class);
        System.out.println(o);
        Map<String, Object> map = mapper.readValue(s, new TypeReference<Map<String,Object>>(){});

        System.out.println(map.entrySet());

        //Custom
        File file = new File("test.json");
        mapper.writeValue(file, adresas);
        //I Faila
        File file1 = new File("adresas.json");
        mapper.writeValue(file1, payment1);
        Payment payment2 = mapper.readValue(file1, Payment.class);
        System.out.println(payment2);
//
//        Adresas adresasIsJsonFailo = mapper.readValue(file, Adresas.class);
//
//        System.out.println(adresasIsJsonFailo.getSalis());
//        System.out.println(adresasIsJsonFailo.getMiestas());
//        System.out.println(adresasIsJsonFailo.getGatve());
//        System.out.println(adresasIsJsonFailo.getNamoNr());
//        System.out.println(adresasIsJsonFailo);
    }
}

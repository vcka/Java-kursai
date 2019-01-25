package lt.ok;

import java.util.ArrayList;

public class NutolesDiskas implements Saugykla {

    ArrayList<Info> diskas = new ArrayList<>();

    public void saugotiInfo(Info info) {
        diskas.add(info);
        System.out.println("Issaugota i diska.");
    }

    public Info rastiInfo(int id) {
        for (Info failas : diskas
        ) {
            if (failas.equals(id)) return failas;
            System.out.println("Rasta nutolusiame diske pagal id.");
        }
        System.out.println("Nerasta nutolusiame diske pagal id.");
        return null;
    }

    public Info rastiInfo(String zodis) {
        for (Info failas : diskas
        ) {
            if (failas.equals(zodis)) return failas;
            System.out.println("Rasta nutolusiame diske pagal zodi.");
        }
        System.out.println("Nerasta nutolusiame diske pagal zodi.");
        return null;
    }
}

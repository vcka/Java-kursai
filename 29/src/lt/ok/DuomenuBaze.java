package lt.ok;

import java.util.HashMap;

public class DuomenuBaze implements Saugykla {

    HashMap<Integer, Info> hmap = new HashMap<>();

    public void saugotiInfo(Info info) {
        hmap.put(info.getId(), info);
        System.out.println("Issaugota duomenu bazeje");
    }

    public Info rastiInfo(int id) {
        System.out.println(hmap.get(id));
        System.out.println("Rasta pagal id");
        return null;
    }

    public Info rastiInfo(String zodis) {
        System.out.println(hmap.containsValue(zodis));
        System.out.println("Rasta pagal zodi");
        return null;
    }
}

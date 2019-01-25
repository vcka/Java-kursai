package lt.ok;

public class Programa {

    public static void main(String[] args) {

        Saugykla nutolesDiskas = new NutolesDiskas();
        Saugykla duomenuBaze = new DuomenuBaze();

        Info info1 = new Info(1, "Labas");
        Info info2 = new Info(2, "Viso gero");

        saugoti(nutolesDiskas, info1);
        saugoti(duomenuBaze, info2);

        rastiPagalId(nutolesDiskas, 1);
        rastiPagalZodi(nutolesDiskas, "Labas");
     }

    static void saugoti(Saugykla saugykla, Info info) {
        saugykla.saugotiInfo(info);

    }

    static void rastiPagalId(Saugykla saugykla, int id) {
        System.out.println(saugykla.rastiInfo(id));
    }

    static void rastiPagalZodi(Saugykla saugykla, String zodis) {
        System.out.println(saugykla.rastiInfo(zodis));
    }
}
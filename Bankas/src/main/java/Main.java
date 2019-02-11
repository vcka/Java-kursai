public class Main {
    public static void main(String[] args) {
        Bankas bankoSaskaita = new Bankas();

        Asmuo asmuo1 = new Asmuo("Jonas", "Kaukas");
        Asmuo asmuo2 = new Asmuo("Vardenis", "Pavardenis");
        Asmuo asmuo3 = new Asmuo("Nulis", "Pinigu");

        bankoSaskaita.sukurtiBankoSaskaita(asmuo1, 100, Currency.€);
        bankoSaskaita.sukurtiBankoSaskaita(asmuo2, 1000, Currency.$);

        System.out.println(bankoSaskaita);
        System.out.println(bankoSaskaita.getId(asmuo2));

        System.out.println(bankoSaskaita.gautiAsmensSaskaitosLikuti(asmuo1));
        System.out.println(bankoSaskaita.gautiAsmensSaskaitosLikuti(asmuo2));

        bankoSaskaita.pervestiPinigus(asmuo1, asmuo2, 12, Currency.€);

        System.out.println(bankoSaskaita.gautiAsmensSaskaitosLikuti(asmuo1));
        System.out.println(bankoSaskaita.gautiAsmensSaskaitosLikuti(asmuo2));

        bankoSaskaita.inestiPiniguISaskaita(asmuo1, 2000);
        bankoSaskaita.pervestiPinigus(asmuo1, asmuo3, 100, Currency.$);

        System.out.println(bankoSaskaita.gautiAsmensSaskaitosLikuti(asmuo1));
        System.out.println(bankoSaskaita.gautiAsmensSaskaitosLikuti(asmuo2));

        bankoSaskaita.spausdintiSaskaituDuomenis();


    }
}

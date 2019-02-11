public class Main {
    public static void main(String[] args) {
        Bankas bankoSaskaita = new Bankas();

        Asmuo asmuo1 = new Asmuo("Jonas", "Kaukas");
        Asmuo asmuo2 = new Asmuo("Vardenis", "Pavardenis");
        Asmuo asmuo3 = new Asmuo("Nulis", "Pinigu");

        bankoSaskaita.sukurtiBankoSaskaita(asmuo1, 100, Currency.€);
        bankoSaskaita.sukurtiBankoSaskaita(asmuo2, 1000, Currency.$);

        bankoSaskaita.pervestiPinigus(asmuo1, asmuo2, 1200, Currency.€);

        bankoSaskaita.inestiPiniguISaskaita(asmuo1, 2000);
        bankoSaskaita.pervestiPinigus(asmuo2, asmuo1, 100, Currency.$);

        bankoSaskaita.spausdintiSaskaituDuomenis();


    }
}

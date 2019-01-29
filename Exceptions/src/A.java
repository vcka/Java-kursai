public class A {
    public static void main(String[] args) {
        B b = new B();
        try {
            b.callC();
        }catch (NullPointerException e){
            System.out.println("Ivyko klaida");
        }
    }
}

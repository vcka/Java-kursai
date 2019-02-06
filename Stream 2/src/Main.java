import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        ShopService shopService = new DefaultShopService();
        shopService.getAllShops().forEach(System.out::println);
        System.out.println(shopService.getShopById(5, ()-> new ShopView(666,"Alude")));
    }
}

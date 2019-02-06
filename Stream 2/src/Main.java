import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        ShopService shopService = new DefaultShopService();
        shopService.getAllShops().forEach(System.out::println);
        System.out.println(shopService.getShopById(5, ()-> new ShopView(666,"Alude")));
        shopService.getShopsEmployees(2).forEach(System.out::println);
        shopService.getAllEmployees().forEach(System.out::println);
        shopService.getEmployeesWithSalaryBetween(1000,1333).forEach(System.out::println);
    }

}

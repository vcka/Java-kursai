import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class DefaultShopService implements ShopService {

    private List<Shop> shops = ShopRepository.getShops();

    @Override
    public List<ShopView> getAllShops() {
        return shops.stream()
                .map(shop -> new ShopView(shop.getId(), shop.getName()))
                .collect(toList());
    }

    @Override
    public ShopView getShopById(int shopId, Supplier<ShopView> defaultValue) {
        Optional<ShopView> shopView = shops.stream()
                .filter(shop -> shop.getId()==shopId)
                .map(shop -> new ShopView(shop.getId(), shop.getName()))
                .findFirst();
        if(shopView.isPresent()){
            return shopView.get();
        }else{
            return defaultValue.get();
        }
    }

    @Override
    public List<Employee> getShopsEmployees(int shopId) {
        return shops.stream()
                .filter(shop -> shopId==shop.getId())
                .flatMap(shop -> shop.getEmployees().stream())
                .collect(toList());
    }

    @Override
    public List<Employee> getAllEmployees() {

        return shops.stream()
                .flatMap(shop -> shop.getEmployees().stream())
                .collect(toList());
    }

    @Override
    public List<Employee> getEmployeesWithSalaryBetween(int low, int max) {

        return shops.stream()
                .flatMap(shop -> shop.getEmployees().stream())
                .filter(shop -> shop.getSalary() > low && shop.getSalary() < max)
                .collect(toList());
    }

    @Override
    public List<Item> getItemsByType(Item.ItemType type) {

        return shops.stream()
                .flatMap(shop -> shop.getMerchandise().stream())
                .filter(item -> type.equals(item.getType()))
                .collect(toList());
    }

    @Override
    public Item getCheapestItem() {

        return shops.stream()
                .flatMap(shop -> shop.getMerchandise().stream())
                .min((item1, item2) -> item1.getPrice() - item2.getPrice())
                .orElseGet(() -> Item.clothingItem(0, "CheapestItem",0,1));
    }

    @Override
    public Item getMostExpensiveItem() {

        return shops.stream()
                .flatMap(shop -> shop.getMerchandise().stream())
                .max((item1, item2) -> item1.getPrice() - item2.getPrice())
                .orElseGet(() -> Item.clothingItem(0, "ExpensiveItem",0,1));
    }

    @Override
    public Map<Item.ItemType, List<Item>> getItemsGroupedByType() {

        return shops.stream()
                .flatMap(shop -> shop.getMerchandise().stream())
                .collect(Collectors.groupingBy(Item::getType));
    }

    @Override
    public Item findItemBy(Predicate<Item> condition) {

        return shops.stream()
                .flatMap(shop -> shop.getMerchandise().stream())
                .filter(condition)
                .findFirst()
                .get();
    }

    @Override
    public int getAllItemsPrice() {

        return shops.stream()
                .flatMap(shop -> shop.getMerchandise().stream())
                .mapToInt(item -> item.getQuantity()*item.getPrice())
                .sum();
    }

    @Override
    public int totalPayToEmployees(int shopId) {

        return shops.stream()
                .filter(shop -> shopId == shop.getId())
                .flatMap(shop -> shop.getEmployees().stream())
                .mapToInt(Employee::getSalary)
                .sum();
    }
}

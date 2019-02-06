import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;

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
        return shops.stream().flatMap(shop -> shop.stream())
    }

    @Override
    public List<Employee> getAllEmployees() {
        return null;
    }

    @Override
    public List<Employee> getEmployeesWithSalaryBetween(int low, int max) {
        return null;
    }

    @Override
    public List<Item> getItemsByType(Item.ItemType type) {
        return null;
    }

    @Override
    public Item getCheapestItem() {
        return null;
    }

    @Override
    public Item getMostExpensiveItem() {
        return null;
    }

    @Override
    public Map<Item.ItemType, Item> getItemsGroupedByType() {
        return null;
    }

    @Override
    public Item findItemBy(Predicate<Item> condition) {
        return null;
    }

    @Override
    public int getAllItemsPrice() {
        return 0;
    }

    @Override
    public int totalPayToEmployees(int shopId) {
        return 0;
    }
}

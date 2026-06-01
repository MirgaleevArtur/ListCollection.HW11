import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DealsManager {

    public List<String> getDeals() {
        return deals;
    }

    private final List<String> deals;

    public void printDeals() {
        if (deals.isEmpty()) {
            System.out.println("Список пуст.");
            return;
        }
        System.out.println("Ваш актуальный список дел:");
        for (int i = 0; i < deals.size(); i++) {
            System.out.println((i + 1) + ". " + deals.get(i));
        }
    }

    public void printMenu() {
        String menu = """
                0. Выход из программы
                1. Добавить дело
                2. Показать дела
                3. Удалить дело по номеру
                4. Удалить дело по названию
                5. Удалить дело по ключевому слову""";

        System.out.println(menu);
    }


    public DealsManager() {
        deals = new ArrayList<>();
    }

    public void addDeal(String deal) {
        if (deal != null && !deal.isEmpty()) {
            deals.add(deal);
            System.out.println("Добавлена задача: " + deal);
        } else {
            System.out.println("Ошибка! Задача не может быть пустой!");
        }
    }


    public void removeDealByIndex(int index) {
        if (index > 0 && index <= deals.size()) {
            String removedDeal = deals.get(index - 1);
            deals.remove(index - 1);
            System.out.println("Удалена задача № " + index + ": " + removedDeal);
        } else {
            System.out.println("Ошибка: задачи с таким номером нет.");
        }
    }

    public void removeDealByName(String name) {

        if (deals.remove(name)) {
            System.out.println("Задача " + name + " удалена!");
        } else {
            System.out.println("Ошибка: задача " + name + " не найдена в списке.");
        }
    }

    public void removeByKeyword(String keyword) {

        Iterator<String> iterator = deals.iterator();
        int count = 0;

        while (iterator.hasNext()) {
            String currentDeal = iterator.next();

            if (currentDeal.toLowerCase().contains(keyword.toLowerCase())) {
                iterator.remove();
                count++;
            }
        }

        if (count > 0) {
            System.out.println("Удалено задач: " + count);
        } else {
            System.out.println("Задач с таким словом не найдено.");
        }
    }
}

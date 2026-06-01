import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.IsIterableContaining.hasItems;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class TestDealsManagerClass {
    private DealsManager dealsManager;
    private final String dealFirst = "Купить Молоко";
    private final String dealSecond = "Позвонить Олегу";
    List<String> deals;

    @BeforeEach
    public void setUp() {
        dealsManager = new DealsManager();
        deals = dealsManager.getDeals();
    }

    @Test
    @DisplayName("Успешное добавление задачи")
    public void add_deals_success() {
        dealsManager.addDeal(dealFirst);
        dealsManager.addDeal(dealSecond);

        assertThat(deals, hasSize(2));
        assertThat(deals, hasItems(dealFirst, dealSecond));
    }


    @Test
    @DisplayName("Добавление пустой задачи")
    public void add_empty_deal() {
        dealsManager.addDeal("");
        dealsManager.addDeal(null);
        assertThat(deals, empty());
    }

    @Test
    @DisplayName("Удаление задачи по индексу")
    public void removing_deal_by_index() {
        dealsManager.addDeal(dealFirst);
        dealsManager.addDeal(dealSecond);

        dealsManager.removeDealByIndex(1);
        assertThat(deals, hasSize(1));

        assertThat(deals, not(hasItem(dealFirst)));
        assertThat(deals, hasItem(dealSecond));
    }

    @Test
    @DisplayName("Удаление задачи с невалидным индексом")
    public void removing_deal_by_invalid_index() {
        dealsManager.addDeal(dealFirst);
        dealsManager.addDeal(dealSecond);

        dealsManager.removeDealByIndex(0);
        dealsManager.removeDealByIndex(-20);
        dealsManager.removeDealByIndex(deals.size() + 1);

        assertTrue(deals.contains(dealFirst));
        assertTrue(deals.contains(dealSecond));
    }

    @Test
    @DisplayName("Удаление задачи по названию")
    public void removing_deal_by_name() {
        dealsManager.addDeal(dealFirst);
        dealsManager.addDeal(dealSecond);

        dealsManager.removeDealByName(dealFirst);
        assertEquals(1, dealsManager.getDeals().size());
        assertFalse(deals.contains(dealFirst));
        assertTrue(deals.contains(dealSecond));
    }

    @Test
    @DisplayName("Удаление задачи по несуществующему названию")
    public void removing_deal_by_invalid_name() {
        dealsManager.addDeal(dealFirst);
        dealsManager.addDeal(dealSecond);
        assertEquals(2, dealsManager.getDeals().size());

        dealsManager.removeDealByName("invalid deal");
        assertEquals(2, dealsManager.getDeals().size());
    }

    @Test
    @DisplayName("Удаление задачи по ключевому слову")
    public void removing_deal_by_keyword() {
        dealsManager.addDeal(dealFirst);
        dealsManager.removeByKeyword("Купить");

        assertFalse(deals.contains(dealFirst));
        assertTrue(deals.isEmpty());
    }

    @Test
    @DisplayName("Удаление задачи по не существующему ключевому слову")
    public void removing_deal_by_invalid_keyword() {
        dealsManager.addDeal(dealFirst);
        dealsManager.removeByKeyword("Продать");

        assertEquals(1, dealsManager.getDeals().size());
    }
}

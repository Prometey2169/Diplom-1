import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger;
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;

    @Before
    public void setUp() {
        burger = new Burger();
        Mockito.when(bun.getName()).thenReturn("white bun");
        Mockito.when(ingredient.getName()).thenReturn("sour cream");
        Mockito.when(bun.getPrice()).thenReturn(200.00F);
        Mockito.when(ingredient.getPrice()).thenReturn(200.00F);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void addBunsTest() {
        burger.setBuns(bun);
        assertEquals(bun.getName(), burger.bun.getName());
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        assertEquals("sour cream", burger.ingredients.get(0).getName());
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        assertEquals(2, burger.ingredients.size());
        burger.removeIngredient(1);
        assertEquals(1, burger.ingredients.size());
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        Ingredient firstIng = ingredient;
        Ingredient secondIng = ingredient;
        burger.addIngredient(firstIng);
        burger.addIngredient(secondIng);
        burger.moveIngredient(1, 0);
        assertEquals(secondIng, burger.ingredients.get(0));
        assertEquals(firstIng, burger.ingredients.get(1));
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float expectedPrice = bun.getPrice() * 2 + ingredient.getPrice();
        assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptOfBurgerTest() {
        burger.setBuns(bun);
        Ingredient firstIng = ingredient;
        Ingredient secondIng = ingredient;
        burger.addIngredient(firstIng);
        burger.addIngredient(secondIng);
        assertEquals("(==== white bun ====)\r\n" +
                "= sauce sour cream =\r\n" +
                "= sauce sour cream =\r\n" +
                "(==== white bun ====)\r\n" +
                "\r\n" +
                "Price: 800,000000\r\n", burger.getReceipt());
    }
}

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientParameterizedTest {
    private final IngredientType typeExpected;
    private final String nameExpected;
    private final float priceExpected;

    public IngredientParameterizedTest(IngredientType typeExpected, String nameExpected, float priceExpected) {
        this.typeExpected = typeExpected;
        this.nameExpected = nameExpected;
        this.priceExpected = priceExpected;
    }


    @Parameterized.Parameters(name = "Тип ингредиента: {0}, Имя ингредиента: {1}, Цена ингредиента: {2}")
    public static Object[][] getIngredientData() {
        return new Object[][]{
                {FILLING, "dinosaur", 200},
                {SAUCE, "hot sauce", 100},
        };
    }
    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(typeExpected, nameExpected, priceExpected);
        assertEquals(priceExpected, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(typeExpected, nameExpected, priceExpected);
        assertEquals(nameExpected, ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(typeExpected, nameExpected, priceExpected);
        assertEquals(typeExpected, ingredient.getType());
    }
}


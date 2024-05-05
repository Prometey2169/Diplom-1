import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    Bun bun = new Bun("red bun", 300.00f);

    @Test
    public void getName() {
        assertEquals("red bun", bun.getName());
    }

    @Test
    public void getPrice() {
        assertEquals(300.00F, bun.getPrice(), 0);
    }
}

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    @Test
    void testIsUnder10() {
        assertTrue(Main.isUnder10(9));
        assertFalse(Main.isUnder10(10));
    }

    @Test
    void testIsUnder18() {
        assertTrue(Main.isUnder18(17));
        assertFalse(Main.isUnder18(18));
    }

    @Test
    void testIsFromWarsaw() {
        assertTrue(Main.isFromWarsaw("Warsaw"));
        assertFalse(Main.isFromWarsaw("Krakow"));
    }

    @Test
    void testCheckDiscount() {
        assertEquals(100, Main.checkDiscount(9, "Warsaw"));
        assertEquals(60, Main.checkDiscount(17, "Warsaw"));
        assertEquals(50, Main.checkDiscount(17, "Krakow"));
        assertEquals(10, Main.checkDiscount(19, "Warsaw"));
        assertEquals(0, Main.checkDiscount(19, "Krakow"));
    }

    @Test
    void testCheckPrice() {
        assertEquals(40.0, Main.checkPrice(0));
        assertEquals(20.0, Main.checkPrice(50));
        assertEquals(0.0, Main.checkPrice(100));
    }

    @Test
    void testToString() {
        assertEquals(LocalDate.now() + ": Warsaw, 9 years old, " + LocalDate.now().getDayOfWeek().name() +
                " Ticket price: 120.0 PLN Discount: 20%", Main.toString(LocalDate.now(), "Warsaw", 9,
                LocalDate.now().getDayOfWeek().name(), 120.0, 20));
    }
}
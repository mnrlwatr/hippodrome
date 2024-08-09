import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HippodromeTest {

    @Test
    void nullHorsesListException() {
        Exception exception=assertThrows(IllegalArgumentException.class, () -> new Hippodrome(null));
        assertEquals("Horses cannot be null.", exception.getMessage());
    }
}

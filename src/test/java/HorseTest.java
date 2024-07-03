import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HorseTest {
    @Test
    void whenAssertingException(){
        Throwable exeption = assertThrows(IllegalArgumentException.class,
                ()->{
            new Horse(null,100,500);
                });
        assertEquals("Name cannot be null.",exeption.getMessage());
    }
}

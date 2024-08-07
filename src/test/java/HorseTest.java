

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class HorseTest {
    /*
    The test stops when the first of these assertions fail.
    This means that we don’t find out if any of the later assertions would have passed or failed, which can increase debugging time.
    We can solve this problem by wrapping multiple assertions up into a single action (using assertAll() method).
     */

    @Test
    void nullNameException() {
        assertThrows(IllegalArgumentException.class, () -> new Horse(null, 100, 500));
    }

    @Test
    void nullNameExceptionMessage() {
        try {
            new Horse(null, 100, 500);
            fail("IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Name cannot be null.", e.getMessage());
        }

    }

    @ParameterizedTest
    @MethodSource("stringArgsProvider")
    void blankNameCheck(String arguments) {
        assertThrows(IllegalArgumentException.class, () -> new Horse(arguments, 100, 500));
    }

    @ParameterizedTest
    @MethodSource("stringArgsProvider")
    void blankNameExceptionMessage (String arguments) {
        try {
            new Horse(arguments, 100, 500);
            fail("IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Name cannot be blank.", e.getMessage());
        }
    }

    static Stream<String> stringArgsProvider() {
        return Stream.of("", " ", "\n", "\t", "\n\n", "\t\t");
    }

    @Test
    void negativeSpeedException() {
        Throwable exeption = assertThrows(IllegalArgumentException.class,
                () -> new Horse("petr", -100, 500));
        assertEquals("Speed cannot be negative.", exeption.getMessage());
    }

    @Test
    void negativeDistanceException() {
        Throwable exeption = assertThrows(IllegalArgumentException.class,
                () -> new Horse("petr", 100, -500));
        assertEquals("Distance cannot be negative.", exeption.getMessage());
    }

    @Test
    void getName() {
        Horse horse = new Horse("Name", 200, 1000);
        assertEquals("Name", horse.getName());
    }

    @Test
    void getSpeed() {
        Horse horse = new Horse("Name", 200, 1000);
        assertEquals(200, horse.getSpeed());
    }

    @Test
    void getDistance() {
        Horse horse = new Horse("Name", 200, 1000);
        assertEquals(1000, horse.getDistance());
        Horse horse2 = new Horse("Name", 200);
        assertEquals(0, horse2.getDistance());

    }

    @Test
    public void isCalledGetRandomDouble() {

    }


}

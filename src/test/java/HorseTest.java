import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.concurrent.Semaphore;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class HorseTest {
    /*
    The test stops when the first of these assertions fail.
    This means that we don’t find out if any of the later assertions would have passed or failed, which can increase debugging time.
    We can solve this problem by wrapping multiple assertions up into a single action (using assertAll() method).
     */

    @Test
    void nullName() {
        Throwable exeption = assertThrows(IllegalArgumentException.class,
                () -> {
                    new Horse(null, 100, 500);
                });
        assertEquals("Name cannot be null.", exeption.getMessage());
    }

    @ParameterizedTest
    @MethodSource("stringArgsProvider")
    void blankName(String arguments) {
        Throwable exeption = assertThrows(IllegalArgumentException.class,
                () -> {
                    new Horse(" \n", 100, 500);
                });
        assertEquals("Name cannot be blank.", exeption.getMessage());
    }

    static Stream<String> stringArgsProvider() {
        return Stream.of("", "  ", "\n\n", "\t\t");
    }

    @Test
    void negativeValueSpeed(){
        Throwable exeption = assertThrows(IllegalArgumentException.class,
                () -> {
                    new Horse("petr", -100, 500);
                });
        assertEquals("Speed cannot be negative.", exeption.getMessage());
    }

    @Test
    void negativeValueDistance(){
        Throwable exeption = assertThrows(IllegalArgumentException.class,
                () -> {
                    new Horse("petr", 100, -500);
                });
        assertEquals("Distance cannot be negative.", exeption.getMessage());
    }

    @Test
    void getName (){
        Horse horse = new Horse("Name",200,1000);
        assertEquals("Name", horse.getName());
    }
    @Test
    void getSpeed (){
        Horse horse = new Horse("Name",200,1000);
        assertEquals(200, horse.getSpeed());
    }
    @Test
    void getDistance (){
        Horse horse = new Horse("Name",200,1000);
        assertEquals(1000, horse.getDistance());
        Horse horse2 = new Horse("Name",200);
        assertEquals(0, horse2.getDistance());

    }



}

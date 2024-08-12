import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class HippodromeTest {

    @Test
    void nullHorsesListException() {
        Exception exception=assertThrows(IllegalArgumentException.class, () -> new Hippodrome(null));
        assertEquals("Horses cannot be null.", exception.getMessage());
    }

    @Test
    void emptyHorsesListException(){
        Exception exception=assertThrows(IllegalArgumentException.class, () -> new Hippodrome(new ArrayList<>()));
        assertEquals( "Horses cannot be empty.", exception.getMessage());
    }

    @Test
    void getHorses(){
        List<Horse> horses = new ArrayList<>();
        Random random = new Random();
        for (int i = 1; i <31; i++) {
            horses.add(new Horse("H"+i, random.nextInt(10,51), random.nextInt(100,501)));
        }
        Hippodrome hippodrome = new Hippodrome(horses);
        List<Horse> listFromGetHorse = hippodrome.getHorses();
        assertIterableEquals(horses,listFromGetHorse);
    }
}

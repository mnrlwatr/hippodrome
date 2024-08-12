
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

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

    @Test
    void moveInvocationByEachHorse (){
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i <50; i++) {
            horses.add(mock(Horse.class));
        }
        Hippodrome hippodrome = new Hippodrome(horses);

        hippodrome.move();

        for (Horse horse : horses) {
            Mockito.verify(horse).move();
        }

    }

    @Test
    void getWinner(){
        List<Horse> horses = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
           horses.add(new Horse("H"+i, i, i));
        }
        Hippodrome hippodrome = new Hippodrome(horses);

        assertSame(horses.get(horses.size()-1),hippodrome.getWinner());
    }
}

package lektion16;

import lektion16.schach.stack.inheritance.StackKomp;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StackTest {

    public void testPushAnsPop() {
        //Arrange
        StackKomp stack = new StackKomp();
        //ACT
        stack.push("erster Element");
        stack.push("zweites Element");
        stack.push("drittes Element");

        //Asserts
        assertEquals("Drittes Element", stack.pop());
        assertEquals("Zweites Element", stack.pop());
        assertEquals("Erstes Element", stack.pop());

    }
    @Test
    public void testPop() {
        //Arrange
        StackKomp stack = new StackKomp();
        //Axt & Asserts
        assertThrows(IllegalStateException.class, () -> {
            stack.pop();
        }, "Es sollte eine Exception geworfen werden, wenn der Stack leer ist.");

    }
}

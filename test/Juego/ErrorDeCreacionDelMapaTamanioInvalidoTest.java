package Juego;

import org.junit.Test;

public class ErrorDeCreacionDelMapaTamanioInvalidoTest {
    @Test
    public void testFooThrowsIndexOutOfBoundsException() {
        boolean thrown = false;

        try {
            throw (new ErrorDeCreacionDelMapaTamanioInvalido());
        } catch (ErrorDeCreacionDelMapaTamanioInvalido e) {
            thrown = true;
        }

        assert(thrown);
    }
}

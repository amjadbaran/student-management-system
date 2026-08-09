package amjad.sms;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class AppTest {

    @Test
    public void testAppMainExecution() {
        // Simulate user entering '6' (Exit option) so the loop terminates immediately
        String simulatedInput = "6\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        // Verify that running the main method executes without throwing any exceptions
        assertDoesNotThrow(() -> {
            App.main(new String[]{});
        });
    }
}
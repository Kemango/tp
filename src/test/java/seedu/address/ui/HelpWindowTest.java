package seedu.address.ui;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.CountDownLatch;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javafx.application.Platform;
import javafx.stage.Stage;

/**
 * Contains tests for {@code HelpWindow}.
 */
public class HelpWindowTest {

    @BeforeAll
    public static void initToolkit() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        try {
            Platform.startup(latch::countDown);
        } catch (IllegalStateException e) {
            latch.countDown();
        }
        latch.await();
    }

    @Test
    public void constructorSuccess() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        Platform.runLater(() -> {
            try {
                HelpWindow helpWindow = new HelpWindow(new Stage());

                helpWindow.show();
                assertTrue(helpWindow.isShowing());

                helpWindow.hide();
                assertFalse(helpWindow.isShowing());
            } finally {
                latch.countDown();
            }
        });

        latch.await();
    }
}

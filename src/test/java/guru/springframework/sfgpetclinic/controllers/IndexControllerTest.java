package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.fail;

class IndexControllerTest {
    private static IndexController indexController;

    @BeforeAll
    static void beforeAll() {
        indexController = new IndexController();
    }

    @BeforeEach
    void setUp() {
    }

    @Test
    void index() {
        assertEquals("index", indexController.index());
    }

    @Test
    void oupsHandler() {
        assertThrows(ValueNotFoundException.class, () -> indexController.oupsHandler());
    }

    @Test
    void testTimeout() {
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);
            System.out.println("I got here");
        });
    }
    @Test
    void testTimeoutGood() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(150);
            fail("Can't be run");
        });
    }
}

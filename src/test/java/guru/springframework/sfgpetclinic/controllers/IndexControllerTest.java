package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

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
        assertThat(indexController.index()).isEqualTo("index");
    }

    @Test
    void oupsHandler() {
        assertThrows(ValueNotFoundException.class, () -> indexController.oupsHandler());
    }

    @Disabled
    @Test
    void testTimeout() {
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);
            System.out.println("I got here");
        });
    }

    @Disabled
    @Test
    void testTimeoutGood() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(150);
            fail("Can't be run");
        });
    }

    @Test
    void testAssumptionTrue() {
        assumeTrue("GURU".equalsIgnoreCase("GURU"));
    }

    @EnabledOnOs(OS.WINDOWS)
    @Test
    void testOnWindows() {
    }

    @EnabledOnOs(OS.LINUX)
    @Test
    void testOnLinux() {
        fail("Test must run");
    }
}

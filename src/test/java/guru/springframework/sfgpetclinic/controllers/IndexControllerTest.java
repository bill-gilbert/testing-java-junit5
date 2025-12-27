package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.JRE;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class IndexControllerTest {

    IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    @DisplayName("Test proper View name")
    @Test
    void index() {
        assertEquals("index", controller.index(), "Wrong View return");
    }

    @DisplayName("Test exception")
    @Test
    void oupsHandler() {
        // assertEquals("notimplemented", controller.oupsHandler(), () -> "Wrong View return");
        assertThrows(ValueNotFounException.class, ()-> controller.oupsHandler());
    }

    @Disabled("Demo of timeout")
    @Test
    void testTimeout() {
        assertTimeout(Duration.ofMillis(100), () -> Thread.sleep(20));
    }

    @Disabled("Demo of timeout")
    @Test
    void testTimeoutPrempt() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> Thread.sleep(20));
    }

    @Test
    void testAssumptionTrue() {
        assumeTrue("GURU".equalsIgnoreCase("GURU"));
    }

    @Test
    void testAssumptionFalse() {
        assumeTrue("GURU".equalsIgnoreCase("NOT_GURU"));
    }

    @EnabledOnJre(JRE.JAVA_11)
    @Test
    void enableOnJre21() {
    }
}
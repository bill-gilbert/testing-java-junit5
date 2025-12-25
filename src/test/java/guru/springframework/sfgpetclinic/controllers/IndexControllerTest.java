package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {

    IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    @Test
    void index() {
        assertEquals("index", controller.index(), "Wrong View return");
        assertEquals("index", controller.index(), "Wrong View return");
    }

    @Test
    void oupsHandler() {
        assertTrue("index2".equals(controller.index()), ()->"Wrong View return");
    }
}
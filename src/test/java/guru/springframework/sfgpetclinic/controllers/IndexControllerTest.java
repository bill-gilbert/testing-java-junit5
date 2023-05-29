package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        assertEquals("notimplemented", indexController.oupsHandler());
    }
}

package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("model")
class PersonTest {

    @BeforeEach
    void beforeEach() {

    }

    @Test
    void groupAssert() {
        Person person = new Person(1L, "Joe", "Down");
        assertAll("Check Person",
                () -> assertEquals("Joe", person.getFirstName()),
                () -> assertEquals("Down", person.getLastName()));
        assertEquals(Long.valueOf(1), person.getId(), "Id must be equals");
    }
}

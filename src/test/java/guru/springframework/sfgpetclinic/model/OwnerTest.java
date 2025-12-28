package guru.springframework.sfgpetclinic.model;


import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OwnerTest {

    @Test
    void dependentAssertions() {
        Owner owner = new Owner(1L, "Joe", "Buck");
        owner.setCity("Key West");
        owner.setTelephone("1231231234");

        assertAll("Properties Test",
                () -> assertAll("Person Properties",
                        () -> assertEquals("Joe", owner.getFirstName()),
                        () -> assertEquals("Buck", owner.getLastName(), ()->"Last name should match")),
                        () -> assertAll("Owner Properties",
                                () -> assertEquals("Key West", owner.getCity(), "City should match")),
                        () -> assertEquals("1231231234", owner.getTelephone(), "Telephone should match"));

        assertThat(owner.getCity(), is("Key West"));
    }
}
package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.map.OwnerMapService;
import guru.springframework.sfgpetclinic.services.map.PetMapService;
import guru.springframework.sfgpetclinic.services.map.PetTypeMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Owner map Service Test -")
public class OwnerMapserviceTest {
    OwnerMapService ownerMapService;
    PetTypeService petTypeService;
    PetService petService;

    @BeforeEach
    void setUp() {
        petTypeService = new PetTypeMapService();
        petService = new PetMapService();
        ownerMapService = new OwnerMapService(petTypeService, petService);
        System.out.println("First before Each");
    }

    @DisplayName("Verify Zero Owners")
    @Test
    void ownerAreZero() {
        int ownerCount = ownerMapService.findAll().size();
        assertThat(ownerCount).isZero();
    }

    @DisplayName("Pet Type - ")
    @Nested
    class TestCreatePetTypes {
        @BeforeEach
        void setUp() {
            PetType petType = new PetType(1L, "Dog");
            PetType petType2 = new PetType(2L, "Cat");
            petTypeService.save(petType);
            petTypeService.save(petType2);
            System.out.println("Nested before Each");
        }

        @Test
        void testPetCount() {
            int petTypeCount = petTypeService.findAll().size();
            assertThat(petTypeCount).isNotZero().isEqualTo(2);
        }

        @DisplayName("Save owner Tests - ")
        @Nested
        class SaveOwnersTests {
            @BeforeEach
            void setUp() {
                ownerMapService.save(new Owner(1L, "Before", "Each"));
                System.out.println("Saved Owner Before Each");
            }

            @Test
            void saveOwner() {
                Owner owner = new Owner(2L, "Joe", "Buck");
                Owner savedOwner = ownerMapService.save(owner);
                assertThat(savedOwner).isNotNull();
            }

            @DisplayName("Save owner Tests - ")
            @Nested
            class FindOwnersTests {
                @Test
                void findOwner() {
                    Owner owner = ownerMapService.findById(1L);
                    assertThat(owner).isNotNull();
                }

                @Test
                void findOwnerNotFound() {
                    Owner owner = ownerMapService.findById(2L);
                    assertThat(owner).isNull();
                }

            }
        }
    }


    @DisplayName("Verify Zero Owners")
    @Test
    void ownerAreStillZero() {
        int ownerCount = ownerMapService.findAll().size();
        assertThat(ownerCount).isZero();
    }
}

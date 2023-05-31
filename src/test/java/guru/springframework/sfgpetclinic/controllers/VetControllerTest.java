package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.fauxspring.ModelMapImpl;
import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.SpecialityMapService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class VetControllerTest {
    VetService vetService;
    VetController vetController;

    @BeforeEach
    void setUp() {
        SpecialtyService specialtyService = new SpecialityMapService();
        vetService = new VetMapService(specialtyService);
        vetController = new VetController(vetService);

        Vet jimmy = new Vet(1L, "Jimmy", "Doe", Set.of(new Speciality(1L, "Therapy")));
        Vet alex = new Vet(2L, "Alex", "Smirnoff", Set.of(new Speciality(2L, "Surgery")));
        vetService.save(jimmy);
        vetService.save(alex);
    }

    @Test
    void listVets() {
        ModelMapImpl model = new ModelMapImpl();
        String view = vetController.listVets(model);
        assertThat(view).isEqualTo("vets/index");
        assertThat(model.getMap().size()).isEqualTo(1);
        assertThat(((Set)model.getMap().get("vets")).size()).isEqualTo(2);
    }
}

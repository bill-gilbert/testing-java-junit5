package guru.springframework.sfgpetclinic.controllers;

public class ValueNotFounException extends RuntimeException {
    public ValueNotFounException(String message) {
        super(message);
    }

    public ValueNotFounException() {
        super();
    }
}


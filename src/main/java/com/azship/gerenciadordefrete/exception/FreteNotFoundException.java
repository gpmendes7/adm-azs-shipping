package com.azship.gerenciadordefrete.exception;

import jakarta.persistence.EntityNotFoundException;

public class FreteNotFoundException extends EntityNotFoundException {
    public FreteNotFoundException(Long id) {
        super(String.format("Frete com id %s não existe!", id));
    }
}

package com.trstore.usermanagement.exception;

import org.springframework.data.crossstore.ChangeSetPersister;

public class ResourceNotFoundException extends ChangeSetPersister.NotFoundException {
    public ResourceNotFoundException(String s) {
    }
}

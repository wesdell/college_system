package com.wesdell.college_system.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String entityName, Long id) {
        super(entityName + " with id " + id + " not found");
    }
}

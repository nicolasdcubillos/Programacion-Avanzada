package com.puj;

public class EdadInvalidaException extends Exception {
    public EdadInvalidaException() {
        super("Ocurrio un error, la edad es invalida.");
    }
}

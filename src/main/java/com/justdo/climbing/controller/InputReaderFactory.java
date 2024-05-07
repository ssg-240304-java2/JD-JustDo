package com.justdo.climbing.controller;

public class InputReaderFactory {
    private static InputReader inputReader;

    public static InputReader getInputReader() {
        if (inputReader == null) {
            inputReader = new InputReader();
        }
        return inputReader;
    }
}
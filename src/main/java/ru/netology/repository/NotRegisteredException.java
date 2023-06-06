package ru.netology.repository;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String playerName) {
        super("Игрок с именем " + playerName + " не зарегистрирован");
    }
}

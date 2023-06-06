package ru.netology.repository;

import ru.netology.domain.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);

    }

    public int round(String playerName1, String playerName2) {
        Player player1 = null; // для раунда заводим "пустого" игрока1
        Player player2 = null; //.. и игрока2
        for (Player player : players) {  //выбираем игроков среди зарегистрированных
            if (player.getName().equals(playerName1)) {
                player1 = player;
            }
            if (player.getName().equals(playerName2)) {
                player2 = player;
            }
        }

        if (player1 == null) {  //если игрока1 не находим - исключение
            throw new NotRegisteredException(playerName1);
        }
        if (player2 == null) {   //если игрока2 не находим - исключение
            throw new NotRegisteredException(playerName2);
        }

        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        if (player1 == player2) {
            System.out.println("Игрок не может сражаться сам с собой");
        }
        return 0;

    }

}

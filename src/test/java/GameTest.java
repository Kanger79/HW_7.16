import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Player;
import ru.netology.repository.Game;
import ru.netology.repository.NotRegisteredException;

public class GameTest {


    @Test
    public void playerName1Win() { // игрок1 сильнее чем игрок2
        Player name1 = new Player(2, "name1", 25);
        Player name2 = new Player(4, "name2", 24);
        Player name3 = new Player(5, "name3", 28);

        Game game = new Game();

        game.register(name1);
        game.register(name2);
        game.register(name3);

        int actual = game.round("name1", "name2");
        int expected = 1;

        Assertions.assertEquals(expected, actual);

        System.out.println("Тест-1_Игрок-1 (Id - " + name1.getId() + ", сила " + name1.getStrength() + "), сильнее чем Игрок-2 (Id - " + name2.getId() + ", сила " + name2.getStrength() + ")");
    }

    @Test
    public void playerName2Win() { // Игрок2 слабее чем игрок1
        Player name1 = new Player(2, "name1", 25);
        Player name2 = new Player(4, "name2", 24);
        Player name3 = new Player(5, "name3", 28);

        Game game = new Game();

        game.register(name1);
        game.register(name2);

        int actual = game.round("name2", "name1");
        int expected = 2;

        Assertions.assertEquals(expected, actual);

        System.out.println("Тест-2_Игрок-2 (сила " + name2.getStrength() + "), слабее чем Игрок-1 (сила " + name1.getStrength() + ")");
    }

    @Test
    public void playerName2EqualPlayerName1() { // Игроки равны

        Player name2 = new Player(4, "name2", 28);
        Player name3 = new Player(5, "name3", 28);

        Game game = new Game();

        game.register(name3);
        game.register(name2);

        int actual = game.round("name2", "name3");
        int expected = 0;

        Assertions.assertEquals(expected, actual);

        System.out.println("Тест-3_Игрок-2 (сила " + name2.getStrength() + "), равен по силе Игроку-3 (сила " + name3.getStrength() + ")");
    }

    @Test
    public void oneOfPlayersNotRegistered() { // Один из игроков не зарегистрирован
        Player name1 = new Player(2, "name1", 25);
        Player name2 = new Player(4, "name2", 28);

        Game game = new Game();

        game.register(name1);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("name1", "name2");
        });

        System.out.println("Тест-4_Игрок name2 не зарегистрирован");
    }

    @Test
    public void twoPlayersNotRegistered() { // Оба игрока не зарегистрированы
        Player name1 = new Player(2, "name1", 25);
        Player name2 = new Player(4, "name2", 28);

        Game game = new Game();

//        game.register(name1);
//        game.register(name2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("name1", "name2");
        });

        System.out.println("Тест-5_Игроки name1 и name2 не зарегистрированы");
    }

    @Test
    public void byMyself() { // сам с собой
        Player name1 = new Player(2, "name1", 25);
        Player name2 = new Player(4, "name2", 28);

        System.out.print("Тест-6_");
        Game game = new Game();

//        game.register(name1);
        game.register(name2);

        int actual = game.round("name2", "name2");
        int expected = 0;
        Assertions.assertEquals(expected, actual);

    }

}

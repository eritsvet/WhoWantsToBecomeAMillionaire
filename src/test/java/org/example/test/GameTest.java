package org.example.test;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class GameTest {
    Game game = new Game();
    @Дано("пользователь запустил игру")
    public void пользовательЗапустилИгру() {
        assertNotNull("Игра не запущена",game);
        System.out.println("Игра запустилась");
    }
    @Когда("программа вызывает метод fillQuestions")
    public void программаВызываетМетодFillQuestions() {
        game.fillQuestions();
        assertNotNull("Метод не запустился",game.getQuestions());
        System.out.println("Метод запустился");
    }
    @Тогда("массив с вопросами и ответами заполнится")
    public void массивСВопросамиИОтветамиЗаполнится() {
        HashMap<String, List<String>> array = new HashMap<>();
        array.put("2 + 2 = ?", List.of("1", "2", "3", "4"));
        array.put("Лучший ВУЗ страны?", List.of("Mirea", "HSE", "MAI", "Bauman"));
        array.put("Столица Латвии?", List.of("Польша", "Алматы", "Рига", "Рязань"));
        array.put("Кто написал пьесу 'На дне'", List.of("Островский", "Горький", "Гоголь", "Тургенев"));

        assertEquals("Массив не заполнен, либо заполнен неправильно",game.getQuestions(), array);
        System.out.println("Массив успешно заполнился");
    }

    @Дано("пользователь верно ответил на вопрос")
    public void пользовательВерноОтветилНаВопрос() {
        game.fillQuestions();
        assertTrue("Пользователь ответил неверно",game.checkAnswer("D",0));
        System.out.println("Пользователь ответил верно");
    }
    @Когда("программа вызывает метод earnMoney")
    public void программаВызываетМетодEarnMoney() {
        assertNotNull("Ошибка при вызове метода",game.earnMoney(game.getMoney(), 0));
        System.out.println("Метод успешно вызвался");
    }
    @Тогда("деньги добавятся на счёт игрока")
    public void деньгиДобавятсяНаСчётИгрока() {
        assertEquals("Деньги зачислились неправильно",game.getMoney(), 4000);
        System.out.println("Деньги успешно зачислились");
    }
}

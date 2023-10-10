package org.example.test;

public class Main {
    public static void main(String[] args) {
        System.out.println("""
                <-{Добро пожаловать в игру "Кто хочет стать миллионером?"}->
                Правила: Всего 4 вопроса, на каждый есть 4 варианта ответа, но только один верный
                Сумма выигрыша зависит от количества отгаданных вопросов
                Начинаем!
                """);
        Game game = new Game ();
        game.fillQuestions();
        game.start();
    }
}
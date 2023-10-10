package org.example.test;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.Assert.assertTrue;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class GameTDDTest {
    private Game game = new Game();

    @Rule
    public final TextFromStandardInputStream systemInMock
            = emptyStandardInputStream();
    @Before
    public void setUp() throws Exception{
        game.fillQuestions();
    }
    @Test
    public void startGameTest() throws InterruptedException {
        systemInMock.provideLines("D", "Yes", "C", "Yes","B","Yes", "A");
        game.start();
    }

    @Test
    public void checkAnswerTest(){
        assertTrue("Ошибка при проверке ответов",game.checkAnswer("D",0));
        assertTrue("Ошибка при проверке ответов",game.checkAnswer("C",1));
        assertTrue("Ошибка при проверке ответов",game.checkAnswer("B",2));
        assertTrue("Ошибка при проверке ответов",game.checkAnswer("A",3));
        System.out.println("Проверка ответов выполнена правильно");
    }
}

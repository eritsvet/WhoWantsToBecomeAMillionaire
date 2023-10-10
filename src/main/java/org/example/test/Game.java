package org.example.test;

import java.util.*;

public class Game {
    private HashMap<String, List<String>> questions;
    private final List<String> answers = new ArrayList<>();
    private int money = 0;
    public Game(){
    }

    public HashMap<String, List<String>> getQuestions() {
        return questions;
    }

    public void fillQuestions(){
        HashMap<String, List<String>> questions = new HashMap<>(); // Заполнение вопросами
        questions.put("2 + 2 = ?", List.of("1", "2", "3", "4"));
        questions.put("Лучший ВУЗ страны?", List.of("Mirea", "HSE", "MAI", "Bauman"));
        questions.put("Столица Латвии?", List.of("Польша", "Алматы", "Рига", "Рязань"));
        questions.put("Кто написал пьесу 'На дне'", List.of("Островский", "Горький", "Гоголь", "Тургенев"));
        this.questions = questions;

        this.answers.addAll(List.of("D", "C", "B", "A"));
    }
    public void start(){
        int count = 0;
        for (Map.Entry<String, List<String>> entry : questions.entrySet()) {
            System.out.printf("Выигранные деньги: %d рублей %n", this.money);
            System.out.printf("Вопрос №%d: %s%n",count+1,entry.getKey());
            System.out.printf("A: %s | B: %s | C: %s | D: %s%n", entry.getValue().get(0), entry.getValue().get(1),entry.getValue().get(2),entry.getValue().get(3) );
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine();
            System.out.println(answer);
            boolean isCorrect = checkAnswer(answer, count);
            if (isCorrect){
                if (count == 3){
                    System.out.println("Поздравляем, Вы стали миллионером!");
                    break;
                };
                earnMoney(this.money, count);
                System.out.printf("И это правильный ответ! Вы выиграли %d рублей! Хотите продолжить? (Yes/No) ", this.money);
                if (scanner.nextLine().equalsIgnoreCase("Yes")){
                    count++;
                    continue;
                }
                else {
                    System.out.printf("Вы выиграли %d рублей, ответив на %s вопрос(ов)!", this.money, count+1);
                    break;
                }
            } else{
                System.out.println("К сожалению вы проиграли :(");
                break;
            }
        }
    }
    public boolean checkAnswer(String answer, int position){
        if (answer.equalsIgnoreCase(this.answers.get(position))){
            return true;
        }
        else return false;
    }
    public int earnMoney(int money, int index){
        int result = (money + 2000) * ((index + 1) * 2);
        this.money = result;
        return result;
    }

    public int getMoney() {
        return money;
    }
}

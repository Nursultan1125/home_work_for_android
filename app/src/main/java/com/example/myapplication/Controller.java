package com.example.myapplication;


public class Controller {
    private int level = 0;
    private int leave = 3;

    public static final  Question[] QUESTIONS = {
            new Question("Правда ли, что у осьминогов прямоугольные зрачки?", true),
            new Question("Правда ли, что американские астронавты 45 лет назад устроили в космосе забастовку?", true),
            new Question("Правда ли, что спутники Сатурна Эпиметей и Янус периодически меняются орбитами?", true),
            new Question("Правда ли, что из-за особого рациона кровь у летучей мыши (бразильского складчатогуба) не красного, а голубого цвета?", false),
            new Question("Правда ли, что дикобраз может пораниться собственными иглами?", true),
            new Question("To knit — это английский глагол «вязать». А для распускания связанного в 1990-х появился глагол to tink — knit наоборот. Это правда?", true),
            new Question("Правда ли, что изюм содержит в своём составе тетрагидроканнабинол и поэтому запрещён к ввозу в Судан и Филиппины?", false),
            new Question("Правда ли, что на побережье Хабаровского края произрастает морозоустойчивый вид пальм?", false),
            new Question("Правда ли, что бамбук цветёт примерно раз в 60 лет?", true),
            new Question("Правда ли, что российская река Делькю несёт свои воды сразу в два океана?\n", true)
    };

    public Controller(){}

    public Controller(int leave){
        this.leave = leave;
    }

    public boolean isRight(Question question, boolean answer){
        return question.getAnswer() == answer;
    }

    public void handle(boolean answer){
        if(!isRight(QUESTIONS[level], answer)){
            leave -= 1;
        }
        if(!isFinish())
            level ++;
    }

    public boolean isFinish(){
        return level >= QUESTIONS.length - 1;
    }

    public Question getCurrentQuestion(){
        return QUESTIONS[level];
    }


    public int getLevel(){
        return level;
    }

    public int getLeave() {
        return leave;
    }

    public void reset(){
        level = 0;
        leave = 3;
    }
}

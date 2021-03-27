package com.android.quiz_igti;

public class QuestionLibrary {

    public String mQuestions[] = {
        "A linguagem oficial para desenvolvimento Android Nativo pela Google é a Kotlin",
        "O processo de publicação do aplicativo na Google Play é gratuito",
        "O Brasil possui uma população de quase 210 milhões",
        "Flutter é uma dos frameworks de desenvolvimento mobile",
        "A linguagem de programação do Flutter é o Dart",
        "O Flutter possui interoperabilidade e pode ter projetos em Java e Dart",
        "React-Native é uma plataforma para desenvolvimento de aplicativos móveis",
        "O Kotlin possui interoperabilidade oque possibilita implementar projetos em Java e Kotlin"
    };

    private String mChoices[][] = {
            {"Verdadeiro","Falso"},
            {"Verdadeiro","Falso"},
            {"Verdadeiro","Falso"},
            {"Verdadeiro","Falso"},
            {"Verdadeiro","Falso"},
            {"Verdadeiro","Falso"},
            {"Verdadeiro","Falso"},
            {"Verdadeiro","Falso"}
    };

    private String mCorrectAnswers[] = {
            "Verdadeiro","Falso","Verdadeiro","Verdadeiro","Verdadeiro","Falso","Verdadeiro","Verdadeiro"
    };

    public String getQuestion(int a){
        String question = mQuestions[a];
        return question;
    }

    public String getChoice1(int a){
        String choice0 = mChoices[a][0];
        return choice0;
    }
    public String getChoice2(int a){
        String choice1 = mChoices[a][1];
        return choice1;
    }

    public String getCorrectAnswer(int a){
        String answer = mCorrectAnswers[a];
        return answer;
    }


}

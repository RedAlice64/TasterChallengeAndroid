package edu.bu.ec500c1.tasterchallengeandroid;

import java.util.Iterator;

public class MultipleChoice {
    private String[] choices;
    private int iterator;
    private int correctId;
    MultipleChoice(){
        choices=new String[4];
        choices[0]="tiger";
        choices[1]="mouse";
        choices[2]="monkey";
        choices[3]="rabbit";
        iterator=0;
        correctId=3;
    }
    MultipleChoice(String XML){

    }

    public String next(){
        iterator++;
        if(iterator>3){iterator=0;return choices[3];}
        else return choices[iterator-1];
    }

    public boolean isCorrect(int answer){
        return answer==correctId;
    }

}

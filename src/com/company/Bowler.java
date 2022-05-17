package com.company;

import java.util.*;
import java.lang.*;

public class Bowler {

    //instance variables

    public String name;
    public ArrayList<BowlingFrame> frame;

    public Bowler(String name) {
        this.name = name;
        frame = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BowlingFrame getBowlingFrame(int a) {
        return frame.get(a);
    }

    public void addFrame(int throw1, int throw2) {
        BowlingFrame newFrame = new BowlingFrame(throw1, throw2);
        this.frame.add(newFrame);
    }

    public int getTotalScore() {
        int totalScore = 0;
        for (int i = 0; i < 10; i++) {
            int totalStrikeBonus = 0;
            int frame1ToAdd = frame.get(i).getThrow1();
            totalScore += frame1ToAdd;
            int frame2ToAdd = frame.get(i).getThrow2();
            totalScore += frame2ToAdd;
            if (frame.get(i).isSpare == true) {
                int last1stThrow = frame.get(i + 1).getThrow1();
                totalScore += last1stThrow;
            }
            else if (frame.get(i).isStrike == true){
                int firstStrikeBonus = frame.get(i + 1).getThrow1();
                int secondStrikeBonus = 0;
                if (firstStrikeBonus == 10){
                    secondStrikeBonus = frame.get(i + 2).getThrow1();
                }
                else{
                    secondStrikeBonus = frame.get(i + 1).getThrow2();
                }
                totalScore += firstStrikeBonus;
                totalScore += secondStrikeBonus;
            }
        }
        return totalScore;
    }
}

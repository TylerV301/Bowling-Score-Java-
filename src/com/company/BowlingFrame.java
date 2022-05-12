package com.company;

import java.util.*;
import java.lang.*;

public class BowlingFrame {

    //instance variables
    int throw1;
    int throw2;
    Boolean isStrike = false;
    Boolean isSpare = false;

    public BowlingFrame(int throw1, int throw2){
        this.throw1 = throw1;
        this.throw2 = throw2;
    }

    public int getThrow1() {
        return throw1;
    }

    public int getThrow2() {
        return throw2;
    }

    public void setThrow1(int throw1) {
        this.throw1 = throw1;
    }

    public void setThrow2(int throw2) {
        this.throw2 = throw2;
    }

    public int getFrame(){
        return (throw1 + throw2);
    }

    public void setSpare(Boolean spare) {
        isSpare = spare;
    }

    public void setStrike(Boolean strike) {
        isStrike = strike;
    }

    public Boolean getSpare() {
        return isSpare;
    }

    public Boolean getStrike() {
        return isStrike;
    }
}

package com.siv.wordsearch20;

public class Letter {

    public char letter;
    public boolean isSelected;

    public Letter() {
    }

    public Letter(char letter, boolean isSelected) {
        this.letter = letter;
        this.isSelected = isSelected;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}

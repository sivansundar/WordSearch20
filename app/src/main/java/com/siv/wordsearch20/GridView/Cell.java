package com.siv.wordsearch20.GridView;

import android.graphics.Rect;

public class Cell {

    private Rect rect;
    private char letter;
    private int rowIndex, columnIndex;

    public Cell(Rect rect, char letter, int rowIndex, int columnIndex) {
        this.rect = rect;
        this.letter = letter;
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
    }

    public Rect getRect() {
        return rect;
    }

    public void setRect(Rect rect) {
        this.rect = rect;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }

    public int getColumnIndex() {
        return columnIndex;
    }

    public void setColumnIndex(int columnIndex) {
        this.columnIndex = columnIndex;
    }
}

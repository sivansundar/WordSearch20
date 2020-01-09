package com.siv.wordsearch20.GridView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.core.view.MotionEventCompat;

import com.siv.wordsearch20.Model.Word;

public class Grid extends View {

    private int rows, columns, width, height, rectWH;

    private char[][] letters;
    private Word[] words;

    private Cell[][] cells;
    private Cell cellDragFrom, cellDragTo;

    private Paint textPaint;
    private Paint highlighterPaint;
    private Paint gridLinePaint;

    private OnWordSearchedListener onWordSearchedListener;
    private int wordsSearched = 0;
    private int[] highlighterColors = {0x4400649C, 0x44ffd900, 0x447fbb00};

    public Grid(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        
        init();
    }

    private void init() {

        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setSubpixelText(true);
        textPaint.setColor(0xcc000000);
        textPaint.setTextSize(70);
        textPaint.setTextAlign(Paint.Align.LEFT);

        highlighterPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        highlighterPaint.setStyle(Paint.Style.STROKE);
        highlighterPaint.setStrokeWidth(110);
        highlighterPaint.setStrokeCap(Paint.Cap.ROUND);
        highlighterPaint.setColor(0x4400649C);

        gridLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        gridLinePaint.setStyle(Paint.Style.STROKE);
        gridLinePaint.setStrokeWidth(4);
        gridLinePaint.setStrokeCap(Paint.Cap.SQUARE);
        gridLinePaint.setColor(0x11000000);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if(rows <= 0 || columns <= 0) {
            return;
        }

        // Grid
        for(int i = 0; i < rows - 1; i++) {
            canvas.drawLine(0, cells[i][0].getRect().bottom, width, cells[i][0].getRect().bottom, gridLinePaint);
        }
        for(int i = 0; i < columns - 1; i++) {
            canvas.drawLine(cells[0][i].getRect().right, cells[0][0].getRect().top, cells[0][i].getRect().right, cells[columns-1][0].getRect().bottom, gridLinePaint);
        }

        // Letters
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                String letter = String.valueOf(cells[i][j].getLetter());
                Rect textBounds = new Rect();
                textPaint.getTextBounds(letter, 0, 1, textBounds);
                canvas.drawText(letter, cells[i][j].getRect().centerX() - (textPaint.measureText(letter) / 2),
                        cells[i][j].getRect().centerY() + (textBounds.height() / 2), textPaint);
            }
        }

        // Highlighter
        if(cellDragFrom != null && cellDragTo != null && isFromToValid(cellDragFrom, cellDragTo)) {
            canvas.drawLine(cellDragFrom.getRect().centerX(), cellDragFrom.getRect().centerY(),
                    cellDragTo.getRect().centerX() + 1, cellDragTo.getRect().centerY(), highlighterPaint);
        }

        for(Word word : words) {
            if(word.isHighlighted()) {
                canvas.drawLine(
                        cells[word.getFromRow()][word.getFromColumn()].getRect().centerX(),
                        cells[word.getFromRow()][word.getFromColumn()].getRect().centerY(),
                        cells[word.getToRow()][word.getToColumn()].getRect().centerX() + 1,
                        cells[word.getToRow()][word.getToColumn()].getRect().centerY(), highlighterPaint);
            }
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int measuredWidth = measure(widthMeasureSpec);
        int measuredHeight = measure(heightMeasureSpec);
        int d = Math.min(measuredWidth, measuredHeight);
        setMeasuredDimension(d, d);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        width = w;
        height = h;

        initCells();
    }

    private void initCells() {
        if(rows <= 0 || columns <= 0) {
            return;
        }
        cells = new Cell[rows][columns];
        rectWH = width/rows;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                cells[i][j] = new Cell(new Rect(j*rectWH,i*rectWH,(j+1)*rectWH,(i+1)*rectWH),letters[i][j],i,j);
            }
        }
    }

    private int measure(int measureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        if (specMode == MeasureSpec.UNSPECIFIED) {
            result = 100;
        } else {
            result = specSize;
        }
        return result;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        final int pointerIndex = MotionEventCompat.getActionIndex(event);
        final float x = MotionEventCompat.getX(event, pointerIndex);
        final float y = MotionEventCompat.getY(event, pointerIndex);


       Log.d("WordsGrid", "x:" + x + ", y:" + y);

        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            cellDragFrom = getCell(x,y);
            cellDragTo = cellDragFrom;
            invalidate();
        } else if(event.getAction() == MotionEvent.ACTION_MOVE) {
            Cell cell = getCell(x,y);
            if(cellDragFrom != null && cell != null && isFromToValid(cellDragFrom, cell)) {
                cellDragTo = cell;
                invalidate();
            }
        } else if(event.getAction() == MotionEvent.ACTION_UP) {
//            Log.d("WordsGrid", getWordStr(cellDragFrom, cellDragTo));
            String word = getWordStr(cellDragFrom, cellDragTo);
            highlightIfContain(word);
            cellDragFrom = null;
            cellDragTo = null;
            invalidate();
            return false;
        }
        return true;
    }

    private Cell getCell(float x, float y) {
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                if(cells[i][j].getRect().contains((int)x,(int)y)) {
                    return cells[i][j];
                }
            }
        }
        return null;
    }

    public void setLetters(char[][] letters) {
        this.letters = letters;
        rows = letters.length;
        columns = letters[0].length;
        initCells();
        invalidate();
    }
    public void setOnWordSearchedListener(OnWordSearchedListener onWordSearchedListener) {
        this.onWordSearchedListener = onWordSearchedListener;
    }

    public void setWords(Word... words) {
        this.words = words;
    }

    private String getWordStr(Cell from, Cell to) {
        String word = "";
        if(from.getRowIndex() == to.getRowIndex()) {
            int c = from.getColumnIndex() < to.getColumnIndex() ? from.getColumnIndex() : to.getColumnIndex();
            for(int i = 0; i < Math.abs(from.getColumnIndex() - to.getColumnIndex()) + 1; i++) {
                word += String.valueOf(cells[from.getRowIndex()][i+c].getLetter());
            }
        } else if(from.getColumnIndex() == to.getColumnIndex()) {
            int r = from.getRowIndex() < to.getRowIndex() ? from.getRowIndex() : to.getRowIndex();
            for(int i = 0; i < Math.abs(from.getRowIndex() - to.getRowIndex()) + 1; i++) {
                word += String.valueOf(cells[i+r][to.getColumnIndex()].getLetter());
            }
        } else {
            if(from.getRowIndex() > to.getRowIndex()) {
                Cell cell = from;
                from = to;
                to = cell;
            }
            for(int i = 0; i < Math.abs(from.getRowIndex() - to.getRowIndex()) + 1; i++) {
                int foo = from.getColumnIndex() < to.getColumnIndex() ? i : -i;
                word += String.valueOf(cells[from.getRowIndex()+i][from.getColumnIndex()+foo].getLetter());
            }
        }
        return word;
    }

    private void highlightIfContain(String str) {
        for(Word word : words) {
            if(word.getWord().equals(str)) {
                if(onWordSearchedListener != null) {
                    onWordSearchedListener.wordFound(str);
                }
                word.setHighlighted(true);
                wordsSearched++;
                break;
            }
        }
    }
    private boolean isFromToValid(Cell cellDragFrom, Cell cellDragTo) {
        return (Math.abs(cellDragFrom.getRowIndex() - cellDragTo.getRowIndex()) == Math.abs(cellDragFrom.getColumnIndex() - cellDragTo.getColumnIndex()))
                || cellDragFrom.getRowIndex() == cellDragTo.getRowIndex() || cellDragFrom.getColumnIndex() == cellDragTo.getColumnIndex();
    }

    public interface OnWordSearchedListener {
        public void wordFound(String word);
    }
}

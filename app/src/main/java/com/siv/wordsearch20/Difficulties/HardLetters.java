package com.siv.wordsearch20.Difficulties;

public class HardLetters {

    private char[][] hardLetters = {

            //FromRow, FromColoumn, ToRow, ToColoumn

            //Row = UD
            //Coloumn = LR

            //0   1   2   3   4   5   6   7   8   9
            {'A', 'M', 'C', 'D', 'F', 'F', 'G', 'S', 'I', 'O'},// 0
            {'O', 'J', 'A', 'V', 'A', 'T', 'O', 'W', 'B', 'B'},// 1
            {'A', 'M', 'C', 'C', 'C', 'T', 'M', 'I', 'I', 'J'},// 2
            {'A', 'O', 'A', 'S', 'E', 'O', 'E', 'F', 'K', 'E'},// 3
            {'N', 'B', 'C', 'H', 'B', 'C', 'W', 'T', 'O', 'C'},// 4
            {'D', 'I', 'G', 'O', 'O', 'G', 'L', 'E', 'T', 'T'},// 5
            {'R', 'L', 'L', 'P', 'O', 'N', 'I', 'Z', 'L', 'I'},// 5
            {'O', 'E', 'V', 'I', 'K', 'B', 'I', 'V', 'I', 'V'},// 7
            {'I', 'E', 'C', 'F', 'O', 'W', 'A', 'Z', 'N', 'E'},// 8
            {'D', 'C', 'V', 'Y', 'A', 'I', 'A', 'B', 'L', 'C'}//  9

            //Y Swift - 0,7,4,7
            //Y Java - 1, 1, 1, 4
            //Y Kotlin - 3, 8, 8, 8
            //Y ObjectiveC - 0, 9, 9, 9
            // Mac - 0,1,2,3
            //Y Mobile - 2, 1, 7, 1

            //Shopify - 3, 3, 9, 3
            //Google - 5,2,5,7

            //Android - 3, 0, 9, 0
            //Facebook - 0, 4, 7, 4
    };

    private char[][] hardLetters2 = {

            //FromRow, FromColoumn, ToRow, ToColoumn

            //Row = UD
            //Coloumn = LR

            //0   1   2   3   4   5   6   7   8   9
            {'O', 'F', 'A', 'C', 'E', 'B', 'O', 'O', 'K', 'E'},// 0
            {'S', 'B', 'W', 'G', 'O', 'O', 'G', 'L', 'E', 'C'},// 1
            {'H', 'K', 'J', 'I', 'E', 'T', 'M', 'J', 'I', 'A'},// 2    1 1
            {'O', 'O', 'O', 'E', 'F', 'O', 'E', 'M', 'Q', 'N'},// 3
            {'P', 'M', 'C', 'T', 'C', 'T', 'W', 'O', 'L', 'D'},// 4
            {'I', 'O', 'N', 'I', 'L', 'T', 'A', 'J', 'A', 'R'},// 5
            {'F', 'B', 'L', 'I', 'F', 'I', 'I', 'A', 'Q', 'O'},// 5
            {'Y', 'I', 'V', 'T', 'E', 'B', 'N', 'V', 'P', 'I'},// 7
            {'E', 'L', 'S', 'W', 'I', 'F', 'T', 'A', 'E', 'D'},// 8
            {'C', 'E', 'M', 'A', 'C', 'I', 'A', 'M', 'L', 'C'}//  9


            //Swift - 8 2 8 6

            //Java - 5 7 8 7

            //Kotlin - 2, 1, 7, 6

            //ObjectiveC - 0,0,9,9

            //MAC - 9 2 9 4

            //Mobile - 4,1,9,1

            //Facebook 0 1 0 8
            //Shopify 1 0 7 0

            //Google 1 3 1 8
            //Android 2 9 8 9
    };

    public HardLetters() {
    }

    public char[][] getHardLetters() {
        return hardLetters;
    }

    public void setHardLetters(char[][] hardLetters) {
        this.hardLetters = hardLetters;
    }

    public char[][] getHardLetters2() {
        return hardLetters2;
    }

    public void setHardLetters2(char[][] hardLetters2) {
        this.hardLetters2 = hardLetters2;
    }
}

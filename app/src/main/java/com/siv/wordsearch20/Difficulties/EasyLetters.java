package com.siv.wordsearch20.Difficulties;

public class EasyLetters {


    private char[][] easyLetters = {

            //FromRow, FromColoumn, ToRow, ToColoumn

            //Row = UD
            //Coloumn = LR

            //0   1   2   3   4   5   6   7   8   9
            {'A', 'O', 'C', 'D', 'E', 'F', 'G', 'K', 'I', 'O'},// 0
            {'O', 'J', 'A', 'V', 'A', 'T', 'O', 'V', 'B', 'C'},// 1
            {'A', 'M', 'C', 'D', 'E', 'T', 'M', 'J', 'I', 'J'},// 2
            {'A', 'O', 'A', 'W', 'L', 'O', 'E', 'S', 'K', 'J'},// 3
            {'A', 'B', 'C', 'M', 'B', 'C', 'W', 'V', 'O', 'J'},// 4
            {'A', 'I', 'N', 'I', 'T', 'I', 'A', 'L', 'T', 'J'},// 5
            {'A', 'L', 'L', 'I', 'F', 'N', 'I', 'H', 'L', 'J'},// 5
            {'N', 'E', 'V', 'T', 'E', 'B', 'P', 'V', 'I', 'J'},// 7
            {'A', 'E', 'C', 'S', 'O', 'M', 'A', 'Z', 'N', 'J'},// 8
            {'C', 'C', 'V', 'A', 'R', 'I', 'A', 'B', 'L', 'E'}//  9

            //Y Swift - 7 , 3, 3, 7
            //Y Java - 1, 1, 1, 4
            //Y Kotlin - 3, 8, 8, 8
            //Y ObjectiveC - 9, 0, 0, 9
            // Variable - 9, 2, 9, 9
            //Y Mobile - 2, 1, 7, 1
    };

    private char[][] easyLetters2 = {

            //FromRow, FromColoumn, ToRow, ToColoumn

            //Row = UD
            //Coloumn = LR

            //0   1   2   3   4   5   6   7   8   9
            {'O', 'S', 'V', 'A', 'R', 'I', 'A', 'B', 'L', 'E'},// 0
            {'B', 'J', 'W', 'V', 'A', 'T', 'O', 'V', 'B', 'C'},// 1
            {'J', 'K', 'C', 'I', 'E', 'T', 'M', 'J', 'I', 'J'},// 2    1 1
            {'E', 'O', 'O', 'W', 'F', 'O', 'E', 'M', 'Q', 'J'},// 3
            {'C', 'J', 'C', 'T', 'B', 'T', 'W', 'O', 'L', 'J'},// 4
            {'T', 'A', 'N', 'I', 'L', 'I', 'A', 'B', 'A', 'J'},// 5
            {'I', 'V', 'L', 'I', 'F', 'I', 'I', 'I', 'Q', 'J'},// 5
            {'V', 'A', 'V', 'T', 'E', 'B', 'N', 'L', 'P', 'J'},// 7
            {'E', 'E', 'C', 'S', 'O', 'M', 'A', 'E', 'Q', 'J'},// 8
            {'C', 'C', 'V', 'A', 'R', 'I', 'A', 'M', 'L', 'E'}//  9


            //Y Swift - 0 , 1, 4, 5

            //Y Java - 4, 1, 7, 1

            //Y Kotlin - 2, 1, 7, 6

            //Y ObjectiveC - 0, 0, 9, 0

            //Y Variable - 0, 2, 0, 9

            //Y Mobile - 3, 7, 8, 7
    };


    public EasyLetters() {
    }

    public char[][] getEasyLetters() {
        return easyLetters;
    }

    public char[][] getEasyLetters2() {
        return easyLetters2;
    }


}

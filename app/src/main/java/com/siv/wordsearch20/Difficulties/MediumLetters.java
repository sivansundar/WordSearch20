package com.siv.wordsearch20.Difficulties;

public class MediumLetters {

    private char[][] mediumLetters = {

            //FromRow, FromColoumn, ToRow, ToColoumn

            //Row = UD
            //Coloumn = LR
            // Set letters in MainActivity

            //0   1   2   3   4   5   6   7   8   9
            {'O', 'O', 'C', 'V', 'S', 'W', 'I', 'F', 'T', 'S'},// 0
            {'B', 'Z', 'R', 'A', 'J', 'T', 'A', 'O', 'M', 'H'},// 1
            {'J', 'M', 'A', 'R', 'A', 'T', 'R', 'T', 'O', 'O'},// 2
            {'E', 'Q', 'O', 'I', 'V', 'E', 'I', 'L', 'B', 'P'},// 3
            {'C', 'A', 'C', 'A', 'A', 'C', 'A', 'I', 'I', 'I'},// 4
            {'T', 'D', 'N', 'B', 'I', 'I', 'B', 'N', 'L', 'F'},// 5
            {'I', 'K', 'L', 'L', 'F', 'L', 'L', 'H', 'E', 'Y'},// 6
            {'V', 'Q', 'V', 'E', 'K', 'O', 'T', 'L', 'I', 'N'},// 7
            {'E', 'G', 'O', 'O', 'G', 'L', 'E', 'I', 'F', 'Y'},// 8
            {'C', 'Z', 'J', 'X', 'Q', 'A', 'H', 'A', 'Q', 'S'}//  9

            //Y Swift - 0 4 0 8
            //Y Java - 1 4 4 4
            // Variable - 0 3 7 3
            //Y Mobile - 1 8 5 8
            //Y ObjectiveC - 0 0 9 0
            //Y Kotlin - 7 4 7 9
            //Shopify - 0 9 6 9
            //Google - 8 1 8 6

    };

    private char[][] mediumLetters2 = {

            //FromRow, FromColoumn, ToRow, ToColoumn

            //Row = UD
            //Coloumn = LR

            //0   1   2   3   4   5   6   7   8   9
            {'G', 'Q', 'A', 'A', 'C', 'Q', 'F', 'F', 'K', 'S'},// 0
            {'S', 'O', 'V', 'J', 'O', 'O', 'G', 'L', 'H', 'C'},// 1
            {'S', 'K', 'O', 'A', 'A', 'T', 'M', 'O', 'I', 'J'},// 2    1 1
            {'H', 'O', 'O', 'G', 'R', 'V', 'P', 'M', 'Q', 'M'},// 3
            {'O', 'M', 'C', 'T', 'L', 'I', 'A', 'O', 'L', 'O'},// 4
            {'P', 'O', 'N', 'I', 'L', 'E', 'A', 'J', 'A', 'B'},// 5
            {'I', 'B', 'L', 'Y', 'I', 'I', 'I', 'B', 'Q', 'I'},// 5
            {'F', 'I', 'V', 'T', 'T', 'B', 'N', 'V', 'L', 'L'},// 7
            {'Y', 'L', 'C', 'S', 'W', 'I', 'F', 'T', 'E', 'E'},// 8
            {'O', 'B', 'J', 'E', 'C', 'T', 'I', 'V', 'E', 'C'}//  9

            //Shopify - 2 0 8 0
            //Swift - 8 3 8 7
            //Java - 1 3 4 6
            //Variable - 1 2 8 9
            //Mobile - 3 9 8 9
            //Google - 0 0 5 5
            //ObjectiveC - 9 0 9 9
            //Kotlin - 2 1 7 6


            //Swift - 0 , 1, 4, 5

            //Java - 5 7 8 7

            //Kotlin - 2, 1, 7, 6

            //ObjectiveC - 0,0,9,9

            //MAC - 9 2 9 4

            //Mobile - 4,1,9,1

            //Facebook 0 1 0 8
            //Shopify 1 0 7 0
            //Google 1 3 1 8
    };


    public MediumLetters() {
    }

    public char[][] getMediumLetters() {
        return mediumLetters;
    }

    public void setMediumLetters(char[][] mediumLetters) {
        this.mediumLetters = mediumLetters;
    }

    public char[][] getMediumLetters2() {
        return mediumLetters2;
    }

    public void setMediumLetters2(char[][] mediumLetters2) {
        this.mediumLetters2 = mediumLetters2;
    }
}

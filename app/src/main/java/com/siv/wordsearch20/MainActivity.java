package com.siv.wordsearch20;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.siv.wordsearch20.GridView.Grid;
import com.siv.wordsearch20.Model.Word;
import com.siv.wordsearch20.StopWatch.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Grid wordsGrid;

    private List<char[][]> letterArray;

    public List<String> wordsFound;
    int score = 0 ;

    public TextView counterText;
    public TextView stopwatchText;

    public RecyclerView wordsRecyclerView;
    public WordAdapter wordAdapter;

    public StopWatch stopwatch;

    private char[][] letters  = {

            //FromRow, FromColoumn, ToRow, ToColoumn

            //Row = UD
            //Coloumn = LR

            //0   1   2   3   4   5   6   7   8   9
            {'A','O','C','D','E','F','G','K','I','O'},// 0
            {'O','J','A','V','A','T','O','V','B','C'},// 1
            {'A','M','C','D','E','T','M','J','I','J'},// 2    1 1
            {'A', 'O', 'A', 'W', 'L', 'O', 'E', 'S', 'K', 'J'},// 3
            {'A', 'B', 'C', 'M', 'B', 'C', 'W', 'V', 'O', 'J'},// 4
            {'A', 'I', 'N', 'I', 'A', 'I', 'A', 'L', 'T', 'J'},// 5
            {'A', 'L', 'L', 'I', 'F', 'N', 'I', 'H', 'L', 'J'},// 5
            {'N', 'E', 'V', 'T', 'E', 'B', 'P', 'V', 'I', 'J'},// 7
            {'A', 'E', 'C', 'S', 'O', 'M', 'A', 'Z', 'N', 'J'},// 8
            {'C','C','V','A','R','I','A','B','L','E'}//  9

            //Y Swift - 7 , 3, 3, 7
            //Y Java - 1, 1, 1, 4
            //Y Kotlin - 3, 8, 8, 8
            //Y ObjectiveC - 9, 0, 0, 9
            // Variable - 9, 2, 9, 9
            //Y Mobile - 2, 1, 7, 1
    };

    private char[][] letters2 = {

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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wordsFound = new ArrayList<String>();

        wordsRecyclerView = findViewById(R.id.wordListRecyclerView);
        wordsRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL));
        wordAdapter = new WordAdapter((ArrayList<String>) wordsFound, this);
        wordsRecyclerView.setAdapter(wordAdapter);

        counterText = findViewById(R.id.score);
        stopwatchText = findViewById(R.id.stopWatch_text);

        letterArray = new ArrayList<>();
        letterArray.add(letters);
        letterArray.add(letters2);

        stopwatch = new StopWatch();
        stopwatch.setTextView(stopwatchText);
        stopwatch.start();


        Random rand = new Random();
        Toast.makeText(this, "SIZE : " + letterArray.size(), Toast.LENGTH_SHORT).show();
        int random = rand.nextInt(letterArray.size());
        // Toast.makeText(this, "RANDOM : " + random + " \"SIZE " + letterArray.size(), Toast.LENGTH_SHORT).show();


        wordsGrid = findViewById(R.id.wordsGrid);

        Log.d("LETTERS : ", "onCreate: : " + letters[1][1] + letters[2][1] + letters[3][1] + letters[4][1]);

        wordsFound.add("SWIFT");
        wordsFound.add("JAVA");
        wordsFound.add("OBJECTIVEC");
        wordsFound.add("KOTLIN");
        wordsFound.add("MOBILE");
        wordsFound.add("VARIABLE");

        switch (random) {
            case 0:
                wordsGrid.setWords(
                        new Word("SWIFT", false, 7, 3, 3, 7),
                        new Word("JAVA", false, 1, 1, 1, 4),
                        new Word("OBJECTIVEC", false, 9, 0, 0, 9),
                        new Word("KOTLIN", false, 3, 8, 8, 8),
                        new Word("MOBILE", false, 2, 1, 7, 1),
                        new Word("VARIABLE", false, 9, 2, 9, 9));

                wordsGrid.setLetters(letters);
                break;

            case 1:
                wordsGrid.setWords(
                        new Word("SWIFT", false, 0, 1, 4, 5),
                        new Word("JAVA", false, 4, 1, 7, 1),
                        new Word("KOTLIN", false, 2, 1, 7, 6),
                        new Word("OBJECTIVEC", false, 0, 0, 9, 0),
                        new Word("VARIABLE", false, 0, 2, 0, 9),
                        new Word("MOBILE", false, 3, 7, 8, 7)
                );

                wordsGrid.setLetters(letters2);
                break;

            default:
                Toast.makeText(this, "This default block is executed when the grid cannot be randomized.", Toast.LENGTH_SHORT).show();
                break;

        }



        //letterArray.get(random)


        wordsGrid.setOnWordSearchedListener(new Grid.OnWordSearchedListener() {
            @Override
            public void wordFound(String word) {

                if (wordsFound.contains(word)) {

                    Toast.makeText(MainActivity.this, word + " found : " + wordsFound.indexOf(word), Toast.LENGTH_SHORT).show();
                    score++;
                    counterText.setText("Score : " + score);

                    wordsFound.remove(word);
                    wordAdapter.notifyDataSetChanged();

                }
                
                if (score == 6) {
                    stopwatch.stop();
                    AlertDialog.Builder scoreDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                    scoreDialogBuilder.setTitle("Congratulations!");
                    scoreDialogBuilder.setMessage("You took " + stopwatchText.getText().toString() + " to complete searching.");
                    scoreDialogBuilder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            // Do nothing.
                        }
                    });

                    AlertDialog scoreDialog = scoreDialogBuilder.create();
                    scoreDialog.show();

                    Toast.makeText(MainActivity.this, "YOU ARE DONE!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


}

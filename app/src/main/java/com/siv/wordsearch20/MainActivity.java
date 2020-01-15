package com.siv.wordsearch20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.graphics.Paint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.siv.wordsearch20.GridView.Grid;
import com.siv.wordsearch20.Model.Word;
import com.yashovardhan99.timeit.Stopwatch;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Grid wordsGrid;

    private List<char[][]> letterArray;

    public List<String> wordsFound;
    int score = 0 ;

    public RecyclerView wordsRecyclerView;
    public WordAdapter wordAdapter;


    private char[][] letters  = {

            //FromRow, FromColoumn, ToRow, ToColoumn

            //Row = UD
            //Coloumn = LR

            //0   1   2   3   4   5   6   7   8   9
            {'A','O','C','D','E','F','G','K','I','O'},// 0
            {'O','J','A','V','A','T','O','V','B','C'},// 1
            {'A','M','C','D','E','T','M','J','I','J'},// 2    1 1
            {'A','O','K','W','L','O','E','S','K','J'},// 3
            {'A','B','C','O','B','C','W','V','O','J'},// 4
            {'A','I','N','I','T','I','A','L','T','J'},// 5
            {'A','L','L','I','F','L','I','H','L','J'},// 5
            {'N','E','V','T','E','B','I','V','I','J'},// 7
            {'A','E','C','S','O','M','A','N','N','J'},// 8
            {'C','C','V','A','R','I','A','B','L','E'}//  9

            //Y Swift - 7 , 3, 3, 7
            //Y Java - 1, 1, 1, 4
            //Y Kotlin - 3, 8, 8, 8
            //Y ObjectiveC - 9, 0, 0, 9
            // Variable -
            //Y Mobile - 2, 1, 7, 1
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

        TextView counterText = (TextView) findViewById(R.id.counterText);
        TextView stopwatchText = findViewById(R.id.stopwatch);
        letterArray = new ArrayList<>();
        letterArray.add(letters);

        Stopwatch stopwatch = new Stopwatch();
        stopwatch.setTextView(stopwatchText);
        stopwatch.start();

        Random rand = new Random();
        int random = rand.nextInt(letterArray.size());
        Toast.makeText(this, "RANDOM : " + random, Toast.LENGTH_SHORT).show();

        wordsGrid = (Grid) findViewById(R.id.wordsGrid);

        Log.d("LETTERS : ", "onCreate: : " + letters[1][1] + letters[2][1] + letters[3][1] + letters[4][1]);

        wordsFound.add("SWIFT");
        wordsFound.add("JAVA");
        wordsFound.add("OBJECTIVEC");
        wordsFound.add("KOTLIN");
        wordsFound.add("MOBILE");
        wordsFound.add("VARIABLE");

        wordsGrid.setWords(
                new Word("SWIFT", false,7, 3, 3, 7),
                new Word("JAVA", false, 1,1,1,4),
                new Word("OBJECTIVEC", false, 9, 0, 0, 9),
                new Word("KOTLIN", false, 3, 8, 8, 8),
                new Word("MOBILE", false, 2,1,7,1),
                new Word("VARIABLE", false, 9, 2, 9, 9));

        //letterArray.get(random)
        wordsGrid.setLetters(letters);


        wordsGrid.setOnWordSearchedListener(new Grid.OnWordSearchedListener() {
            @Override
            public void wordFound(String word) {

                if (wordsFound.contains(word)) {
                    Toast.makeText(MainActivity.this, word + " found : " + wordsFound.indexOf(word), Toast.LENGTH_SHORT).show();
                    score++;
                    Log.d("TAG", "wordFound: REMOVE INDEX : " + wordsFound.indexOf(word));
                    wordsFound.remove(wordsFound.indexOf(word));
                    wordAdapter.notifyDataSetChanged();

                }
                
                if (score == 6) {
                    stopwatch.stop();
                    Toast.makeText(MainActivity.this, "YOU ARE DONE!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


}

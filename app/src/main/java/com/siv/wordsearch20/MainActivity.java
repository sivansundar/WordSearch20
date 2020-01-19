package com.siv.wordsearch20;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import com.siv.wordsearch20.Database.LeaderboardDatabase;
import com.siv.wordsearch20.Database.LeaderboardEntity;
import com.siv.wordsearch20.Difficulties.EasyLetters;
import com.siv.wordsearch20.Difficulties.HardLetters;
import com.siv.wordsearch20.Difficulties.MediumLetters;
import com.siv.wordsearch20.GridView.Grid;
import com.siv.wordsearch20.Model.Word;
import com.siv.wordsearch20.StopWatch.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Grid wordsGrid;

    public EasyLetters easyLettersObject;
    public MediumLetters mediumLettersObject;
    public HardLetters hardLettersObject;
    public List<String> easyWords, mediumWords, hardWords;
    public List<LeaderboardEntity> leaderboardList;
    public TextView scoreText, gamecounterText, stopwatchText;
    public MaterialCheckBox material_checkbox;
    public String currentDifficulty;
    public MaterialButton easyButton, mediumButton, hardButton;
    public StopWatch stopwatch;
    public Random rand;

    public RecyclerView wordsRecyclerView;
    public WordAdapter wordAdapter;


    int score = 0, topscore;
    private List<char[][]> easyLetterArray, mediumLettersArray, hardLetterArray;

    boolean isShareClicked;
    boolean difficultyStatus = false;
    boolean infoStatus;
    private SharedPreferences sharedpreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        wordsRecyclerView = findViewById(R.id.wordListRecyclerView);
        wordsRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL));

        gamecounterText = findViewById(R.id.gamecounter_text);
        stopwatchText = findViewById(R.id.stopWatch_text);
        scoreText = findViewById(R.id.score);
        wordsGrid = findViewById(R.id.wordsGrid);

        isShareClicked = false;
        sharedpreferences = getSharedPreferences("pref", Context.MODE_PRIVATE);

        editor = sharedpreferences.edit();

        infoStatus = sharedpreferences.getBoolean("info", true);
        Log.d("TAG", "onCreate: infoStatus : " + infoStatus);


        final View difficultyDialog = LayoutInflater.from(MainActivity.this).inflate(R.layout.difficulty_alert_view, null);

        initDifficultyDialogView(difficultyDialog);

        rand = new Random();


        MaterialAlertDialogBuilder difficultyDialogBuilder = new MaterialAlertDialogBuilder(MainActivity.this);
        difficultyDialogBuilder.setTitle("Choose Difficulty");
        difficultyDialogBuilder.setMessage("Pick a difficulty level to begin with.");
        difficultyDialogBuilder.setView(difficultyDialog);
        difficultyDialogBuilder.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                finish();
            }
        });
        AlertDialog difficultyAlert = difficultyDialogBuilder.create();

        easyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fireStopWatchandGame();

                difficultyStatus = true;
                currentDifficulty = "Easy";

                easyLettersObject = new EasyLetters();

                easyLetterArray = new ArrayList<>();
                easyLetterArray.add(easyLettersObject.getEasyLetters());
                easyLetterArray.add(easyLettersObject.getEasyLetters2());

                int randomGrid = rand.nextInt(easyLetterArray.size());

                easyWords = new ArrayList<String>();

                easyWords.add("SWIFT");
                easyWords.add("JAVA");
                easyWords.add("OBJECTIVEC");
                easyWords.add("KOTLIN");
                easyWords.add("MOBILE");
                easyWords.add("VARIABLE");


                pickEasyGrid(randomGrid);

                wordAdapter = new WordAdapter((ArrayList<String>) easyWords, getApplicationContext());
                wordsRecyclerView.setAdapter(wordAdapter);


                difficultyAlert.dismiss();


            }
        });

        mediumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fireStopWatchandGame();
                currentDifficulty = "Medium";

                mediumLettersObject = new MediumLetters();

                mediumLettersArray = new ArrayList<>();
                mediumLettersArray.add(mediumLettersObject.getMediumLetters());
                mediumLettersArray.add(mediumLettersObject.getMediumLetters2());

                mediumWords = new ArrayList<String>();

                mediumWords.add("SWIFT");
                mediumWords.add("JAVA");
                mediumWords.add("OBJECTIVEC");
                mediumWords.add("KOTLIN");
                mediumWords.add("MOBILE");
                mediumWords.add("SHOPIFY");
                mediumWords.add("GOOGLE");
                mediumWords.add("VARIABLE");

                int randomGrid = rand.nextInt(mediumLettersArray.size());
                pickMediumGrid(randomGrid);

                wordAdapter = new WordAdapter((ArrayList<String>) mediumWords, getApplicationContext());
                wordsRecyclerView.setAdapter(wordAdapter);

                difficultyAlert.dismiss();

            }
        });

        hardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fireStopWatchandGame();
                currentDifficulty = "Hard";


                hardLettersObject = new HardLetters();

                hardLetterArray = new ArrayList<>();
                hardLetterArray.add(hardLettersObject.getHardLetters());
                hardLetterArray.add(hardLettersObject.getHardLetters2());

                hardWords = new ArrayList<String>();

                hardWords.add("SWIFT");
                hardWords.add("JAVA");
                hardWords.add("OBJECTIVEC");
                hardWords.add("KOTLIN");
                hardWords.add("MOBILE");
                hardWords.add("MAC");
                hardWords.add("SHOPIFY");
                hardWords.add("ANDROID");
                hardWords.add("GOOGLE");
                hardWords.add("FACEBOOK");

                int randomGrid = rand.nextInt(hardLetterArray.size());
                pickHardGrid(randomGrid);

                wordAdapter = new WordAdapter((ArrayList<String>) hardWords, getApplicationContext());
                wordsRecyclerView.setAdapter(wordAdapter);


                difficultyAlert.dismiss();

            }
        });
        difficultyAlert.show();


        wordsGrid.setOnWordSearchedListener(new Grid.OnWordSearchedListener() {
            @Override
            public void wordFound(String word) {

                switch (currentDifficulty) {
                    case "Easy":
                        if (easyWords.contains(word)) {
                            topscore = 6;

                            Toast.makeText(MainActivity.this, word + " found : " + easyWords.indexOf(word), Toast.LENGTH_SHORT).show();
                            score++;
                            scoreText.setText("Score : " + score);

                            easyWords.remove(word);
                            wordAdapter.notifyDataSetChanged();

                        }

                        break;


                    case "Medium":
                        if (mediumWords.contains(word)) {
                            topscore = 8;

                            Toast.makeText(MainActivity.this, word + " found : " + mediumWords.indexOf(word), Toast.LENGTH_SHORT).show();
                            score++;
                            scoreText.setText("Score : " + score);

                            mediumWords.remove(word);
                            wordAdapter.notifyDataSetChanged();
                        }

                        break;


                    case "Hard":
                        if (hardWords.contains(word)) {
                            topscore = 10;

                            Toast.makeText(MainActivity.this, word + " found : " + hardWords.indexOf(word), Toast.LENGTH_SHORT).show();
                            score++;
                            scoreText.setText("Score : " + score);

                            hardWords.remove(word);
                            wordAdapter.notifyDataSetChanged();
                        }
                }


                switch (currentDifficulty) {

                }
                if (score == topscore) {
                    stopwatch.stop();

                    final View dialogView = LayoutInflater.from(MainActivity.this).inflate(R.layout.custom_md_alertdialog, null);

                    TextInputEditText nameEditText = dialogView.findViewById(R.id.name_edittext);

                    MaterialAlertDialogBuilder scoreDialogBuilder = new MaterialAlertDialogBuilder(MainActivity.this);
                    scoreDialogBuilder.setTitle("Congratulations!");
                    scoreDialogBuilder.setView(dialogView);
                    scoreDialogBuilder.setMessage("You took " + stopwatchText.getText().toString() + " to complete searching.");

                    scoreDialogBuilder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            // Do nothing.

                            String name = nameEditText.getText().toString().trim();

                            if (!name.isEmpty()) {
                                addToLeaderboard(name, stopwatchText.getText().toString());

                                leaderboardOrSharePrompt();


                            }

                        }
                    });

                    scoreDialogBuilder.setCancelable(false);

                    AlertDialog scoreDialog = scoreDialogBuilder.create();
                    scoreDialog.show();

                    Toast.makeText(MainActivity.this, "YOU ARE DONE!", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (isShareClicked) {
            finish();
        }
        Log.d("TAG", "onStop: AFTER SHARE ");
    }

    private void leaderboardOrSharePrompt() {

        MaterialAlertDialogBuilder leaderboardOrShareDialogBuilder = new MaterialAlertDialogBuilder(MainActivity.this);
        leaderboardOrShareDialogBuilder.setMessage("Do you want to view the leaderboard or share your best time on social media?");
        leaderboardOrShareDialogBuilder.setPositiveButton("Leaderboard", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
                startActivity(new Intent(MainActivity.this, LeaderBoardActivity.class));
            }
        });
        leaderboardOrShareDialogBuilder.setNeutralButton("Share", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "I just played WordSeach20 and took " + stopwatchText.getText().toString() + " to complete it. \nWhat is your best shot at it?" +
                        "\n\n\nCheckout the repository at http://www.github.com/sivansundar/wordsearch20");
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
                isShareClicked = true;
            }
        });
        leaderboardOrShareDialogBuilder.setCancelable(false);
        leaderboardOrShareDialogBuilder.create().show();
    }

    public void fireStopWatchandGame() {
        if (infoStatus != false) {

            fireInstructionsDialog();

            //Add a customview with a checkbox and change the value of the shared pref when chosen.

        } else {

            fireGameWithCountdown();

        }
    }

    private void fireGameWithCountdown() {
        new CountDownTimer(3000, 1000) {

            @Override
            public void onTick(long l) {
                long time = l + 1000;
                Log.d("Tick", "onTick: " + time);
                gamecounterText.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this, "Get Ready : " + l / 1000, Toast.LENGTH_SHORT).show();
                Log.d("Ready", "onTick: Get Ready : \" + l/1000");
                gamecounterText.setText("Your game will begin in \n" + time / 1000);
            }

            @Override
            public void onFinish() {
                gamecounterText.setVisibility(View.GONE);
                wordsRecyclerView.setVisibility(View.VISIBLE);
                scoreText.setVisibility(View.VISIBLE);
                wordsGrid.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this, "GO!", Toast.LENGTH_SHORT).show();
                startStopWatch();

            }
        }.start();
    }

    private void fireInstructionsDialog() {

        final View material_checkboxView = LayoutInflater.from(MainActivity.this).inflate(R.layout.instructions_alert_view, null);

        material_checkbox = material_checkboxView.findViewById(R.id.material_checkbox);

        material_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(MainActivity.this, "Checked Status = : " + b, Toast.LENGTH_SHORT).show();

                if (b == true) {
                    editor.putBoolean("info", false);
                    editor.commit();

                } else {
                    editor.putBoolean("info", true);
                    editor.commit();
                }
            }
        });

        MaterialAlertDialogBuilder scoreDialogBuilder = new MaterialAlertDialogBuilder(MainActivity.this);
        scoreDialogBuilder.setTitle("Instructions.");
        scoreDialogBuilder.setView(material_checkboxView);
        scoreDialogBuilder.setMessage(R.string.instructions);
        scoreDialogBuilder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                fireGameWithCountdown();
            }
        });
        scoreDialogBuilder.setCancelable(false);
        scoreDialogBuilder.create().show();

    }



    private void pickHardGrid(int randomGrid) {
        switch (randomGrid) {
            case 0:

                wordsGrid.setWords(
                        new Word("SWIFT", false, 0, 7, 4, 7),
                        new Word("JAVA", false, 1, 1, 1, 4),
                        new Word("OBJECTIVEC", false, 0, 9, 9, 9),
                        new Word("KOTLIN", false, 3, 8, 8, 8),
                        new Word("MOBILE", false, 2, 1, 7, 1),
                        new Word("MAC", false, 0, 1, 2, 3),
                        new Word("SHOPIFY", false, 3, 3, 9, 3),
                        new Word("GOOGLE", false, 5, 2, 5, 7),
                        new Word("ANDROID", false, 3, 0, 9, 0),
                        new Word("FACEBOOK", false, 0, 4, 7, 4));

                wordsGrid.setLetters(hardLetterArray.get(0));
                break;

            case 1:
                //Configure for Android and change Swift positions
                wordsGrid.setWords(
                        new Word("SWIFT", false, 8, 2, 8, 6),
                        new Word("JAVA", false, 5, 7, 8, 7),
                        new Word("KOTLIN", false, 2, 1, 7, 6),
                        new Word("OBJECTIVEC", false, 0, 0, 9, 9),
                        new Word("MAC", false, 9, 2, 9, 4),
                        new Word("MOBILE", false, 4, 1, 9, 1),
                        new Word("FACEBOOK", false, 0, 1, 0, 8),
                        new Word("SHOPIFY", false, 1, 0, 7, 0),
                        new Word("GOOGLE", false, 1, 3, 1, 8),
                        new Word("ANDROID", false, 2, 9, 8, 9)
                );

                wordsGrid.setLetters(hardLetterArray.get(1));
                break;

            default:
                Toast.makeText(this, "This default block is executed when the grid cannot be randomized.", Toast.LENGTH_SHORT).show();
                break;

        }


    }

    private void pickMediumGrid(int randomGrid) {

        switch (randomGrid) {
            case 0:
                wordsGrid.setWords(
                        new Word("SWIFT", false, 0, 4, 0, 8),
                        new Word("JAVA", false, 1, 4, 4, 4),
                        new Word("OBJECTIVEC", false, 0, 0, 9, 0),
                        new Word("KOTLIN", false, 7, 4, 7, 9),
                        new Word("MOBILE", false, 1, 8, 6, 8),
                        new Word("VARIABLE", false, 0, 3, 7, 3),
                        new Word("SHOPIFY", false, 0, 9, 6, 9),
                        new Word("GOOGLE", false, 8, 1, 8, 6));

                wordsGrid.setLetters(mediumLettersArray.get(0));
                break;


            case 1:
                wordsGrid.setWords(
                        new Word("SHOPIFY", false, 2, 0, 8, 0),
                        new Word("SWIFT", false, 8, 3, 8, 7),
                        new Word("JAVA", false, 1, 3, 4, 6),
                        new Word("VARIABLE", false, 1, 2, 8, 9),
                        new Word("MOBILE", false, 3, 9, 8, 9),
                        new Word("GOOGLE", false, 0, 0, 5, 5),
                        new Word("OBJECTIVEC", false, 9, 0, 9, 9),
                        new Word("KOTLIN", false, 2, 1, 7, 6)
                );
                wordsGrid.setLetters(mediumLettersArray.get(1));

                break;


            default:
                Toast.makeText(this, "Default case triggered", Toast.LENGTH_SHORT).show();
                break;
        }

    }

    private void pickEasyGrid(int randomGrid) {

        switch (randomGrid) {
            case 0:

                wordsGrid.setWords(
                        new Word("SWIFT", false, 7, 3, 3, 7),
                        new Word("JAVA", false, 1, 1, 1, 4),
                        new Word("OBJECTIVEC", false, 9, 0, 0, 9),
                        new Word("KOTLIN", false, 3, 8, 8, 8),
                        new Word("MOBILE", false, 2, 1, 7, 1),
                        new Word("VARIABLE", false, 9, 2, 9, 9));

                wordsGrid.setLetters(easyLetterArray.get(0));
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

                wordsGrid.setLetters(easyLetterArray.get(1));
                break;

            default:
                Toast.makeText(this, "This default block is executed when the grid cannot be randomized.", Toast.LENGTH_SHORT).show();
                break;

        }


    }

    private void startStopWatch() {


        stopwatch = new StopWatch();
        stopwatch.setTextView(stopwatchText);
        stopwatch.start();
    }

    private void initDifficultyDialogView(View difficultyDialog) {

        easyButton = difficultyDialog.findViewById(R.id.easyButton);
        mediumButton = difficultyDialog.findViewById(R.id.mediumButton);
        hardButton = difficultyDialog.findViewById(R.id.hardButton);

    }

    private void addToLeaderboard(String name, String timestamp) {

        class AddToLeaderboardTask extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {

                String rawTime = timestamp.replace(":", "");

                Log.d("TAG", "doInBackground: RAW TIME : " + rawTime);
                Log.d("TAG", "doInBackground: ORIGINAL TIME : " + timestamp);

                LeaderboardEntity playerSession = new LeaderboardEntity();
                playerSession.setName(name);
                playerSession.setTimestamp(timestamp);
                playerSession.setRawTime(Integer.valueOf(rawTime));

                LeaderboardDatabase db = LeaderboardDatabase.getDatabase(MainActivity.this);
                db.leaderboardDao().insert(playerSession);

                leaderboardList = db.leaderboardDao().getLeaderboardData();

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                // finish();

                Toast.makeText(MainActivity.this, "Saved!", Toast.LENGTH_SHORT).show();


            }
        }


        AddToLeaderboardTask task = new AddToLeaderboardTask();
        task.execute();
    }


}

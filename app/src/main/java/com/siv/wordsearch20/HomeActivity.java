package com.siv.wordsearch20;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class HomeActivity extends AppCompatActivity {

    public MaterialButton play_button, instructions_button, leaderboard_button, about_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        play_button = findViewById(R.id.play_btn);
        instructions_button = findViewById(R.id.instructions_btn);
        leaderboard_button = findViewById(R.id.leaderboard_btn);
        about_button = findViewById(R.id.about_btn);

        final View aboutAlertView = LayoutInflater.from(HomeActivity.this).inflate(R.layout.about_alert_view, null);


        play_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, MainActivity.class));
            }
        });

        instructions_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder instDialogBuilder = new AlertDialog.Builder(HomeActivity.this);
                instDialogBuilder.setTitle("Instructions");
                instDialogBuilder.setMessage(R.string.instructions);
                instDialogBuilder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Do nothing.
                    }
                });

                AlertDialog instDialog = instDialogBuilder.create();
                instDialog.show();
            }
        });

        leaderboard_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, LeaderBoardActivity.class));
            }
        });

        about_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(HomeActivity.this);
                materialAlertDialogBuilder.setView(aboutAlertView);
                materialAlertDialogBuilder.create().show();
            }
        });

    }
}

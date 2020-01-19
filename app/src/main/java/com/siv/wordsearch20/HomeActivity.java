package com.siv.wordsearch20;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

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
                final View aboutAlertView = LayoutInflater.from(HomeActivity.this).inflate(R.layout.about_alert_view, null);
                TextView aboutText = aboutAlertView.findViewById(R.id.about_text);
                ImageButton twitterButton = aboutAlertView.findViewById(R.id.twitterButton);
                ImageButton githubButton = aboutAlertView.findViewById(R.id.githubButton);

                twitterButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            Intent intent = new Intent(Intent.ACTION_VIEW,
                                    Uri.parse("twitter://user?screen_name=sivansundar"));
                            startActivity(intent);
                        } catch (Exception e) {
                            startActivity(new Intent(Intent.ACTION_VIEW,
                                    Uri.parse("https://twitter.com/sivansundar")));
                        }
                    }
                });

                githubButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://github.com/sivansundar")));
                    }
                });

                aboutText.setMovementMethod(LinkMovementMethod.getInstance());

                MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(HomeActivity.this);
                materialAlertDialogBuilder.setTitle("About");
                materialAlertDialogBuilder.setView(aboutAlertView);

                materialAlertDialogBuilder.setCancelable(true);
                materialAlertDialogBuilder.create().show();
            }
        });

    }
}

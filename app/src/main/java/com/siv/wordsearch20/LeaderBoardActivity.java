package com.siv.wordsearch20;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.siv.wordsearch20.Database.LeaderboardDatabase;
import com.siv.wordsearch20.Database.LeaderboardEntity;

import java.util.List;

public class LeaderBoardActivity extends AppCompatActivity {

    RecyclerView leaderBoardRecyclerView;
    LeaderboardAdapter leaderboardAdapter;

    LeaderboardDatabase db;

    List<LeaderboardEntity> leaderboardEntityList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_board);


        getLeaderboardData();
//        leaderboardEntityList = db.leaderboardDao().getLeaderboardData();

        leaderBoardRecyclerView = findViewById(R.id.leaderboard_recyclerView);
        leaderBoardRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        //leaderboardAdapter.notifyDataSetChanged();
    }

    private void getLeaderboardData() {

        class GetLeaderBoardDataAsync extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {
                db = LeaderboardDatabase.getDatabase(LeaderBoardActivity.this);
                leaderboardEntityList = db.leaderboardDao().getLeaderboardData();
                leaderboardAdapter = new LeaderboardAdapter(leaderboardEntityList, getApplicationContext());
                leaderBoardRecyclerView.setAdapter(leaderboardAdapter);
                Log.d("LeaderboardActivity", "onCreate: Leaderboard data  : " + leaderboardEntityList);

                leaderboardAdapter.notifyDataSetChanged();

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
            }
        }

        GetLeaderBoardDataAsync getLeaderBoardDataAsync = new GetLeaderBoardDataAsync();
        getLeaderBoardDataAsync.execute();

    }
}

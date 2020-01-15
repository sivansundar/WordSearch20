package com.siv.wordsearch20.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {LeaderboardEntity.class}, version = 1, exportSchema = false)
public abstract class LeaderboardDatabase extends RoomDatabase {

    private static final int NUM_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUM_OF_THREADS);
    private static volatile LeaderboardDatabase INSTANCE;

    static LeaderboardDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (LeaderboardDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            LeaderboardDatabase.class, "word_search_database")
                            .build();

                }
            }
        }

        return INSTANCE;

    }

    public abstract LeaderboardDao leaderboardDao();
}

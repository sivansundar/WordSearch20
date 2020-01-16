package com.siv.wordsearch20.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface LeaderboardDao {

    @Insert
    void insert(LeaderboardEntity leaderboardEntity);

    @Query("SELECT * FROM leaderboard ORDER BY RawTime ASC")
    List<LeaderboardEntity> getLeaderboardData();


}

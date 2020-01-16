package com.siv.wordsearch20.Database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "leaderboard")
public class LeaderboardEntity {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    private int lid;

    @NonNull
    @ColumnInfo(name = "Name")
    private String name;

    @NonNull
    @ColumnInfo(name = "Time")
    private String timestamp;

    @NonNull
    @ColumnInfo(name = "RawTime")
    private int rawTime;


    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(@NonNull String timestamp) {
        this.timestamp = timestamp;
    }

    public int getRawTime() {
        return rawTime;
    }

    public void setRawTime(int rawTime) {
        this.rawTime = rawTime;
    }
}

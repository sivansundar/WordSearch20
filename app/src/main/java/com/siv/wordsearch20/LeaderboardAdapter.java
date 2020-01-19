package com.siv.wordsearch20;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.siv.wordsearch20.Database.LeaderboardEntity;

import java.util.List;

public class LeaderboardAdapter extends RecyclerView.Adapter<LeaderboardAdapter.ViewHolder> {

    public List<LeaderboardEntity> leaderboardData;
    public Context mContext;


    public LeaderboardAdapter(List<LeaderboardEntity> leaderboardData, Context mContext) {
        this.leaderboardData = leaderboardData;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public LeaderboardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.leaderboard_item, parent, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeaderboardAdapter.ViewHolder holder, int position) {

        holder.leaderboardID_text.setText(String.valueOf(position + 1));
        holder.leaderboardName_text.setText(leaderboardData.get(position).getName());
        holder.leaderboardTime_text.setText(leaderboardData.get(position).getTimestamp());
        holder.leaderboardDifficulty_text.setText(leaderboardData.get(position).getDifficulty());
    }

    @Override
    public int getItemCount() {
        return leaderboardData.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView leaderboardID_text;
        public TextView leaderboardName_text;
        public TextView leaderboardTime_text;
        public TextView leaderboardDifficulty_text;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            leaderboardID_text = itemView.findViewById(R.id.lid_text);
            leaderboardName_text = itemView.findViewById(R.id.lname_text);
            leaderboardTime_text = itemView.findViewById(R.id.ltime_text);
            leaderboardDifficulty_text = itemView.findViewById(R.id.ldifficulty_text);


        }
    }
}

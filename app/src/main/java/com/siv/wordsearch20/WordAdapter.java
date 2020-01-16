package com.siv.wordsearch20;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.Chip;

import java.util.ArrayList;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.ViewHolder> {

    public ArrayList<String> wordList;
    public Context mContext;

    public WordAdapter(ArrayList<String> wordList, Context mContext) {
        this.wordList = wordList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.word_item, parent, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.wordChip.setText(wordList.get(position));
    }

    @Override
    public int getItemCount() {
        return wordList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        Chip wordChip;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            wordChip = itemView.findViewById(R.id.wordChip);

        }
    }
}

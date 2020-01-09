package com.siv.wordsearch20;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static android.content.ContentValues.TAG;

public class LetterAdapter extends RecyclerView.Adapter<LetterAdapter.MyViewHolder> {

    public List<Letter> lettersList;
    public Context mContext;

    public LetterAdapter(List<Letter> lettersList, Context mContext) {
        this.lettersList = lettersList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public LetterAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.word_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull LetterAdapter.MyViewHolder holder, int position) {

        Letter letterData = lettersList.get(position);
//        holder.letter.setText(letterData.getLetter());
        holder.setLetter(letterData.letter);
        Log.d(TAG, "onBindViewHolder: LETTER : " + letterData.getLetter() + " Position : " + position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, " VALUE : " + letterData.getLetter() + " Boolean : " + letterData.isSelected   , Toast.LENGTH_SHORT).show();

                if (!letterData.isSelected) {
                    letterData.isSelected = true;
                    holder.itemView.setBackgroundColor(Color.GREEN);
                    Toast.makeText(mContext, "SELECTED : " + letterData.isSelected, Toast.LENGTH_SHORT).show();
                }
                else {
                    letterData.isSelected = false;
                    holder.itemView.setBackgroundColor(Color.WHITE);

                    Toast.makeText(mContext, "SELECTED : " + letterData.isSelected, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return lettersList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


        }

        public void setLetter(char letter) {
            TextView let;
            let = itemView.findViewById(R.id.letter_text);

            let.setText(String.valueOf(letter));

        }

        public void setColor() {

            //Change color when tapped on letter

        }
    }
}

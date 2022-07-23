package com.example.jokesapp.controller;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.jokesapp.R;

public class CardsDataAdapter extends ArrayAdapter<String> {

    private Context mContext;
    private boolean clicked = true;

    public CardsDataAdapter(@NonNull Context context, int resource) {
        super(context, resource);

        mContext =context;

    }

    @Override
    public View getView(int position, final View contentView, ViewGroup parent){
        //supply the layout for your card
        TextView v = (contentView.findViewById(com.example.jokesapp.R.id.content));
        v.setText(getItem(position));

        ImageButton likeButton = contentView.findViewById(R.id.likeButton);

        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(mContext, "Like btn is tapped", Toast.LENGTH_SHORT).show();

                if (clicked) {

                    likeButton.setImageResource(R.drawable.like_filled);
                    clicked = false;

                } else {

                    likeButton.setImageResource(R.drawable.like_empty);
                    clicked = true;

                }

            }
        });

        return contentView;
    }

}
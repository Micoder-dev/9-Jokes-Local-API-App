package com.example.jokesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.jokesapp.controller.CardsDataAdapter;
import com.wenchao.cardstack.CardStack;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    CardStack mCardStack;
    CardsDataAdapter mCardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("JOKES", loadJSONFromAsset());


        mCardStack = findViewById(R.id.container);

        mCardStack.setContentResource(R.layout.joke_card);
        mCardStack.setStackMargin(20);

        mCardAdapter = new CardsDataAdapter(getApplicationContext(),0);
        mCardAdapter.add("test1");
        mCardAdapter.add("test2");
        mCardAdapter.add("test3");
        mCardAdapter.add("test4");
        mCardAdapter.add("test5");

        mCardStack.setAdapter(mCardAdapter);

    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = this.getAssets().open("jokes.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

}
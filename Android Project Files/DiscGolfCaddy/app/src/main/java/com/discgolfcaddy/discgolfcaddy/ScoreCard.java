package com.discgolfcaddy.discgolfcaddy;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;


public class scoreCard extends Activity {


    private int holeCount = 0;
    private int playerCount = 0; // variables for player count and hole count.
    private int[] scores;
    //private ScrollView scorelayout;
    private RelativeLayout[] players;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_card);
        Intent intent = getIntent();
        Bundle extras = getIntent().getExtras();
        holeCount = extras.getInt("holes");
        playerCount = extras.getInt("players");
        //playerCount = 4;
        //ScrollView score = (ScrollView) findViewById(R.id.scrollView);
        RelativeLayout score = (RelativeLayout) findViewById(R.id.scorecard);
        TextView[] texts = new TextView[playerCount];
        EditText[] scores = new EditText[playerCount];
        for (int c=0; c< playerCount; c++){
            texts[c] = new TextView(this);
            scores[c] = new EditText(this);
            texts[c].setId(c);
            scores[c].setId(c);
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            if (c > 0){
                params.addRule(RelativeLayout.BELOW, c-1);
                //texts[c].
            }
            texts[c].setLayoutParams(params);
            params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            scores[c].setLayoutParams(params);
            texts[c].setText(Integer.toString((c+1)));
            score.addView(texts[c]);
            score.addView(scores[c]);
        }

       /*
        setContentView(R.layout.activity_score_card);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }*/
    }


    @Override
        public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        /*
        getMenuInflater().inflate(R.menu.menu_score_card, menu);
        return true;*/
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }
/*
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_map, container, false);
            return rootView;
        }*/
    }
}

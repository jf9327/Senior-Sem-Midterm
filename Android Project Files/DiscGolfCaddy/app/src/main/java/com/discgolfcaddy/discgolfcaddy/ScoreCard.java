package com.discgolfcaddy.discgolfcaddy;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.InputType;
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
import android.widget.TableLayout;
import android.widget.TableRow;
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
        Bundle extras = getIntent().getExtras();
        holeCount = extras.getInt("holes");
        playerCount = extras.getInt("players");
        TableLayout scorecard = (TableLayout) findViewById(R.id.scorecard);
        TextView[] texts = new TextView[playerCount];
        EditText[] scores = new EditText[playerCount];
        TableRow[] trows = new TableRow[playerCount];
        for (int c=0; c < playerCount; c++){
            trows[c] = new TableRow(this);
            texts[c] = new TextView(this);
            scores[c] = new EditText(this);
            texts[c].setId(c);
            scores[c].setId(c * playerCount);
            scores[c].setInputType(InputType.TYPE_CLASS_NUMBER);
            texts[c].setText("Player: " + Integer.toString((c+1)));
            trows[c].addView(texts[c]);
            trows[c].addView(scores[c]);
            scorecard.addView(trows[c]);
        }

    }
    @Override
    public void onDestroy(){
        // Add stuff for the shared preferences here.
        super.onDestroy();
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

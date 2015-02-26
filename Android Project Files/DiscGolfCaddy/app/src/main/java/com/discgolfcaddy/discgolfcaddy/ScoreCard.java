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
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


public class scoreCard extends Activity {


    private int holeCount = 0;
    private int playerCount = 0; // variables for player count and hole count.
    private int holenumber = 0;
    //      [hole][player]
    private int[][] playerscores;
    //private ScrollView scorelayout;
    private Button next;
    private Button back;
    private TextView[] texts;
    private EditText[] scores;
    private TableRow[] trows;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_card);
        Bundle extras = getIntent().getExtras();
        TextView holenum = (TextView) findViewById(R.id.hole_count);
        holenum.append(Integer.toString(holenumber+1));
        holeCount = extras.getInt("holes");
        playerCount = extras.getInt("players");
        playerscores = new int[holeCount][playerCount];
        initPlayerArray();
        TableLayout scorecard = (TableLayout) findViewById(R.id.scorecard);
        texts = new TextView[playerCount];
        scores = new EditText[playerCount];
        trows = new TableRow[playerCount];
        for (int c=0; c < playerCount; c++){
            trows[c] = new TableRow(this);
            texts[c] = new TextView(this);
            scores[c] = new EditText(this);
            texts[c].setId(c);
            scores[c].setId(c * playerCount);
            scores[c].setInputType(InputType.TYPE_CLASS_NUMBER);
            scores[c].setText("0");
            texts[c].setText("Player: " + Integer.toString((c+1)));
            trows[c].addView(texts[c]);
            trows[c].addView(scores[c]);
            scorecard.addView(trows[c]);
        }
        next = (Button) findViewById(R.id.button_next);
        back = (Button) findViewById(R.id.button_back);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holenumber == holeCount){
                    // start final score activity.
                } else {
                    for (int x = 0; x < playerCount; x++) {
                        playerscores[holenumber][x] = Integer.parseInt(scores[x].getText().toString());
                        scores[x].setText(Integer.toString(playerscores[holenumber][x]));
                    }
                    TextView holenum = (TextView) findViewById(R.id.hole_count);
                    holenumber++;
                    holenum.setText("Hole: " + Integer.toString(holenumber + 1));
                }
               // holenum.append(Integer.toString(holenumber+1));
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holenumber > 0){
                    holenumber--;
                    for (int y =0; y < playerCount; y++){
                       scores[y].setText(Integer.toString(playerscores[holenumber][y]));
                        //scores[y].getText();
                    }
                    TextView holenum = (TextView) findViewById(R.id.hole_count);
                    holenum.setText("Hole: " + Integer.toString(holenumber + 1));
                    //holenumber++;
                }
                // else do nothing.
            }
        });
    }
    @Override
    public void onDestroy(){
        // Add stuff for the shared preferences here.
        super.onDestroy();
    }
    public void initPlayerArray(){
        for (int a =0; a < holeCount; a++){
            for (int b =0; b < playerCount; b++){
                playerscores[a][b] = 0;
            }
        }
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

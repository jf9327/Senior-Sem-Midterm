package com.discgolfcaddy.discgolfcaddy;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ActionMenuView;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.view.Menu;
import android.view.View.OnClickListener;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.app.Activity;

public class mainMenu extends Activity implements OnClickListener {

    private Menu gameMenu;
    private PopupMenu newGamePopup;
    private RelativeLayout mainMenuLayout;
    private RelativeLayout newGameParameters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        findViewById(R.id.new_game).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //v.getId();
                start_newgame();
            }
        });
                findViewById(R.id.start_button).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mainMenu.this, scoreCard.class);
                Bundle b = new Bundle();
                EditText players = (EditText) findViewById(R.id.number_players);
                EditText holes = (EditText) findViewById(R.id.number_holes);
                b.putInt("players", Integer.parseInt(players.getText().toString()));
                b.putInt("holes", Integer.parseInt(holes.getText().toString()));
                intent.putExtras(b);
                startActivity(intent);

            }
        });
        //newGamePopup = new PopupMenu(this, findViewById(R.id.new_game));

    }
    @Override
    public void onBackPressed(){
        if (mainMenuLayout.getVisibility() == View.INVISIBLE){
            mainMenuLayout = (RelativeLayout) findViewById(R.id.main_menu);
            mainMenuLayout.setVisibility(View.VISIBLE);
            newGameParameters = (RelativeLayout) findViewById(R.id.new_game_parameters);
            newGameParameters.setVisibility(View.INVISIBLE);
        } else {
            super.onBackPressed();
        }

    }
    @Override
    public void onPause(){
        super.onPause();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);
        gameMenu = menu;
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

       return false;
       //return super.onOptionsItemSelected(item);
    }
    /*
    @Override
    public boolean onPrepareOptionsMenu(Menu menu){

        return super.onPrepareOptionsMenu(menu);
    }*/
    public void start_newgame(){
        // change visible attribute for the id main_menu relative layout to "gone"
        // also change visible attribute for the other Relative layout id new_game_paramters to visible to get input on the number
        // of users and the number of holes for as fresh game.
       // gameMenu.clear();
        mainMenuLayout = (RelativeLayout) findViewById(R.id.main_menu);
        mainMenuLayout.setVisibility(View.INVISIBLE);
        newGameParameters = (RelativeLayout) findViewById(R.id.new_game_parameters);
        newGameParameters.setVisibility(View.VISIBLE);

    }
    public void start_coursefinder(){
        // start golf course activity.
    }

    @Override
    public void onClick(View v) {

    }

}


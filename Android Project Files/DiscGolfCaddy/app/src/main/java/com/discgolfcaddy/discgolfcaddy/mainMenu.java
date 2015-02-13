package com.discgolfcaddy.discgolfcaddy;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ActionMenuView;
import android.view.View;
import android.widget.RelativeLayout;

public class mainMenu extends ActionBarActivity {

    private Menu gameMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
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
        switch (id){
            case R.id.new_game:
                start_newgame();
                return true;

            case R.id.course_finder:
                start_coursefinder();
                return true;

        }
        return super.onOptionsItemSelected(item);
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
        gameMenu.clear();
    }
    public void start_coursefinder(){
        // start golf course activity.
    }
}

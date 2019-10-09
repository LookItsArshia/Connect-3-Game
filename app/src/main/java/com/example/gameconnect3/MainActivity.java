package com.example.gameconnect3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int activePlayer =0; //0=yellow, 1=red
    int[] keepTrack={9,9,9,9,9,9,9,9,9};
    int[][] waysToWin = {
            {0,1,2}, {3,4,5}, {6,7,8},
            {0,3,6}, {1,4,7}, {2,5,8},
            {0,4,8},{2,4,6}};

    public void dropIn(View view){
        ImageView counter = (ImageView) view;
        //System.out.println(counter.getTag().toString());
        int tapped = Integer.parseInt(counter.getTag().toString());
        System.out.println(tapped);
        //Need to do 3 things
        //Move it to top of the screen
        //Apply red or yellow to it as image
        //bring it back down again


        if(keepTrack[tapped]==9){
            keepTrack[tapped]= activePlayer;
            counter.setTranslationY(-1000f);
            if (activePlayer==0){
                counter.setImageResource(R.drawable.yellow);
                activePlayer=1;
            }
            else{
                counter.setImageResource(R.drawable.red);
                activePlayer=0;

            }
            counter.animate().translationYBy(1000f).setDuration(300);
            for (int[] winnings : waysToWin){
                if(keepTrack[winnings[0]] == keepTrack[winnings[1]] && keepTrack[winnings[1]]== keepTrack[winnings[2]]&& keepTrack[winnings[0]]!=9){
                    System.out.println(keepTrack[winnings[0]]);
                }
            }

        }

    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

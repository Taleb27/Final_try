package y2022.aoc.taleb.final_try;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class tictoeActivity extends AppCompatActivity {
private TextView playeronescore,playertwoscore,playerstatus;
private Button [] buttons = new Button[9];
private Button resetGame;
private int playeronescorecount,playertwoscorecount,roundcount;
boolean activePlayer;

    int [] gameState = {2,2,2,2,2,2,2,2,2};

    int [][]winningPositions = {
            {0,1,2}, {3,4,5}, {6,7,8},//rows
            {0,3,6}, {1,4,7} , {2,5,8}, // columns
            {0,4,8} , {2,4,6}
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tictoe);

    }
}




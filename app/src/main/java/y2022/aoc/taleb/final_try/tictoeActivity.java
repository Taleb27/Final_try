package y2022.aoc.taleb.final_try;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class tictoeActivity extends AppCompatActivity implements View.OnClickListener,DialogInterface.OnClickListener {
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
        playeronescore =(TextView) findViewById(R.id.playeronescore);
        playertwoscore = (TextView) findViewById(R.id.playertwoscore);
        playerstatus = (TextView) findViewById(R.id.playerStatus);
        resetGame = (Button) findViewById(R.id.resetGame);

        for(int i=0; i< buttons.length;i++){
            String buttonID = "btn_"+i;
            int resourceID = getResources().getIdentifier(buttonID, "id", getPackageName());
            buttons[i] = (Button) findViewById(resourceID);
            buttons[i].setOnClickListener(this);

        }
roundcount = 0;
        playeronescorecount=0;
        playertwoscorecount=0;
        activePlayer=true;
    }

    @Override
    public void onClick(View v) {
      if (!((Button)v).getText().toString().equals("")){
          return;
      }
      String buttonId = v.getResources().getResourceEntryName(v.getId());
      int gameStatePointer = Integer.parseInt(buttonId.substring(buttonId.length()-1,buttonId.length()));

      if(activePlayer){
          ((Button) v).setText("x");
          ((Button) v).setTextColor(Color.parseColor("#FFC34A"));
          gameState[gameStatePointer] = 0;
      } else{
          ((Button) v).setText("o");
          ((Button) v).setTextColor(Color.parseColor("#70FFEA"));
          gameState[gameStatePointer] = 1;
      }
      roundcount++;
      if (checkWinner()){
          if (activePlayer){
              playeronescorecount++;
              updateplayerScore();
              Toast.makeText(this,"player one Won!", Toast.LENGTH_SHORT).show();
              playAgain();
          }else{
              playertwoscorecount++;
              updateplayerScore();
              Toast.makeText(this,"player two Won!", Toast.LENGTH_SHORT).show();
              playAgain();
          }
      }else if (roundcount==9){
             playAgain();
             Toast.makeText(this, "No Winner!", Toast.LENGTH_SHORT).show();

      }else {
          activePlayer = !activePlayer;
      }
     if (playeronescorecount>playertwoscorecount){
         playerstatus.setText("player One is winning!");
     }else if (playeronescorecount<playertwoscorecount){
         playerstatus.setText("player Two is winning!");
     }else{
         playerstatus.setText("");
     }
     resetGame.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             playAgain();
             playeronescorecount=0;
             playertwoscorecount=0;
             playerstatus.setText("");
             updateplayerScore();

         }
     });
    }
    public boolean checkWinner(){
        boolean winnerResult = false;

        for(int [] winningPosion : winningPositions){
            if (gameState[winningPosion[0]] == gameState[winningPosion[1]]&& gameState[winningPosion[1]]== gameState[winningPosion[2]]&& gameState[winningPosion[0]]!=2)
            {
                winnerResult = true;
            }
        }
        return winnerResult;
    }
public void updateplayerScore(){
        playeronescore.setText(Integer.toString(playeronescorecount));
        playertwoscore.setText(Integer.toString(playertwoscorecount));

}
public void playAgain(){
        roundcount = 0;
        activePlayer = true;

        for (int i=0; i < buttons.length; i++){
            gameState[i] = 2;
            buttons[i].setText("");

        }

    }
    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder=  new AlertDialog.Builder(this);
        builder.setMessage("are u sure");
        builder.setCancelable(false);
        builder.setPositiveButton("yes",this);
        builder.setNegativeButton("N0",this);
        AlertDialog dialog= builder.create();
        dialog.show();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        if(which== dialog.BUTTON_POSITIVE){
            super.onBackPressed();

            dialog.cancel();
        }
        if(which== dialog.BUTTON_NEGATIVE){

            dialog.cancel();
        }

    }

}




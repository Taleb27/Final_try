package y2022.aoc.taleb.final_try;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.CompoundButton;


import java.util.Random;

public class higherlowerActivity extends AppCompatActivity implements View.OnClickListener,DialogInterface.OnClickListener{
public static final int Max_number=100;
public static final Random RANDOM = new Random();
private TextView msgTv;
private EditText numberEnteredEt;
private Button submit;
private int numberTofind , numberTries;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_higherlower);
        msgTv = findViewById(R.id.msg);
        numberEnteredEt = findViewById(R.id.numberEnteredEt);
        submit = findViewById(R.id.Submit);
        submit = findViewById(R.id.Submit);
        submit.setOnClickListener(this);
        newGame();

    }


    @Override
    public void onClick( View view){

    }
    private void submit(){
        int n = Integer.parseInt(numberEnteredEt.getText().toString());
        numberTries++;

        if(n==numberTofind){
            Toast.makeText(this , "congratulations . you gussed right "+numberTofind+ "in"+ numberTries+ "tries",Toast.LENGTH_SHORT).show();
            newGame();

        }else if( n> numberTofind){
            msgTv.setText(R.string.too_high);
            numberEnteredEt.setText("");
        }else if(n<numberTofind){
            msgTv.setText(R.string.too_low);
            numberEnteredEt.setText("");
        }
    }
    private void newGame(){
        numberTofind = RANDOM.nextInt(Max_number)+1;
        msgTv.setText("You Win!");
        numberEnteredEt.setText("");
        numberTries = 0

        ;
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
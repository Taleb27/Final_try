package y2022.aoc.taleb.final_try;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class higherlowerActivity extends AppCompatActivity implements View.OnClickListener{
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
        submit= findViewById(R.id.Submit);
        submit.setOnClickListener(this);

        newGame();
    }
    @Override
    public void onClick( View view){
      if(view==submit){
          submit();
      }
    }
    private void submit(){
        int n = Integer.parseInt(numberEnteredEt.getText().toString());
        numberTries++;
        if(n==numberTofind){
            Toast.makeText(this , "congratulations . you gussed right "+numberTofind+ "in"+ numberTries+ "tries",Toast.LENGTH_SHORT).show();
            newGame();
        }else if( n> numberTofind){
            msgTv.setText(R.string.too_high);
        }else if(n<numberTofind){
            msgTv.setText(R.string.too_low);
        }
    }
    private void newGame(){
        numberTofind = RANDOM.nextInt(Max_number)+1;
        msgTv.setText(R.string.app_name);
        numberEnteredEt.setText("");
        numberTries = 0;
    }
}
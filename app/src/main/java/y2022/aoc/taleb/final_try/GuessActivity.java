package y2022.aoc.taleb.final_try;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GuessActivity extends AppCompatActivity implements View.OnClickListener {
private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess);
        btn1 = findViewById(R.id.Btn1);
        btn1.setOnClickListener(this);
        btn2 = findViewById(R.id.Btn2);
        btn2.setOnClickListener(this);
        btn3 = findViewById(R.id.Btn3);
        btn3.setOnClickListener(this);
        btn4 = findViewById(R.id.Btn4);
        btn4.setOnClickListener(this);

        changeButtonsColors();
    }


    @Override
    public void onClick(View view) {

    }

    public void changeButtonsColors(){
        Button[] randbut = {btn1,btn2,btn3,btn4};
        int[] options = {-1, -1, -1, -1};
        int[] colors = {Color.GREEN,Color.RED,Color.BLUE, Color.YELLOW};
        for(int i=0; i<options.length;i++) {
            randbut[i].setBackgroundColor(colors[randNumber()]);

        }

    }

    public int randNumber(){
        return (int)(Math.random()*4);
    }
}
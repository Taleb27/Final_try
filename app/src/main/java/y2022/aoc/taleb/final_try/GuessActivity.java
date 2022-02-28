package y2022.aoc.taleb.final_try;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

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

    public boolean isThere(Button btn1,Button btn2,Button btn3,Button btn4,int color){

        ColorDrawable buttonColor1 = (ColorDrawable) btn1.getBackground();
        ColorDrawable buttonColor2 = (ColorDrawable) btn2.getBackground();
        ColorDrawable buttonColor3 = (ColorDrawable) btn3.getBackground();
        ColorDrawable buttonColor4 = (ColorDrawable) btn4.getBackground();
        if(buttonColor1.getColor()==color)
            return false;
        else if(buttonColor2.getColor()==color)
            return false;
        else if(buttonColor3.getColor()==color)
            return false;
        else if((buttonColor4.getColor()==color))
            return false;
        return true;

    }

    public void changeButtonsColors(){
        Button[] randbut = {btn1,btn2,btn3,btn4};
        Button temp = btn1;
        Integer[] norepeat= new Integer[randbut.length];
        int[] options = {-1, -1, -1, -1};
        int[] colors = {Color.GREEN,Color.RED,Color.BLUE, Color.YELLOW};
        for(int i=0; i<options.length;i++) {
            temp.setBackgroundColor(colors[randNumber()]);
            ColorDrawable buttonColor = (ColorDrawable) temp.getBackground();

            while(!isThere(btn1,btn2,btn3,btn4,buttonColor.getColor())){
                temp.setBackgroundColor(colors[randNumber()]);
                buttonColor = (ColorDrawable) temp.getBackground();
            }
            randbut[i].setBackgroundColor(buttonColor.getColor());

        }

    }

    public int randNumber(){
        return (int)(Math.random()*4);
    }
}
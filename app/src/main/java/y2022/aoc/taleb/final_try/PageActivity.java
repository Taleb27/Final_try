package y2022.aoc.taleb.final_try;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PageActivity extends AppCompatActivity implements View.OnClickListener {
    private Button guess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);

        guess = findViewById(R.id.buttonGuess);
        guess.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
     GuessActivity();
    }


    private void GuessActivity() {
        Intent intent= new Intent(PageActivity.this, tictoeActivity.class);
        startActivity(intent);
    }
}
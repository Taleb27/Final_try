package y2022.aoc.taleb.final_try;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class PageActivity extends AppCompatActivity implements View.OnClickListener {
    private Button guess;
    private Button high;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);

        guess = findViewById(R.id.buttonGuess);
        guess.setOnClickListener(this);
        high = findViewById(R.id.BtnMath);
        high.setOnClickListener(this);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent intent= new Intent(PageActivity.this,ProfileActivity.class);
                startActivity(intent);
                break;
            case R.id.extmenu:

                break;
        }
        return super.onOptionsItemSelected(item);

    }


    @Override
    public void onClick(View v) {
        Intent i= new Intent(this,tictoeActivity.class);
        Intent i1= new Intent(this,higherlowerActivity.class);

        if(v.getId()==R.id.buttonGuess)
            startActivity(i);
        else
            startActivity(i1);
    }


}
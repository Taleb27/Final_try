package y2022.aoc.taleb.final_try;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ArrayListActivity extends AppCompatActivity  {
    //the object of the view - design
    private ListView myListView;
    //the object for the adapter connecting the data to the view
    private CustomAdapter myAdapter;
    //object containing the items to be displayed - Data
    private ArrayList<Item> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_list);
        list=new ArrayList<>();

        list.add(new Item("my first item",R.drawable.background,true,50));
        list.add(new Item("idk",R.drawable.background,true,34));
        list.add(new Item("this is supposed to be a string",R.drawable.background,true,74));
        list.add(new Item("weeeeee",R.drawable.background,true,21));

        //reference to the list view so it can be programmed
        myListView=findViewById(R.id.MyListView);

        //connect adapter with data
        myAdapter=new CustomAdapter(this,R.raw.supermariobros,list);

        //connect adapter with view
        myListView.setAdapter(myAdapter);
        //connects click listener to items in the list

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),"Item:"+list.get(i),Toast.LENGTH_LONG).show();
            }
        });
        myListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                list.remove(i);
                myAdapter.notifyDataSetChanged();
                return false;

            }
        });
    }
}
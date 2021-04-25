package com.example.basiclist2021;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class BasicListViewActivity extends AppCompatActivity {

    protected ListView listView;
    public final static String TAG = "BasicListView";
    // add two weeks worth of days to demonstrate scrolling in ListView
    protected String[] myArray = {"Monday", "Tuesday", "Wednesday", "Thursday",
            "Friday", "Saturday", "Sunday",
            "Monday", "Tuesday", "Wednesday", "Thursday",
            "Friday", "Saturday", "Sunday"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set up the ListView widget
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,myArray);
        this.listView=findViewById(R.id.listView);

        //associate listview and adapter
        this.listView.setAdapter(arrayAdapter);
        this.listView.setClickable(true);
        listView.setOnItemClickListener(new ListListener(this));
    }

    private class ListListener implements AdapterView.OnItemClickListener {

        private Context context;
        ListListener(Context context){this.context = context; }
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {


            // which list item was clicked ?
            Object obj = listView.getItemAtPosition(position);

            //view in Logcat
            Log.i(TAG,"Clicked:"+obj.toString());

            //Use a toast
            Toast toast = Toast.makeText(context, obj.toString(), Toast.LENGTH_SHORT);
            toast.show();

        }
    } //ListListener
}///~
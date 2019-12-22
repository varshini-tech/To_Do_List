package com.blogspot.atifsoftwares.to_do_list;

import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> to_do_list;
    ArrayAdapter<String> list_to_view;
    ListView listview;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
                to_do_list=new ArrayList<>();
        list_to_view=new ArrayAdapter<>(this,R.layout.list_view,to_do_list);
        listview=findViewById(R.id.list_1);

        listview.setAdapter(list_to_view);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView=(TextView) view;
                textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

            }
        });
        editText=findViewById(R.id.et);

    }
    public void addtolist(View view){
        to_do_list.add(editText.getText().toString());
        list_to_view.notifyDataSetChanged();

        editText.setText("");

    }
}

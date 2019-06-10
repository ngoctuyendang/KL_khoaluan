package com.example.icaremonitor;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class History_Activity extends AppCompatActivity {
    ImageView image ;

    private static final String TAG = "ListDataActivity";
    Database mDatabase;
    ArrayList<User> userList;

    private ListView mListview;
    User user;
    Cursor cursor;

    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        btnDelete = (Button)findViewById(R.id.btndel);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabase.deleteAll();
                mListview.setAdapter(null);
                Toast.makeText(History_Activity.this, "đã xóa tất cả ", Toast.LENGTH_LONG).show();
            }
        });

        image = (ImageView)findViewById(R.id.btnback);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(History_Activity.this,Main2Activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.animotion,R.anim.animotion2);
            }
        });
        mDatabase = new Database(this);

        userList = new ArrayList <>();
        Cursor data = mDatabase.getData();

        mListview = (ListView) findViewById(R.id.listView);

        int numRows=data.getCount();
        if (numRows == 0) {
            Toast.makeText(History_Activity.this, "nothing ", Toast.LENGTH_LONG).show();
        } else {
            while (data.moveToNext()) {
                String value;
                String date;
                String ex;
                value = data.getString(1);
                date = data.getString(2);
                ex = data.getString(3);
                User user = new User(value, date, ex);
                userList.add(user);

                ThreeColumn_ListAdapter adapter = new ThreeColumn_ListAdapter(this, R.layout.list_row, userList);

                mListview.setAdapter(adapter);
            }

        }
    }
}

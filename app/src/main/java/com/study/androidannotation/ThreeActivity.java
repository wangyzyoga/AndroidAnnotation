package com.study.androidannotation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.ItemLongClick;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

@EActivity(R.layout.activity_three)
public class ThreeActivity extends AppCompatActivity {

    @ViewById(R.id.lV1)
    ListView listView;

    @ItemLongClick(R.id.lV1)
    public void listViewItemClick() {
        Toast.makeText(ThreeActivity.this, "你好！", 1).show();
    }

    @AfterViews
    public void init() {
        List<String> name = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            name.add(String.valueOf(i));
        }

        MyAdapter adapter = new MyAdapter(ThreeActivity.this, name);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}

package com.study.androidannotation;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_second)
public class SecondActivity extends Activity {

    @Extra(MainActivity.NAME_KEY)
    String name;
    @Extra(MainActivity.AGE_KEY)
    String age;

    @ViewById(R.id.tV1)
    TextView tV1;
    @ViewById
    TextView tV2;

    @AfterViews
    public void initView() {
        tV1.setText(name);
        tV2.setText(age);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}

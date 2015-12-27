package com.study.androidannotation;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.LongClick;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.DimensionRes;
import org.androidannotations.annotations.res.StringRes;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    public static final String NAME_KEY = "name_key";
    public static final String AGE_KEY = "age_key";

    @ViewById(R.id.btn1)
    Button button;

    @ViewById(R.id.tV2)
    TextView tV2;
    @ViewById
    TextView tV3;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
//    @ViewsById({R.id.tV2, R.id.tV3})
//    List<TextView> list;

    @StringRes(R.string.name)
    String name;

    @DimensionRes(R.dimen.text_size)
    float fontsize;

    @Background
    public void doSomething() {
        Log.e("*****tag*****", "thread id =" + Thread.currentThread().getId());
        updateUI();
    }

    @org.androidannotations.annotations.UiThread
    public void updateUI() {
        tV3.setText("update UI");
    }

    @Click(R.id.btn1)
    public void startActivity() {
        doSomething();
//        Intent intent = new Intent(MainActivity.this, SecondActivity_.class);
//        intent.putExtra(NAME_KEY, "yoga");
//        intent.putExtra(AGE_KEY, "20");
//        startActivity(intent);
    }

    @LongClick({R.id.tV2, R.id.tV3})
    public void showToast() {
        Toast.makeText(MainActivity.this, "OK", 1).show();
    }

    @AfterViews
    public void setTextView() {
        tV2.setText("textView2");
        tV3.setText(name);
        tV3.setTextSize(fontsize);
//        tV3.setText("textView3");
//        for (TextView textView:list) {
//            textView.setText("Hello @ViewsById!");
//        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("*****tag*****", "MainActivity id =" + Thread.currentThread().getId());
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.study.androidannotation/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.study.androidannotation/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}

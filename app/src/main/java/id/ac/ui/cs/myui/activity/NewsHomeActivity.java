package id.ac.ui.cs.myui.activity;

import android.content.Intent;

import android.os.Bundle;

import android.widget.FrameLayout;


import com.crashlytics.android.Crashlytics;
import id.ac.ui.cs.myui.R;
import id.ac.ui.cs.myui.task.NewsSceleTask;
import io.fabric.sdk.android.Fabric;

public class NewsHomeActivity extends BookmarkActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        //setContentView(R.layout.activity_news_home);

        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.content_bookmark); //Remember this is the FrameLayout area within your activity_main.xml
        getLayoutInflater().inflate(R.layout.activity_news_home, contentFrameLayout);
        

        new NewsSceleTask(this).execute();

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }
}

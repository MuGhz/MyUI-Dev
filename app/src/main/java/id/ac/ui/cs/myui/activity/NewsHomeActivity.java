package id.ac.ui.cs.myui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ListView;

import id.ac.ui.cs.myui.R;
import id.ac.ui.cs.myui.task.NewsSceleTask;

public class NewsHomeActivity extends BookmarkActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_news_home);

        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.content_bookmark); //Remember this is the FrameLayout area within your activity_main.xml
        getLayoutInflater().inflate(R.layout.activity_news_home, contentFrameLayout);


        new NewsSceleTask(this).execute();

    }
}

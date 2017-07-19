package id.ac.ui.cs.myui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import id.ac.ui.cs.myui.R;
import id.ac.ui.cs.myui.task.NewsSceleTask;

public class NewsHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_home);

        new NewsSceleTask(this).execute();
    }
}

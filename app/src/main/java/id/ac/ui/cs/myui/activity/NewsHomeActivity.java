package id.ac.ui.cs.myui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import com.crashlytics.android.Crashlytics;
import id.ac.ui.cs.myui.R;
import id.ac.ui.cs.myui.task.NewsSceleTask;
import io.fabric.sdk.android.Fabric;

public class NewsHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_news_home);

        new NewsSceleTask(this).execute();
    }
}

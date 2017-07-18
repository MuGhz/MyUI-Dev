package id.ac.ui.cs.myui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import id.ac.ui.cs.myui.R;

public class NewsDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        TextView pubDate = (TextView) findViewById(R.id.pubdate);
        TextView news_title = (TextView) findViewById(R.id.news_title);
        TextView news_author = (TextView) findViewById(R.id.news_author);
        TextView news_content = (TextView) findViewById(R.id.news_content);


    }
}

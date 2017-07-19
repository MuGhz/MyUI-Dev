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

        String tanggal = getIntent().getStringExtra("Tanggal");
        String description = getIntent().getStringExtra("Description");
        String penulis = getIntent().getStringExtra("Penulis");
        String judul = getIntent().getStringExtra("Judul");

        TextView pubDate = (TextView) findViewById(R.id.pubdate);
        TextView news_title = (TextView) findViewById(R.id.news_title);
        TextView news_author = (TextView) findViewById(R.id.news_author);
        TextView news_content = (TextView) findViewById(R.id.news_content);


        news_content.setText(description);
        pubDate.setText(tanggal);
        news_title.setText(judul);
        news_author.setText(penulis);

    }
}

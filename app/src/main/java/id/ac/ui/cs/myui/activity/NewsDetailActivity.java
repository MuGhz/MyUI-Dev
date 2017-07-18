package id.ac.ui.cs.myui.activity;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import id.ac.ui.cs.myui.R;

public class NewsDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        Intent intent = getIntent();

        TextView pubDate = (TextView) findViewById(R.id.pubdate);
        pubDate.setText(intent.getStringExtra("pubDate"));

        TextView news_title = (TextView) findViewById(R.id.news_title);
        news_title.setText(intent.getStringExtra("title"));

        TextView news_author = (TextView) findViewById(R.id.news_author);
        news_author.setText(intent.getStringExtra("author"));
        news_author.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("CLICK","Next update can see author profile");
            }
        });

        TextView news_content = (TextView) findViewById(R.id.news_content);
        if (Build.VERSION.SDK_INT >= 24) {
            news_content.setText(Html.fromHtml(intent.getStringExtra("content"),Html.FROM_HTML_MODE_LEGACY));
        }
        else {
            news_content.setText(Html.fromHtml(intent.getStringExtra("content")));
        }


    }
}

package id.ac.ui.cs.myui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

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

        //Get button bookmark
        ImageButton buttonBookmark = (ImageButton) findViewById(R.id.button_bookmark);

        //Set button bookmark onclick listener
        buttonBookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bookmark();
            }
        });


        news_content.setText(description);
        pubDate.setText(tanggal);
        news_title.setText(judul);
        news_author.setText(penulis);

    }

    private void bookmark(){
        Toast.makeText(NewsDetailActivity.this, "Bookmark", Toast.LENGTH_SHORT).show();
    }

}

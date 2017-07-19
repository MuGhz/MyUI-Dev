package id.ac.ui.cs.myui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import id.ac.ui.cs.myui.R;
import id.ac.ui.cs.myui.database.DatabaseHandler;
import id.ac.ui.cs.myui.model.News;

public class NewsDetailActivity extends AppCompatActivity {

    DatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        // Init database
        databaseHandler = new DatabaseHandler(this);
        //
        final String tanggal = getIntent().getStringExtra("Tanggal");
        final String description = getIntent().getStringExtra("Description");
        final String penulis = getIntent().getStringExtra("Penulis");
        final String judul = getIntent().getStringExtra("Judul");
        final String link = getIntent().getStringExtra("link");

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
                News news = new News(judul, description, link, 0, tanggal, penulis);
                bookmark(news);
            }
        });


        news_content.setText(description);
        pubDate.setText(tanggal);
        news_title.setText(judul);
        news_author.setText(penulis);

    }

    private void bookmark(News news){

        if (!isBookmarked(news)){
            Toast.makeText(NewsDetailActivity.this, "Berhasil menambahkan ke daftar Bookmark", Toast.LENGTH_SHORT).show();
            news.setBookmarked(true);
            databaseHandler.addNews(news);
        }else{
            Toast.makeText(NewsDetailActivity.this, "Sudah di Bookmark", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isBookmarked(News news){
        List<News> newsList = databaseHandler.getAllBookmarkedNews();
        for (News i :newsList){
            if (i.getTitle().equals(news.getTitle())){
                return true;
            } if (i.getTanggal().equals(news.getTanggal())){
                return true;
            }
        }
        return false;
    }

}

package id.ac.ui.cs.myui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
    String parent; //Activity that showed before this activity. It can be bookmark activity or news home activity.
    //If former activity was bookmark: parent.equals("bookmark"), otherwise: parent.equals("newsHome").

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
        parent = getIntent().getStringExtra("contextParent");


        TextView pubDate = (TextView) findViewById(R.id.pubdate);
        TextView news_title = (TextView) findViewById(R.id.news_title);
        TextView news_author = (TextView) findViewById(R.id.news_author);
        TextView news_content = (TextView) findViewById(R.id.news_content);

        //Get button bookmark
        ImageButton buttonBookmark = (ImageButton) findViewById(R.id.button_bookmark);

        //Set button bookmark onclick listener
        final News news = new News(judul, description, link, tanggal, penulis);
        setBookmarkButton(news, buttonBookmark);



        news_content.setText(description);
        pubDate.setText(tanggal);
        news_title.setText(judul);
        news_author.setText(penulis);

    }

    private void setBookmarkButton(final News news, ImageButton buttonBookmark){
        if (parent.equals("bookmark")){
            buttonBookmark.setBackgroundDrawable(getResources().getDrawable(R.drawable.bookmark_delete_button));
            setTitle("Detail News Bookmark");
            buttonBookmark.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    unBookmark(news);
                }
            });
        }else {
            buttonBookmark.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    bookmark(news);
                }
            });
            setTitle("Detail New News");
        }
    }

    private void bookmark(News news){

        if (!isBookmarked(news)){
            Toast.makeText(NewsDetailActivity.this, "Berhasil menambahkan ke daftar Bookmark", Toast.LENGTH_SHORT).show();
            databaseHandler.addBookmark(news);
        }else{
            Toast.makeText(NewsDetailActivity.this, "Sudah di Bookmark", Toast.LENGTH_SHORT).show();
        }
    }

    private void unBookmark(News news){

        if (isBookmarked(news)){
            Toast.makeText(NewsDetailActivity.this, "Berhasil menghapus dari daftar Bookmark", Toast.LENGTH_SHORT).show();
            databaseHandler.deleteBookmark(news);
            Intent intent = new Intent(NewsDetailActivity.this, BookmarkNewsActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(NewsDetailActivity.this, "Sudah terhapus dari Bookmark", Toast.LENGTH_SHORT).show();
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

    @Override
    public void onBackPressed() {
        Intent intent;
        if (parent.equals("bookmark")){
            intent = new Intent(NewsDetailActivity.this, BookmarkNewsActivity.class);
        }else{
            intent = new Intent(NewsDetailActivity.this, NewsHomeActivity.class);
        }
        startActivity(intent);
    }
}

package id.ac.ui.cs.myui.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
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

    public static final String PACKAGE_NAME = "jp.naver.line.android";
    public static final String CLASS_NAME = "jp.naver.line.android.activity.selectchat.SelectChatActivity";
    public static final String PACKAGE_WA = "com.whatsapp";
    Context context;
    ImageButton ibShareLine;
    ImageButton ibShare;
    ImageButton ibShareWA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        context = this;

        ibShareLine = (ImageButton) findViewById(R.id.button_line);
        ibShare = (ImageButton) findViewById(R.id.button_share);
        ibShareWA = (ImageButton) findViewById(R.id.button_wa);

        // Init database
        databaseHandler = new DatabaseHandler(this);
        //
        final String tanggal = getIntent().getStringExtra("Tanggal");
        final String description = getIntent().getStringExtra("Description");
        final String penulis = getIntent().getStringExtra("Penulis");
        final String judul = getIntent().getStringExtra("Judul");
        final String link = getIntent().getStringExtra("link");
        parent = getIntent().getStringExtra("contextParent");

        Log.d("desc",description);
        TextView pubDate = (TextView) findViewById(R.id.pubdate);
        final TextView news_title = (TextView) findViewById(R.id.news_title);
        final TextView news_author = (TextView) findViewById(R.id.news_author);
        final TextView news_content = (TextView) findViewById(R.id.news_content);

        //Get button bookmark
        ImageButton buttonBookmark = (ImageButton) findViewById(R.id.button_bookmark);

        //Set button bookmark onclick listener
        final News news = new News(judul, description, link, tanggal, penulis);
        setBookmarkButton(news, buttonBookmark);



        news_content.setText(description);
        pubDate.setText(tanggal);
        news_title.setText(judul);
        news_author.setText(penulis);

        String[] tmp = news_content.getText().toString().split(" ");
        String sendString = "";
        if (tmp.length >= 25) {
            for (int i = 0; i < 25; i++) {
                sendString += tmp[i] + " ";
            }
        } else {
            sendString = news_content.getText().toString()
            ;
        }

        final String snippet = sendString + "...";

        ibShareLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkLineInstalled()) {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setClassName(PACKAGE_NAME, CLASS_NAME);
                    intent.setType("text/plain");
                    String shareBodyText = news_title.getText() + "\n" + news_author.getText()
                            + "\n" + snippet + "\n\nSelengkapnya : \n" + link;
                    intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject/Title");
                    intent.putExtra(android.content.Intent.EXTRA_TEXT, shareBodyText);
                    startActivity(intent);
                } else {
                    Toast.makeText(context, "LINE tidak terdeteksi, silahkan install terlebih dahulu", Toast.LENGTH_SHORT).show();
                }
            }

        });

        ibShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(android.content.Intent.ACTION_SEND);
                intent.setType("text/plain");
                String shareBodyText = news_title.getText() + "\n" + news_author.getText()
                        + "\n" + snippet + "\n\nSelengkapnya : \n" + link;
                intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject/Title");
                intent.putExtra(android.content.Intent.EXTRA_TEXT, shareBodyText);
                startActivity(Intent.createChooser(intent, "Choose sharing method"));
            }
        });

        ibShareWA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                if (checkWAInstalled()) {
                    Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
                    whatsappIntent.setType("text/plain");
                    whatsappIntent.setPackage("com.whatsapp");
                    String shareBodyText = news_title.getText() + "\n" + news_author.getText()
                            + "\n" + snippet + "\n\nSelengkapnya : \n" + link;
                    whatsappIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBodyText);
                    whatsappIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject/Title");
                    startActivity(whatsappIntent);
                }
                else {
                    Toast.makeText(context, "WhatsApp tidak terdeteksi, silahkan install terlebih dahulu", Toast.LENGTH_SHORT).show();
                }


            }
        });

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
    private boolean checkLineInstalled(){
        PackageManager pm = getPackageManager();
        List<ApplicationInfo> m_appList = pm.getInstalledApplications(0);
        boolean lineInstallFlag = false;
        for (ApplicationInfo ai : m_appList) {
            if(ai.packageName.equals(PACKAGE_NAME)){
                lineInstallFlag = true;
                break;
            }
        }
        return lineInstallFlag;
    }

    private boolean checkWAInstalled(){
        PackageManager pm = getPackageManager();
        List<ApplicationInfo> m_appList = pm.getInstalledApplications(0);
        boolean lineInstallFlag = false;
        for (ApplicationInfo ai : m_appList) {
            if(ai.packageName.equals(PACKAGE_WA)){
                lineInstallFlag = true;
                break;
            }
        }
        return lineInstallFlag;
    }
}

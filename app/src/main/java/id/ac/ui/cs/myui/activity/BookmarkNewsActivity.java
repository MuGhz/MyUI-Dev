package id.ac.ui.cs.myui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import id.ac.ui.cs.myui.R;
import id.ac.ui.cs.myui.adapter.BookmarkNewsAdapter;
import id.ac.ui.cs.myui.database.DatabaseHandler;
import id.ac.ui.cs.myui.model.News;

public class BookmarkNewsActivity extends BookmarkActivity{
    DatabaseHandler databaseHandler;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_bookmark_news);

        // Init database
        databaseHandler = new DatabaseHandler(this);

        setTitle("Bookmark News");
        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.content_bookmark); //Remember this is the FrameLayout area within your activity_main.xml
        getLayoutInflater().inflate(R.layout.activity_bookmark_news, contentFrameLayout);


        final ListView listView = (ListView) findViewById(R.id.list_bookmark);
        ArrayList<News> listMenuItems = createSampleMenu();
        final BookmarkNewsAdapter listMenuAdapter = new BookmarkNewsAdapter(BookmarkNewsActivity.this, R.layout.bookmark_item, listMenuItems);
        listView.setAdapter(listMenuAdapter);
        final Intent intent = new Intent(this, NewsDetailActivity.class);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String title = listMenuAdapter.getItem(i).getTitle();
                String description = listMenuAdapter.getItem(i).getDescription();
                String tanggal = listMenuAdapter.getItem(i).getTanggal();
                String penulis = listMenuAdapter.getItem(i).getPenulis();
                String link = listMenuAdapter.getItem(i).getLink();
                intent.putExtra("Description", description);
                intent.putExtra("Tanggal", tanggal);
                intent.putExtra("Penulis", penulis);
                intent.putExtra("Judul", title);
                intent.putExtra("link", link);
                intent.putExtra("contextParent", "bookmark");
                startActivity(intent);
            }
        });


    }

    private ArrayList<News> createSampleMenu(){
        List<News> newsList = databaseHandler.getAllBookmarkedNews();
        ArrayList<News> dummy = new ArrayList<>();
        for (News i :newsList){
            dummy.add(new News(i.getTitle(),i.getDescription(),i.getLink(),i.getTanggal(),i.getPenulis()));
        }
        return dummy;

    }

    @Override
    public void onBackPressed() {
        Intent intent = intent = new Intent(this, NewsHomeActivity.class);
        startActivity(intent);
    }
}

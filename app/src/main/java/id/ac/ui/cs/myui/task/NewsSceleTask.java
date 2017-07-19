package id.ac.ui.cs.myui.task;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RemoteViews;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import id.ac.ui.cs.myui.R;
import id.ac.ui.cs.myui.activity.NewsDetailActivity;
import id.ac.ui.cs.myui.activity.NewsHomeActivity;
import id.ac.ui.cs.myui.adapter.NewsAdapter;
import id.ac.ui.cs.myui.model.ItemNews;
import id.ac.ui.cs.myui.model.News;
import id.ac.ui.cs.myui.model.NewsScele;
import id.ac.ui.cs.myui.service.NewsService;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by agni.wira on 17/07/17.
 */

public class NewsSceleTask extends AsyncTask<Object,Object,ArrayList<News>> {
    private Context context;

    public NewsSceleTask(Context context) {
        this.context = context;
    }

    @Override
    protected ArrayList<News> doInBackground(Object... objects) {
        Retrofit client = new Retrofit.Builder()
                .baseUrl("https://scele.cs.ui.ac.id/")
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        NewsService service = client.create(NewsService.class);

        Call<NewsScele> call = service.listNewsScele();

        Response<NewsScele> posts = null;


        try {
            posts = call.execute();

            ArrayList<ItemNews> itemNews = posts.body().getChannel().item;

            ArrayList<News> news = new ArrayList<>();


            for (int i=0; i<itemNews.size(); i++){
                String title = itemNews.get(i).getTitle();
                String desc = itemNews.get(i).getContent();
                String link = itemNews.get(i).getLink();
                String tanggal = itemNews.get(i).getPubdate();
                String penulis = itemNews.get(i).getPenulis();
                news.add(new News(title,desc,link,i,tanggal,penulis));
            }

            return news;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    @Override
    protected void onPostExecute(ArrayList<News> newsSceles) {
        Activity newsHome = (Activity) context;
        final ListView listView = (ListView) newsHome.findViewById(R.id.list_news);
        ArrayList<News> listMenuItems = newsSceles;
        final NewsAdapter listMenuAdapter = new NewsAdapter(context, R.layout.news_item_layout, listMenuItems);
        listView.setAdapter(listMenuAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                News value = (News) adapterView.getItemAtPosition(i);

                Intent intent = new Intent(context, NewsDetailActivity.class);
                intent.putExtra("title",value.getTitle());
                intent.putExtra("pubDate",value.getTanggal());
                intent.putExtra("content",value.getDescription());
                intent.putExtra("author",value.getPenulis());
                intent.putExtra("link",value.getLink()+"");
                intent.putExtra("id",value.getId());

                context.startActivity(intent);
            }
        });

        }
}

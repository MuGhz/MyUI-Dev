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
            Log.d("githubagni", ((posts.body()).getChannel().item).get(0).getPenulis()+"ayam");

            ArrayList<News> news = new ArrayList<>();


            for (int i=0; i<((posts.body()).getChannel().item).size(); i++){
                String title = (posts.body()).getChannel().item.get(i).getTitle();
                String desc = (posts.body()).getChannel().item.get(i).getContent();
                String link = (posts.body()).getChannel().item.get(i).getLink();
                String tanggal = (posts.body()).getChannel().item.get(i).getPubdate();
                String penulis = (posts.body()).getChannel().item.get(i).getPenulis();

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

        final Intent intent = new Intent(context, NewsDetailActivity.class);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String title = listMenuAdapter.getItem(i).getTitle();
                String description = listMenuAdapter.getItem(i).getDescription();
                String tanggal = listMenuAdapter.getItem(i).getTanggal();
                String penulis = listMenuAdapter.getItem(i).getPenulis();
                intent.putExtra("Description", description);
                intent.putExtra("Tanggal", tanggal);
                intent.putExtra("Penulis", penulis);
                intent.putExtra("Judul", title);
                context.startActivity(intent);
            }
        });

    }
}

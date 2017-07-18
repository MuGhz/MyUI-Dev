package id.ac.ui.cs.myui.task;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import id.ac.ui.cs.myui.model.NewsScele;
import id.ac.ui.cs.myui.service.NewsService;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by agni.wira on 17/07/17.
 */

public class NewsSceleTask extends AsyncTask<Object,Object,ArrayList<NewsScele>> {
    private Context context;

    public NewsSceleTask(Context context) {
        this.context = context;
    }

    @Override
    protected ArrayList<NewsScele> doInBackground(Object... objects) {
        Retrofit client = new Retrofit.Builder()
                .baseUrl("https://scele.cs.ui.ac.id/")
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        NewsService service = client.create(NewsService.class);

        Call<NewsScele> call = service.listNewsScele();

        Response<NewsScele> posts = null;


        try {
            posts = call.execute();
            Log.d("githubagni", (posts.body()).getChannel().title+"ayam");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }
}

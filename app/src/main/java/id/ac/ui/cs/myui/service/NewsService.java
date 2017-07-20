package id.ac.ui.cs.myui.service;

import java.util.List;

import id.ac.ui.cs.myui.model.NewsScele;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by agni.wira on 17/07/17.
 */

public interface NewsService {
    @GET("rss/file.php/31/666b240034aa3e621eb79626d3fc2b12/mod_forum/1/rss.xml")
    Call<NewsScele> listNewsScele();
}



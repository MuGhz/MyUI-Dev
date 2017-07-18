package id.ac.ui.cs.myui.service;

import java.util.List;

import id.ac.ui.cs.myui.model.NewsScele;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by agni.wira on 17/07/17.
 */

public interface NewsService {
    @GET("rss/file.php/31/d7770acd577a06a1a67cd40c160b88f6/mod_forum/1/rss.xml")
    Call<NewsScele> listNewsScele();
}



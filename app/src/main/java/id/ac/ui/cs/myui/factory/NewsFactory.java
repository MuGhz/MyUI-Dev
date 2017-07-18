package id.ac.ui.cs.myui.factory;

import android.content.Intent;
import android.text.Editable;

import java.util.ArrayList;
import java.util.Random;

import id.ac.ui.cs.myui.model.News;

/**
 * Created by Ivan on 7/18/17.
 */

public class NewsFactory {
    public static News getNews()
    {
        String newsTitle = "Berita 1";
        String newsContent = "orem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
        String newsDate = "2017-01-01";
        String newsDateEdited = newsDate;
        String newsSubmitBy = "Orang 1";
        String newsEditedBy = newsSubmitBy;
        return new News(newsTitle, newsContent, newsDate, newsDateEdited, newsSubmitBy, newsEditedBy);
    }

    public static News getNews(String newsTitle, String newsContent, String newsDate, String newsDateEdited, String newsSubmitBy, String newsEditedBy){
        return new News(newsTitle, newsContent, newsDate, newsDateEdited, newsSubmitBy, newsEditedBy);
    }

    public static ArrayList<News> getNews(Integer size) {
        return new ArrayList<News>();
    }
}

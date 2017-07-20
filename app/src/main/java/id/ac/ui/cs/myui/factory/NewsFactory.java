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
    public static News getNews() {
        long id = 0;
        String title = "Berita 1";
        String description = "orem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
        String tanggal = "2017-01-01";
        String link = "cs.ui.ac.id";
        String penulis = "Orang 1";
        boolean bookmarked = false;

        return new News(title, description, link, tanggal, penulis);
    }
}



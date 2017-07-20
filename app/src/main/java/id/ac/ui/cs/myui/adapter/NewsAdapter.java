package id.ac.ui.cs.myui.adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import id.ac.ui.cs.myui.R;
import id.ac.ui.cs.myui.model.News;

/**
 * Created by agni.wira on 18/07/17.
 */

public class NewsAdapter extends ArrayAdapter<News> {
    private final LayoutInflater mInflater;
    private ArrayList<News> menuList;

    public NewsAdapter(@NonNull Context context, @LayoutRes int resource, ArrayList<News> items) {
        super(context, resource);
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        menuList = items;

    }

    @Override
    public int getCount() {
        return menuList.size();
    }

    @Nullable
    @Override
    public News getItem(int position) {
        return menuList.get(position);
    }

    @Override
    public int getPosition(@Nullable News item) {
        return super.getPosition(item);
    }

    @Override
    public long getItemId(int position) {
        return menuList.get(position).getId();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LinearLayout layout;
        if(convertView == null){
            layout = (LinearLayout) mInflater.inflate(R.layout.news_item_layout,parent,false);
        }else{
            layout = (LinearLayout) convertView;
        }
        TextView title = (TextView) layout.findViewById(R.id.title_news);
        TextView penulis = (TextView) layout.findViewById(R.id.nama_penulis_news);
        TextView tanggal = (TextView) layout.findViewById(R.id.tanggal_news);
        TextView description = (TextView) layout.findViewById(R.id.description_news);

        News itemMenu = menuList.get(position);

        title.setText(itemMenu.getTitle());
        penulis.setText(itemMenu.getPenulis());
        tanggal.setText(itemMenu.getTanggal());
        description.setText(stripHtml(itemMenu.getDescription()));

        return layout;
    }

    public String stripHtml(String html) {
        return Html.fromHtml(html).toString().replaceAll("\n", "").trim();
    }

}

package id.ac.ui.cs.myui.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.StrictMode;
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

public class NewsDetailActivity extends AppCompatActivity {
    public static final String PACKAGE_NAME = "jp.naver.line.android";
    public static final String CLASS_NAME = "jp.naver.line.android.activity.selectchat.SelectChatActivity";
    public static final String PACKAGE_WA = "com.whatsapp";
    public static
    Context context;
    ImageButton ibShareLine;
    ImageButton ibShareWA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        context = this;
        Intent intent = getIntent();

        final String link = intent.getStringExtra("link");


        ibShareLine = (ImageButton) findViewById(R.id.button_line);
        ibShareWA = (ImageButton) findViewById(R.id.button_wa);

        TextView pubDate = (TextView) findViewById(R.id.pubdate);
        pubDate.setText(intent.getStringExtra("pubDate"));

        final TextView news_title = (TextView) findViewById(R.id.news_title);
        news_title.setText(intent.getStringExtra("title"));

        final TextView news_author = (TextView) findViewById(R.id.news_author);
        news_author.setText(intent.getStringExtra("author"));
        news_author.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("CLICK", "Next update can see author profile");
            }
        });

        final TextView news_content = (TextView) findViewById(R.id.news_content);
        if (Build.VERSION.SDK_INT >= 24) {
            news_content.setText(Html.fromHtml(intent.getStringExtra("content"), Html.FROM_HTML_MODE_LEGACY));
        } else {
            news_content.setText(Html.fromHtml(intent.getStringExtra("content")));
        }


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
                    //startActivity(Intent.createChooser(intent, "Choose sharing method"));
                    startActivity(intent);
                } else {
                    Toast.makeText(context, "LINE tidak terdeteksi, silahkan install terlebih dahulu", Toast.LENGTH_SHORT).show();
                }
            }

        });



//    Button button_wa = (Button) findViewById(R.id.inibuttonwa);
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
                Log.d("DEBUG BUTTON", "onClick: LILILI");
            }

            Log.d("DEBUG BUTTON", "onClick: lalala ");

        }
    });
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

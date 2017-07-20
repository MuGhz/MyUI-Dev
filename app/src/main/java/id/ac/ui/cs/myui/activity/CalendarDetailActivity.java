package id.ac.ui.cs.myui.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

import id.ac.ui.cs.myui.R;
import id.ac.ui.cs.myui.fragment.SliderFragment;
import id.ac.ui.cs.myui.model.CalendarItem;

/**
 * Created by galih.priyambodho on 17/07/17.
 */

public class CalendarDetailActivity extends AppCompatActivity /*extends FragmentActivity*/{


    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private static final int NUM_PAGES = 5;

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_detail);
        PagerAdapter mPagerAdapter;

        Intent intent = getIntent();
        TextView kegiatan = (TextView) findViewById(R.id.kegiatan);
        TextView tanggalMulai = (TextView) findViewById(R.id.tanggal_mulai);
        TextView tanggalSelesai = (TextView) findViewById(R.id.tanggal_selesai);
        TextView durasi = (TextView) findViewById(R.id.durasi);
        TextView pelaksana = (TextView) findViewById(R.id.pelaksana);

        kegiatan.setText(intent.getStringExtra("nama kegiatan"));
        durasi.setText(intent.getStringExtra("durasi") + " hari");
        tanggalMulai.setText(intent.getStringExtra("tanggal mulai"));
        tanggalSelesai.setText(intent.getStringExtra("tanggal selesai"));
        pelaksana.setText(intent.getStringExtra("pelaksana"));


       /* // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter)*/;
    }

    /*@Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    *//**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     *//*
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new SliderFragment();
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
*/

}

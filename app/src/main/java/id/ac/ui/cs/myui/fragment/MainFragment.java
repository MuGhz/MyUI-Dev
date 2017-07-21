package id.ac.ui.cs.myui.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import id.ac.ui.cs.myui.R;
import id.ac.ui.cs.myui.activity.CalendarDetailActivity;
import id.ac.ui.cs.myui.activity.DetailActivity;
import id.ac.ui.cs.myui.activity.HomeActivity;
import id.ac.ui.cs.myui.activity.LoginActivity;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by faisalagustp on 7/13/17.
 */

/**
 * This class define Menu tab logic
 * You may have to fix this class or maybe delete it if you think necessary
 */
public class MainFragment extends Fragment {
    Button btnLogout;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d("On create", "Main fragment");
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onStart(){
        super.onStart();

        TextView tvUsername = (TextView) getView().findViewById(R.id.tvUsername);
        tvUsername.setText(getActivity().getIntent().getStringExtra("username"));
        Log.d("FRAGMENT EXTRA", getActivity().getIntent().getStringExtra("username"));
        //Event onClick to move to other Intent from fragment
        LinearLayout academicTrackerBtn = (LinearLayout) getView().findViewById(R.id.academic_tracker_btn);
        academicTrackerBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(getActivity(), CalendarDetailActivity.class);
                getActivity().startActivity(i);
            }
        });


        btnLogout=(Button) getView().findViewById(R.id.btnLogout);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp= PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor e=sp.edit();
                e.clear();
                e.apply();

                startActivity(new Intent(getActivity(),LoginActivity.class));
                getActivity().finish();   //finish current activity
            }
        });
    }

    @Override
    public void onResume(){
        super.onResume();
        TextView tvUsername = (TextView) getView().findViewById(R.id.tvUsername);
        tvUsername.setText(getActivity().getIntent().getStringExtra("username"));
        Log.d("ON RESUME FRAGMENT", getActivity().getIntent().getStringExtra("username"));
    }
}

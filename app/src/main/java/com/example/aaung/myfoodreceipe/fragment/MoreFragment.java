package com.example.aaung.myfoodreceipe.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aaung.myfoodreceipe.R;
import com.example.aaung.myfoodreceipe.adapter.HomeItemAdapter;
import com.example.aaung.myfoodreceipe.model.HomeItem;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link MoreFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MoreFragment extends Fragment implements View.OnClickListener {

    public MoreFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     */
    // TODO: Rename and change types and number of parameters
    public static MoreFragment newInstance() {
        MoreFragment fragment = new MoreFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_more, container, false);
        TextView mAppVersion = view.findViewById(R.id.txt_app_version);
        TextView mLanguageSetting = view.findViewById(R.id.txt_language_setting);
        TextView mAboutUs = view.findViewById(R.id.txt_about_us);
        TextView mShare = view.findViewById(R.id.txt_tell_a_friend);
        TextView mRateTheApp = view.findViewById(R.id.txt_rate_the_app);
        mLanguageSetting.setOnClickListener(this);
        mAboutUs.setOnClickListener(this);
        mShare.setOnClickListener(this);
        mRateTheApp.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.txt_language_setting:
                break;
            case R.id.txt_about_us:
                break;
            case R.id.txt_tell_a_friend:
                shareTheApp();
                break;
            case R.id.txt_rate_the_app:
                break;
        }
    }

    private void shareTheApp(){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Yummy Recipe");
        intent.putExtra(Intent.EXTRA_TEXT, "Hey! Download this app");
        startActivity(Intent.createChooser(intent, "choose one"));
    }
}

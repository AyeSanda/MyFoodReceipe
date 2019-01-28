package com.example.aaung.myfoodreceipe.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aaung.myfoodreceipe.R;
import com.example.aaung.myfoodreceipe.adapter.HomeItemAdapter;
import com.example.aaung.myfoodreceipe.model.HomeItem;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements HomeItemAdapter.HomeItemClickListener {

    private HomeItemAdapter mHomeItemAdapter;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView mRecyclerView = view.findViewById(R.id.rv_recipe);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        mHomeItemAdapter = new HomeItemAdapter(getContext(), this);
        mRecyclerView.setAdapter(mHomeItemAdapter);


        //mHomeItemAdapter
        return view;
    }

    @Override
    public void onHomeItemClickListener(HomeItem item) {
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_layout,CategoryListFragment.newInstance(item.getCategoryId(),false),CategoryListFragment.class.getName())
                .commit();


    }
}

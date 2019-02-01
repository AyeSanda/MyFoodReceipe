package com.example.aaung.myfoodreceipe.fragment;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aaung.myfoodreceipe.R;
import com.example.aaung.myfoodreceipe.adapter.CategoryListItemAdapter;
import com.example.aaung.myfoodreceipe.adapter.HomeItemAdapter;
import com.example.aaung.myfoodreceipe.constantdata.HomeItemConstant;
import com.example.aaung.myfoodreceipe.model.HomeItem;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link CategoryListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CategoryListFragment extends Fragment implements SearchView.OnQueryTextListener, CategoryListItemAdapter.CategoryItemClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "category_Id";
    private static final String ARG_PARAM2 = "isFrom_Tab";

    private CategoryListItemAdapter mCategoryListItemAdapter;
    private RecyclerView mRecyclerView;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CategoryListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param categoryId Parameter 1.
     * @param isFromTab Parameter 2.
     * @return A new instance of fragment CategoryListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CategoryListFragment newInstance(String categoryId, boolean isFromTab) {
        CategoryListFragment fragment = new CategoryListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, categoryId);
        args.putBoolean(ARG_PARAM2, isFromTab);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_category_list, container, false);
        mRecyclerView = view.findViewById(R.id.rv_categories);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        mCategoryListItemAdapter = new CategoryListItemAdapter(getContext(),HomeItemConstant.homeItems, this);
        mRecyclerView.setAdapter(mCategoryListItemAdapter);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_options, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getContext().getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.search).getActionView();

        searchView.setOnQueryTextListener(this);

        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        if(query.isEmpty())
            return false;

        if(mCategoryListItemAdapter != null){
            doSearchQuery(query);
        }
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if(mCategoryListItemAdapter != null){
            doSearchQuery(newText);
        }
        return true;
    }



    private void doSearchQuery(String query){

        ArrayList<HomeItem> categoryItemList = new ArrayList<>();
        for (HomeItem item :  HomeItemConstant.homeItems) {

            String name = item.getCategoryName().toLowerCase();
            if (name.contains(query.toLowerCase()))

                categoryItemList.add(item);
        }
        mCategoryListItemAdapter = new CategoryListItemAdapter(getContext(),categoryItemList,this);
        mRecyclerView.setAdapter(mCategoryListItemAdapter);
        mCategoryListItemAdapter.notifyDataSetChanged();
    }

    @Override
    public void onCategoryItemClickListener(HomeItem item) {

        CategoryDetailRecipeFragment recipeFragment = CategoryDetailRecipeFragment.newInstance(item.getCategoryId());
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_layout,recipeFragment,CategoryDetailRecipeFragment.class.getName())
                .addToBackStack(CategoryListFragment.class.getName())
                .commit();
    }
}

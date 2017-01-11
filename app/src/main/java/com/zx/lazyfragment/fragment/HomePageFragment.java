package com.zx.lazyfragment.fragment;


import android.support.v4.app.Fragment;
import android.view.View;

import com.zx.lazyfragment.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomePageFragment extends LazyFragment {


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_page;
    }

    @Override
    protected void init(View view) {

    }
}

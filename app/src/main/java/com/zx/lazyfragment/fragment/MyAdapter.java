package com.zx.lazyfragment.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by 周旭 on 2017/1/10.
 */

public class MyAdapter extends FragmentPagerAdapter {

    private List<Fragment> mList;

    public MyAdapter(FragmentManager fm,List<Fragment> mList) {
        super(fm);
        this.mList =  mList;
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }
}

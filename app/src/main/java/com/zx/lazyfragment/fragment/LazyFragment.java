package com.zx.lazyfragment.fragment;


import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * "懒加载"的Fragment的基类
 */
public abstract class LazyFragment extends Fragment {


    private View view;

    private boolean needInit;      //是否需要在onCreateView中初始化组件
    private boolean hasLoad;      //标识是否已经加载过
    private boolean hasCreated;  //是否为第一次加载数据

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        //展示 & 没有加载过
        if (isVisibleToUser && !hasLoad) {
            //如果当前Fragment向用户展示且没有加载过，进行下一步判断
            if (hasCreated) {
                //如果onCreateView已经被创建，此时进行加载
                initView();
            } else {
                //如果Fragment没有创建，那么设置标记，在onCreateView中加载
                needInit = true;
            }
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(getLayoutId(), container, false);
        if (needInit) {
            //是否要初始化，后面页不需要
            initView();
            needInit = false;
        }
        hasCreated = true;
        return view;
    }

    private void initView() {
        init(view);
        hasLoad = true;
    }

    //获取Fragment的布局文件
    @LayoutRes
    protected abstract int getLayoutId();

    //包含初始化数据
    protected abstract void init(View view);

}

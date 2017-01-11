package com.zx.lazyfragment.fragment;


import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.zx.lazyfragment.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends LazyFragment {

    private ProgressBar progressBar; //提示用户网络数据加载的进度条
    private TextView netDataTv; //显示加载后的网络数据

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void init(View view) {

        progressBar = (ProgressBar) view.findViewById(R.id.mine_progress_bar);
        netDataTv = (TextView) view.findViewById(R.id.mine_net_data_tv);

        //初始化数据
        initData();
    }




    //初始化数据
    private void initData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //模拟加载网络数据
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //网络加载结束
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setVisibility(View.GONE); //设置ProgressBar不可见
                        netDataTv.setText("加载的网络数据"); //模拟加载网络数据后，显示结果在UI
                    }
                });
            }
        }).start();
    }


}

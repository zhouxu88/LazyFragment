package com.zx.lazyfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.zx.lazyfragment.fragment.ClassifyFragment;
import com.zx.lazyfragment.fragment.HomePageFragment;
import com.zx.lazyfragment.fragment.MineFragment;
import com.zx.lazyfragment.fragment.MyAdapter;
import com.zx.lazyfragment.fragment.ShopCartFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener,RadioGroup.OnCheckedChangeListener{

    private ViewPager viewPager;
    private List<Fragment> mList;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
    }

    //初始化ViewPager的数据
    private void initData() {
        mList = new ArrayList<>();
        mList.add(new HomePageFragment());
        mList.add(new ClassifyFragment());
        mList.add(new ShopCartFragment());
        mList.add(new MineFragment());
        MyAdapter myAdapter = new MyAdapter(getSupportFragmentManager(), mList);
        viewPager.setAdapter(myAdapter);
        viewPager.setOffscreenPageLimit(mList.size() - 1);
    }

    //初始化View
    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.main_vp);
        radioGroup = (RadioGroup) findViewById(R.id.rg_main);
        viewPager.setOnPageChangeListener(this);
        radioGroup.setOnCheckedChangeListener(this);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    //设置RadioGroup的选中状态
    @Override
    public void onPageSelected(int position) {
        switch (position){
            case 0:
                radioGroup.check(R.id.home_page_rb);
                break;
            case 1:
                radioGroup.check(R.id.classify_rb);
                break;
            case 2:
                radioGroup.check(R.id.shop_cart_rb);
                break;
            case 3:
                radioGroup.check(R.id.mine_rb);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {}

    //底部导航的点击事件
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.home_page_rb:
                viewPager.setCurrentItem(0);
                break;
            case R.id.classify_rb:
                viewPager.setCurrentItem(1);
                break;
            case R.id.shop_cart_rb:
                viewPager.setCurrentItem(2);
                break;
            case R.id.mine_rb:
                viewPager.setCurrentItem(3);
                break;
        }
    }
}

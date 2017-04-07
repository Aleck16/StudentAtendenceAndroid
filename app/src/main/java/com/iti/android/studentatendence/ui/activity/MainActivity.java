package com.iti.android.studentatendence.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.iti.android.studentatendence.R;
import com.iti.android.studentatendence.ui.fragment.FragmentFactory;
import com.iti.android.studentatendence.utils.UIUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tl_main)
    TabLayout mTlMain;
    @BindView(R.id.vp_Fragment_pager)
    ViewPager mVpFragmentPager;
    @BindView(R.id.main_toolbar)
    Toolbar mMainToolbar;

    private Play_tab_Adapter mPlay_tab_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mMainToolbar.setTitle("考勤");
        setSupportActionBar(mMainToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false); //不显示bar的返回按钮
        }

        mPlay_tab_adapter = new Play_tab_Adapter(getSupportFragmentManager());
        mVpFragmentPager.setAdapter(mPlay_tab_adapter);

        /**
         * 默认不可滚动，居中显示，且填充
         */
        //tab可滚动
//        mTlMain.setTabMode(TabLayout.MODE_SCROLLABLE);
        //tab居中显示
//        mTlMain.setTabGravity(TabLayout.GRAVITY_CENTER);
        mTlMain.setupWithViewPager(mVpFragmentPager);
    }

    class Play_tab_Adapter extends FragmentPagerAdapter {

        private String[] mTabNames;

        public Play_tab_Adapter(FragmentManager fm) {
            super(fm);
            mTabNames = UIUtils.getStringArray(R.array.tab_names);   //加载页面标题数据
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = FragmentFactory.createFragment(position);
            //开始加载数据
//            fragment.loadData();
            return fragment;
        }

        @Override
        public int getCount() {
            return mTabNames.length;
        }

        //此方法用来显示tab上的标签
        @Override
        public CharSequence getPageTitle(int position) {
            return mTabNames[position];
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_teacher, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.setting:       //设置
                break;
            default:
                break;
        }
        return true;
    }
}

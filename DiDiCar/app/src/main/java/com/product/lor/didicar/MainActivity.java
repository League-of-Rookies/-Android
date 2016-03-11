package com.product.lor.didicar;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.lor.activities.BaseCompatActivity;
import com.lor.fragments.main.LeftMenuFragment;
import com.mxn.soul.flowingdrawer_core.FlowingView;
import com.mxn.soul.flowingdrawer_core.LeftDrawerLayout;

/**
 * 程序主 Activity
 * <pre>
 * Created by YanJin on 2016/3/11. 14:41
 * </pre>
 */
public class MainActivity extends BaseCompatActivity implements
        LeftMenuFragment.OnListFragmentInteractionListener {

    private static final String TAG_FRAGMENT_LEFT_MENU = "tag_fragment_left_menu";

    /**
     * 左侧抽屉菜单
     */
    private LeftDrawerLayout mLeftDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* 初始化视图 */
        initView();
        /* 添加 Fragment */
        FragmentManager fm = getSupportFragmentManager();
        LeftMenuFragment leftMenuFragment = (LeftMenuFragment)
                fm.findFragmentByTag(TAG_FRAGMENT_LEFT_MENU);
        FlowingView flowingView = (FlowingView) findViewById(R.id.activity_main_flowingView);
        if (leftMenuFragment == null) {
            fm.beginTransaction().add(R.id.activity_main_container_left_menu, leftMenuFragment
                    = LeftMenuFragment.newInstance()).commit();
        }

        /*左侧抽屉菜单设置*/
        mLeftDrawerLayout.setFluidView(flowingView);
        mLeftDrawerLayout.setMenuFragment(leftMenuFragment);


    }

    /**
     * 初始化视图
     */
    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.bg_btn_user);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLeftDrawerLayout.toggle();
            }
        });

        mLeftDrawerLayout = (LeftDrawerLayout) findViewById(R.id.activity_main_drawerLayout);

    }


    /**
     * 创建菜单：在这里添加 Toolbar 上的 menu
     *
     * @param menu --
     * @return --
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // 这里添加自定义的一个菜单布局11
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     *  Toolbar 上的 menu 被选中的回调
     *
     * @param item --
     * @return --
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_main_end:     // 最右侧的 item
                showSysToast("Clicked");
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * 左侧抽屉菜单的 item 的点击事件回调
     *
     * @param groupPosition group 位置-从 0 开始
     * @param itemPosition  item 的位置-从 0 开始
     */
    @Override
    public void onItemClick(int groupPosition, int itemPosition) {
    }
}

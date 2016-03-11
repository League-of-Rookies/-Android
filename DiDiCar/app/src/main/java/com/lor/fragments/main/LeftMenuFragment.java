package com.lor.fragments.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mxn.soul.flowingdrawer_core.MenuFragment;
import com.product.lor.didicar.R;

/**
 * <pre>
 * Created by YanJin on 2016/3/11. 15:00 <p/>
 * </pre>
 * * 一个 {@link MenuFragment} 的子类 , 用于显示 {@link com.product.lor.didicar.MainActivity}
 * 主界面的左侧抽屉的内容<br/>
 * 注意：[1] 关联此 Fragment 的 Activity 需要实现
 * {@link LeftMenuFragment.OnListFragmentInteractionListener} 接口 <br/>
 * 来处理 Fragment 和 Activity 的交互事件 <br/>
 * 注意：[2] 请使用
 * {@link LeftMenuFragment#newInstance} 工厂方法 <br/>
 * 来创建一个 此 Fragment 的实例
 */
public class LeftMenuFragment extends MenuFragment {


    /**
     * 创建一个 Fragment 实例
     * @return --
     */
    public static LeftMenuFragment newInstance() {
        LeftMenuFragment fragment = new LeftMenuFragment();
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_left_menu, container,
                false);
        // 这里必须调用 setupReveal() 方法返回根视图
        return setupReveal(view);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onOpenMenu() {
        // 抽屉菜单打开回调
    }

    @Override
    public void onCloseMenu() {
        // 抽屉菜单关闭回调
    }


    /**
     * Activity 和 Fragment 交互的接口
     */
    public interface OnListFragmentInteractionListener {
        /**
         * 左侧抽屉菜单的 item 的点击事件回调
         *
         * @param groupPosition group 位置-从 0 开始
         * @param itemPosition  item 的位置-从 0 开始
         */
        void onItemClick(int groupPosition, int itemPosition);
    }

}

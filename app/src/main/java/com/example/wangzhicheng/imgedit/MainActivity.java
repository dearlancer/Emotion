package com.example.wangzhicheng.imgedit;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ToggleButton;

import com.example.wangzhicheng.imgedit.expression.EmotionEditText;
import com.example.wangzhicheng.imgedit.expression.fragmnet.EmotionMainFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)RecyclerView recyclerView;
    @BindView(R.id.edit_text)EmotionEditText emotionEditText;
    @BindView(R.id.emotion_button)ToggleButton emotionBtn;
    @BindView(R.id.image_view)ImageView picImg;
    @BindView(R.id.fl_emotionview_main)FrameLayout emotionLay;

    private EmotionMainFragment emotionMainFragment;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initDatas();
    }

    /**
     * 初始化布局数据
     */
    private void initDatas(){
        initEmotionMainFragment();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        emotionMainFragment.unbindToEditText();
    }

    /**
     * 初始化表情面板
     */
    public void initEmotionMainFragment(){
        //构建传递参数
        Bundle bundle = new Bundle();
        //绑定主内容编辑框
        bundle.putBoolean(EmotionMainFragment.BIND_TO_EDITTEXT,true);
        //隐藏控件
        bundle.putBoolean(EmotionMainFragment.HIDE_BAR_EDITTEXT_AND_BTN,true);
        //替换fragment
        //创建修改实例
        emotionMainFragment = EmotionMainFragment.newInstance(EmotionMainFragment.class,bundle);
        emotionMainFragment.bindToContentView(emotionEditText);
        emotionMainFragment.bindToEdittext(emotionEditText);
        emotionMainFragment.bindToEmotionView(emotionBtn);
        //mAdapter.setEmotionFragment(emotionMainFragment);
        FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
        // Replace whatever is in thefragment_container view with this fragment,
        // and add the transaction to the backstack
        transaction.replace(R.id.fl_emotionview_main,emotionMainFragment);
        transaction.addToBackStack(null);
        //提交修改
        transaction.commit();
    }
}

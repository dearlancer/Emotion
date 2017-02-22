package com.example.wangzhicheng.imgedit.expression.fragmnet;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wangzhicheng.imgedit.R;
import com.example.wangzhicheng.imgedit.expression.EmotionEditText;
import com.example.wangzhicheng.imgedit.expression.EmotionKeyboard;
import com.example.wangzhicheng.imgedit.expression.Model.ImageModel;
import com.example.wangzhicheng.imgedit.expression.adapter.HorizontalRecyclerviewAdapter;
import com.example.wangzhicheng.imgedit.expression.adapter.NoHorizontalScrollerVPAdapter;
import com.example.wangzhicheng.imgedit.expression.until.EmotionUtils;
import com.example.wangzhicheng.imgedit.expression.until.GlobalOnItemClickManagerUtils;
import com.example.wangzhicheng.imgedit.expression.until.SharedPreferencedUtils;
import com.example.wangzhicheng.imgedit.expression.view.MyViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangzhicheng
 * Description:表情主界面
 * 适配一切编辑框
 */
public class EmotionMainFragment extends BaseFragment {

    //是否绑定当前Bar的编辑框的flag
    public static final String BIND_TO_EDITTEXT="bind_to_edittext";
    //是否隐藏bar上的编辑框和发生按钮
    public static final String HIDE_BAR_EDITTEXT_AND_BTN="hide bar's editText and btn";

    //当前被选中底部tab
    private static final String CURRENT_POSITION_FLAG="CURRENT_POSITION_FLAG";
    private int CurrentPosition=0;
    //底部水平tab
    private RecyclerView recyclerview_horizontal;
    private HorizontalRecyclerviewAdapter horizontalRecyclerviewAdapter;
    //表情面板
    private EmotionKeyboard mEmotionKeyboard;
    //需要绑定的内容view
    private View contentView;
    private EmotionEditText editText;

    //是否绑定当前Bar的编辑框,默认true,即绑定。
    //false,则表示绑定contentView,此时外部提供的contentView必定也是EditText
    private boolean isBindToBarEditText=true;

    //是否隐藏bar上的编辑框和发生按钮,默认不隐藏
    private boolean isHidenBarEditTextAndBtn=false;

    List<Fragment> fragments=new ArrayList<>();

    private MyViewPager viewPager;   //不可横向滚动的ViewPager
    private View emotionView;
    /**
     * 创建与Fragment对象关联的View视图时调用
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main_emotion, container, false);
        isHidenBarEditTextAndBtn= args.getBoolean(EmotionMainFragment.HIDE_BAR_EDITTEXT_AND_BTN);
        //获取判断绑定对象的参数
        isBindToBarEditText=args.getBoolean(EmotionMainFragment.BIND_TO_EDITTEXT);
        initView(rootView);
        mEmotionKeyboard = EmotionKeyboard.with(getActivity())
                .setEmotionView(rootView.findViewById(R.id.ll_emotion_layout))//绑定表情面板
                .bindToContent(contentView)//绑定内容view
                .bindToEditText(!isBindToBarEditText? ((EmotionEditText) contentView) : editText)//判断绑定那种EditView
                .bindToEmotionButton(emotionView)//绑定表情按钮
                .build();
        initListener();
        initDatas();
        //创建全局监听
        GlobalOnItemClickManagerUtils globalOnItemClickManager= GlobalOnItemClickManagerUtils.getInstance();

        if(isBindToBarEditText){
            //绑定当前Bar的编辑框
            globalOnItemClickManager.attachToEditText(editText);
        }else{
            // false,则表示绑定contentView,此时外部提供的contentView必定也是EditText
            globalOnItemClickManager.attachToEditText((EmotionEditText) contentView);
            mEmotionKeyboard.bindToEditText((EmotionEditText)contentView);
        }
        return rootView;
    }

    /**
     * 绑定内容view, 初始化的时候绑定
     * @param contentView
     * @return
     */
    public void bindToContentView(View contentView){
        this.contentView=contentView;
        if(mEmotionKeyboard != null) {
            mEmotionKeyboard.bindToContent(contentView);
            mEmotionKeyboard.bindToEditText(!isBindToBarEditText ? ((EmotionEditText) this.contentView) : (EmotionEditText) this.editText);
        }
    }

    public void bindToEmotionView(View emotionView){
        this.emotionView=emotionView;
    }

    /**
     * 绑定edittext， 可能需要动态绑定
     * @param edittext
     */
    public void bindToEdittext(EmotionEditText edittext){
        this.editText=edittext;
        GlobalOnItemClickManagerUtils.getInstance().attachToEditText(editText);
        if(mEmotionKeyboard != null) {
            mEmotionKeyboard.bindToEditText(this.editText);
        }
    }

    /**
     * 初始化view控件
     */
    protected void initView(View rootView){
        recyclerview_horizontal= (RecyclerView) rootView.findViewById(R.id.recyclerview_horizontal);
        viewPager= (MyViewPager) rootView.findViewById(R.id.vp_emotionview_layout);
    }
    public boolean needShortupView(){
        return true;
    }
    /**
     * 初始化监听器
     */
    protected void initListener(){

    }

    /**
     * 与activity解绑时需要释放静态类引用，防止内存泄漏
     */
    @Override
    public void onDetach() {
        super.onDetach();
        GlobalOnItemClickManagerUtils.getInstance().attachToEditText(null);
    }

    /**
     * 数据操作
     */
    protected void initDatas(){
        replaceFragment();
        List<ImageModel> list = new ArrayList<>();
        for (int i=0 ; i<fragments.size(); i++){
            if(i==0){
                ImageModel model1=new ImageModel();
                model1.icon= getResources().getDrawable(R.drawable.emoji000);
                model1.flag="经典笑脸";
                model1.isSelected=true;
                list.add(model1);
            }else {
                ImageModel model = new ImageModel();
                model.icon = getResources().getDrawable(R.drawable.emoji001);
                model.flag = "其他笑脸" + i;
                model.isSelected = false;
                list.add(model);
            }
        }

        //记录底部默认选中第一个
        CurrentPosition=0;
        SharedPreferencedUtils.setInteger(getActivity(), CURRENT_POSITION_FLAG, CurrentPosition);

        //底部tab
        horizontalRecyclerviewAdapter = new HorizontalRecyclerviewAdapter(getActivity(),list);
        recyclerview_horizontal.setHasFixedSize(true);//使RecyclerView保持固定的大小,这样会提高RecyclerView的性能
        recyclerview_horizontal.setAdapter(horizontalRecyclerviewAdapter);
        recyclerview_horizontal.setLayoutManager(new GridLayoutManager(getActivity(), 1, GridLayoutManager.HORIZONTAL, false));
        //初始化recyclerview_horizontal监听器
        horizontalRecyclerviewAdapter.setOnClickItemListener(new HorizontalRecyclerviewAdapter.OnClickItemListener() {
            @Override
            public void onItemClick(View view, int position, List<ImageModel> datas) {
                //获取先前被点击tab
                int oldPosition = SharedPreferencedUtils.getInteger(getActivity(), CURRENT_POSITION_FLAG, 0);
                //修改背景颜色的标记
                datas.get(oldPosition).isSelected = false;
                //记录当前被选中tab下标
                CurrentPosition = position;
                datas.get(CurrentPosition).isSelected = true;
                SharedPreferencedUtils.setInteger(getActivity(), CURRENT_POSITION_FLAG, CurrentPosition);
                //通知更新，这里我们选择性更新就行了
                horizontalRecyclerviewAdapter.notifyItemChanged(oldPosition);
                horizontalRecyclerviewAdapter.notifyItemChanged(CurrentPosition);
                //viewpager界面切换
                viewPager.setCurrentItem(position,false);
            }

            @Override
            public void onItemLongClick(View view, int position, List<ImageModel> datas) {
            }
        });



    }

    private void replaceFragment(){
        //创建fragment的工厂类
        FragmentFactory factory=FragmentFactory.getSingleFactoryInstance();
        //创建修改实例
        EmotiomComplateFragment emotionFragment= (EmotiomComplateFragment) factory.getFragment(EmotionUtils.EMOTION_CLASSIC_TYPE);
        fragments.add(emotionFragment);
        //fragments.add(luFragment);
        NoHorizontalScrollerVPAdapter adapter =new NoHorizontalScrollerVPAdapter(getActivity().getSupportFragmentManager(),fragments);
        viewPager.setAdapter(adapter);
    }


    /**
     * 是否拦截返回键操作，如果此时表情布局未隐藏，先隐藏表情布局
     * @return true则隐藏表情布局，拦截返回键操作
     *         false 则不拦截返回键操作
     */
    public boolean isInterceptBackPress(){
      return mEmotionKeyboard.interceptBackPress();
    }

}



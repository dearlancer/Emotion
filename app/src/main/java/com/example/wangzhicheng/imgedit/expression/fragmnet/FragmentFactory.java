package com.example.wangzhicheng.imgedit.expression.fragmnet;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.example.wangzhicheng.imgedit.expression.fragmnet.EmotiomComplateFragment;

/**
 * Created by wangzhicheng
 * Description:产生fragment的工厂类
 */
public class FragmentFactory {

    public static final String EMOTION_MAP_TYPE="EMOTION_MAP_TYPE";
    private static FragmentFactory factory;

    private FragmentFactory(){

    }

    /**
     * 双重检查锁定，获取工厂单例对象
     * @return
     */
    public static FragmentFactory getSingleFactoryInstance(){
        if(factory==null){
            synchronized (FragmentFactory.class){
                if(factory==null){
                    factory = new FragmentFactory();
                }
            }
        }
        return factory;
    }

    /**
     * 获取fragment的方法
     * @param emotionType 表情类型，用于判断使用哪个map集合的表情
     * 使用工厂模式 根据传入的类型判断返回的表情列表
     */
    public Fragment getFragment(int emotionType){
        Bundle bundle = new Bundle();

        bundle.putInt(FragmentFactory.EMOTION_MAP_TYPE,emotionType);

        EmotiomComplateFragment fragment= EmotiomComplateFragment.newInstance(EmotiomComplateFragment.class,bundle);

        return fragment;
    }

}

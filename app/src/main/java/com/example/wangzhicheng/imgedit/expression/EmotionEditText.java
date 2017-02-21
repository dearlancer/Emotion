package com.example.wangzhicheng.imgedit.expression;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.widget.EditText;

import com.example.wangzhicheng.imgedit.expression.until.EmotionUtils;
import com.example.wangzhicheng.imgedit.expression.until.ScreenUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class EmotionEditText extends EditText {
    public static final String EMOJIMATCHER="\\[([a-zA-Z]*[\\u4e00-\\u9fa5]*)\\]";
    public static final String LUMATCHER="\\[鹿([a-zA-Z]*[\\u4e00-\\u9fa5]*)\\]";
    EmotionEditText emotionEditText;

    public EmotionEditText(Context context) {
        this(context, null);
    }

    public EmotionEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        emotionEditText =this;
    }
    public void setEmojiText(String str){
        int start=0,end=0;
        SpannableString spannable = new SpannableString(str);
        Pattern pattern= Pattern.compile(EMOJIMATCHER);
        Matcher matcher=pattern.matcher(spannable);
        while(matcher.find()){
            start=matcher.start();
            end=matcher.end();
            String emoji=matcher.group();
            int imgId= EmotionUtils.getImgByName(EmotionUtils.EMOTION_CLASSIC_TYPE,emoji);
            Drawable drawable = null;
            try {
                drawable = getContext().getDrawable(imgId);
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                Drawable d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, ScreenUtils.dip2px(getContext(), 20), ScreenUtils.dip2px(getContext(), 20), true));
                d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
                ImageSpan span = new ImageSpan(d, ImageSpan.ALIGN_BASELINE);
                spannable.setSpan(span, start,end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            } catch (Resources.NotFoundException e) {
            }
        }
        pattern= Pattern.compile(LUMATCHER);
        matcher=pattern.matcher(spannable);
        while(matcher.find()){
            start=matcher.start();
            end=matcher.end();
            String lu=matcher.group();
            int imgId=EmotionUtils.getImgByName(EmotionUtils.LU_CLASSIC_TYPE,lu);
            Drawable drawable = null;
            try {
                drawable = getContext().getDrawable(imgId);
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                Drawable d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, ScreenUtils.dip2px(getContext(), 20), ScreenUtils.dip2px(getContext(), 20), true));
                d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
                ImageSpan span = new ImageSpan(d, ImageSpan.ALIGN_BASELINE);
                spannable.setSpan(span, start,end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            } catch (Resources.NotFoundException e) {
            }
        }
        setText(spannable);
        setSelection(spannable.length());
    }
    public void appendText(String str) {
        int index = getSelectionStart();
        Editable editable = getText();
        editable.insert(index, str);
    }

    /**
     * 获取带表情和图片的字符串的长度
     * 一个表情的长度为1
     *
     * @param s 带表情的字符串
     * @return
     */
    public int getEmojiLength(String s){
        int length = s.length();
        Pattern pattern= Pattern.compile(EMOJIMATCHER);
        Matcher matcher=pattern.matcher(s);
        while(matcher.find()){
            length-=matcher.end()-matcher.start()-1;
        }
        pattern= Pattern.compile(LUMATCHER);
        matcher=pattern.matcher(s);
        while(matcher.find()){
            length-=matcher.end()-matcher.start()-1;
        }
        return length;
    }

    /**
     * 重写拷贝事件，支持拷贝表情
     *
     * @param id
     * @return
     */
    @Override
    public boolean onTextContextMenuItem(int id) {
        if (id == android.R.id.paste) {
            ClipboardManager clip = (ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE);
            if (clip.hasPrimaryClip() && clip.getPrimaryClip().getItemCount() > 0) {
                CharSequence pasteStr = clip.getPrimaryClip().getItemAt(0).getText();
                getEditableText().insert(getSelectionStart(),pasteStr);
                return true;
            }
        }
        return super.onTextContextMenuItem(id);
    }
}

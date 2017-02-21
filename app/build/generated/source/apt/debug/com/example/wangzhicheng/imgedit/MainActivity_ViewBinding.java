// Generated code from Butter Knife. Do not modify!
package com.example.wangzhicheng.imgedit;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ToggleButton;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.wangzhicheng.imgedit.expression.EmotionEditText;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding<T extends MainActivity> implements Unbinder {
  protected T target;

  @UiThread
  public MainActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.emotionEditText = Utils.findRequiredViewAsType(source, R.id.edit_text, "field 'emotionEditText'", EmotionEditText.class);
    target.emotionBtn = Utils.findRequiredViewAsType(source, R.id.emotion_button, "field 'emotionBtn'", ToggleButton.class);
    target.picImg = Utils.findRequiredViewAsType(source, R.id.image_view, "field 'picImg'", ImageView.class);
    target.emotionLay = Utils.findRequiredViewAsType(source, R.id.fl_emotionview_main, "field 'emotionLay'", FrameLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.emotionEditText = null;
    target.emotionBtn = null;
    target.picImg = null;
    target.emotionLay = null;

    this.target = null;
  }
}

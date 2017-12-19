package com.chinastis.myeidttext;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by xianglong on 2017/9/12.
 */

public class MyEditTextView extends android.support.v7.widget.AppCompatEditText {

    public MyEditTextView(Context context) {
        super(context);
    }

    public MyEditTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyEditTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }
}

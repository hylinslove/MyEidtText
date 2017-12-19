package com.chinastis.myeidttext;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MyEditTextLayout extends LinearLayout {
    private MyTextView bac1;
    private MyTextView bac2;
    private MyTextView bac3;
    private MyTextView bac4;

    private MyEditTextView code1;
    private MyEditTextView code2;
    private MyEditTextView code3;
    private MyEditTextView code4;

    private int codeNum2;
    private int codeNum3;
    private int codeNum4;

    private final Animation animation;

    private int position = 1;

    public MyEditTextLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.edit_text_my, this);
        initView();
        animation = AnimationUtils.loadAnimation(context, R.anim.edit_bac);

        bac1.startAnimation(animation);

    }

    private void initView() {
        bac1 = (MyTextView) this.findViewById(R.id.bac1);
        bac2 = (MyTextView) this.findViewById(R.id.bac2);
        bac3 = (MyTextView) this.findViewById(R.id.bac3);
        bac4 = (MyTextView) this.findViewById(R.id.bac4);

        code1 = (MyEditTextView) this.findViewById(R.id.code1);
        code2 = (MyEditTextView) this.findViewById(R.id.code2);
        code3 = (MyEditTextView) this.findViewById(R.id.code3);
        code4 = (MyEditTextView) this.findViewById(R.id.code4);

        code1.addTextChangedListener(watcher);
        code2.addTextChangedListener(watcher);
        code3.addTextChangedListener(watcher);
        code4.addTextChangedListener(watcher);

        code1.setOnFocusChangeListener(listener);
        code2.setOnFocusChangeListener(listener);
        code3.setOnFocusChangeListener(listener);
        code4.setOnFocusChangeListener(listener);

    }

    public String getCode() {
        StringBuffer sb = new StringBuffer();
        sb.append(code1.getText().toString())
                .append(code2.getText().toString())
                .append(code3.getText().toString())
                .append(code4.getText().toString());

        return sb.toString();

    }


    private OnFocusChangeListener listener = new OnFocusChangeListener() {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if (!hasFocus) {
                return;
            }

            clearBackAnimation();

            int i = v.getId();
            if (i == R.id.code1) {
                bac1.startAnimation(animation);
                position = 1;


            } else if (i == R.id.code2) {
                bac2.startAnimation(animation);
                position = 2;


            } else if (i == R.id.code3) {
                bac3.startAnimation(animation);
                position = 3;


            } else if (i == R.id.code4) {
                bac4.startAnimation(animation);
                position = 4;


            }
        }
    };


    private TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            changeCodeLength();
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

            switch (position) {
                case 1:
                    if(code1.getText().toString().length() == 1) {
                        code2.requestFocus();
                    }

                    break;
                case 2:
                    if(code2.getText().toString().length() == 1) {
                        code3.requestFocus();
                    }
                    break;
                case 3:
                    if(code3.getText().toString().length() == 1) {
                        code4.requestFocus();
                    }
                    break;

            }
        }
    };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_DEL) {
            switch (position) {
                case 2:
                    if(codeNum2==0){
                        code1.requestFocus();
                    }
                    break;
                case 3:
                    if(codeNum3==0){
                        code2.requestFocus();
                    }
                    break;
                case 4:
                    if(codeNum4==0){
                        code3.requestFocus();
                    }
                    break;
            }
        }
        changeCodeLength();
        return super.onKeyDown(keyCode, event);
    }

    private void clearBackAnimation() {
        bac1.clearAnimation();
        bac2.clearAnimation();
        bac3.clearAnimation();
        bac4.clearAnimation();
    }

    private void changeCodeLength() {
        codeNum2 = code2.getText().toString().length();
        codeNum3 = code3.getText().toString().length();
        codeNum4 = code4.getText().toString().length();
    }

}

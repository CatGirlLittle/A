package com.dongdao.a.activity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.dongdao.a.R;

public class ResetActivity extends Activity implements View.OnTouchListener {
    private ImageView passwordimg;
    private EditText passwordEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);
        initView();
        initListener();
    }

    private void initListener() {
        passwordimg.setOnTouchListener(this);
    }

    private void initView() {
        passwordimg= (ImageView) this.findViewById(R.id.passwordimg);
        passwordEdt= (EditText) this.findViewById(R.id.password);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN :
                passwordEdt.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                break;
            case MotionEvent.ACTION_UP :
                passwordEdt.setTransformationMethod(PasswordTransformationMethod.getInstance());
                break;
        }
        return true;
    }
}

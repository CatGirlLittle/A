package com.dongdao.a.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.dongdao.a.R;

public class LoginActivity extends Activity implements OnClickListener{
    private Button loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initListener();
    }

    private void initListener() {
        loginbtn.setOnClickListener(this);
    }

    private void initView() {
        loginbtn= (Button) this.findViewById(R.id.loginbtn);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.loginbtn:
                Intent intent=new Intent(this,MeetingListActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }

    }
}

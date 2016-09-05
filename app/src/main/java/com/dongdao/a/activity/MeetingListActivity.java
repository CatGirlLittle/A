package com.dongdao.a.activity;

import android.app.Activity;
import android.opengl.Visibility;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.dongdao.a.R;
import com.dongdao.a.adapter.MeetingListAdapter;
import com.dongdao.a.info.MeetingInfo;

import java.util.ArrayList;
import java.util.List;

public class MeetingListActivity extends Activity implements MeetingListAdapter.ClickHandle {

    private MeetingListAdapter meetingListAdapter;
    private List<MeetingInfo> meetingInfoList=new ArrayList<MeetingInfo>();
    private ListView listView;
    private TextView textViewback,textViewcenter,textViewtitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meetinglayout);
        initData();
        initView();
    }

    private void initData() {
        MeetingInfo meetingInfo;
        for (int i=0;i<=10;i++){
            if(i%2==0){
                meetingInfo =new MeetingInfo(i,"401",1,"国航项目");
            }else{
                meetingInfo=new MeetingInfo(i,"402",0,"南航项目");
            }
            meetingInfoList.add(meetingInfo);
        }
    }

    private void initView() {
        textViewback= (TextView) this.findViewById(R.id.back);
        textViewback.setVisibility(View.GONE);
        textViewcenter= (TextView) this.findViewById(R.id.center);
        textViewcenter.setVisibility(View.GONE);
        textViewtitle= (TextView) this.findViewById(R.id.title);
        textViewtitle.setText("会议室列表");
        listView= (ListView) this.findViewById(R.id.meeting_listview);
        meetingListAdapter=new MeetingListAdapter(meetingInfoList,this,MeetingListActivity.this);
        listView.setAdapter(meetingListAdapter);
    }

    @Override
    public void check(int position) {
        Log.e("w","w");
    }

    @Override
    public void book(int position) {
        Log.e("ws","ws");
    }
}

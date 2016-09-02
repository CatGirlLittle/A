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

public class MeetingListActivity extends Activity {

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
        for (int i=0;i<=20;i++){
            MeetingInfo meetingInfo=new MeetingInfo(i+1,"401",1,"国航项目111111111111111111111111111111111111111111111111111");
            meetingInfoList.add(meetingInfo);
        }
    }

    private void initView() {
        textViewback= (TextView) this.findViewById(R.id.back);
        textViewback.setVisibility(View.GONE);
        textViewcenter= (TextView) this.findViewById(R.id.center);
        textViewcenter.setVisibility(View.GONE);
        listView= (ListView) this.findViewById(R.id.meeting_listview);
        meetingListAdapter=new MeetingListAdapter(meetingInfoList,MeetingListActivity.this);
        listView.setAdapter(meetingListAdapter);
    }
}

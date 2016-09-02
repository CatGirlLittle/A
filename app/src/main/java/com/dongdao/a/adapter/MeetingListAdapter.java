package com.dongdao.a.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dongdao.a.R;
import com.dongdao.a.info.MeetingInfo;
import com.dongdao.a.view.MyTextView;

import java.util.List;

/**
 * Created by Administrator on 2016/9/2.
 */
public class MeetingListAdapter extends BaseAdapter {

    private List<MeetingInfo> meetingInfoList;
    private Context context;
    private ClickHandle clickHandle;

    public MeetingListAdapter(List<MeetingInfo> meetingInfoList, Context context,ClickHandle clickHandle) {
        this.meetingInfoList = meetingInfoList;
        this.context = context;
        this.clickHandle=clickHandle;
    }

    @Override
    public int getCount() {
        return meetingInfoList.size();
    }

    @Override
    public Object getItem(int position) {
        return meetingInfoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=new ViewHolder();
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.meetingitemlayout,null);
            viewHolder.number= (TextView) convertView.findViewById(R.id.number);
            viewHolder.meeting_room= (TextView) convertView.findViewById(R.id.meeting_room);
            viewHolder.meeting_name= (MyTextView) convertView.findViewById(R.id.meeting_name);
            viewHolder.meeting_state= (TextView) convertView.findViewById(R.id.meeting_state);
            viewHolder.handle= (Button) convertView.findViewById(R.id.handle);
            viewHolder.bg= (LinearLayout) convertView.findViewById(R.id.bg);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
            int flag=meetingInfoList.get(position).getMeeting_state();
            if(flag==0){
                viewHolder.meeting_state.setText("使用中");
                viewHolder.meeting_state.setTextColor(Color.parseColor("#db2f2f"));
                viewHolder.handle.setText("查看");
                viewHolder.handle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        clickHandle.check(position);
                    }
                });
                viewHolder.bg.setBackgroundColor(Color.parseColor("#22222222"));
            }else{
                viewHolder.meeting_state.setText("未使用");
                viewHolder.handle.setText("预订");
                viewHolder.handle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        clickHandle.book(position);
                    }
                });
                viewHolder.bg.setBackgroundColor(Color.parseColor("#44444444"));
            }
            viewHolder.number.setText(meetingInfoList.get(position).getNumber()+"");
            viewHolder.meeting_name.setText(meetingInfoList.get(position).getMeeting_name());
            viewHolder.meeting_room.setText(meetingInfoList.get(position).getMeeting_room());

        return convertView;
    }

    class ViewHolder{
        TextView number,meeting_room,meeting_state;
        MyTextView meeting_name;
        Button handle;
        LinearLayout bg;
    }
    public interface ClickHandle{
        abstract void check(int position);
        abstract void book(int position);
    }
}

package com.dongdao.a.info;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/9/2.
 */
public class MeetingInfo implements Serializable {
    private int number;
    private String meeting_room;
    private int meeting_state;
    private String meeting_name;

    public MeetingInfo(int number, String meeting_room, int meeting_state, String meeting_name) {
        this.number = number;
        this.meeting_room = meeting_room;
        this.meeting_state = meeting_state;
        this.meeting_name = meeting_name;
    }

    public int getNumber() {
        return number;
    }

    public String getMeeting_room() {
        return meeting_room;
    }

    public int getMeeting_state() {
        return meeting_state;
    }

    public String getMeeting_name() {
        return meeting_name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setMeeting_room(String meeting_room) {
        this.meeting_room = meeting_room;
    }

    public void setMeeting_state(int meeting_state) {
        this.meeting_state = meeting_state;
    }

    public void setMeeting_name(String meeting_name) {
        this.meeting_name = meeting_name;
    }

    @Override
    public String toString() {
        return "MeetingInfo{" +
                "number=" + number +
                ", meeting_room='" + meeting_room + '\'' +
                ", meeting_state=" + meeting_state +
                ", meeting_name='" + meeting_name + '\'' +
                '}';
    }
}

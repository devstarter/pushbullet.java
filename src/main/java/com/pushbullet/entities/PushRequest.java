package com.pushbullet.entities;

public class PushRequest implements Request {
    public PushType type;
    public String title;
    public String body;
    public String url;
    public String channel_tag;

    public PushRequest(PushType type) {
        this.type = type;
    }

    public PushRequest() {

    }
}

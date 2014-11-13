package com.pushbullet.entities;

public class PushResponse {
    public String iden;
    public String type;
    public String title;
    public String body;
    public String created;
    public String modified;
    public Boolean active;
    public Boolean dismissed;
    public String sender_iden;
    public String sender_name;
    public String sender_email;
    public String sender_email_normalized;
    public String receiver_iden;
    public String receiver_email;
    public String receiver_email_normalized;

    @Override
    public String toString() {
        return "Response{" +
                "iden='" + iden + '\'' +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", created='" + created + '\'' +
                ", modified='" + modified + '\'' +
                ", active=" + active +
                ", dismissed=" + dismissed +
                ", sender_iden='" + sender_iden + '\'' +
                ", sender_name='" + sender_name + '\'' +
                ", sender_email='" + sender_email + '\'' +
                ", sender_email_normalized='" + sender_email_normalized + '\'' +
                ", receiver_iden='" + receiver_iden + '\'' +
                ", receiver_email='" + receiver_email + '\'' +
                ", receiver_email_normalized='" + receiver_email_normalized + '\'' +
                '}';
    }
}

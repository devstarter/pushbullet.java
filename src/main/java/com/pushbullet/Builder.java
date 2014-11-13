package com.pushbullet;

import com.pushbullet.entities.PushRequest;
import com.pushbullet.entities.PushResponse;
import com.pushbullet.entities.PushType;

public class Builder {
    protected static PushbulletClient client;

    protected Builder() {}

    public static void registerClient(PushbulletClient client) {
        Builder.client = client;
    }

    public static Builder pushbullet(PushbulletClient client) {
        registerClient(client);
        return pushbullet();
    }

    public static Builder pushbullet() {
        return new Builder();
    }

    public TargetBuilder pushes() {
        return new TargetBuilder(this);
    }

    public static class TargetBuilder {
        private final Builder builder;

        protected TargetBuilder(Builder builder) {
            this.builder = builder;
        }

        public PushesBuilder channel(String tag) {
            final PushRequest request = new PushRequest();
            request.channel_tag = tag;
            return new PushesBuilder(builder, request);
        }

        public PushesBuilder broadcast() {
            return new PushesBuilder(builder, new PushRequest());
        }

    }

    public static class PushesBuilder {
        public static final String CONTEXT = "pushes";
        private final Builder builder;
        private final PushRequest request;

        protected PushesBuilder(Builder builder, PushRequest request) {
            this.builder = builder;
            this.request = request;
        }

        public PushResponse note(String title, String body) {
            request.type = PushType.note;
            request.title = title;
            request.body = body;
            return client.post(CONTEXT, request, PushResponse.class);
        }
    }
}

package com.pushbullet;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.codehaus.jackson.map.ObjectMapper;

import java.util.ArrayList;

import static com.pushbullet.Builder.pushbullet;
import static com.pushbullet.Builder.registerClient;

public class PushbulletTest {

    private PushbulletClient pushbulletClient;

    @Before
    public void setup() {
        pushbulletClient = new PushbulletClient();
        pushbulletClient.key = System.getenv("PUSHBULLET_API");

        final ArrayList<HttpMessageConverter<?>> converters = new ArrayList<>();
        MappingJacksonHttpMessageConverter jacksonConverter = new MappingJacksonHttpMessageConverter();
        jacksonConverter.setObjectMapper(new ObjectMapper());
        converters.add(jacksonConverter);
        converters.add(new StringHttpMessageConverter());

        final RestTemplate template = new RestTemplate();
        template.setMessageConverters(converters);
        pushbulletClient.restTemplate = template;
    }

    @Test
    public void note() throws Exception {
        registerClient(pushbulletClient);
        pushbullet().pushes().channel("pushbullet-java").note("to chanel", "test");
        pushbullet().pushes().broadcast().note("broadcast", "test");
    }
}
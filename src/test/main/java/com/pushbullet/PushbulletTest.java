package com.pushbullet;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

import static com.pushbullet.Builder.pushbullet;
import static com.pushbullet.Builder.registerClient;

public class PushbulletTest {

    @Before
    public void setup() {
        PushbulletClient pushbulletClient = new PushbulletClient();
        pushbulletClient.key = System.getenv("PUSHBULLET_API");

        final ArrayList<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
        MappingJacksonHttpMessageConverter jacksonConverter = new MappingJacksonHttpMessageConverter();
        jacksonConverter.setObjectMapper(new ObjectMapper());
        converters.add(jacksonConverter);

        final RestTemplate template = new RestTemplate();
        template.setMessageConverters(converters);
        pushbulletClient.restTemplate = template;
        registerClient(pushbulletClient);
    }

    @Test
    public void note() {
        pushbullet().pushes().channel("pushbullet-java").note("to chanel", "test");
        pushbullet().pushes().broadcast().note("broadcast", "test");
    }

    @Test
    public void utf() {
        pushbullet().pushes().broadcast().note("Привет", "Текст на русском");
    }

    @Test
    public void Link() {
        pushbullet().pushes().channel("pushbullet-java").link("to chanel", "test","this is url");
    }
}
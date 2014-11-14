Pushbullet on Spring
===================

Java (Spring) library for Pushbullet API

```xml
<bean id="restTemplate" class="org.springframework.web.client.RestTemplate">
    <property name="messageConverters">
        <list>
            <bean class="org.springframework.http.converter.json.MappingJacksonHttpMessageConverter"/>
        </list>
    </property>
</bean>

<bean class="com.pushbullet.PushbulletClient">
    <property name="key" value="${pushbullet.key}"/>
    <property name="restTemplate" ref="restTemplate"/>
</bean>
```

```java
import static com.pushbullet.Builder.pushbullet;
import static com.pushbullet.Builder.registerClient;

@Autowired
private PushbulletClient pushbulletClient;

registerClient(pushbulletClient);
pushbullet().pushes().channel("pushbullet-java").note("to chanel", "test");
// or
pushbullet(pushbulletClient).pushes().broadcast().note("broadcast", "test");
```


package com.example.daoH3.demo.config;

import com.example.daoH3.demo.EndPointInterfaceImpl;
import com.example.daoH3.demo.KafkaEndPointInterfaceImpl;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
@EnableAutoConfiguration

@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(EndPointInterfaceImpl.class);
        register(KafkaEndPointInterfaceImpl.class);
    }

}

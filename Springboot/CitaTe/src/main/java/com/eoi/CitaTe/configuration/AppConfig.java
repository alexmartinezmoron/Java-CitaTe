package com.eoi.CitaTe.configuration;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;


public class AppConfig {

    @Autowired
    Environment environment;
}

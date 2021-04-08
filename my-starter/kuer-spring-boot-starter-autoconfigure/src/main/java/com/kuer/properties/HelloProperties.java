package com.kuer.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * 前缀 kuer.hello
 * @author kuer
 */
@ConfigurationProperties(prefix = "kuer.hello")
public class HelloProperties {

    private String prefix = "prefix";
    private String suffix = "suffix";

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
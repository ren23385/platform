package com.platform.admin.config;

import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:httpclient.properties")
public class HttpClientConfig {

    @Value("${http.maxTotal}")
    private Integer httpMaxTotal;

    @Value("${http.defaultMaxPerRoute}")
    private Integer httpDefaultMaxPerRoute;

    @Value("${http.connectTimeout}")
    private Integer httpConnectTimeout;

    @Value("${http.connectionRequestTimeout}")
    private Integer httpConnectionRequestTimeout;

    @Value("${http.socketTimeout}")
    private Integer httpSocketTimeout;

    @Autowired
    private PoolingHttpClientConnectionManager manager;

    @Bean
    public PoolingHttpClientConnectionManager poolingHttpClientConnectionManager() {
        PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager();
        // 最大连接数
        poolingHttpClientConnectionManager.setMaxTotal(httpMaxTotal);
        // 每个主机的最大并发数
        poolingHttpClientConnectionManager.setDefaultMaxPerRoute(httpDefaultMaxPerRoute);
        return poolingHttpClientConnectionManager;
    }
}

package reactivefeign.spring.config;

import feign.Contract;
import org.springframework.boot.context.properties.ConfigurationProperties;
import reactivefeign.ReactiveRetryPolicy;
import reactivefeign.client.ReactiveHttpRequestInterceptor;
import reactivefeign.client.statushandler.ReactiveStatusHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@ConfigurationProperties("reactivefeign.client")
public class ReactiveFeignClientProperties {

    private boolean defaultToProperties = true;

    private String defaultConfig = "default";

    private Map<String, ReactiveFeignClientConfiguration> config = new HashMap<>();

    public boolean isDefaultToProperties() {
        return defaultToProperties;
    }

    public void setDefaultToProperties(boolean defaultToProperties) {
        this.defaultToProperties = defaultToProperties;
    }

    public String getDefaultConfig() {
        return defaultConfig;
    }

    public void setDefaultConfig(String defaultConfig) {
        this.defaultConfig = defaultConfig;
    }

    public Map<String, ReactiveFeignClientConfiguration> getConfig() {
        return config;
    }

    public void setConfig(Map<String, ReactiveFeignClientConfiguration> config) {
        this.config = config;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReactiveFeignClientProperties that = (ReactiveFeignClientProperties) o;
        return defaultToProperties == that.defaultToProperties &&
                Objects.equals(defaultConfig, that.defaultConfig) &&
                Objects.equals(config, that.config);
    }

    @Override
    public int hashCode() {
        return Objects.hash(defaultToProperties, defaultConfig, config);
    }

    public static class ReactiveFeignClientConfiguration {

        private Integer connectTimeout;

        private Integer readTimeout;

        private Class<ReactiveRetryPolicy> retryPolicy;

        private Class<ReactiveStatusHandler> statusHandler;

        private Class<ReactiveHttpRequestInterceptor> requestInterceptor;

        private Boolean decode404;

        private Class<Contract> contract;

        public Integer getConnectTimeout() {
            return connectTimeout;
        }

        public void setConnectTimeout(Integer connectTimeout) {
            this.connectTimeout = connectTimeout;
        }

        public Integer getReadTimeout() {
            return readTimeout;
        }

        public void setReadTimeout(Integer readTimeout) {
            this.readTimeout = readTimeout;
        }

        public Class<ReactiveRetryPolicy> getRetryPolicy() {
            return retryPolicy;
        }

        public void setRetryPolicy(Class<ReactiveRetryPolicy> retryPolicy) {
            this.retryPolicy = retryPolicy;
        }

        public Class<ReactiveStatusHandler> getStatusHandler() {
            return statusHandler;
        }

        public void setStatusHandler(Class<ReactiveStatusHandler> statusHandler) {
            this.statusHandler = statusHandler;
        }

        public Class<ReactiveHttpRequestInterceptor> getRequestInterceptor() {
            return requestInterceptor;
        }

        public void setRequestInterceptor(Class<ReactiveHttpRequestInterceptor> requestInterceptor) {
            this.requestInterceptor = requestInterceptor;
        }

        public Boolean getDecode404() {
            return decode404;
        }

        public void setDecode404(Boolean decode404) {
            this.decode404 = decode404;
        }

        public Class<Contract> getContract() {
            return contract;
        }

        public void setContract(Class<Contract> contract) {
            this.contract = contract;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ReactiveFeignClientConfiguration that = (ReactiveFeignClientConfiguration) o;
            return Objects.equals(connectTimeout, that.connectTimeout) &&
                    Objects.equals(readTimeout, that.readTimeout) &&
                    Objects.equals(retryPolicy, that.retryPolicy) &&
                    Objects.equals(statusHandler, that.statusHandler) &&
                    Objects.equals(requestInterceptor, that.requestInterceptor) &&
                    Objects.equals(decode404, that.decode404) &&
                    Objects.equals(contract, that.contract);
        }

        @Override
        public int hashCode() {
            return Objects.hash(connectTimeout, readTimeout, retryPolicy,
                    statusHandler, requestInterceptor, decode404, contract);
        }
    }

}


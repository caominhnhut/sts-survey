package com.sts.services.survey.config.security;

import org.springframework.boot.autoconfigure.condition.AllNestedConditions;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
@Conditional(value = {OAuth2RestTemplateConfigurer.ServiceAccountEnabled.class})
public class OAuth2RestTemplateConfigurer{

    /**
     * Condition class to configure OAuth2RestTemplate when both security is enabled and
     * client credentials property is set for secured micro-service
     * to micro-service call.
     */
    static class ServiceAccountEnabled extends AllNestedConditions {

        ServiceAccountEnabled() {
            super(ConfigurationPhase.PARSE_CONFIGURATION);
        }

        @ConditionalOnProperty(prefix = "rest.security", value = "enabled", havingValue = "true")
        static class SecurityEnabled {}

        @ConditionalOnProperty(prefix = "security.oauth2.client", value = "grant-type", havingValue = "client_credentials")
        static class ClientCredentialConfigurationExists {}

    }
}

package com.ofg.infrastructure.base

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import spock.lang.Specification

@WebAppConfiguration
abstract class MvcIntegrationSpec extends Specification {
    
    @Autowired private WebApplicationContext webApplicationContext
    @Autowired private ApplicationContext applicationContext
    protected MockMvc mockMvc

    void setup() {
        mockMvc = MockMvcBuilders.
                webAppContextSetup(webApplicationContext).
                // TODO: get it from an web-infra jar: addFilter(new CorrelationIdFilter()).
                build()
    }

    def cleanup() {
    }

}
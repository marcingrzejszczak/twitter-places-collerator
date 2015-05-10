package com.ofg.twitter

import com.ofg.infrastructure.environment.EnvironmentSetupVerifier
import groovy.transform.CompileStatic
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.EnableAspectJAutoProxy
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import static com.ofg.config.BasicProfiles.*
import static org.springframework.web.bind.annotation.RequestMethod.POST

@CompileStatic
@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
@RestController
class Application {

    static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application)
        application.addListeners(new EnvironmentSetupVerifier([DEVELOPMENT, PRODUCTION, TEST]))
        application.run(args)
    }

    @RequestMapping(
            value = '/{pairId}',
            method = POST)
    String doSth() {
        return "OK"
    }

}

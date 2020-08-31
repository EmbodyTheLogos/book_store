package com.starrockbooks;

import org.h2.server.web.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/*
  References: (1) https://stackoverflow.com/questions/6107156/can-i-make-replace-an-a-link-with-an-input-button
              (2) https://stackoverflow.com/questions/13494078/how-to-do-if-else-in-thymeleaf
              (3) http://enjoycss.com/gallery/text_effects/e7
              (4) https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_link_mailto
              (5) http://animaljam.wikia.com/wiki/File:Blue-christmas-snow-fall-animation.gif
 */

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public ServletRegistrationBean h2ServletRegistationBean() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
        registrationBean.addUrlMappings("/console/*");
        return registrationBean;
    }
}

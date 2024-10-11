
package com.tienda.tienda;

import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class ProjectConfig implements WebMvcConfigurer{
    
    @Bean
    public LocaleResolver localeResolver(){
        var slr = new SessionLocaleResolver(); //Cual va a ser el idioma por defecto que el sitio va a ultilizar.
        slr.setDefaultLocale(Locale.getDefault());
        slr.setLocaleAttributeName("session.current.locale");
        slr.setTimeZoneAttributeName("session.current.timezone");
        return slr;
    }
    @Bean 
    public LocaleChangeInterceptor localeChangeInterceptors(){
        var lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;     
    }
    
    @Override 
    public void addInterceptors(InterceptorRegistry registro){
        registro.addInterceptor(localeChangeInterceptors());
    }
    
}

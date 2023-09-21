package code.alencar.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import code.alencar.serialization.converter.YamlJackson2HttpMessageConverter;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    
    //MediaType para suportar YAML
    private static final MediaType MEDIA_TYPE_APPLICATION_YML = MediaType.valueOf("application/x-yaml");
    
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new YamlJackson2HttpMessageConverter());
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        //Suporte via QueryParam        
        /*configurer.favorParameter(true)
                .parameterName("mediaType")
                .ignoreAcceptHeader(true)
                .useRegisteredExtensionsOnly(false)
                .defaultContentType(MediaType.APPLICATION_JSON) // default
                .mediaType("json", MediaType.APPLICATION_JSON) //SUPORTA JSON
                .mediaType("xml", MediaType.APPLICATION_XML); //SUPORTA XML
        */
        //Suporte via HeaderParam
        configurer.favorParameter(false)
                .ignoreAcceptHeader(false)
                .useRegisteredExtensionsOnly(false)
                .defaultContentType(MediaType.APPLICATION_JSON) // default
                .mediaType("json", MediaType.APPLICATION_JSON) //SUPORTA JSON
                .mediaType("xml", MediaType.APPLICATION_XML) //SUPORTA XML
                .mediaType("x-yaml", MEDIA_TYPE_APPLICATION_YML); //SUPORTA YAML
    }

}

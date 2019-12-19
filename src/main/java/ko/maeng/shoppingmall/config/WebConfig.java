package ko.maeng.shoppingmall.config;

import com.samskivert.mustache.Mustache;
import org.springframework.boot.web.servlet.view.MustacheViewResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.InputStreamReader;
import java.nio.charset.Charset;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    // Mustache Template Loader 구현 : {{> }} 태그 사용 시 인식하지 못하는 에러 해결.
    private static Mustache.TemplateLoader mustacheTemplateLoader(){
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        String prefix = "classpath:/templates/";
        Charset charset = Charset.forName("UTF-8");
        return name -> new InputStreamReader(
                resourceLoader.getResource(prefix + name + ".html").getInputStream(), charset);
    }

    // Mustache ViewResolver 설정.
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        Mustache.Compiler compiler = Mustache.compiler().withLoader(mustacheTemplateLoader());

        MustacheViewResolver resolver = new MustacheViewResolver(compiler);
        resolver.setCharset("UTF-8");
        resolver.setContentType("text/html;charset=UTF-8");
        resolver.setPrefix("classpath:/templates/");
        resolver.setSuffix(".html");
        resolver.setCache(true);
        resolver.setCacheLimit(8192);
        resolver.setExposeSessionAttributes(true);

        registry.viewResolver(resolver);
    }
}

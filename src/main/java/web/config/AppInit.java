package web.config;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{AppConfig.class}; // Указываем основной конфигурационный класс
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class}; // Конфигурация для Spring MVC
    }

    @Override
    protected String[] getServletMappings() {
        System.out.println("Mapping DispatcherServlet to '/'");
        return new String[]{"/"};
    }

}

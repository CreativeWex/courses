package demo02.configuration;

import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackageClasses = AComponent.class) // AService
//@ComponentScan(basePackages = "demo01") // demo01.service
//@ComponentScan(basePackageClasses = {AComponent.class, AService.class})
//@ComponentScan(
//    basePackageClasses = {AComponent.class, AService.class},
//    excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = BService.class)
//)
public class ApplicationConfiguration {
}

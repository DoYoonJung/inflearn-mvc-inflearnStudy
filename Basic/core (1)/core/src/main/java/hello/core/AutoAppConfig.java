package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        //basePackages = "hello.core.member",
        //basePackages로 적용 범위를 지정할 수 있다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        //윗 줄 코드는 ComponentScan의 자동 주입에서 AppConfig의 코드들이 자동주입 되는 것을 제외하기 위해 사용하는 코드다.
        //즉 Configuration 에노테이션@ 이 붙은것들은 뺀다는 뜻
)
public class AutoAppConfig {

}

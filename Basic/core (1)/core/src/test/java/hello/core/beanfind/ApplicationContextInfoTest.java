package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        //리스트 같은게 있을때 밑에다 iter+tap을 누루면 for문이 자동 생성된다.
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("bean = " + beanDefinitionName + " object = "+bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        //리스트 같은게 있을때 밑에다 iter+tap을 누루면 for문이 자동 생성된다.
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
            //getBeanDefinition()은 정보를 불러오는 메서드


            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                //BeanDefinition.ROLE_APPLICATION은 내가 직접 만든 애플리케이션만 가져온다.
                //Role ROLE_APPLICATION: 직접 등록한 애플리케이션 빈
                //Role ROLE_INFRASTRUCTURE: 스프링이 내부에서 사용하는 빈
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("bean = " + beanDefinitionName + " object = "+bean);
            }
        }
    }

}

package go.com;

import go.component.ComponentSelector;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        System.out.println("gogogo---------->");

        //AnnotationConfigApplicationContext context =new AnnotationConfigApplicationContext(GssssComponensssst.class);
        AnnotationConfigApplicationContext context =new AnnotationConfigApplicationContext(ComponentSelector.class);

        String[] beans = context.getBeanDefinitionNames();
        System.out.println(1000);
    }
}
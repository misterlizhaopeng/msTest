package go.component;

import go.beans.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/*存在扫描注解的组件的类也被认为一个组件*/
//@ComponentScan(value = "go.component")
@Configuration
@Import(value = {Dog.class})
//总结：如果把@Configuration、Import都注释了，还有一个组件叫这个类的名字的第一个字母为小写的名字，如：类GssssComponensssst 的组件的名字为：gssssComponensssst
public class GssssComponensssst {
    /*方法的名字为默认组件的名字
    * 还可以通过注解中value的值自定义组件的名字
    * */
    @Bean(value = "gox")
    public Dog GgetGdog()
    {return new Dog();}
}

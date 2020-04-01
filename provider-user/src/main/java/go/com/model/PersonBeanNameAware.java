package go.com.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Date;

public class PersonBeanNameAware implements BeanNameAware, ApplicationContextAware, BeanFactoryAware {
    private Integer id;
    private String name;
    private Date birthday;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("自己的名字是--------------->：" + name);
    }
    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        String applicationName = ctx.getApplicationName();
        System.out.println("容器的名字--------------->：" + applicationName);
        PersonBeanNameAware bean01 = ctx.getBean("personBeanNameAware", PersonBeanNameAware.class);
        System.out.println("bean1---------------->" + bean01);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        PersonBeanNameAware bean02 = beanFactory.getBean("personBeanNameAware", PersonBeanNameAware.class);
        System.out.println("bean2---------------->" + bean02);
    }
}

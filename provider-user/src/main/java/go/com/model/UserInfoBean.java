package go.com.model;

//@Component
//@Scope("singleton")//"prototype"
public class UserInfoBean  {// implements BeanPostProcessor
    private void init (){
        System.out.println("UserInfoBean's method init---->go");
    }
    private void destroy(){
        System.out.println("UserInfoBean's method destroy---->");
    }


    private String name;
    private Integer age;

    public UserInfoBean() {
        System.out.println("UserInfoBean's constructor is invoked ------------------->go");
    }

    public UserInfoBean(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

//    @Override
//    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("postProcessBeforeInitialization is invoked ------->11111");
//        return bean;
//    }
//
//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("postProcessAfterInitialization is invoked ------->22222");
//        return bean;
//    }




}
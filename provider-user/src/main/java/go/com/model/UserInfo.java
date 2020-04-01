package go.com.model;

public class UserInfo  {
       private String name;
       private Integer age;
       public UserInfo() {
       }
       
       public UserInfo(String name, Integer age) {
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
}
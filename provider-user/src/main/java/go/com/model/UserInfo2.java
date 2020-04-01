package go.com.model;

public class UserInfo2 {
    private String name;
    private Integer age;

    public UserInfo2() {
    }

    public UserInfo2(String name, Integer age) {
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


    @Override
    public int hashCode() {
        return this.hashCode() + age;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof UserInfo2))
            return false;  //内容不一致，肯定不相等

        UserInfo2 userInfo2 = (UserInfo2) obj;
       return this.age == userInfo2.age && this.equals(userInfo2.name);
    }
}
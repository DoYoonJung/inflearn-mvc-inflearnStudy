package hello.core;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HelloLombok {
    private String name;
    private int age;

    /*public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }*/
    //원래는 이렇게 메서드를 만들어야 하는걸 lombok을 이용해 단순화함

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("adfasf");

        String name = helloLombok.getName();
        System.out.println("name = " + name);
    }

}

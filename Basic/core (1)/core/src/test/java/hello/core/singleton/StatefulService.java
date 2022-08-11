package hello.core.singleton;
//ctrl + shift + t 하면 test 클래스 생성
public class StatefulService {

    private int price; //상태를 유지하는 필드

    public void order(String name, int price) {
        System.out.println("name = " + name+" price = "+price);
        this.price=price;
    }

    public int getPrice() {
        return price;
    }
}

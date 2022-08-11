package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }
    //아래와 같이 private로 생성자를 설정하면 다른 클래스에서 객체 생성이 불가능 하게 된다. 즉 SingletonService를 사용할 수 있는 곳은
    //여기 클래스 밖에 없다.
    private SingletonService(){
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }

}

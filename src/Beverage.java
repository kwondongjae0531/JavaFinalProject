// MenuItem을 상속(Inheritance)받음
public class Beverage extends Menuitem {
    private String temperature; // "ICE" 또는 "HOT"

    // 자식 생성자: super()를 통해 부모 생성자 호출
    public Beverage(String name, int price, String temperature) {
        super(name, price);
        this.temperature = temperature;
    }

    // 부모의 메서드를 재정의 (Overriding)
    @Override
    public String getDescription() {
        return "[" + temperature + "] " + getName() + " - 가격: " + getPrice() + "원";
    }
}
// MenuItem을 상속(Inheritance)받음
public class Dessert extends Menuitem {
    private boolean packaging; // 포장 여부

    public Dessert(String name, int price, boolean packaging) {
        super(name, price);
        this.packaging = packaging;
    }

    // 부모의 메서드를 재정의 (Overriding)
    @Override
    public String getDescription() {
        String packStatus = packaging ? "포장 가능" : "매장 전용";
        return "[디저트] " + getName() + " (" + packStatus + ") - 가격: " + getPrice() + "원";
    }
}
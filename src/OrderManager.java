import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    // 다형성(Polymorphism): 부모 타입(MenuItem)의 리스트에 Beverage와 Dessert를 모두 담을 수 있음
    private List<Menuitem> cart;

    public OrderManager() {
        this.cart = new ArrayList<>();
    }

    public void addItem(Menuitem item) {
        cart.add(item);
    }

    public void clearCart() {
        cart.clear();
    }

    public int calculateTotal() {
        int total = 0;
        for (Menuitem item : cart) {
            total += item.getPrice();
        }
        return total;
    }

    // 다형성의 핵심: 하나의 부모 타입으로 서로 다른 자식 객체의 오버라이딩된 메서드를 호출
    public String getOrderDetails() {
        if (cart.isEmpty()) return "장바구니가 비어 있습니다.\n";

        StringBuilder details = new StringBuilder("--- 주문 내역 ---\n");
        for (Menuitem item : cart) {
            // item이 Beverage면 Beverage의 getDescription()이,
            // Dessert면 Dessert의 getDescription()이 자동 호출됨 (동적 바인딩)
            details.append(item.getDescription()).append("\n");
        }
        return details.toString();
    }
}
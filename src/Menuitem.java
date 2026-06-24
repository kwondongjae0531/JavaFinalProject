public class Menuitem {
    // private 접근제한자를 사용하여 변수를 외부에서 직접 수정하지 못하게 숨김 (캡슐화)
    private String name;
    private int price;

    // 객체를 생성할 때 이름과 가격을 필수값으로 받도록 지정 (생성자)
    public Menuitem(String name, int price) {
        this.name = name;
        this.price = price;
    }

    // 외부에서 이름을 안전하게 가져갈 수 있도록 열어둔 메서드 (Getter)
    public String getName() {
        return name;
    }

    // 외부에서 가격을 안전하게 가져갈 수 있도록 열어둔 메서드 (Getter)
    public int getPrice() {
        return price;
    }

    // 메뉴의 기본 정보를 문자열로 반환하는 메서드 (자식들이 재정의할 예정)
    public String getDescription() {
        return name + " - 가격: " + price + "원";
    }
}
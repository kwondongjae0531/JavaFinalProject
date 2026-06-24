# ☕ 카페 키오스크 (Trendy Cafe Kiosk)

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Swing](https://img.shields.io/badge/Swing-007396?style=for-the-badge&logo=java&logoColor=white)

Java 객체지향 프로그래밍(OOP)의 핵심 개념을 학습하고 적용하기 위해 구현한 **카페 키오스크 주문 시스템**입니다. Java Swing을 활용하여 사용자 친화적인 모던 GUI 환경을 구축하였으며, 상속과 다형성을 통해 유지보수와 확장이 용이한 구조로 설계되었습니다.

<br>

## 📌 주요 기능 (Features)
* **메뉴 선택:** 음료(ICE/HOT) 및 디저트(포장/매장) 메뉴 선택 기능
* **장바구니 관리:** 선택한 메뉴들의 상세 옵션과 가격을 실시간 영수증 형태로 출력
* **결제 시스템:** 장바구니에 담긴 메뉴들의 총액을 계산하여 결제 처리 및 초기화
* **커스텀 UI:** Java Swing의 둥근 모서리(Rounded Rectangle) 그래픽 처리를 활용한 트렌디한 버튼 디자인

<br>

## 💡 객체지향 프로그래밍(OOP) 적용 핵심

이 프로젝트는 객체지향의 5가지 주요 개념을 모두 포함하고 있습니다.

1. **클래스 & 객체:** `Menuitem`, `Beverage`, `Dessert` 등 역할에 따른 클래스 분리
2. **캡슐화 (Encapsulation):** 모든 데이터(name, price)를 `private`으로 은닉하고 `Getter`로만 접근 허용
3. **상속 (Inheritance):** `Menuitem` 부모 클래스의 공통 속성을 `Beverage`와 `Dessert`가 상속(`extends`)받아 중복 코드 최소화
4. **오버라이딩 (Overriding):** 자식 클래스에서 `getDescription()` 메서드를 각자의 특성(온도, 포장 여부)에 맞게 재정의
5. **다형성 (Polymorphism):** `OrderManager`에서 `List<Menuitem>` 부모 타입 컬렉션 하나로 서로 다른 자식 객체들을 동적 바인딩하여 일괄 제어 및 결제 로직 처리 (개방-폐쇄 원칙 준수)

<br>

<br>

## 📂 프로젝트 구조 (Project Structure)

```text
📦 src
 ┣ 📜 Menuitem.java         // (부모 클래스) 메뉴의 기본 속성 정의
 ┣ 📜 Beverage.java         // (자식 클래스) Menuitem 상속, 온도 속성 추가
 ┣ 📜 Dessert.java          // (자식 클래스) Menuitem 상속, 포장 속성 추가
 ┣ 📜 OrderManager.java     // (제어 클래스) 장바구니 데이터 다형성 관리 및 총액 계산
 ┗ 📜 KioskUI.java          // (메인 클래스) Java Swing 기반 화면 구성 및 이벤트 처리

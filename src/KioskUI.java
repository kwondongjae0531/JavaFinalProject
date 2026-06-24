import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class KioskUI extends JFrame {
    private OrderManager orderManager = new OrderManager();
    private JTextArea receiptArea;

    // 💡 여기서 원하는 폰트 이름으로 바꿀 수 있습니다!
    // (예: "배달의민족 주아", "Gmarket Sans TTF", "Apple SD Gothic Neo" 등)
    private String mainFontName = "NanumGothic";

    public KioskUI() {
        setTitle("✨카페 키오스크 ✨");
        setSize(480, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(15, 15));
        getContentPane().setBackground(new Color(248, 249, 250));

        // 1. 상단 타이틀 안내 문구
        JLabel titleLabel = new JLabel("어떤 메뉴를 준비해 드릴까요?", SwingConstants.CENTER);
        titleLabel.setFont(new Font(mainFontName, Font.BOLD, 22)); // 폰트 적용
        titleLabel.setForeground(new Color(52, 58, 64));
        titleLabel.setBorder(new EmptyBorder(25, 0, 10, 0));
        add(titleLabel, BorderLayout.NORTH);

        // 2. 상단 메뉴 버튼 패널
        JPanel menuPanel = new JPanel(new GridLayout(2, 2, 15, 15));
        menuPanel.setBackground(new Color(248, 249, 250));
        menuPanel.setBorder(new EmptyBorder(0, 25, 10, 25));

        JButton btnIceAmericano = new RoundedButton("🧊 아메리카노", new Color(208, 235, 255), mainFontName);
        JButton btnHotLatte = new RoundedButton("☕ 카페라떼", new Color(255, 227, 210), mainFontName);
        JButton btnCheeseCake = new RoundedButton("🧀 치즈케이크", new Color(255, 243, 191), mainFontName);
        JButton btnChocoCookie = new RoundedButton("🍪 초코쿠키", new Color(235, 220, 209), mainFontName);

        menuPanel.add(btnIceAmericano);
        menuPanel.add(btnHotLatte);
        menuPanel.add(btnCheeseCake);
        menuPanel.add(btnChocoCookie);

        // 3. 중앙 영수증/출력 패널
        receiptArea = new JTextArea();
        receiptArea.setEditable(false);
        receiptArea.setFont(new Font(mainFontName, Font.PLAIN, 15)); // 폰트 적용
        receiptArea.setBackground(Color.WHITE);
        receiptArea.setForeground(new Color(73, 80, 87));
        receiptArea.setBorder(new EmptyBorder(15, 15, 15, 15));

        JScrollPane scrollPane = new JScrollPane(receiptArea);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(222, 226, 230), 2, true));

        JPanel receiptWrapper = new JPanel(new BorderLayout());
        receiptWrapper.setBackground(new Color(248, 249, 250));
        receiptWrapper.setBorder(new EmptyBorder(10, 25, 0, 25));
        receiptWrapper.add(scrollPane, BorderLayout.CENTER);

        // 4. 하단 제어 버튼 패널
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        bottomPanel.setBackground(new Color(248, 249, 250));

        JButton btnClear = new RoundedButton("초기화", new Color(233, 236, 239), mainFontName);
        JButton btnPay = new RoundedButton("결제하기", new Color(59, 201, 122), mainFontName);
        btnPay.setForeground(Color.WHITE);

        bottomPanel.add(btnClear);
        bottomPanel.add(btnPay);

        // 중앙 패널 묶기
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(new Color(248, 249, 250));
        centerPanel.add(menuPanel, BorderLayout.NORTH);
        centerPanel.add(receiptWrapper, BorderLayout.CENTER);

        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // --- 초기 메시지 ---
        receiptArea.setText("원하시는 메뉴를 선택해주세요! 😊");

        // --- 이벤트 리스너 설정 ---
        btnIceAmericano.addActionListener(e -> {
            orderManager.addItem(new Beverage("아메리카노", 4000, "ICE"));
            updateReceipt();
        });

        btnHotLatte.addActionListener(e -> {
            orderManager.addItem(new Beverage("카페라떼", 4500, "HOT"));
            updateReceipt();
        });

        btnCheeseCake.addActionListener(e -> {
            orderManager.addItem(new Dessert("치즈케이크", 5500, true));
            updateReceipt();
        });

        btnChocoCookie.addActionListener(e -> {
            orderManager.addItem(new Dessert("초코쿠키", 2500, false));
            updateReceipt();
        });

        btnClear.addActionListener(e -> {
            orderManager.clearCart();
            receiptArea.setText("장바구니가 비었습니다.\n원하시는 메뉴를 선택해주세요! 😊");
        });

        btnPay.addActionListener(e -> {
            int total = orderManager.calculateTotal();
            if (total == 0) {
                JOptionPane.showMessageDialog(this, "선택된 메뉴가 없습니다. 메뉴를 먼저 골라주세요!", "알림", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "총 결제 금액은 " + total + "원입니다.\n결제가 완료되었습니다! 👏", "결제 완료", JOptionPane.INFORMATION_MESSAGE);
                orderManager.clearCart();
                receiptArea.setText("결제가 완료되었습니다.\n이용해 주셔서 감사합니다! 💖");
            }
        });
    }

    private void updateReceipt() {
        receiptArea.setText(orderManager.getOrderDetails() +
                "\n━━━━━━━━━━━━━━━━━━━━\n" +
                "✨ 총 결제 금액: " + orderManager.calculateTotal() + "원");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new KioskUI().setVisible(true);
        });
    }
}

// --------------------------------------------------------
// ✨ 트렌디한 둥근 버튼을 만들어주는 커스텀 클래스 ✨
// --------------------------------------------------------
class RoundedButton extends JButton {
    private Color bgColor;

    public RoundedButton(String text, Color bgColor, String fontName) {
        super(text);
        this.bgColor = bgColor;
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setFont(new Font(fontName, Font.BOLD, 15)); // 전달받은 폰트 적용
        setForeground(new Color(52, 58, 64));
        setPreferredSize(new Dimension(150, 60));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (getModel().isArmed()) {
            g2.setColor(bgColor.darker());
        } else {
            g2.setColor(bgColor);
        }
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);

        super.paintComponent(g);
        g2.dispose();
    }
}
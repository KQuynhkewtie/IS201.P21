package GUI;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import DTO.currentuser;
import java.awt.*;

public class ThongKe extends BasePanel {
    private JLabel lblThongKe;
    private JTabbedPane tabbedPane;
    private JPanel cardPanel;

    public ThongKe(MainFrame mainFrame) {
        super(mainFrame);
        initUniqueComponents();
    }

    @Override

    public void onPageShown() {
        highlightMenuButton("Thống kê");
        refreshData();

        int selectedIndex = tabbedPane.getSelectedIndex();
        if (selectedIndex == 0 && !currentuser.coQuyen("Xem doanh thu")) {
            JOptionPane.showMessageDialog(null, "Bạn không có quyền xem doanh thu!", "Cảnh báo",
                    JOptionPane.WARNING_MESSAGE);
            // Không chuyển tab, giữ nguyên tab Doanh thu
        }
    }

    protected void initUniqueComponents() {
        // Label tiêu đề
        lblThongKe = new JLabel("Thống kê");
        lblThongKe.setFont(new Font("Arial", Font.BOLD, 20));
        lblThongKe.setBounds(20, 15, 200, 30);
        add(lblThongKe);

        cardPanel = new JPanel();
        cardPanel.setBounds(20, 50, 800, 580);
        cardPanel.setLayout(new BorderLayout());

        tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("Arial", Font.PLAIN, 14));

        // Thêm tab mà không kiểm tra quyền ở đây (để tránh hiện thông báo ngay)
        tabbedPane.addTab("Doanh thu", new TabDoanhThu());
        tabbedPane.addTab("Hạn sử dụng", new TabHanSuDung());

        // Thêm listener kiểm tra quyền khi đổi tab
        tabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int selectedIndex = tabbedPane.getSelectedIndex();

                if (selectedIndex == 0 && !currentuser.coQuyen("Xem doanh thu")) {
                    JOptionPane.showMessageDialog(null, "Bạn không có quyền xem doanh thu!", "Cảnh báo",
                            JOptionPane.WARNING_MESSAGE);
                    // Không đổi tab, giữ nguyên
                } else if (selectedIndex == 1 && !currentuser.coQuyen("Xem HSD")) {
                    JOptionPane.showMessageDialog(null, "Bạn không có quyền xem hạn sử dụng!", "Cảnh báo",
                            JOptionPane.WARNING_MESSAGE);
                    // Không đổi tab, giữ nguyên
                }
            }
        });

        cardPanel.add(tabbedPane, BorderLayout.CENTER);
        add(cardPanel);
    }
}

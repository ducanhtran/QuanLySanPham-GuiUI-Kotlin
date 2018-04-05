package communityuni.com.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class SanPhamPanel {
    private JTable tblSanPham;
    private JPanel pnMain;
    private JTextField txtMa;
    private JTextField txtTen;
    private JTextField txtDonGia;
    private JButton btnLuu;
    private JButton btnTiep;
    private JButton btnXoa;
    private JButton btnThoat;

    private DefaultTableModel tableModelSanPham;

    public SanPhamPanel() {
        tblSanPham.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = tblSanPham.getSelectedRow();
                String ma = tblSanPham.getValueAt(row,0).toString();
                String ten = tblSanPham.getValueAt(row,1).toString();
                double gia = Double.parseDouble(tblSanPham.getValueAt(row,2).toString());
                txtMa.setText(ma);
                txtTen.setText(ten);
                txtDonGia.setText(gia+"");
            }
        });
        btnLuu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vector<String>vector=new Vector<>();
                vector.add(txtMa.getText());
                vector.add(txtTen.getText());
                vector.add(txtDonGia.getText());
                tableModelSanPham.addRow(vector);
            }
        });

        btnThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btnTiep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                txtMa.setText("");
                txtTen.setText("");
                txtDonGia.setText("");
                txtMa.requestFocus();
            }
        });
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(tblSanPham.getSelectedRow()>=0)
                    tableModelSanPham.removeRow(tblSanPham.getSelectedRow());
            }
        });
    }

    private void createUIComponents() {
        tableModelSanPham=new DefaultTableModel();
        tableModelSanPham.addColumn("Mã Sản Phẩm");
        tableModelSanPham.addColumn("Tên Sản Phẩm");
        tableModelSanPham.addColumn("Đơn giá Sản Phẩm");
        tblSanPham=new JTable(tableModelSanPham);
    }

    public JPanel getPnMain() {
        return pnMain;
    }
}

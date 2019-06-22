package view;

import controller.SaleService;
import model.Sale;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * @ClassName: Sale
 * @Description: TODO
 * @Author: 梁壮
 * @Date: 2019/6/6 23:12
 * @Version: 1.0
 */
public class SaleHistory extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JLabel background;
    private String time;
    private String flag;

    public SaleHistory(String time, String flag) {
        this.time = time;
        this.flag = flag;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("销售记录");
        setResizable(false);
        setBounds(650, 300, 900, 580);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblSale = new JLabel(flag);
        lblSale.setForeground(Color.RED);
        lblSale.setFont(new Font("楷体", Font.PLAIN, 21));
        lblSale.setBounds(743, 31, 91, 101);
        contentPane.add(lblSale);

        Sale sale = new Sale();
        sale.setTime(time);
        sale = new SaleService().browseSale(sale);

        String[] sale_title = {"编号","商品","数量","售价","总价","时间"};
        table = new JTable(sale.getSaleInfo(), sale_title);
        table.setBounds(0, 0, 726, 524);
        table.setOpaque(false);
        table.getTableHeader().setReorderingAllowed(false);
        table.setEnabled(false);
        JScrollPane jScrollPane = new JScrollPane(table);
        jScrollPane.setSize(726,524);
        contentPane.add(jScrollPane);

        background = new JLabel("背景");
        background.setBounds(0, 0, 869, 537);
        background.setIcon(new ImageIcon("images\\table_background.jpg"));
        contentPane.add(background);

        setVisible(true);
    }
}

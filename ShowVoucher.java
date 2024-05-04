import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

public class ShowVoucher extends JFrame
{
    private int frmWidth = 500, frmHeight = 400;
    private double scrWidth = getToolkit().getScreenSize().getWidth();
    private double scrHeight = getToolkit().getScreenSize().getHeight();
    private int xLocation = (int) (scrWidth / 2) - frmWidth / 2;
    private int yLocation = (int) (scrHeight / 2) - frmHeight / 2;
    private JLabel lblVoucherID = new JLabel("Voucher ID :");
    private ReadJSONVoucher voucherList = new ReadJSONVoucher();
    private JComboBox<String> cbVoucher = new JComboBox<>();
    private JLabel lblVoucherDate = new JLabel("Voucher Date :");
    private JTextField txtDate = new JTextField();
    private JPanel panelBottom=new JPanel();
    private JButton btnBack = new JButton("Back");
    private JLabel lblTotalPrice = new JLabel("Total Price  :");
    private JPanel panelTop = new JPanel();
    private JTextField txtTotal = new JTextField(10);

    String Coloumn []={"No","Food Names","Qty","Price","Line Total"};
     DefaultTableModel tModel = new DefaultTableModel(Coloumn,0);
    private JTable foodTable = new JTable(tModel);

    private JScrollPane scrollPane = new JScrollPane(foodTable,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

    private WelcomePage parentFrame = null;

    public ShowVoucher(WelcomePage parentFrame)
    {
        this.parentFrame=parentFrame;
        setTitle("Voucher List");
        setVisible(true);
        setSize(frmWidth,frmHeight);
        setLocation(xLocation,yLocation);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);
        foodTable.setEnabled(false);
        panelTop.setLayout(null);
        lblVoucherID.setBounds(20,10,100,30);
        panelTop.add(lblVoucherID);
        for(Voucher vObj : voucherList.getVoucherList())
            cbVoucher.addItem(vObj.getVoucherID());

        cbVoucher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Voucher d =  voucherList.getVoucherList().get(cbVoucher.getSelectedIndex());
                Date voucherDate= d.getVoucherDate();
                ArrayList<Item> itemList = d.getItemAry();
                txtDate.setText(voucherDate.getDate()+"/"+voucherDate.getMonth()+1+"/"+(voucherDate.getYear()+1901));
                tModel.setRowCount(0);
                for(int i = 0 ; i<itemList.size();i++)
                {
                    int voucherOn = itemList.get(i).getNo();
                    String foodName = itemList.get(i).getFood().getFoodName();
                    int foodQty = itemList.get(i).getQty();
                    int foodPrice = itemList.get(i).getFood().getFoodPrice();
                    long lineTotal = itemList.get(i).getTotal();

                    Object[] voucherData = {voucherOn,foodName,foodQty,foodPrice,lineTotal};
                    tModel.addRow(voucherData);
                }
                txtTotal.setText(d.getTotal()+"MMK");

            }
        });
        cbVoucher.setBounds(110,16,120,20);
        panelTop.add(cbVoucher);
        lblVoucherDate.setBounds(240,50,100,30);
        panelTop.add(lblVoucherDate);
        txtDate.setBounds(330,50,100,30);
        txtDate.setEditable(false);
        panelTop.add(txtDate);
        scrollPane.setBounds(10,100,470,200);
        txtTotal.setEditable(false);
        panelTop.add(scrollPane);
        panelBottom.add(btnBack);
        add(panelTop,BorderLayout.CENTER);
        add(panelBottom,BorderLayout.SOUTH);
        panelBottom.add(lblTotalPrice);
        panelBottom.add(txtTotal);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hideFrame();
            }
        });
    }
    public void hideFrame() {
        this.hide();
        this.parentFrame.show();
    }
}

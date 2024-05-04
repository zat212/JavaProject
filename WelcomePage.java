import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePage extends JFrame {
    private int frmWidth = 500, frmHeight = 500;
    private double scrWidth = getToolkit().getScreenSize().getWidth();
    private double scrHeight = getToolkit().getScreenSize().getHeight();
    private int xLocation = (int) (scrWidth / 2) - frmWidth / 2;
    private int yLocation = (int) (scrHeight / 2) - frmHeight / 2;
    private JButton btnshowVoucher = new JButton("Show Voucher");
    private JButton btnreportData = new JButton("Show Report");
    private JLabel lllImg = new JLabel(new ImageIcon("Burger.jpg"));


    public WelcomePage()
    {
        setTitle("Welcome to BTE Burger Shop");
        setVisible(true);
        setSize(frmWidth,frmHeight);
        setLocation(xLocation,yLocation);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        btnshowVoucher.setBounds(170,170,150,30);
        add(btnshowVoucher);
        btnreportData.setBounds(170,220,150,30);
        add(btnreportData);
        lllImg.setBounds(0,0,500,500);
        add(lllImg);
        btnshowVoucher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hideFrame();
            }
        });

        btnreportData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hideFrame1();
            }
        });
    }

    public void hideFrame()
    {
        this.hide();
        ShowVoucher frm = new ShowVoucher(this);
    }

    public void hideFrame1()
    {
        this.hide();
        Reporting_Data frm1 = new Reporting_Data(this);
    }


    public static void main(String[] args)
    {
        new WelcomePage();
    }
}

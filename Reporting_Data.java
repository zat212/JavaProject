import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reporting_Data extends JFrame
{
    private int frmWidth = 500, frmHeight = 500;
    private double scrWidth = getToolkit().getScreenSize().getWidth();
    private double scrHeight = getToolkit().getScreenSize().getHeight();
    private int xLocation = (int) (scrWidth / 2) - frmWidth / 2;
    private int yLocation = (int) (scrHeight / 2) - frmHeight / 2;
    private JButton btnTimeSlot = new JButton("By Time Slot");
    private JButton btnFoodId = new JButton("Food ID");
    private JButton btnBack = new JButton("Back");
    private JPanel panelTop = new JPanel();
    private JPanel panelBottom = new JPanel();
    private JLabel lllImage = new JLabel(new ImageIcon("asdf.jpg"));
    private WelcomePage parentFrame1 = null;

    public Reporting_Data(WelcomePage parentFrame1)
    {
        this.parentFrame1 = parentFrame1;
        setTitle("Data Reporting");
        setVisible(true);
        setSize(frmWidth,frmHeight);
        setLocation(xLocation,yLocation);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelTop.setLayout(null);
        setResizable(false);
        add(panelTop,BorderLayout.CENTER);
        add(panelBottom,BorderLayout.SOUTH);
        btnFoodId.setBounds(180,180,120,25);
        panelTop.add(btnFoodId);
        btnTimeSlot.setBounds(180,215,120,25);
        panelTop.add(btnTimeSlot);
        panelBottom.add(btnBack);
        panelTop.setBackground(Color.black);
        panelBottom.setBackground(Color.darkGray);
        lllImage.setBounds(0,-30,500,500);
        panelTop.add(lllImage);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hideFrame2();
            }
        });

        btnTimeSlot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hideFrame1();

            }
        });

        btnFoodId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hideFrame3();
            }
        });
    }

    public void hideFrame1()
    {
        this.hide();
        TimeSlot frm = new TimeSlot(this);
    }
    public void hideFrame2()
    {
        this.hide();
        this.parentFrame1.show();
    }
    public void hideFrame3()
    {
        this.hide();
        FoodID frm = new FoodID(this);
    }
}

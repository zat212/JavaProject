import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

public class TimeSlot extends JFrame
{
    private int frmWidth = 500, frmHeight = 500;
    private double scrWidth = getToolkit().getScreenSize().getWidth();
    private double scrHeight = getToolkit().getScreenSize().getHeight();
    private int xLocation = (int) (scrWidth / 2) - frmWidth / 2;
    private int yLocation = (int) (scrHeight / 2) - frmHeight / 2;

    private JLabel lblChoseTime = new JLabel("Please chose Time Duration :");
    private JButton btnFoodId = new JButton("Food ID");
    private ReadTimeJson timeReader = new ReadTimeJson();
    String Column [] = {"Food ID","Qty"};
    DefaultTableModel tModel = new DefaultTableModel(Column,10);
    private  JTable reportList = new JTable(tModel);
    private JScrollPane scrollPane = new JScrollPane(reportList,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS
            ,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    UtilDateModel model = new UtilDateModel();

    private JComboBox<String> cbTime = new JComboBox<>();

    private JPanel panelTop = new JPanel();
    private JPanel panelBottom = new JPanel();
    private JLabel lblFrom =new JLabel("From Date :");
    private JLabel lblTo = new JLabel("To Date :");
    private JLabel lblOrder = new JLabel("Order By/Sort By :");
    private JButton btnReport = new JButton("Report");
    private JButton btnBack = new JButton("Back");
    UtilDateModel model1 = new UtilDateModel();
    JDatePanelImpl datePanel = new JDatePanelImpl(model);
    DateLabelFormatter formatter = new DateLabelFormatter();
    JDatePickerImpl datePicker = new JDatePickerImpl(datePanel,formatter);
    JDatePanelImpl datePanel1 = new JDatePanelImpl(model1);
    private JRadioButton rdoAsc = new JRadioButton("Asc");
    private JRadioButton rdoDes = new JRadioButton("Des");
    private ButtonGroup bg = new ButtonGroup();

    DateLabelFormatter formatter1 = new DateLabelFormatter();
    JDatePickerImpl datePicker1 = new JDatePickerImpl(datePanel1,formatter1);
    private Reporting_Data parentFrame = null;

    public TimeSlot(Reporting_Data parentFrame)

    {
        this.parentFrame = parentFrame;  //Reporting_Data
        setTitle("Report By Time Slot Code");
        setVisible(true);
        setSize(frmWidth,frmHeight);
        setLocation(xLocation,yLocation);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        panelTop.setLayout(null);
        scrollPane.setBounds(10,180,470,200);
        panelTop.add(scrollPane);
        add(panelTop, BorderLayout.CENTER);
        add(panelBottom,BorderLayout.SOUTH);
        panelTop.setBackground(Color.WHITE);
        panelBottom.setBackground(Color.DARK_GRAY);
        datePicker.setBounds(220,50,120,25);
        panelTop.add(datePicker);
        datePicker1.setBounds(220,90,120,25);
        panelTop.add(datePicker1);
        btnReport.setBounds(410,410,100,30);
        panelBottom.add(btnReport);
        btnReport.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Date startDate = (Date) datePicker.getModel().getValue();
                Date endDate = (Date) datePanel1.getModel().getValue();
                if(startDate == null || endDate == null)
                	JOptionPane.showMessageDialog(null, "Please choose date range!!!");
                else {
                if(startDate.compareTo(endDate)<=0 )
                {
                ReadTimeJson readTSC = new ReadTimeJson();
                ReadFoodJson readFood = new ReadFoodJson();
                BTEVouchers bteVoucher = new BTEVouchers();
                ArrayList<FoodClass> foodAryList = readFood.getFoodList();
                ArrayList<TimeClass> timeArayList = readTSC.getTimeList();
                int[] qtyAry = new int[foodAryList.size()];
                int timeIndex = cbTime.getSelectedIndex();
                String selectedTimeCode = timeArayList.get(timeIndex).getTimeSlotCode();
                ArrayList<Voucher> selectedVoucher = bteVoucher.getVouchersByTSC(selectedTimeCode, startDate, endDate);
                for (Voucher v : selectedVoucher) {
                    ArrayList<Item> itemAry = v.getItemAry();
                    for(Item item : itemAry)
                    {
                        for(int i = 0;i< foodAryList.size();i++)
                        {
                            if(item.getFood().getFoodID().equals(foodAryList.get(i).getFoodID()))
                                qtyAry[i] += item.getQty();
                        }
                    }
                }
                if(rdoAsc.isSelected()) {
	                for(int i=0;i<foodAryList.size()-1;i++) {
	                	for(int j=0;j<foodAryList.size()-1-i;j++) {
	                		if(qtyAry[j]>qtyAry[j+1]) {
	                			int temp;
	                			temp=qtyAry[j];
	                			qtyAry[j]=qtyAry[j+1];
	                			qtyAry[j+1]=temp;
	                			FoodClass tempFood;
	                			tempFood=foodAryList.get(j);
	                			foodAryList.set(j, foodAryList.get(j+1));
	                			foodAryList.set(j+1, tempFood);
	                			
	                		}
	                	}
	                }
                }else {
                	for(int i=0;i<foodAryList.size()-1;i++) {
	                	for(int j=0;j<foodAryList.size()-1-i;j++) {
	                		if(qtyAry[j]<qtyAry[j+1]) {
	                			int temp;
	                			temp=qtyAry[j];
	                			qtyAry[j]=qtyAry[j+1];
	                			qtyAry[j+1]=temp;
	                			FoodClass tempFood;
	                			tempFood=foodAryList.get(j);
	                			foodAryList.set(j, foodAryList.get(j+1));
	                			foodAryList.set(j+1, tempFood);
	                			
	                		}
	                	}
	                }
                }
                int row=0;
                for(int i = 0 ; i< foodAryList.size();i++)
                {
                    String foodIDs = foodAryList.get(i).getFoodID();
                    int qtyData = qtyAry[i];
                    if(qtyData!=0)
                    {
                        reportList.setValueAt(foodIDs,row,0);
                        reportList.setValueAt(qtyData,row,1);
                        row++;


                   }

                }
                


            }else
                JOptionPane.showMessageDialog(null,"invalid Date range!");

            }}});
            
        lblChoseTime.setBounds(20,10,190,30);
        panelTop.add(lblChoseTime);
        for(TimeClass timeObj : timeReader.getTimeList())
            cbTime.addItem(timeObj.getTimeSlotCode()+"("+timeObj.getTimeSlot()+")") ;
        cbTime.setBounds(220,12,180,30);
        panelTop.add(cbTime);
        lblFrom.setBounds(20,50,100,30);
        panelTop.add(lblFrom);
        lblTo.setBounds(20,90,100,30);
        panelTop.add(lblTo);
        lblOrder.setBounds(20,130,190,30);
        panelTop.add(lblOrder);
        lblOrder.setBounds(20,130,130,30);
        panelTop.add(rdoAsc);
        panelTop.add(rdoDes);
        rdoDes.setBounds(300,130,50,25);
        rdoAsc.setBounds(220,130,50,25);
        rdoAsc.setBackground(Color.WHITE);
        rdoDes.setBackground(Color.WHITE);
        bg.add(rdoAsc);
        bg.add(rdoDes);
        panelBottom.add(btnBack);
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

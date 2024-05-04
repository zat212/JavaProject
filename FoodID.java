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
import javax.swing.JOptionPane;

public class FoodID extends JFrame
{
    private int frmWidth = 500, frmHeight = 500;
    private double scrWidth = getToolkit().getScreenSize().getWidth();
    private double scrHeight = getToolkit().getScreenSize().getHeight();
    private int xLocation = (int) (scrWidth / 2) - frmWidth / 2;
    private int yLocation = (int) (scrHeight / 2) - frmHeight / 2;

    private JLabel lblChoseTime = new JLabel("Please chose Food ID :");
    private ReadFoodJson foodReader = new ReadFoodJson();

    private JComboBox cbFoodID = new JComboBox();

    private JPanel panelTop = new JPanel();
    private JPanel panelBottom = new JPanel();
    private JLabel lblFrom =new JLabel("From Date :");
    private JLabel lblTo = new JLabel("To Date :");
    private JLabel lblOrder = new JLabel("Order By/Sort By :");
    private JButton btnReport = new JButton("Report");
    private JButton btnBack = new JButton("Back");
    String Coloumn [] = {"Time Slot","Qty"};
    DefaultTableModel tModel = new DefaultTableModel(Coloumn,12);
    private JTable ReportList = new JTable(tModel);

    private JScrollPane scrollPane = new JScrollPane(ReportList,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS
            ,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    UtilDateModel model = new UtilDateModel();
    JDatePanelImpl datePanel = new JDatePanelImpl(model);
    DateLabelFormatter formatter = new DateLabelFormatter();
    JDatePickerImpl datePicker = new JDatePickerImpl(datePanel,formatter);
    UtilDateModel model1 = new UtilDateModel();
    JDatePanelImpl datePanel1 = new JDatePanelImpl(model1);
    private JRadioButton rdoAsc = new JRadioButton("Asc");
    private JRadioButton rdoDes = new JRadioButton("Des");
    private ButtonGroup bg = new ButtonGroup();
    DateLabelFormatter formatter1 = new DateLabelFormatter();
    JDatePickerImpl datePicker1 = new JDatePickerImpl(datePanel1,formatter1);
    private Reporting_Data parentFrame = null;

    public FoodID(Reporting_Data parentFrame)

    {
        this.parentFrame = parentFrame;  //Reporting_Data
        setTitle("Report By FOOD-ID");
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
        panelTop.setBackground(Color.white);
        panelBottom.setBackground(Color.darkGray);
        datePicker.setBackground(Color.WHITE);
        datePicker1.setBackground(Color.WHITE);
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
                if(startDate == null || endDate == null) {
                    JOptionPane.showMessageDialog(null, "Please choose date range!!!");
                } else {
                	 if(startDate.compareTo(endDate)<=0 ) {                
                ReadTimeJson readTSC = new ReadTimeJson();
                ReadFoodJson readFood = new ReadFoodJson();
                BTEVouchers bteVoucher = new BTEVouchers();
                ArrayList<FoodClass> foodList = readFood.getFoodList();
                ArrayList<TimeClass> timeArayList = readTSC.getTimeList();
                int[] qtyAry = new int[timeArayList.size()];
                int foodIndex = cbFoodID.getSelectedIndex();
                String selectedFoodId = foodList.get(foodIndex).getFoodID();
                ArrayList<Voucher> slectedVoucher =bteVoucher.getVouchersByFoodID(selectedFoodId,startDate,endDate);
                for( Voucher v : slectedVoucher){
                    for(int i = 0 ; i < timeArayList.size();i++)
                    {
                        if(v.getTimeSlotCode().getTimeSlotCode().equals(timeArayList.get(i).getTimeSlotCode()))
                        {
                            ArrayList<Item> itemAry = v.getItemAry();
                            int index = -1;
                            for(int j = 0 ; j< itemAry.size() && index == -1 ; j++)
                            {
                                if(selectedFoodId.equals(itemAry.get(j).getFood().getFoodID()))
                                    index=j;
                            }
                            if(index!=-1)
                                qtyAry[i] += itemAry.get(index).getQty();
                        }
                    }
                }
                if(rdoAsc.isSelected()) {
	                for(int i=0;i<timeArayList.size()-1;i++) {
	                	for(int j=0;j<timeArayList.size()-1-i;j++) {
	                		if(qtyAry[j]>qtyAry[j+1]) {
	                			int temp;
	                			temp=qtyAry[j];
	                			qtyAry[j]=qtyAry[j+1];
	                			qtyAry[j+1]=temp;
	                			TimeClass tempTime;
	                			tempTime=timeArayList.get(j);
	                			timeArayList.set(j, timeArayList.get(j+1));
	                			timeArayList.set(j+1, tempTime);
	                			
	                		}
	                	}
	                }
                }else {
                	for(int i=0;i<timeArayList.size()-1;i++) {
	                	for(int j=0;j<timeArayList.size()-1-i;j++) {
	                		if(qtyAry[j]<qtyAry[j+1]) {
	                			int temp;
	                			temp=qtyAry[j];
	                			qtyAry[j]=qtyAry[j+1];
	                			qtyAry[j+1]=temp;
	                			TimeClass tempTime;
	                			tempTime=timeArayList.get(j);
	                			timeArayList.set(j, timeArayList.get(j+1));
	                			timeArayList.set(j+1, tempTime);
	                			
	                		}
	                	}
	                }
                }
                int row=0;
                for(int i = 0 ; i<timeArayList.size();i++)
                {
                    String timeData = timeArayList.get(i).getTimeSlot();
                    int qtyData = qtyAry[i];
                    if(qtyData!=0)
                    {
                        ReportList.setValueAt(timeData,row,0);
                        ReportList.setValueAt(qtyData,row,1);
                        row++;
                    }


                }}else
                    JOptionPane.showMessageDialog(null,"invalid Date range!");



        }

        }}

        );
        lblChoseTime.setBounds(20,10,190,30);
        panelTop.add(lblChoseTime);
        ArrayList<FoodClass> foodList = foodReader.getFoodList();
        for (FoodClass foodObj : foodList) {
            cbFoodID.addItem(foodObj.getFoodID() + "(" + foodObj.getFoodName() + ")");
            System.out.println("Added: " + foodObj.getFoodID() + "(" + foodObj.getFoodName() + ")");
        }
        cbFoodID.setBounds(220,12,180,30);
        cbFoodID.setBackground(Color.WHITE);
        panelTop.add(cbFoodID);
        lblFrom.setBounds(20,50,100,30);
        panelTop.add(lblFrom);
        lblTo.setBounds(20,90,100,30);
        panelTop.add(lblTo);
        lblOrder.setBounds(20,130,190,30);
        panelTop.add(lblOrder);
        lblOrder.setBounds(20,130,130,30);
        panelTop.add(rdoAsc);
        panelTop.add(rdoDes);
        rdoDes.setBackground(Color.white);
        rdoAsc.setBackground(Color.white);
        rdoDes.setBounds(300,130,50,25);
        rdoAsc.setBounds(220,130,50,25);
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
    public void hideFrame()
    {
        this.hide();
        this.parentFrame.show();
    }}

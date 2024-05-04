import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class TestingMain

{
    public static void main(String[] args){
        showReportByFoodID();
    }
    public static void showReportByFoodID() {
        Scanner input = new Scanner(System.in);
        BTEVouchers bteVouchers = new BTEVouchers();
        System.out.println("Please enter Time Slot Code to show report");
        String timeSlot = input.next();
        Date d1 = new Date(122, 0, 1);
        Date d2 = new Date(122, 0, 4);
        System.out.println("d1 : " + d1.getDate() + "/" + d1.getMonth() + "/" + d1.getYear());
        ReadTimeJson readTSC = new ReadTimeJson();
        ReadFoodJson readFood = new ReadFoodJson();
        ArrayList<FoodClass> foodAryList = readFood.getFoodList();
        ArrayList<TimeClass> timeAryList = readTSC.getTimeList();
        int[] qtyAry = new int[foodAryList.size()];
        ArrayList<Voucher> selectedVoucher = bteVouchers.getVouchersByTSC(timeSlot, d1, d2);
        System.out.println("Selected Vouchers : " + selectedVoucher.size());
        for (Voucher v : selectedVoucher) {
            System.out.println(v);
            ArrayList<Item> itemAry = v.getItemAry();
            for(Item item : itemAry){
                for(int i = 0;i< foodAryList.size();i++)
                {
                    if(item.getFood().getFoodID().equals(foodAryList.get(i).getFoodID()))
                        qtyAry[i] +=item.getQty();
                }
            }

        }
        System.out.println("------------------");
        for (int i = 0; i < foodAryList.size(); i++)
            System.out.println(foodAryList.get(i).getFoodID() + "--->" + qtyAry[i]);

    }}
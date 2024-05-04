import org.json.simple.JSONObject;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main
{

    static ReadJSONVoucher voucherData = new ReadJSONVoucher();
    static  BTEVouchers getData = new BTEVouchers();
//    static ReadFoodJson foodData = new ReadFoodJson();
    static ArrayList<Item> foodIDandNamelist;
//    static ArrayList<Item> itemList = voucherDate.get



//    JSONObject json = new JSONObject();
//    static Date d2 = null;
//    static String items;




    public static void main(String[] args) {

//        List<Voucher> vouchers = voucherData.getVoucherList();
//        for (int i = 0; i < voucherData.getVoucherList().size(); i++) {
//            System.out.println(voucherData.getVoucherList().get(i).getItemAry().get(i).getFood().getFoodID());
//            System.out.println(voucherData.getVoucherList().get(i).getVoucherDate());
//            System.out.println(voucherData.getVoucherList().get(i).getItems());
//            System.out.println(voucherData.getVoucherList().get(i).getTimeSlotCode().getTimeSlotCode());}


        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(5);
        arr.add(3);
        arr.add(8);
        arr.add(1);
        arr.add(2);
        System.out.println("Before sorting: " + arr);

        // Perform bubble sort
        int n = arr.size();
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr.get(j) > arr.get(j+1)) {
                    // Swap elements
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j+1));
                    arr.set(j+1, temp);
                }
            }
        }

        System.out.println("After sorting: " + arr);
    }
//        ArrayList<Object> list = new ArrayList<Object>();
//        list.add("Hello");
//        list.add(42);
//        list.add("hee hee ha ha");
//        list.add(12);
//        System.out.println(list);






        //            Voucher voucher = vouchers.get(i);






//            Date voucherDate = voucher.getVoucherDate();
//
//            Date startDate = new Date(2022, 0, 2);
//            Daနနte endDate = new Date(2022, 0, 4);
//
//            String items = "";
//
//            ArrayList<Integer> qtyList = new ArrayList<Integer>();
//            if (getData.isDateInRange(voucherDate, startDate, endDate))
//                {
//
//                    for(int j = 0; j<voucher.getItemAry().size(); j++ ){
//
//                    items+= voucher.getItemAry().get(j).getFood().getFoodID();
//
//                    }
//                    try {
//                        qtyList.add(voucher.getItemAry().get(0).getQty()); // FD001 ကို လို ချင်လို့ index(0) လို့ ပေး software မှာဆို getslectedindex နဲ့ ယူ
//                    }catch (IndexOutOfBoundsException e)
//                    {
//                      continue;
//                    }
//                    System.out.println(voucher.getVoucherDate());
//                    System.out.println(items+" "+voucher.getTimeSlotCode().getTimeSlot()+" "+voucher.getTimeSlotCode().getTimeSlotCode()+
//                            " " +qtyList);
//
//                }
            }


//        for(int i = 0 ; i <voucherData.getVoucherList().size();i++)
//        {
//            Date d2 = voucherData.getVoucherList().get(i).getVoucherDate();
//            Date startDate = new Date(2022,0,2);
//            Date endDate = new Date(2022,0,4);
//
//            ArrayList<Item> itemData = voucherData.getVoucherList().get(i).getItemAry();
//            boolean isDateRange = getData.isDateInRange(d2,startDate,endDate);
//            if(isDateRange){
//            for(int j = 0 ; j<itemData.size();j++)
//            {
//                System.out.println(voucherData.getVoucherList().get(j).getVoucherDate());
//                System.out.println(voucherData.getVoucherList().get(j).getItems());
//            }
//
//        }}

//        System.out.println(voucherData.getVoucherList().get(4).getVoucherDate());
//        System.out.println(voucherData.getVoucherList().get(0).getTimeSlotCode());
//        System.out.println(itemList);
//        for(int i = 0 ; i<voucherDate.)
//        for (int i = 0; i < voucherData.getVoucherList().size(); i++)
//////            System.out.println(voucherData.getVoucherList().get(i).getVoucherDate());
//        {System.out.println(voucherData.getVoucherList().get(i).getItems());}
//        Scanner input = new Scanner(System.in);
//        System.out.println("enter index : ");
//        int index = input.nextInt();
//            System.out.println(voucherData.getVoucherList().get(index).getTimeSlotCode());
//            System.out.println(voucherData.getVoucherList().get(index).getItems());
//        System.out.println(voucherData.getVoucherList().get(index+8).getTimeSlotCode());
//        System.out.println(voucherData.getVoucherList().get(index+8).getItems());
//            System.out.println(voucherData.getVoucherList().get(i).getTimeSlotCode());

//            System.out.println(voucherData.getVoucherList().get(i).getItems());
////            System.out.println(voucherData.getVoucherList().get(i).getTimeSlotCode());}
//
//        for(int i = 0 ; i<foodIDandNamelist.size();i++)
//            if(d2.getDate().compareTo(d1.getDate())>=0 && d2.compareTo(d3)<=0)
////            for (int j = 0;j<voucherData.getVoucherList().size();j++)
//
//        { foodIDandNamelist = voucherData.getVoucherList().get(i).getItemAry();
//        System.out.println(foodIDandNamelist.get(i).getNo());}
//        Date d1 = new Date(2022,0,1);
//        Date d3 = new Date(2022,0,4);
//        for(int i = 0 ; i < voucherData.getVoucherList().size(); i ++)
//        {
//        Date d2 = voucherData.getVoucherList().get(i).getVoucherDate();
//        for(int j = 0 ; j<voucherData.getVoucherList().get(i).getItemAry().size();j++){
//        String foodName = voucherData.getVoucherList().get(i).getItemAry().get(i).getFood().getFoodName();
//            ArrayList<Voucher> itemData = getData.getVouchersByFoodID(foodName,d1,d3);
//            System.out.println(d2);
//            System.out.println(itemData);}
//        }

//        for (int i = 0 ;i<voucherData.getVoucherList().size();i++)
//        {
//            System.out.println(voucherData.getVoucherList().get(i).getItemAry().get(i).getFood().getFoodID());
//        }


        // start to ask
//                String items = voucherData.getVoucherList().get(i).getItems();
//                String fd001 = "";
//                int fd001Qt = 0;
//
//                String[] itemArray = items.split("\\]\\[");
//                for (String item : itemArray)
//                {
//                    if (item.contains("FD001"))
//                    {
//                        fd001 = item.split(",")[1];
//                        fd001Qt =Integer.parseInt(item.split(",")[2].replace("]",""));
//                        break;
//                    }
//
//                }
//                System.out.println(fd001);
//                System.out.println(fd001Qt);

//                System.out.println(voucherData.getVoucherList().get(i).getTimeSlotCode().getTimeSlot().getClass());









////
////
//        }
//            System.out.println(voucherData.getVoucherList().get(i).getVoucherDate());
////            System.out.println(voucherData.getVoucherList().get(i).getItems());
//            System.out.println(voucherData.getVoucherList().get(i).getTimeSlotCode());
//        }
//        System.out.println(voucherData.getVoucherList().get(1).getItems());


//            System.out.println(itemData.get(i).getQty());
//        String str = "apple,banana,orange,kiwi,mango";
//        String[] fruits = str.split(",", 3);
//        for (String fruit : fruits) {
//            System.out.println(fruit);
//        }








//        System.out.println("__________________________________");
//        System.out.println(foodlist);






//        System.out.println("--------");
//        for (int i = 0; i < voucherData.getVoucherList().size(); i++)
//////            System.out.println(voucherData.getVoucherList().get(i).getVoucherDate());
//            System.out.println(voucherData.getVoucherList().get(i));


//
//    }

//        Date startDate = new Date(2022,0,1); // Set the start date
//        Date endDate = new Date(2022,0,4);   // Set the end date
//
//        for (int i = 0; i < voucherData.getVoucherList().size(); i++) {
//            Date voucherDate = voucherData.getVoucherList().get(i).getVoucherDate();
//            if (voucherDate.after(startDate) && voucherDate.before(endDate)) {
//                System.out.println(voucherData.getVoucherList().get(i).getTimeSlotCode());
//                System.out.println(voucherData.getVoucherList().get(i).getVoucherDate());
//            }
//        }
//        String foodName = foodData.getFoodList().get(2).getFoodName();
//        System.out.println(foodName);







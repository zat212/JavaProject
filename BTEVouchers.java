
import java.util.ArrayList;
import java.util.Date;

public class BTEVouchers {
    private ArrayList<Voucher> voucherList;
	private ReadJSONVoucher jsonVouchers;
	
	public BTEVouchers() {
		jsonVouchers = new ReadJSONVoucher();
		voucherList = jsonVouchers.getVoucherList();
	}
	//Method to get Vouchers by searching FoodID
	public ArrayList<Voucher> getVouchersByFoodID(String foodID,Date fromDate,Date toDate){
		ArrayList<Voucher> vList = new ArrayList<Voucher>();
		for(int i=0;i<voucherList.size();i++) {
			Voucher v=voucherList.get(i);
			Date d2=v.getVoucherDate();
			if(isInDateRange(d2,fromDate,toDate)) {
				ArrayList<Item> itemList=v.getItemAry();
				for(int j=0;j<itemList.size();j++) {
					if(itemList.get(j).getFood().getFoodID().equals(foodID)) {
						vList.add(v);
					}
						
				}
			}
		}
		return vList;
	}
	//Method to get Vouchers by searching Time Slot Code
	public ArrayList<Voucher> getVouchersByTSC(String tsc,Date fromDate,Date toDate){

		ArrayList<Voucher> vList = new ArrayList<Voucher>();
		for(int i=0;i<voucherList.size();i++) {
			Voucher v=voucherList.get(i);
			Date d=v.getVoucherDate();
			if(isInDateRange(d,fromDate,toDate)) {
				if(tsc.equals(v.getTimeSlotCode().getTimeSlotCode()))
					vList.add(v);
			}
		}
		return vList;
	}
	//Checking input date is in range method
	public boolean isInDateRange(Date d,Date fromDate,Date toDate) {
		boolean isInRange=false;
		if(d.getYear()==fromDate.getYear() && d.getYear()==toDate.getYear()) {
			if(d.getMonth()==fromDate.getMonth() && d.getMonth()==toDate.getMonth()) {
				if(d.getDate()>=fromDate.getDate() && d.getDate()<=toDate.getDate())
					isInRange=true;
			}
		}
		return isInRange;
	}



}

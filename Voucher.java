
import java.util.ArrayList;
import java.util.Date;

public class Voucher {
	private String voucherID;
	private Date voucherDate;
	private TimeClass timeSlotCode;
	private ArrayList<Item> itemAry;
	private long voucherTotal;
	public Voucher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Voucher(String voucherID, Date voucherDate, TimeClass timeSlotCode, ArrayList<Item> itemAry, long total) {
		super();
		this.voucherID = voucherID;
		this.voucherDate = voucherDate;
		this.timeSlotCode = timeSlotCode;
		this.itemAry = itemAry;
		this.voucherTotal = total;
	}



	public String getVoucherID() {
		return voucherID;
	}
	public void setVoucherID(String voucherID) {
		this.voucherID = voucherID;
	}
	public Date getVoucherDate() {
		return voucherDate;
	}
	public void setVoucherDate(Date voucherDate) {
		this.voucherDate = voucherDate;
	}
	public TimeClass getTimeSlotCode() {
		return timeSlotCode;
	}
	public void setTimeSlotCode(TimeClass timeSlotCode) {
		this.timeSlotCode = timeSlotCode;
	}
	public ArrayList<Item> getItemAry() {
		return itemAry;
	}
	public void setItemAry(ArrayList<Item> itemAry) {
		this.itemAry = itemAry;
	}
	public long getTotal() {
		return voucherTotal;
	}
	public void setTotal(long total) {
		this.voucherTotal = total;
	}
	@Override
	public String toString() {
		return "Voucher [voucherID=" + voucherID + ", voucherDate=" + voucherDate.getDate()+"/"+(voucherDate.getMonth()+1)+"/"+(voucherDate.getYear()+1900) + ", timeSlotCode=" + timeSlotCode.getTimeSlot()
				+ "items= ["+getItems()+"], voucherTotal=" + voucherTotal + "]";
	}
	
	public String getItems() {
		String str="";
		for(Item item : itemAry) {
			str+="["+item.getNo()+","+item.getFood().getFoodID()+","+item.getQty()+"]";
		}
		return str;
	}



}



public class Item {
	
	private int no;
	private FoodClass food;
	private int qty;
	private long total;
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Item(int no, FoodClass food, int qty) {
		super();
		this.no = no;
		this.food = food;
		this.qty = qty;
		this.total = qty*food.getFoodPrice();
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public FoodClass getFood() {
		return food;
	}
	public void setFood(FoodClass food) {
		this.food = food;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}


	
	

}

public class FoodClass
{
    private String foodID;
    private String foodName;
    private int foodPrice;

    public FoodClass()
    {
        super();
    }

    public FoodClass(String foodID, String foodName, int foodPrice) {
        this.foodID = foodID;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }

    public String getFoodID() {
        return foodID;
    }

    public void setFoodID(String foodID) {
        this.foodID = foodID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(int foodPrice) {
        this.foodPrice = foodPrice;
    }

    @Override
    public String toString() {
        return "FoodClass{" +
                "foodID='" + foodID + '\'' +
                ", foodName='" + foodName + '\'' +
                ", foodPrice=" + foodPrice +
                '}';
    }
}

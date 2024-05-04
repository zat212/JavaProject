import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadFoodJson
{
    private ArrayList<FoodClass> foodList;

    public ReadFoodJson() {
        foodList = new ArrayList<>();
        setData();
    }
    public void setData()
    {
        
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("foods.json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray foodListInJSON = (JSONArray) obj;
            System.out.println(foodListInJSON);

            for (Object jsonObj : foodListInJSON) {
                JSONObject foodInJSon = (JSONObject) jsonObj;
                foodList.add(parseFoodObject(foodInJSon));
            }

            for (FoodClass e : foodList)
                System.out.println(e);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }

    }

    private static FoodClass parseFoodObject(JSONObject food)
    {
        JSONObject obj = (JSONObject) food.get("food");    

        String iD = (String) obj.get("foodID");

        int price = Integer.parseInt((String)obj.get("foodPrice"));

        String name = (String) obj.get("foodName");

        FoodClass food1 = new FoodClass(iD,name,price);
        return food1;                                 
    }
    public ArrayList<FoodClass> getFoodList()
    {
        return foodList;
    }
}
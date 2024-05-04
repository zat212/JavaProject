import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
 
public class ReadJSONVoucher{


	private ArrayList<Voucher> voucherList;
	
    @SuppressWarnings("unchecked")
    public ReadJSONVoucher()
    {
        voucherList = new ArrayList<>();
        setData();
    }
    
    public void setData()
    {

        JSONParser jsonParser = new JSONParser();
     
         
        try{
        	FileReader reader = new FileReader("BTE_Vouchers.json");
        	Object obj = jsonParser.parse(reader);
            JSONArray foodListInJson = (JSONArray) obj;
            for(Object jsonObj : foodListInJson) {
            	JSONObject voucherInJson = (JSONObject)jsonObj;
            	voucherList.add(parseVoucherObject(voucherInJson));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
 
    private Voucher parseVoucherObject(JSONObject voucher){

        JSONObject voucherObject = (JSONObject) voucher.get("voucher");
         

        String voucherID = (String) voucherObject.get("voucherID");    
         

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String d = (String) voucherObject.get("voucherDate");  
       Date voucherDate=null;
	try {
		voucherDate = dateFormat.parse(d);
	} catch (java.text.ParseException e) {

		e.printStackTrace();
	}
        

        Object strTsc = voucherObject.get("timeSlotCode");
        TimeClass tsc = new Gson().fromJson(strTsc.toString(), TimeClass.class);

        ArrayList<Item> itemAry=new ArrayList<Item>();
        JSONArray arrays = (JSONArray) voucherObject.get("itemAry");
        for (Object object : arrays) {

        		itemAry.add(new Gson().fromJson(object.toString(), Item.class));
        }
        System.out.println("itemAry size is "+itemAry.size());
        //Get VoucherTotal
        long voucherTotal = (long) voucherObject.get("voucherTotal");
        
        Voucher vObj = new Voucher(voucherID,voucherDate,tsc,itemAry,voucherTotal);
        return vObj;
    }

    public ArrayList<Voucher> getVoucherList()
    {
        return voucherList;
    }
}

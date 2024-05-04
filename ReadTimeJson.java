import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadTimeJson
{
    private ArrayList<TimeClass> timeList;
    public ReadTimeJson(){
        timeList = new ArrayList<>();
        setData();
    }
    public void setData()
    {

        JSONParser jsonParser = new JSONParser();


        try (FileReader reader = new FileReader("time.json"))
        {
            Object obj = jsonParser.parse(reader);

            JSONArray timeListInJSON = (JSONArray) obj;
            System.out.println(timeListInJSON);

            for(Object jsonObj : timeListInJSON) {
                JSONObject timeInJSon = (JSONObject)jsonObj;
                timeList.add(parseTimeObject(timeInJSon));
            }

            for(TimeClass e : timeList)
                System.out.println(e);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (ParseException e) {
            e.printStackTrace();
        }


    }

    private static TimeClass parseTimeObject(JSONObject time)
    {

        JSONObject obj = (JSONObject) time.get("time");  


        String code = (String) obj.get("timeSlotCode");

        String timeSlot = (String) obj.get("timeSlot");

        TimeClass time1 = new TimeClass(code,timeSlot);
        return time1;                                 
    }

    public ArrayList<TimeClass> getTimeList()
    {
        return timeList;
    }
}

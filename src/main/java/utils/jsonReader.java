package utils;

import com.jayway.jsonpath.JsonPath;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class jsonReader {
  String Reader;
  private final String path= "src/test/java/testData/";
  String fileName;
  public jsonReader(String fileName)
  {
      this.fileName = fileName;
      try
      {
          JSONObject object =(JSONObject)  new JSONParser().parse(new FileReader(path+fileName+".json"));
          Reader= object.toJSONString();
      }
      catch (Exception e)
      {
            System.out.println("Error in reading the json file: " + e.getMessage());
      }
  }
  public String getData(String cred)
  {
      try
      {
          return JsonPath.read(Reader,cred);
      }
      catch (Exception e)
      {
          System.out.println("Error in getting the json data: " + e.getMessage());
          return "";
      }
  }




}

package com.example.bionic.lesson0306json;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import com.example.bionic.lesson0306json.models.HoundImages;
import com.example.bionic.lesson0306json.resources.Hound;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import java.io.IOException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    RecyclerView houndRecyclerView = findViewById(R.id.hound_rv);
    GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
    houndRecyclerView.setLayoutManager(gridLayoutManager);
    buildingJSONObject();
    parsingJsonString();
    HoundImages houndImages = parsingJSONWithMoshi();
    List<String> houndUrls = houndImages.getMessage();
    HoundAdapter houndAdapter = new HoundAdapter(houndUrls);
    houndRecyclerView.setAdapter(houndAdapter);

    Log.d("HOUND", "URL List: " + houndUrls.toString());

  }

  /**
   * { "student": [ { "id": 1, "name": "John Doe", "year": "1st", "curriculum": "Arts", "birthday":
   * 3/3/1995 }, { "id": 2, "name": "Michael West", "year": "2nd", "curriculum": "Economic",
   * "birthday": 4/4/1994 } ] }
   * Lets build this JSONObject using the json api
   */

  public static JSONObject buildingJSONObject() {
    JSONObject studentObject = new JSONObject();
    try {
      studentObject.put("student",
          new JSONArray()
              .put(new JSONObject()
                  .put("id", 1)
                  .put("name", "John Doe")
                  .put("year", "1st")
                  .put("curriculum", "Arts")
                  .put("birthday", "3/3/1995"))
              .put(new JSONObject()
                  .put("id", 2)
                  .put("name", "Michael West")
                  .put("year", "2nd")
                  .put("curriculum", "Economic")
                  .put("birthday", "4/4/1994"))
      );
    } catch (JSONException e) {
      e.printStackTrace();
    }

    Log.d("STUDENT", "Student Object: " + studentObject.toString());

    return studentObject;
  }


  public static void parsingJsonString() {
    String userProfile = "{\n"
        + "    \"firstName\": \"John\",\n"
        + "    \"lastName\": \"Smith\",\n"
        + "    \"isAlive\": true,\n"
        + "    \"age\": 25,\n"
        + "    \"heightCm\": \"167.64\",\n"
        + "    \"address\": {\n"
        + "        \"streetAddress\": \"21 2nd Street\",\n"
        + "        \"city\": \"New York\",\n"
        + "        \"state\": \"NY\",\n"
        + "        \"postalCode\": \"10021-3100\",\n"
        + "        \"phone\": null\n"
        + "    }\n"
        + "}";

    try {
      JSONObject userProfileObject = new JSONObject(userProfile);
      String firstName = userProfileObject.getString("firstName");
      String lastName = userProfileObject.getString("lastName");
      Boolean isAlive = userProfileObject.getBoolean("isAlive");
      int age = userProfileObject.getInt("age");
      double heightCm = userProfileObject.getDouble("heightCm");
      JSONObject addressObject = userProfileObject.getJSONObject("address");
      String streetAddress = addressObject.getString("streetAddress");
      String city = addressObject.getString("city");
      String state = addressObject.getString("state");
      String postalCode = addressObject.getString("postalCode");
      String phone = addressObject.getString("phone");
      Log.d("USERPROFILE", "User Profile: "
          + "\nfirstName: " + firstName
          + "\nlastName: " + lastName
          + "\nisAlive: " + isAlive
          + "\nage: " + age
          + "\nheightCm: " + heightCm
          + "\naddress: "
          + "\n\t\tstreetAddress: " + streetAddress
          + "\n\t\tcity: " + city
          + "\n\t\tstate: " + state
          + "\n\t\tpostalCode: " + postalCode
          + "\n\t\tphone: " + phone);
    } catch (JSONException e) {
      e.printStackTrace();
    }
  }

  public HoundImages parsingJSONWithMoshi() {
    Moshi moshi = new Moshi.Builder().build();
    JsonAdapter<HoundImages> houndImagesJsonAdapter = moshi.adapter(HoundImages.class);
    HoundImages houndImages = null;
    try {
      houndImages = houndImagesJsonAdapter.fromJson(Hound.dogJson);
      Log.d("TAG", "Oncreate: " + houndImages.getStatus());
      Log.d("TAG", "Oncreate: " + houndImages.getMessage().size());
    } catch (IOException e) {
      e.printStackTrace();
    }

    Log.d("JSON: ", "onCreate: " + houndImages.getMessage());

    return houndImages;
  }
}

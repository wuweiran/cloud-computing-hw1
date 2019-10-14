package edu.nyu.cs9223.hw1;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author wwrus
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class UserInfo implements Serializable {
    private String location;
    private String cuisine;
    private String diningDate;
    private String diningTime;
    private String peopleNum;
    private String phoneNumber;

    public static UserInfo fromSlots(String message) {
        JsonObject content = JsonParser.parseString(message).getAsJsonObject();
        return new UserInfo(
                content.get("Location").getAsString(),
                content.get("Cuisine").getAsString(),
                content.get("DiningDate").getAsString(),
                content.get("DinningTime").getAsString(),
                content.get("PeopleNum").getAsString(),
                content.get("PhoneNumber").getAsString());
    }
}

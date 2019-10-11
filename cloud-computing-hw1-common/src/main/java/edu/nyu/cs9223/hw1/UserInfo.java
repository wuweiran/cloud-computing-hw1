package edu.nyu.cs9223.hw1;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author wwrus
 */
@Getter
@Setter
public class UserInfo implements Serializable {
    private String location;
    private String cuisine;
    private String diningTime;
    private String peopleNum;
    private String phoneNumber;

    public static UserInfo fromJson(String message) {
        return new Gson().fromJson(message, UserInfo.class);
    }
}

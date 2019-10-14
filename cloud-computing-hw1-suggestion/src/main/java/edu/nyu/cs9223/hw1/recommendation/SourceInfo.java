package edu.nyu.cs9223.hw1.recommendation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author wuweiran
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
public class SourceInfo {
    private String cuisineType;
    private String address;
    private String reviewNum;
    private String coordinates;
    private String rating;
    private String zipCode;
    private String name;
}

package edu.nyu.cs9223.hw1.chatbot.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author weiranwu
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Bot {
    private String name;
    private String alias;
    private String version;
}

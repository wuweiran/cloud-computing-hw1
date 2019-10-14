package edu.nyu.cs9223.hw1.search;

import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class ElasticSearchServiceTest {

    @Test
    public void search() {
        assertNotEquals(ElasticSearchService.search("Chinese").size(), 0);
    }
}
package com.test.structuralPatterns.filterPattern;

import java.util.List;

public interface  Criteria {
    public List<Person> meetCriteria(List<Person> persons);
}

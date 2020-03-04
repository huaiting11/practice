package com.test.StructuralPatterns.FilterPattern;

import java.util.List;

public interface  Criteria {
    public List<Person> meetCriteria(List<Person> persons);
}

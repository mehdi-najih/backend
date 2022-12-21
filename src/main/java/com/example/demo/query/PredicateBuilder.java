package com.example.demo.query;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.example.demo.entity.QEmployee;
import java.util.Map;


public class PredicateBuilder {

    public static Predicate employeePredicateFilter(Map<String, String> filters) {
        BooleanBuilder where = new BooleanBuilder();
        QEmployee employee = QEmployee.employee;
        if (filters.get("firstName") != null && !filters.get("firstName").equals("")) {
            where.and(employee.firstName.eq(filters.get("firstName")));
        }
        return where;
    }
}

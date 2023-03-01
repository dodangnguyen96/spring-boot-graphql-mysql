package com.bezkoder.springgraphql.mysql.resolver;

import com.bezkoder.springgraphql.mysql.model.Student;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentResolver implements GraphQLQueryResolver {


    public List<Student> students() {
        Student a = new Student("chum", 2);
        List<Student> as = new ArrayList<>();
        as.add(a);
        return as;
    }

}

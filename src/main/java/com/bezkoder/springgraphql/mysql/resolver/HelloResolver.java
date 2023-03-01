package com.bezkoder.springgraphql.mysql.resolver;

import com.bezkoder.springgraphql.mysql.model.Student;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HelloResolver implements GraphQLQueryResolver {


    public String hello() {
        return "Hello GraphQL GraphQL!!!";
    }

}

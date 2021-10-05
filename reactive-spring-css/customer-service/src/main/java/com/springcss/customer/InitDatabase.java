package com.springcss.customer;

import com.springcss.customer.domain.CustomerTicket;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

@Component
public class InitDatabase {
  @Bean
  CommandLineRunner init(MongoOperations operations) {
    return args -> {
      operations.dropCollection(CustomerTicket.class);
    };
  }
}

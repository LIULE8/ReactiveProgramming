package com.springcss.customer.repository;

import com.springcss.customer.domain.CustomerTicket;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerTicketRepository extends ReactiveMongoRepository<CustomerTicket, String> {

  List<CustomerTicket> getCustomerTicketByOrderNumber(String orderNumber);
}

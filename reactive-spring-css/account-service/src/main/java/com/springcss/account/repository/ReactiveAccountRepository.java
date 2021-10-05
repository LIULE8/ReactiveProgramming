package com.springcss.account.repository;

import com.springcss.account.domain.Account;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ReactiveAccountRepository
    extends ReactiveMongoRepository<Account, String>, ReactiveQueryByExampleExecutor<Account> {

  Mono<Account> findAccountByAccountName(String accountName);
}

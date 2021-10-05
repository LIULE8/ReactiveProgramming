package com.springcss.r2dbc.demo.controller;

import com.springcss.r2dbc.demo.domain.Account;
import com.springcss.r2dbc.demo.repository.ReactiveAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "accounts")
public class AccountController {

  @Autowired private ReactiveAccountRepository reactiveAccountRepository;

  @GetMapping(value = "/{accountId}")
  public Mono<Account> getAccountById(@PathVariable("accountId") Long accountId) {

    Mono<Account> account = reactiveAccountRepository.getAccountById(accountId);
    return account;
  }

  @PostMapping(value = "/")
  public Mono<Boolean> addAccount(@RequestBody Account account) {

    return reactiveAccountRepository.addAccount(account.getAccountCode(), account.getAccountName());
  }
}

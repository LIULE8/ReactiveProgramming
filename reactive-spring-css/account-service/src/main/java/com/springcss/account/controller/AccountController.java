package com.springcss.account.controller;

import com.springcss.account.domain.Account;
import com.springcss.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "accounts")
public class AccountController {

  @Autowired private AccountService accountService;

  @GetMapping(value = "/{accountId}")
  public Mono<Account> getAccountById(@PathVariable("accountId") String accountId) {
    //
    //		Account account = new Account();
    //		account.setId(1L);
    //		account.setAccountCode("DemoCode");
    //		account.setAccountName("DemoName");

    Mono<Account> account = accountService.getAccountById(accountId);
    return account;
  }

  @GetMapping(value = "accountname/{accountName}")
  public Mono<Account> getAccountByAccountName(@PathVariable("accountName") String accountName) {

    Mono<Account> account = accountService.getAccountByAccountName(accountName);
    return account;
  }

  @PostMapping(value = "/")
  public Mono<Void> addAccount(@RequestBody Mono<Account> account) {

    return accountService.addAccount(account);
  }

  @PutMapping(value = "/")
  public Mono<Void> updateAccount(@RequestBody Mono<Account> account) {

    return accountService.updateAccount(account);
  }
}

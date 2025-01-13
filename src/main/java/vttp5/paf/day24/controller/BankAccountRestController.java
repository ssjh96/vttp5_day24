package vttp5.paf.day24.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import vttp5.paf.day24.model.BankAccount;
import vttp5.paf.day24.service.BankAccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/bankaccounts")
public class BankAccountRestController 
{
    @Autowired
    private BankAccountService bankAccountService;
    
    @GetMapping("/exists/{account-id}")
    public ResponseEntity<Boolean> checkAccountExists(@PathVariable ("account-id") Integer accountId) 
    {
        Boolean isAccountExists = bankAccountService.checkAccountExists(accountId);

        return ResponseEntity.ok().body(isAccountExists);
    }

    @GetMapping("/{account-id}")
    public ResponseEntity<BankAccount> getById(@PathVariable ("account-id") Integer accountId) 
    {
        BankAccount bankAccount = bankAccountService.getAccountById(accountId);
        
        return ResponseEntity.ok().body(bankAccount);
    }
    
    
}

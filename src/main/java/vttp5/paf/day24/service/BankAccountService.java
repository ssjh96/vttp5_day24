package vttp5.paf.day24.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp5.paf.day24.repository.BankAccountRepo;

@Service
public class BankAccountService 
{
    @Autowired
    private BankAccountRepo bankAccountRepo;

    public Boolean checkAccountExists (int accountId)
    {
        return bankAccountRepo.accountExist(accountId);
    }
    
}

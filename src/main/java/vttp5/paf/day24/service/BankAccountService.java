package vttp5.paf.day24.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp5.paf.day24.model.BankAccount;
import vttp5.paf.day24.model.exception.AccountInactiveException;
import vttp5.paf.day24.model.exception.InsufficientBalanceException;
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

    public BankAccount getAccountById (int accountId)
    {
        return bankAccountRepo.getAccountById(accountId);
    }

    // Withdrawals etc
    public void transfer(int transfererAccId, int transfereeAccId, float transferAmt)
    {
        // retrieve both accs 
        BankAccount accFrom = bankAccountRepo.getAccountById(transfererAccId);
        BankAccount accTo = bankAccountRepo.getAccountById(transfereeAccId);

        // check both accs active or not
        Boolean isAccToActive = checkAccountActive(accTo);
        Boolean isAccFromActive = checkAccountActive(accFrom);

        // check transferer has sufficient bal to transfer to transfer the transfer amt
        Boolean isTransfererBalanceSufficient = checkSufficientBalance(accFrom, transferAmt);

        // logic to decide whether to continue to perform the transaction
        if (isAccFromActive && isAccToActive && isTransfererBalanceSufficient)
        {
            // must be perform in transacation
            //
        }
    }
    
    private Boolean checkAccountActive(BankAccount bankAccount)
    {
        if (bankAccount.getIsActive().equals(true))
        {
            return true;
        }
        throw new AccountInactiveException("Account ID " + bankAccount.getId() + "-" + bankAccount.getFullName() + " is inactive.");
    }

    private Boolean checkSufficientBalance(BankAccount bankAccount, float transferAmt)
    {
        Boolean isSufficientFund = ((bankAccount.getBalance() - transferAmt) > 0) ? true : false;

        if (isSufficientFund)
        {
            return true;
        }

        throw new InsufficientBalanceException("Transferer " + bankAccount.getFullName() + " does not have sufficient fund to make the transfer.");
    }
}

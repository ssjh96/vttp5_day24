package vttp5.paf.day24.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import vttp5.paf.day24.model.BankAccount;
import vttp5.paf.day24.model.exception.AccountNotFoundException;
import vttp5.paf.day24.util.Queries;

@Repository
public class BankAccountRepo 
{
    @Autowired 
    JdbcTemplate template; // connect to db?

    public Boolean accountExist(int accountId)
    {
        try
        {
            // Automatically map to BankAccount model since the return type is generic T?
            // can use the checkexist one also
            BankAccount bankAccount = template.queryForObject(Queries.selectByBankAccoutnIdSQL, BeanPropertyRowMapper.newInstance(BankAccount.class), accountId); // if record is not found > dataaccessexception error

            return true; // account is found
        }

        catch (DataAccessException error)
        {
            throw new AccountNotFoundException("The account you are querying does not exists in the system");
            // dataaccessexception error is a null?
            
        }

       // return false; // how come don't need return
    }

    public BankAccount getAccountById(int accountId)
    {
        try
        {
            // Automatically map to BankAccount model since the return type is generic T?
            // can use the checkexist one also
            BankAccount bankAccount = template.queryForObject(Queries.selectByBankAccoutnIdSQL, BeanPropertyRowMapper.newInstance(BankAccount.class), accountId); // if record is not found > dataaccessexception error

            return bankAccount; // account is found
        }

        catch (DataAccessException error)
        {
            throw new AccountNotFoundException("Account id " + accountId + " not found in the system");
        }
    }

    // updated account is passed into here, i.e. account with updated details
    public Boolean updateAccountByIdBankAccount(BankAccount accountToUpdate)
    {
        int accountUpdated = template.update(Queries.updateBankAccountByIdSQL, accountToUpdate.getBalance(), accountToUpdate.getId());
        // we set balance here, the logic is inside the service to add or what not
        // all comparison logic is inside service layer

        if (accountUpdated > 0)
        {
            return true;
        }
        return false;
    }
}

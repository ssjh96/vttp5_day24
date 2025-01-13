package vttp5.paf.day24.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import vttp5.paf.day24.model.BankAccount;
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
            // dataaccessexception error is a null?
            
        }

        return false;
    }


}

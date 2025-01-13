package vttp5.paf.day24.util;

public class Queries {

    public static final String createAccSQL = "insert into BankAccount(fullName, isActive, balance) values (?, ?, ?)";

    public static final String selectAllBankAccountSQL = "select * from BankAccount";

    public static final String selectByBankAccoutnIdSQL = "select * from BankAccount where id = ?";

    public static final String deleteBankAccountByIdSQL = "update BankAccount set isActive = false where id = ?";

    public static final String updateBankAccountByIdSQL = "update BankAccount set balance = ? where id = ?";

    public static final String checkAccountExistsSQL = "select count(*) as cnt from BankAccount where id = ?"; // this to check exists also can, you get a 0 or 1 when you check

//     -- -- Show all
// -- select * from BankAccount;

// -- select * from BankAccount where id = 1;

// -- -- DeleteMapping
// -- update BankAccount set isActive = false where id = 1;

// -- -- PutMapping
// -- update BankAccount set balance = 1000000.0 where id = 1;
}

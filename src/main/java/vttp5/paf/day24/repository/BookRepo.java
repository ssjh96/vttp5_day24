package vttp5.paf.day24.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.management.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import vttp5.paf.day24.model.Book;
import vttp5.paf.day24.model.exception.BookNotFoundException;
import vttp5.paf.day24.util.Queries;

@Repository
public class BookRepo {
    
    @Autowired
    private JdbcTemplate template;

    public Boolean insertBook(Book book)
    {
        // not preferred
        // template.update(Queries.createBookSQL, book.getTitle(), book.getQuantity());

        // dont understand
        KeyHolder keyHolder = new GeneratedKeyHolder();
        PreparedStatementCreator psc = new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException 
            {
                PreparedStatement ps = con.prepareStatement(Queries.createBookSQL, new String[]{"id"});
                ps.setString(1, book.getTitle());
                ps.setInt(2, book.getQuantity());

                return ps;
                // TODO Auto-generated method stub
                // throw new UnsupportedOperationException("Unimplemented method 'createPreparedStatement'");
            }
        };

        int createdBookId = template.update(psc, keyHolder);

        if(createdBookId > 0)
        {
            return true;
        }
        return false;
    }


    
    public List<Book> getAllBooks() 
    {
        List<Book> books = template.query(Queries.getBooksSQL, BeanPropertyRowMapper.newInstance(Book.class));

        if (books.isEmpty())
        {
            throw new BookNotFoundException("No books in the list found.");
        }

        return books;
    }



    public Book getBookById (int bookId)
    {
        Book book = null;

        // Book book = template.queryForObject(Queries.getBookByIdSQL, BeanPropertyRowMapper.newInstance(Book.class), bookId);

        try
        {
            book = template.queryForObject(Queries.getBookByIdSQL, BeanPropertyRowMapper.newInstance(Book.class), bookId);
        }
        catch (DataAccessException ex)
        {
            throw new BookNotFoundException("Book with " + bookId + "not found.");
        }

        return book;
    }


    // UPDATE books SET title = ?, quantity = ? WHERE id = ?
    public Boolean updateBook(Book book)
    {
        int bUpdated = template.update(Queries.updateBookByIdSQL, book.getTitle(), book.getQuantity(), book.getId());

        if (bUpdated > 0)
            return true;
        return false;
    }


    // UPDATE books SET is_active = ? WHERE id = ?
    public Boolean updateBookStatus (Book book)
    {
        int bUpdated = template.update(Queries.updateBookStatusByIdSQL, book.getIsActive(), book.getId());

        if (bUpdated>0)
        {
            return true;
        }
        return false;
    }
}

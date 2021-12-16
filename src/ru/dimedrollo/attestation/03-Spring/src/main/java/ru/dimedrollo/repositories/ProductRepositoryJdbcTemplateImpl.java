package ru.dimedrollo.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.dimedrollo.models.Product;

import javax.sql.DataSource;
import java.util.List;


@Component
public class UsersRepositoryJdbcTemplateImpl implements ProductRepository {

    //language=SQL
    private static final String SQL_INSERT = "insert into postgres(first_name, last_name, age) values(?, ?, ?)";

    //language=SQL
    private static final String SQL_SELECT_ALL = "select * from account order by id";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UsersRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private static final RowMapper<Product> productRowMapper = (row, rowNumber) -> {
        int id = row.getInt("id");
        String description = row.getString("description");
       int price = row.getInt("price");
        int amount = row.getInt("amount");

        return new Product(id, description, price, amount);
    };

    @Override
    public List<Product> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, productRowMapper);
    }


    @Override
    public void save(Product product) {
        jdbcTemplate.update(SQL_INSERT, product.getDescription(), product.getPrice(), product.getAmount());
    }

}


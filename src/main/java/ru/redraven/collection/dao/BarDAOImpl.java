package ru.redraven.collection.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import ru.redraven.collection.model.Bar;
import ru.redraven.collection.model.Brand;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Дмитрий on 22.02.2015.
 */
public class BarDAOImpl implements BarDAO {

    private JdbcTemplate jdbcTemplate;

    public BarDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean update(Bar bar) {
        String sql = "UPDATE bar SET name=?, date=?, weight=?, "
                + "additional=?, idfactory=?  WHERE idbar=?";
        return jdbcTemplate.update(sql, bar.getName(), bar.getDate(),
                bar.getWeight(), bar.getAdditional(), bar.getBrand().getId(), bar.getId()) != 0;
    }

    @Override
    public boolean create(Bar bar) {
        String sql = "INSERT INTO bar (name, date, weight, additional, idfactory)"
                + " VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, bar.getName(), bar.getDate(),
                bar.getWeight(), bar.getAdditional(), bar.getBrand().getId()) != 0;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM bar WHERE idbar=?";
        return jdbcTemplate.update(sql, id) != 0;
    }

    @Override
    public Bar get(int id) {
        String sql = "SELECT bar.idbar, bar.name, bar.date, bar.weight, bar.additional, factory.idfactory, factory.name FROM bar, factory WHERE bar.idfactory = factory.idfactory AND idbar=" + id;
        return jdbcTemplate.query(sql, new ResultSetExtractor<Bar>() {

            @Override
            public Bar extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    Bar bar = new Bar();
                    bar.setId(rs.getInt("bar.idbar"));
                    bar.setName(rs.getString("bar.name"));
                    bar.setDate(rs.getDate("bar.date"));
                    bar.setWeight(rs.getInt("bar.weight"));
                    bar.setBrand(new Brand(rs.getInt("factory.idfactory"), rs.getString("factory.name")));
                    bar.setAdditional(rs.getString("bar.additional"));
                    return bar;
                }
                return null;
            }
        });
    }

    @Override
    public List<Bar> list() {
        String sql = "SELECT * FROM bar, factory WHERE bar.idfactory = factory.idfactory ORDER BY idbar DESC";
        List<Bar> listContact = jdbcTemplate.query(sql, new RowMapper<Bar>() {

            @Override
            public Bar mapRow(ResultSet rs, int rowNum) throws SQLException {
                Bar bar = new Bar();
                bar.setId(rs.getInt("idbar"));
                bar.setName(rs.getString("name"));
                bar.setDate(rs.getDate("date"));
                bar.setWeight(rs.getInt("weight"));
                bar.setBrand(new Brand(rs.getInt("factory.idfactory"), rs.getString("factory.name")));
                bar.setAdditional(rs.getString("additional"));
                return bar;
            }

        });

        return listContact;
    }
}

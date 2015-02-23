package ru.redraven.collection.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import ru.redraven.collection.model.Bar;

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
    public void saveOrUpdate(Bar bar) {
        if (bar.getIdBar() > 0) {
            // update
            String sql = "UPDATE bar SET name=?, date=?, weight=?, "
                    + "additional=?, idfactory=?  WHERE idbar=?";
            jdbcTemplate.update(sql, bar.getName(), bar.getDate(),
                    bar.getWeight(), bar.getAdditional(), bar.getIdFactory(), bar.getIdBar());
        } else {
            // insert
            String sql = "INSERT INTO bar (name, date, weight, additional, idfactory)"
                    + " VALUES (?, ?, ?, ?, ?, ?)";
            jdbcTemplate.update(sql, bar.getName(), bar.getDate(),
                    bar.getWeight(), bar.getAdditional(), bar.getIdFactory());
        }
    }

    @Override
    public void delete(int idBar) {
        String sql = "DELETE FROM bar WHERE idbar=?";
        jdbcTemplate.update(sql, idBar);
    }

    @Override
    public Bar get(int idBar) {
        String sql = "SELECT * FROM bar WHERE idbar=" + idBar;
        return jdbcTemplate.query(sql, new ResultSetExtractor<Bar>() {

            @Override
            public Bar extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    Bar bar = new Bar();
                    bar.setIdBar(rs.getInt("idbar"));
                    bar.setName(rs.getString("name"));
                    bar.setDate(rs.getDate("date"));
                    bar.setWeight(rs.getInt("weight"));
                    bar.setIdFactory(rs.getInt("idfactory"));
                    bar.setAdditional(rs.getString("additional"));
                    return bar;
                }
                return null;
            }
        });
    }

    @Override
    public List<Bar> list() {
        String sql = "SELECT * FROM bar";
        List<Bar> listContact = jdbcTemplate.query(sql, new RowMapper<Bar>() {

            @Override
            public Bar mapRow(ResultSet rs, int rowNum) throws SQLException {
                Bar bar = new Bar();
                bar.setIdBar(rs.getInt("idbar"));
                bar.setName(rs.getString("name"));
                bar.setDate(rs.getDate("date"));
                bar.setWeight(rs.getInt("weight"));
                bar.setIdFactory(rs.getInt("idfactory"));
                bar.setAdditional(rs.getString("additional"));
                return bar;
            }

        });

        return listContact;
    }
}

package com.itlbv.routineplanner.repository.jdbc;

import com.itlbv.routineplanner.model.Routine;
import com.itlbv.routineplanner.repository.RoutineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class JdbcRoutineRepositoryImpl implements RoutineRepository {

    private static final BeanPropertyRowMapper<Routine> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Routine.class);

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final SimpleJdbcInsert simpleInsert;

    @Autowired
    public JdbcRoutineRepositoryImpl(DataSource dataSource, JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.simpleInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("routines")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public Routine save(Routine routine, int userId) {
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", routine.getId())
                .addValue("user_id", userId)
                .addValue("name", routine.getName());
        if (routine.isNew()) {
            Number newId = simpleInsert.executeAndReturnKey(map);
            routine.setId(newId.intValue());
        } else if (namedParameterJdbcTemplate.update(
                "UPDATE routines SET name=:name WHERE id=:id AND user_id=:user_id", map) == 0) {
            return null;
        }
        return routine;
    }

    @Override
    public boolean delete(int id, int userId) {
        return (jdbcTemplate.update("DELETE FROM routines WHERE id=? AND user_id=?", id, userId)) > 0;
    }

    @Override
    public Routine get(int id, int userId) {
        List<Routine> routines = jdbcTemplate.query("SELECT * FROM routines WHERE id=? AND user_id=?", ROW_MAPPER, id, userId);
        return DataAccessUtils.singleResult(routines);
    }

    @Override
    public List<Routine> getAll(int userId) {
        return jdbcTemplate.query("SELECT * FROM routines WHERE user_id=?", ROW_MAPPER, userId);
    }
}

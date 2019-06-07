package com.itlbv.routineplanner.repository.jdbc;

import com.itlbv.routineplanner.model.Routine;
import com.itlbv.routineplanner.repository.RoutineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
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
    public Routine save(Routine routine) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Routine get(int id) {
        return null;
    }

    @Override
    public List<Routine> getAll() {
        return jdbcTemplate.query("SELECT * FROM routines", ROW_MAPPER);
    }
}

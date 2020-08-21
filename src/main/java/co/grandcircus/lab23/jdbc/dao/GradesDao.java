package co.grandcircus.lab23.jdbc.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.grandcircus.jdbcintro.entity.Grades;

// Repository annotation allows spring to create a RoomsDao and use
// it with @Autowired in our controller
@Repository
public class GradesDao {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	public List<Grades> findAll() {
		String sql = "SELECT * FROM grades";
		// .query returns a List
		// RowMapper converts the SLQ table results to Room objects, matching the field names
		return jdbc.query(sql, new BeanPropertyRowMapper<>(Grades.class));
	}
	
	public Grades findById(Long id) {
		// ? leaves a "blank" called a parameter to fill in later
		String sql = "SELECT * FROM grades WHERE id = ?";
		// .queryForObject returns a single object
		// the value(s) for ? params are specified at the end...
		return jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(Grades.class), id);
	}
	
	public void create(Grades grades) {
		String sql = "INSERT INTO grades (name, type, score, total) VALUES (?, ?, ?, ?)";
		// .update is used for any modification (INSERT, UPDATE, DELETE)
		// the value(s) for ? params are specified at the end...
		jdbc.update(sql, grades.getName(), grades.getType(), grades.getScore(), grades.getTotal());
	}
	
	public void update(Grades grades) {
		String sql = "UPDATE grades SET name = ?, type = ?, score = ?, total = ? WHERE id = ?";
		jdbc.update(sql, grades.getName(), grades.getType(),
				grades.getScore(), grades.getTotal(), grades.getId());
	}
	
	public void delete(Long id) {
		String sql = "DELETE FROM grades WHERE id = ?";
		jdbc.update(sql, id);
	}

}
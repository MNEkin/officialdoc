package ekin.example.officialdoc.service;

import ekin.example.officialdoc.model.User;
import ekin.example.officialdoc.model.UserToSignup;
import ekin.example.officialdoc.utils.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.util.List;


@Service
public class UserService
{
    @Autowired
    private JdbcTemplate jdbc;

    @Transactional(readOnly = true)
    public List<User> findAll()
    {
        return jdbc.query("SELECT * FROM users", new UserRowMapper());
    }

    @Transactional(readOnly = true)
    public User findUserById(int id)
    {
        return jdbc.queryForObject("SELECT * FROM users WHERE userId=?",
                new Object[]{id}, new UserRowMapper());
    }

    public UserToSignup create(final UserToSignup user)
    {
        final String sql = "INSERT INTO users (userEmail, userName, password)" +
                " VALUES (?,?,?)";

        jdbc.update(con ->
        {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getUserEmail());
            ps.setString(2, user.getUserName());
            ps.setString(3, user.getPassword());
            return ps;
        });

        return user;
    }
}

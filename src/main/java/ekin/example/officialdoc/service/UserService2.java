package ekin.example.officialdoc.service;

import ekin.example.officialdoc.model.User;
import ekin.example.officialdoc.utils.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Service
public class UserService2
{
    @Autowired
    private JdbcTemplate jdbc;

    @Transactional(readOnly = true)
    public List<User> findAll()
    {
        return jdbc.query("select * from users", new UserRowMapper());
    }

    @Transactional(readOnly = true)
    public User findUserById(int id)
    {
        return jdbc.queryForObject("select * from users where userId=?",
                                    new Object[]{id}, new UserRowMapper());
    }

    public User create(final User user)
    {
        final String sql ="insert into users (userId, userName, userEmail, address)" +
                            " values (?,?,?,?)";
        KeyHolder holder = new GeneratedKeyHolder();
        jdbc.update(new PreparedStatementCreator()
        {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException
            {
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, user.getUserId());
                ps.setString(2, user.getUserName());
                ps.setString(3, user.getUserEmail());
                ps.setString(4, user.getAddress());
                return ps;
            }
        }, holder);
        int newUserId = 1005;//holder.getKey().intValue();
        user.setUserId(newUserId);
        return user;
    }
}

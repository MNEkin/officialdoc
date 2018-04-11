package ekin.example.officialdoc.utils;

import ekin.example.officialdoc.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements org.springframework.jdbc.core.RowMapper<User>
{
    //Don't know why this class is necessary
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        User user = new User();
        user.setUserId(rs.getInt("userId"));
        user.setUserName(rs.getString("userName"));
        user.setUserEmail(rs.getString("userEmail"));
        user.setAddress(rs.getString("address"));
        return user;
    }


}

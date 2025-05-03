import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseAppender implements LogAppender {
    private final String jdbcUrl;
    private final String username;
    private final String pwd;

    public DatabaseAppender(String jdbcUrl, String username, String pwd) {
        this.jdbcUrl = jdbcUrl;
        this.username = username;
        this.pwd = pwd;
    }

    @Override
    public void append(LogMessage msg) {
        try(Connection conn= DriverManager.getConnection(jdbcUrl,username,pwd)) {
            PreparedStatement statement= conn.prepareStatement("INSERT INTO logs (level, message, timestamp) VALUES (?,?,?)");
            statement.setString(1,msg.getLevel().toString());
            statement.setString(2,msg.getMsg());
            statement.setLong(3,msg.getTime());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

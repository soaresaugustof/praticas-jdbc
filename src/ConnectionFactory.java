import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection recuperarConexao() throws SQLException {
	Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/loja_virtual", "postgres",
		"mEZCdzyvpB");
	return con;
    }
}

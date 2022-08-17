import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

    public DataSource dataSource;

    public ConnectionFactory() {
	ComboPooledDataSource cpds = new ComboPooledDataSource();
	cpds.setJdbcUrl("jdbc:postgresql://localhost:5432/loja_virtual");
	cpds.setUser("postgres");
	cpds.setPassword("mEZCdzyvpB");

	this.dataSource = cpds;
    }

    public Connection recuperarConexao() throws SQLException {
	Connection con = this.dataSource.getConnection();
	return con;
    }
}

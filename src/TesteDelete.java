import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteDelete {
    public static void main(String[] args) throws SQLException {
	ConnectionFactory factory = new ConnectionFactory();
	Connection connection = factory.recuperarConexao();

	Statement stm = connection.createStatement();
	stm.execute("delete from produto where id > 2");

	Integer linhasModificadas = stm.getUpdateCount();

	System.out.println("Quantidade de linhas modificadas: " + linhasModificadas);
    }
}

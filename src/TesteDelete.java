import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TesteDelete {
    public static void main(String[] args) throws SQLException {
	ConnectionFactory factory = new ConnectionFactory();
	Connection connection = factory.recuperarConexao();

	PreparedStatement stm = connection.prepareStatement("delete from produto where id > ?");
	stm.setInt(1, 2);
	stm.execute();

	Integer linhasModificadas = stm.getUpdateCount();

	System.out.println("Quantidade de linhas modificadas: " + linhasModificadas);
	stm.close();
    }
}

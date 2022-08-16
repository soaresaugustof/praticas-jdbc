import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteInsert {
    public static void main(String[] args) throws SQLException {
	ConnectionFactory factory = new ConnectionFactory();
	Connection con = factory.recuperarConexao();

	Statement stm = con.createStatement();
	stm.execute("insert into produto (nome, descricao) values ('TECLADO', 'TECLADO SEM FIO')",
		Statement.RETURN_GENERATED_KEYS);

	ResultSet rst = stm.getGeneratedKeys();
	while (rst.next()) {
	    Integer id = rst.getInt(1);
	    System.out.println("Produto de id " + id + " criado");
	}
    }

}

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteInsercaoComParametros {
    public static void main(String[] args) throws SQLException {
	String nome = "MOUSE'";
	String descricao = "MOUSE SEM FIO";
	ConnectionFactory factory = new ConnectionFactory();
	Connection con = factory.recuperarConexao();

	PreparedStatement stm = con.prepareStatement("insert into produto (nome, descricao) values (?, ?)",
		Statement.RETURN_GENERATED_KEYS);

	stm.setString(1, nome);
	stm.setString(2, descricao);
	stm.execute();

	ResultSet rst = stm.getGeneratedKeys();
	while (rst.next()) {
	    Integer id = rst.getInt(1);
	    System.out.println("Produto de id " + id + " criado");
	}
    }

}

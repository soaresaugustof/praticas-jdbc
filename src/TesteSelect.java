import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteSelect {
    public static void main(String[] args) throws SQLException {
	ConnectionFactory conexao = new ConnectionFactory();
	Connection con = conexao.recuperarConexao();

	Statement stm = con.createStatement();
	stm.execute("select id, nome, descricao from produto");

	ResultSet rst = stm.getResultSet();
	while (rst.next()) {
	    Integer id = rst.getInt("id");
	    System.out.println(id);
	    String nome = rst.getString("nome");
	    System.out.println(nome);
	    String descricao = rst.getString("descricao");
	    System.out.println(descricao);
	}
    }

}

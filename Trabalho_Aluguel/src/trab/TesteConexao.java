package trab;

import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;





public class TesteConexao {
	
	public static void main(String[] args) throws SQLException {
		Connection con = TesteConexao.getConnection();
		teste(con);
		con.close();
	}


public static Connection getConnection() throws SQLException{
	try{
		
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Conectando ao banco");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/locadora",
                "root", "2525");
	}catch (ClassNotFoundException e) {
		System.out.println("Não conectado");
		throw new SQLException(e.getMessage());
	}
}

public static String teste(Connection con) {
	
	try {
		Statement sql = con.createStatement();
		
		String query = "select * from locadora.agencia";


		ResultSet res = sql.executeQuery(query);
		
		while(res.next()) {
		 
		Agencia ag = new Agencia(res.getString("nome"), res.getInt("cod"), res.getString("localidade"));
		
		System.out.println(ag.getCodigo());
		System.out.println(ag.getNome());
		System.out.println(ag.getLocalidade());
	
		}	
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return null;
}

}




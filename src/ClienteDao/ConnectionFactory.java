package ClienteDao;
import java.sql.*;
import java.sql.Connection;

public class ConnectionFactory {
    public static Connection createConnectionToMySQL() throws SQLException {

        private static final String USERNAME = "root";

        private static final String PASSWORD = "12345";

        private static final String DATABASE_URL = "jdbc:mysql://localhost:3306";

        java.sql.Connection connection = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
    return Connection;
    }

        public void main(String[] args) throws Exception{

        java.sql.Connection con = createConnectionToMySQL();

        if (con != null){
            System.out.println("Conexao com sucesso!" +con);
            con.close();
        }
        }


}


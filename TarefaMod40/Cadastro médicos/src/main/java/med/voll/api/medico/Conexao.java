package med.voll.api.medico;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {

    public static void main(String[] args ) throws SQLException {
        Connection conexao = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/OliverMedc_api", "root", "root");
            ResultSet rsCliente = conexao.createStatement().executeQuery("SELEC * FROM CLIENTE");
            while (rsCliente.next()) {
                System.out.println("nome:" + rsCliente.getString("nome"));
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver do banco de dados não localizado.");
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao acessar o banco:" + ex.getMessage());
        } finally {
            if (conexao != null) {
                conexao.close();

            }
        }
    }
}


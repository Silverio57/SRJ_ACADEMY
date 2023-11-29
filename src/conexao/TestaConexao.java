/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

import com.mysql.cj.jdbc.ConnectionImpl;
import java.sql.Connection;
import java.sql.SQLException;
 /**
 *
 * @author Silvério Rodrigues
 */
public class TestaConexao {
    public static void main(String[] args) throws SQLException {
        Connection conexao = new Conexao().getConnection();
        System.out.println("Conexão bem sucedida!");
        conexao.close();
    }
}

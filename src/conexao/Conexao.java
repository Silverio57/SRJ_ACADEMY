/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Silvério Rodrigues
 */
public class Conexao {

    public Connection getConnection() {
        try {
			return DriverManager.getConnection("jdbc:mysql://localhost/academiagod", "root", "");
		 }         
		 catch(SQLException excecao) {
			throw new RuntimeException(excecao);
		 }
    }
}

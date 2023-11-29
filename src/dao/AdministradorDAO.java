/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Administrador;
import java.sql.ResultSet;

public class AdministradorDAO {

    private Connection connection;

    public AdministradorDAO() {
        this.connection = new Conexao().getConnection();
    }

    public ResultSet autenticaUsuario(Administrador administrador) {
        try {
            String sql = "select * from adm where usuario = ? and senha = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, administrador.getUsuario());
            stmt.setString(2, administrador.getSenha());

            ResultSet rs = stmt.executeQuery();
            return rs;

        } catch (SQLException e) {
            System.out.println("sasaks");
            return null;
        }

    }

    public void cadastrarAdministrador(Administrador administrador) {
        String sql = "INSERT INTO adm(usuario, senha) VALUES(?,?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, administrador.getUsuario());
            stmt.setString(2, administrador.getSenha());

            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
}

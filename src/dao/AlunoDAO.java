/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Aluno;

/**
 *
 * @author Silvério Rodrigues
 */
public class AlunoDAO {

    private Connection connection;

    public AlunoDAO() {
        this.connection = new Conexao().getConnection();
    }

    public void cadastrarAluno(Aluno aluno) {
        String sql = "INSERT INTO aluno (nome, cpf, idade, plano, rua, numero, bairro, cidade, uf, celular, telefone, email) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            /*futura correção: todas as informações do sistema podem ser do
            *tipo string, desde que as variáveis NÃO sejam usadas para calculo
             */
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCPF());
            stmt.setInt(3, aluno.getIdade());
            stmt.setInt(4, aluno.getPlano());
            stmt.setString(5, aluno.getRua());
            stmt.setString(6, aluno.getNumero());
            stmt.setString(7, aluno.getBairro());
            stmt.setString(8, aluno.getCidade());
            stmt.setString(9, aluno.getUF());
            stmt.setString(10, aluno.getCelular());
            stmt.setString(11, aluno.getTelefone());
            stmt.setString(12, aluno.getEmail());

            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
}

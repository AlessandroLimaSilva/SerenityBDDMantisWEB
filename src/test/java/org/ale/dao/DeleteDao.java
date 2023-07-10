package org.ale.dao;

import net.serenitybdd.core.Serenity;
import org.ale.pages.LoginPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class DeleteDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginPage.class);

    public void deleteCategoryPerName(String nameProject) throws Exception{
        LOGGER.info(ConnectionFactory.CONNECTION_BUG_TRACKER);
        try{
            ConnectionFactory connectionFactory = new ConnectionFactory(ConnectionFactory.CONNECTION_BUG_TRACKER);
            String teste = "DELETE FROM mantis_category_table WHERE name = '"+nameProject+"';";
            LOGGER.info(teste);
            PreparedStatement pst = connectionFactory.getConnection().prepareStatement(teste, Statement.RETURN_GENERATED_KEYS);
            pst.executeUpdate();
            connectionFactory.transactionConfirm();
            pst.close();
            connectionFactory.closeConnection();
        } catch (SQLException ex) {
            throw new SQLException("Falha ocorrida deleteProjectPerName: "+ex.getMessage());
        }
    }

    public void deleteProjectPerName(String nameProject) throws Exception{
        LOGGER.info(ConnectionFactory.CONNECTION_BUG_TRACKER);
        try{
            ConnectionFactory connectionFactory = new ConnectionFactory(ConnectionFactory.CONNECTION_BUG_TRACKER);
            String teste = "DELETE FROM mantis_project_table where name = '"+nameProject+"';";
            LOGGER.info(teste);
            PreparedStatement pst = connectionFactory.getConnection().prepareStatement(teste, Statement.RETURN_GENERATED_KEYS);
            pst.executeUpdate();
            connectionFactory.transactionConfirm();
            pst.close();
            connectionFactory.closeConnection();
        } catch (SQLException ex) {
            throw new SQLException("Falha ocorrida deleteProjectPerName: "+ex.getMessage());
        }
    }

    public void deleteUserPerName(String nameUser) throws Exception{
        LOGGER.info(ConnectionFactory.CONNECTION_BUG_TRACKER);
        try{
            ConnectionFactory connectionFactory = new ConnectionFactory(ConnectionFactory.CONNECTION_BUG_TRACKER);
            String teste = "DELETE FROM mantis_user_table WHERE username = '"+nameUser+"';";
            LOGGER.info(teste);
            PreparedStatement pst = connectionFactory.getConnection().prepareStatement(teste, Statement.RETURN_GENERATED_KEYS);
            pst.executeUpdate();
            connectionFactory.transactionConfirm();
            pst.close();
            connectionFactory.closeConnection();
        } catch (SQLException ex) {
            throw new SQLException("Falha ocorrida deleteUserPerName: "+ex.getMessage());
        }
    }

    public void deleteSubProjectPerName(String idSubPorject,String idProject) throws Exception{
        try{
            ConnectionFactory connectionFactory = new ConnectionFactory(ConnectionFactory.CONNECTION_BUG_TRACKER);
            String teste = "DELETE from mantis_project_hierarchy_table where child_id = '"+idSubPorject+"' AND parent_id = '"+idProject+"';";
            LOGGER.info(teste);
            PreparedStatement pst = connectionFactory.getConnection().prepareStatement(teste, Statement.RETURN_GENERATED_KEYS);
            pst.executeUpdate();
            connectionFactory.transactionConfirm();
            pst.close();
            connectionFactory.closeConnection();
        } catch (SQLException ex) {
            throw new SQLException("Falha ocorrida deleteProjectPerName: "+ex.getMessage());
        }
    }

    public void deleteProjectPerID() throws Exception{
        LOGGER.info(ConnectionFactory.CONNECTION_BUG_TRACKER);
        try{
            int id = Serenity.sessionVariableCalled("ID_PROJETO");
            ConnectionFactory connectionFactory = new ConnectionFactory(ConnectionFactory.CONNECTION_BUG_TRACKER);
            String teste = "DELETE FROM mantis_project_table where id = ?;";
            LOGGER.info(teste);
            PreparedStatement pst = connectionFactory.getConnection().prepareStatement(teste, Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, id);
            pst.executeUpdate();
            connectionFactory.transactionConfirm();
            pst.close();
            connectionFactory.closeConnection();
        } catch (SQLException ex) {
            throw new SQLException("Falha ocorrida deleteProjectPerName: "+ex.getMessage());
        }
    }

    public void deleteIssuePerID() throws Exception{
        LOGGER.info(ConnectionFactory.CONNECTION_BUG_TRACKER);
        try{
            int id = Serenity.sessionVariableCalled("ID_PROJETO");
            ConnectionFactory connectionFactory = new ConnectionFactory(ConnectionFactory.CONNECTION_BUG_TRACKER);
            String oneUser = "DELETE FROM bugtracker.mantis_bug_table WHERE project_id = ?;";
            LOGGER.info(oneUser);
            PreparedStatement pst = connectionFactory.getConnection().prepareStatement(oneUser, Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, id);
            pst.executeUpdate();
            connectionFactory.transactionConfirm();
            pst.close();
            connectionFactory.closeConnection();
        } catch (SQLException ex) {
            throw new SQLException("Falha ocorrida deleteProjectPerName: "+ex.getMessage());
        }
    }

    public void deleteOneBugTextTablePerID(int id) throws Exception{
        LOGGER.info(ConnectionFactory.CONNECTION_BUG_TRACKER);
        try{
            ConnectionFactory connectionFactory = new ConnectionFactory(ConnectionFactory.CONNECTION_BUG_TRACKER);
            String oneUser = "DELETE FROM bugtracker.mantis_bug_text_table WHERE id = ?;";
            LOGGER.info(oneUser);
            PreparedStatement pst = connectionFactory.getConnection().prepareStatement(oneUser, Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, id);
            pst.executeUpdate();
            connectionFactory.transactionConfirm();
            pst.close();
            connectionFactory.closeConnection();
        } catch (SQLException ex) {
            throw new SQLException("Falha ocorrida deleteProjectPerName: "+ex.getMessage());
        }
    }

    public void deleteTarefaMantisTablePerID(int id) throws Exception{
        LOGGER.info(ConnectionFactory.CONNECTION_BUG_TRACKER);
        try{
            ConnectionFactory connectionFactory = new ConnectionFactory(ConnectionFactory.CONNECTION_BUG_TRACKER);
            String oneUser = "DELETE FROM bugtracker.mantis_bug_table WHERE id = ?";
            LOGGER.info(oneUser);
            PreparedStatement pst = connectionFactory.getConnection().prepareStatement(oneUser, Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, id);
            int rowsAffected;
            do {
                rowsAffected = pst.executeUpdate();
            } while (rowsAffected > 0);
            //pst.executeUpdate();
            connectionFactory.transactionConfirm();
            pst.close();
            connectionFactory.closeConnection();
        } catch (SQLException ex) {
            throw new SQLException("Falha ocorrida deleteProjectPerName: "+ex.getMessage());
        }
    }

    public void deleteTagMantisTablePerID(int id) throws Exception{
        LOGGER.info(ConnectionFactory.CONNECTION_BUG_TRACKER);
        try{
            ConnectionFactory connectionFactory = new ConnectionFactory(ConnectionFactory.CONNECTION_BUG_TRACKER);
            String oneUser = "DELETE FROM bugtracker.mantis_tag_table WHERE id = ?;";
            LOGGER.info(oneUser);
            PreparedStatement pst = connectionFactory.getConnection().prepareStatement(oneUser, Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, id);
            pst.executeUpdate();
            connectionFactory.transactionConfirm();
            pst.close();
            connectionFactory.closeConnection();
        } catch (SQLException ex) {
            throw new SQLException("Falha ocorrida deleteProjectPerName: "+ex.getMessage());
        }
    }

}

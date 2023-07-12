package org.ale.dao;

import net.serenitybdd.core.Serenity;
import org.ale.types.BugTextTable;
import org.ale.types.Tarefa;
import org.ale.utils.GlobalParameters;
import org.ale.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

public class InsertDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(InsertDAO.class);

    private String massaTeste = "src/test/resources/query/MassaDeTeste.sql";


    public InsertDAO() throws FileNotFoundException {}

    public void setDataInsert(String sql,String enderecoBanco) throws Exception {
        try{
            LOGGER.info(sql);
            ConnectionFactory connectionFactory = new ConnectionFactory(enderecoBanco);
            PreparedStatement pst = connectionFactory.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.executeUpdate();
            connectionFactory.transactionConfirm();
            LOGGER.info(String.valueOf(pst.getGeneratedKeys()));
            pst.close();
            connectionFactory.closeConnection();
        } catch (SQLException ex) {
            throw new SQLException("Falha ocorrida setDataInsert: "+sql+"\n"+ex.getMessage());
        }
    }

    public void setInsertOneUser(Map<String,Object> map) throws Exception {
        try{
            ConnectionFactory connectionFactory = new ConnectionFactory();
            String oneUser = "INSERT INTO mantis_user_table(username,realname,email,enabled,protected,access_level,cookie_string) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement pst = connectionFactory.getConnection().prepareStatement(oneUser, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, map.get("username").toString());
            pst.setString(2,map.get("realname").toString());
            pst.setString(3, map.get("email").toString());
            pst.setString(4, map.get("enabled").toString());
            pst.setString(5, map.get("protected").toString());
            pst.setString(6, map.get("acesseLevel").toString());
            pst.setString(7, map.get("cookieString").toString());
            pst.executeUpdate();
            connectionFactory.transactionConfirm();
            LOGGER.info(String.valueOf(pst.getGeneratedKeys()));
            pst.close();
            connectionFactory.closeConnection();
        } catch (SQLException ex) {
            throw new SQLException("Falha ocorrida setDataInsertOneUser: "+ex.getMessage());
        }
    }

    public void setInsertOneNewUser(Map<String,Object> map) throws Exception {
        try{
            ConnectionFactory connectionFactory = new ConnectionFactory();
            String oneUser = "INSERT INTO mantis_user_table(username,realname,email,enabled,protected,access_level,cookie_string,date_created) VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement pst = connectionFactory.getConnection().prepareStatement(oneUser, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, map.get("username").toString());
            pst.setString(2,map.get("realname").toString());
            pst.setString(3, map.get("email").toString());
            pst.setString(4, map.get("enabled").toString());
            pst.setString(5, map.get("protected").toString());
            pst.setString(6, map.get("acesseLevel").toString());
            pst.setString(7, map.get("cookieString").toString());
            pst.setString(8, Utils.timeStamp());
            pst.executeUpdate();
            connectionFactory.transactionConfirm();
            LOGGER.info(String.valueOf(pst.getGeneratedKeys()));
            pst.close();
            connectionFactory.closeConnection();
        } catch (SQLException ex) {
            throw new SQLException("Falha ocorrida setDataInsertOneUser: "+ex.getMessage());
        }
    }

    public void setInsertNewOneUserDisabled(Map<String,Object> map) throws Exception {
        try{
            ConnectionFactory connectionFactory = new ConnectionFactory();
            String oneUser = "INSERT INTO mantis_user_table(username,realname,email,enabled,protected,access_level,cookie_string) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement pst = connectionFactory.getConnection().prepareStatement(oneUser, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, map.get("username").toString());
            pst.setString(2,map.get("realname").toString());
            pst.setString(3, map.get("email").toString());
            pst.setString(4, "0");
            pst.setString(5, map.get("protected").toString());
            pst.setString(6, map.get("acesseLevel").toString());
            pst.setString(7, map.get("cookieString").toString());
            pst.executeUpdate();
            connectionFactory.transactionConfirm();
            LOGGER.info(String.valueOf(pst.getGeneratedKeys()));
            pst.close();
            connectionFactory.closeConnection();
        } catch (SQLException ex) {
            throw new SQLException("Falha ocorrida setDataInsertOneUser: "+ex.getMessage());
        }
    }

    public void setInsertOneProjeto(Map<String,Object> map) throws Exception {
        try{
            ConnectionFactory connectionFactory = new ConnectionFactory();
            String sql =
                    "INSERT INTO mantis_project_table (name,status,enabled,view_state,access_min,description,category_id,inherit_global) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement pst = connectionFactory.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            LOGGER.info("MAP = "+map.get("name").toString());
            pst.setString(1, map.get("name").toString());
            pst.setInt(2, (Integer) map.get("status"));
            pst.setInt(3, (Integer) map.get("enabled"));
            pst.setInt(4, (Integer) map.get("viewState"));
            pst.setInt(5, (Integer) map.get("accessMin"));
            pst.setString(6, map.get("description").toString());
            pst.setInt(7, (Integer) map.get("categoryID"));
            pst.setInt(8, (Integer) map.get("inheritGlobal"));
            pst.executeUpdate();
            ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()) {
                Serenity.setSessionVariable("ID_PROJETO").to(rs.getInt(1));
            }

            connectionFactory.transactionConfirm();
            LOGGER.info(String.valueOf(pst.getGeneratedKeys()));
            pst.close();
            connectionFactory.closeConnection();
        } catch (SQLException ex) {
            throw new SQLException("Falha ocorrida setInsertOneProjeto: "+ex.getMessage());
        }
    }

    public int setInsertOneProjetoAndReturnPK(Map<String,Object> map) throws Exception {
        int id = 0;
        try{
            ConnectionFactory connectionFactory = new ConnectionFactory();
            String sql =
                    "INSERT INTO mantis_project_table (name,status,enabled,view_state,access_min,description,category_id,inherit_global) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement pst = connectionFactory.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            LOGGER.info("INSERT INTO mantis_project_table MAP = "+map.get("name").toString());
            pst.setString(1, map.get("name").toString());
            pst.setInt(2, (Integer) map.get("status"));
            pst.setInt(3, (Integer) map.get("enabled"));
            pst.setInt(4, (Integer) map.get("viewState"));
            pst.setInt(5, (Integer) map.get("accessMin"));
            pst.setString(6, map.get("description").toString());
            pst.setInt(7, (Integer) map.get("categoryID"));
            pst.setInt(8, (Integer) map.get("inheritGlobal"));
            pst.executeUpdate();
            ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }

            connectionFactory.transactionConfirm();
            LOGGER.info(String.valueOf(pst.getGeneratedKeys()));
            pst.close();
            connectionFactory.closeConnection();
        } catch (SQLException ex) {
            throw new SQLException("Falha ocorrida setInsertOneProjeto: "+ex.getMessage());
        }
        return id;
    }

    public void insertNovaCategoriaGlobalPorNome(String name) throws Exception {
        try{
            ConnectionFactory connectionFactory = new ConnectionFactory();
            String sql = "INSERT INTO mantis_category_table (name) VALUES (?)";
            PreparedStatement pst = connectionFactory.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            LOGGER.info("MAP = "+sql+" name = "+name);
            pst.setString(1, name);
            pst.executeUpdate();
            connectionFactory.transactionConfirm();
            LOGGER.info(String.valueOf(pst.getGeneratedKeys()));
            pst.close();
            connectionFactory.closeConnection();
        } catch (SQLException ex) {
            throw new SQLException("Falha ocorrida insertNovaCategoriaGlobalPorNome: "+ex.getMessage());
        }
    }

    public void insertNovoSubprojeto(String idProjeto,String idSubprojeto) throws Exception {
        try{
            ConnectionFactory connectionFactory = new ConnectionFactory();
            String sql = "INSERT INTO mantis_project_hierarchy_table(child_id, parent_id, inherit_parent) VALUES (?,?,?)";
            PreparedStatement pst = connectionFactory.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, idSubprojeto);
            pst.setString(2, idProjeto);
            pst.setString(3, "1");
            pst.executeUpdate();
            connectionFactory.transactionConfirm();
            pst.close();
            connectionFactory.closeConnection();
        } catch (SQLException ex) {
            throw new SQLException("Falha ocorrida insertNovoSubprojeto: "+ex.getMessage());
        }
    }

    public int setInsertOneBugTextTable(BugTextTable bugTextTable){
        int id = 0;
        try{
            ConnectionFactory connectionFactory = new ConnectionFactory();
            String sql = "INSERT INTO bugtracker.mantis_bug_text_table (description,steps_to_reproduce,additional_information) VALUES (?,?,?);";
            PreparedStatement pst = connectionFactory.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, bugTextTable.getDescription());
            pst.setString(2, bugTextTable.getStepsToReproduce());
            pst.setString(3, bugTextTable.getAdditionalInformation());
            pst.executeUpdate();
            ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }
            connectionFactory.transactionConfirm();
            pst.close();
            connectionFactory.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return id;
    }

    public int setTarefaMantisTableAndReturnPk(Tarefa tarefa, int bugTextID, int projectID) throws Exception {
        int id = 0;

        int data = Utils.getDataEpochTime();
        try{
            ConnectionFactory connectionFactory = new ConnectionFactory();
            String sql = "INSERT INTO bugtracker.mantis_bug_table (project_id,reporter_id, handler_id, duplicate_id, priority, severity, reproducibility, status, resolution, projection, eta, profile_id, view_state, summary, sponsorship_total, sticky, category_id, date_submitted, due_date, last_updated, bug_text_id) " +
                    "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = connectionFactory.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, projectID);//Project id
            pst.setInt(2, tarefa.getReporterID());//Reporter id
            pst.setInt(3, tarefa.getHandlerID());//handler id
            pst.setInt(4, tarefa.getDuplicateID());//duplicate id
            pst.setInt(5, tarefa.getPriority());//priority
            pst.setInt(6, tarefa.getSeverity());//severity
            pst.setInt(7, tarefa.getReproducibility());//Reproducibility
            pst.setInt(8, tarefa.getStatus());//Status
            pst.setInt(9, tarefa.getResolution());//Resolution
            pst.setInt(10, tarefa.getProjection());//Projection
            pst.setInt(11, tarefa.getEta());//eta
            pst.setInt(12, tarefa.getProfileID());//ProfileID
            pst.setInt(13, tarefa.getViewState());//ViewState
            pst.setString(14, tarefa.getSummary());//Data
            pst.setInt(15, tarefa.getSpondorshipTotal());//SpondorshipTotal
            pst.setInt(16, tarefa.getSticky());//SpondorshipTotal
            pst.setInt(17, tarefa.getCategoryID());//CategoryID
            pst.setInt(18, data);//DateSubmitted
            pst.setInt(19, tarefa.getDueDate());//DueDate
            pst.setInt(20, data);//DueDate
            pst.setInt(21, bugTextID);//Bug text id
            pst.executeUpdate();
            ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }
            connectionFactory.transactionConfirm();
            LOGGER.info(String.valueOf(pst.getGeneratedKeys()));
            pst.close();
            connectionFactory.closeConnection();
        } catch (SQLException ex) {
            throw new SQLException("Falha ocorrida setTarefaMantisTableAndReturnPk: "+ex.getMessage());
        }
        return id;
    }

    public int setInsertTagTable(){
        int id = 0;
        try{
            ConnectionFactory connectionFactory = new ConnectionFactory();
            String sql = "INSERT INTO bugtracker.mantis_tag_table (user_id,name,description,date_created,date_updated) VALUES (?,?,?,?,?);";
            PreparedStatement pst = connectionFactory.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, 1);
            pst.setString(2, "mantisbt");
            pst.setString(3, "teste");
            pst.setInt(4, Utils.getDataEpochTime());
            pst.setInt(5, Utils.getDataEpochTime());
            pst.executeUpdate();
            ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }
            connectionFactory.transactionConfirm();
            pst.close();
            connectionFactory.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return id;
    }

    public void popularBancoDeDadoTesteAPI(){

        try{
            ArrayList<String> sqlList = Utils.lerSQL(new File(massaTeste));
            for(String sql: sqlList){
                LOGGER.info("This loop = "+sql);
                InsertDAO insertDAO = new InsertDAO();
                insertDAO.setDataInsert(sql, GlobalParameters.DB_URL);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}

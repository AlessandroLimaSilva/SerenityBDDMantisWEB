package org.ale.dao;

import org.ale.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SelectDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(SelectDAO.class);

    public Map<String, Object> getProjectForName(String nome) throws Exception {
        String sql = "SELECT * FROM projeto WHERE NAME ='$nome';".replace("$nome",nome);
        Map<String,Object> map = new HashMap<>();
        ConnectionFactory connection = new ConnectionFactory(ConnectionFactory.CONNECTION_DADOS_DE_TESTE);
        Statement stmt = null;

        try {

            stmt = connection.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if(!rs.isBeforeFirst()){
                return null;
            }

            else{

                if (rs.next()) {
                    int i = 1;
                    map.put("name",rs.getString(i++));
                    map.put("status",rs.getInt(i++));
                    map.put("enabled",rs.getInt(i++));
                    map.put("viewState",rs.getInt(i++));
                    map.put("accessMin",rs.getInt(i++));
                    map.put("description",rs.getString(i++));
                    map.put("categoryID",rs.getInt(i));
                    map.put("inheritGlobal",rs.getInt(i));
                }
            }
            LOGGER.info(" = "+map.get("name").toString());
            rs.close();
            stmt.close();
            connection.closeConnection();

        } catch (SQLException errorsql) {
            throw new Exception("Falha ocorrida Connection Factory: "+errorsql.getMessage());
        } finally{
            try {
                connection.closeConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    public String getIDProject(String nome) throws Exception{
        String sql = "select id from mantis_project_table where name ='$nome';".replace("$nome",nome);
        String resposta=null;
        ConnectionFactory connection = new ConnectionFactory(ConnectionFactory.CONNECTION_BUG_TRACKER);
        Statement stmt = null;

        try {

            stmt = connection.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if(!rs.isBeforeFirst()){
                return null;
            }

            else{

                if (rs.next()) {
                    resposta = rs.getString(1);
                }
            }
            rs.close();
            stmt.close();
            connection.closeConnection();

        } catch (SQLException errorsql) {
            throw new Exception("Falha ocorrida Connection Factory: "+errorsql.getMessage());
        } finally{
            try {
                connection.closeConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resposta;
    }

    public String getLinkEmail(String email) throws Exception{
        String sql = "SELECT body FROM bugtracker.mantis_email_table WHERE email = '$email' ORDER BY submitted DESC LIMIT 1".replace("$email",email);
        String resposta=null;
        ConnectionFactory connection = new ConnectionFactory(ConnectionFactory.CONNECTION_BUG_TRACKER);
        Statement stmt = null;

        try {

            stmt = connection.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if(!rs.isBeforeFirst()){
                return null;
            }

            else{

                if (rs.next()) {
                    resposta = rs.getString(1);
                }
            }
            rs.close();
            stmt.close();
            connection.closeConnection();

        } catch (SQLException errorsql) {
            throw new Exception("Falha ocorrida Connection Factory: "+errorsql.getMessage());
        } finally{
            try {
                connection.closeConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Utils.limpaUrlEmail(resposta);
    }



    public Map<String, Object> getUserForName(String username) throws Exception {
        String sql = "SELECT * FROM usuario WHERE USERNAME ='$username';".replace("$username",username);
        Map<String,Object> map = new HashMap<>();
        ConnectionFactory connection = new ConnectionFactory(ConnectionFactory.CONNECTION_DADOS_DE_TESTE);
        Statement stmt = null;

        try {

            stmt = connection.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if(!rs.isBeforeFirst()){
                return null;
            }

            else{

                if (rs.next()) {
                    int i = 1;
                    map.put("username",rs.getString(i++));
                    map.put("realname",rs.getString(i++));
                    map.put("email",rs.getString(i++));
                    map.put("enabled",rs.getInt(i++));
                    map.put("protected",rs.getInt(i++));
                    map.put("acesseLevel",rs.getInt(i++));
                    map.put("cookieString",rs.getString(i++));
                    map.put("tipoUsuario",rs.getString(i));
                }
            }
            rs.close();
            stmt.close();
            connection.closeConnection();

        } catch (SQLException errorsql) {
            throw new Exception("Falha ocorrida Connection Factory: "+errorsql.getMessage());
        } finally{
            try {
                connection.closeConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    public Map<String, Object> getUserForType(String tipoUsuario) throws Exception {
        String sql = "SELECT * FROM usuario WHERE TIPO_USUARIO ='$tipoUsuario';".replace("$tipoUsuario",tipoUsuario);
        Map<String,Object> map = new HashMap<>();
        ConnectionFactory connection = new ConnectionFactory(ConnectionFactory.CONNECTION_DADOS_DE_TESTE);
        Statement stmt = null;

        try {

            stmt = connection.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if(!rs.isBeforeFirst()){
                return null;
            }

            else{

                if (rs.next()) {
                    int i = 1;
                    map.put("username",rs.getString(i++));
                    map.put("realname",rs.getString(i++));
                    map.put("email",rs.getString(i++));
                    map.put("enabled",rs.getInt(i++));
                    map.put("protected",rs.getInt(i++));
                    map.put("acesseLevel",rs.getInt(i++));
                    map.put("cookieString",rs.getString(i++));
                    map.put("tipoUsuario",rs.getString(i));
                }
            }
            rs.close();
            stmt.close();
            connection.closeConnection();

        } catch (SQLException errorsql) {
            throw new Exception("Falha ocorrida Connection Factory: "+errorsql.getMessage());
        } finally{
            try {
                connection.closeConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    public Map<String, Object> getUserForEmail(String email) throws Exception {
        String sql = "SELECT * FROM usuario WHERE email ='$email';".replace("$email",email);
        Map<String,Object> map = new HashMap<>();
        ConnectionFactory connection = new ConnectionFactory(ConnectionFactory.CONNECTION_DADOS_DE_TESTE);
        Statement stmt = null;

        try {

            stmt = connection.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if(!rs.isBeforeFirst()){
                return null;
            }

            else{

                if (rs.next()) {
                    int i = 1;
                    map.put("username",rs.getString(i++));
                    map.put("realname",rs.getString(i++));
                    map.put("email",rs.getString(i++));
                    map.put("enabled",rs.getInt(i++));
                    map.put("protected",rs.getInt(i++));
                    map.put("acesseLevel",rs.getInt(i++));
                    map.put("cookieString",rs.getString(i++));
                    map.put("tipoUsuario",rs.getString(i));
                }
            }
            rs.close();
            stmt.close();
            connection.closeConnection();

        } catch (SQLException errorsql) {
            throw new Exception("Falha ocorrida Connection Factory: "+errorsql.getMessage());
        } finally{
            try {
                connection.closeConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    public Map<String, Object> getBugTextDadosDeTesteTable() throws Exception {
        String sql = "SELECT * FROM dadosdeteste.bug_text WHERE id ='1';";
        Map<String,Object> map = new HashMap<>();
        ConnectionFactory connection = new ConnectionFactory(ConnectionFactory.CONNECTION_DADOS_DE_TESTE);
        Statement stmt = null;

        try {

            stmt = connection.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if(!rs.isBeforeFirst()){
                return null;
            }

            else{

                if (rs.next()) {
                    int i = 1;
                    map.put("description",rs.getString(i++));
                    map.put("stepsToReproduce",rs.getString(i++));
                    map.put("additionalInformation",rs.getString(i++));
                }
            }
            rs.close();
            stmt.close();
            connection.closeConnection();

        } catch (SQLException errorsql) {
            throw new Exception("Falha ocorrida getBugTextDadosDeTesteTable: "+errorsql.getMessage());
        } finally{
            try {
                connection.closeConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    public Map<String, Object> getTarefaDadosDeTesteTable() throws Exception {
        String sql = "SELECT * FROM dadosdeteste.tarefa WHERE id ='1';";
        Map<String,Object> map = new HashMap<>();
        ConnectionFactory connection = new ConnectionFactory(ConnectionFactory.CONNECTION_DADOS_DE_TESTE);
        Statement stmt = null;
        try {
            stmt = connection.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(!rs.isBeforeFirst()){
                return null;
            } else{
                if (rs.next()) {
                    int i = 2;
                    map.put("projectID",rs.getInt(i++));
                    map.put("reporterID",rs.getInt(i++));
                    map.put("handlerID",rs.getInt(i++));
                    map.put("duplicateID",rs.getInt(i++));
                    map.put("priority",rs.getInt(i++));
                    map.put("severity",rs.getInt(i++));
                    map.put("reproducibility",rs.getInt(i++));
                    map.put("status",rs.getInt(i++));
                    map.put("resolution",rs.getInt(i++));
                    map.put("projection",rs.getInt(i++));
                    map.put("eta",rs.getInt(i++));
                    map.put("profileID",rs.getInt(i++));
                    map.put("viewState",rs.getInt(i++));
                    map.put("summary",rs.getString(i++));
                    map.put("spondorshipTotal",rs.getInt(i++));
                    map.put("sticky",rs.getInt(i++));
                    map.put("categoryID",rs.getInt(i++));
                    map.put("dateSubmitted",rs.getInt(i++));
                    map.put("dueDate",rs.getInt(i++));
                    map.put("lastUpdate",rs.getInt(i++));

                }
            }
            rs.close();
            stmt.close();
            connection.closeConnection();

        } catch (SQLException errorsql) {
            throw new Exception("Falha ocorrida getTarefaDadosDeTesteTable: "+errorsql.getMessage());
        } finally{
            try {
                connection.closeConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    public ArrayList<String> getQueryResult(String query) throws Exception {
        ArrayList<String> arrayList = null;
        ConnectionFactory connection = new ConnectionFactory();
        Statement stmt = null;

        try {

            stmt = connection.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if(!rs.isBeforeFirst()){
                return null;
            }

            else{
                int numberOfColumns;
                ResultSetMetaData metadata=null;

                arrayList = new ArrayList<String>();
                metadata = rs.getMetaData();
                numberOfColumns = metadata.getColumnCount();

                while (rs.next()) {
                    int i = 1;
                    while(i <= numberOfColumns) {
                        arrayList.add(rs.getString(i++));
                    }
                }
            }

            rs.close();
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                connection.closeConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }


}

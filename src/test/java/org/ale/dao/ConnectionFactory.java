package org.ale.dao;

import org.ale.utils.GlobalParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConnectionFactory.class);
    private static Connection CONNECTION;
    protected static final String CONNECTION_BUG_TRACKER = GlobalParameters.DB_URL_MANTISBT;
    protected static final String CONNECTION_DADOS_DE_TESTE = GlobalParameters.DB_URL_TESTE;
    private String usuarioBanco = GlobalParameters.DB_USER;
    private String senhaBanco = GlobalParameters.DB_PASSWORD;


    //protected static final String CONNECTION_BUG_TRACKER = "jdbc:mysql://localhost/bugtracker";
    //protected static final String CONNECTION_DADOS_DE_TESTE = "jdbc:mysql://localhost/dadosdeteste";

    public ConnectionFactory() throws Exception{
        try {
            if (CONNECTION != null && !CONNECTION.isClosed()){
                LOGGER.info("Conexão esta aberta e sera fechada?");
                LOGGER.info("Conexão foi fechada Porque estava aberta ?\n"+CONNECTION.isClosed());
                return;
            }
            Class.forName("com.mysql.cj.jdbc.Driver");
            CONNECTION = DriverManager.getConnection(CONNECTION_BUG_TRACKER,usuarioBanco,senhaBanco);
            CONNECTION.setAutoCommit(false);
            CONNECTION.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            LOGGER.info("Connection is Open");

        }
        catch (ClassNotFoundException cnf){
            throw new Exception("Driver não encontrado !");
        }
        catch (SQLException sql){
            throw new Exception("Falha ocorrida Connection Factory: "+sql.getMessage());
        }
    }

    public ConnectionFactory(String enderecoBanco, String nomeUsuario, String senha) {
        try {
            if (CONNECTION != null && !CONNECTION.isClosed()) return;
            Class.forName("com.mysql.cj.jdbc.Driver");
            CONNECTION = DriverManager.getConnection(enderecoBanco,usuarioBanco, senhaBanco);
            CONNECTION.setAutoCommit(false);
            CONNECTION.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        /*try {
            if (CONNECTION != null && !CONNECTION.isClosed()){
                CONNECTION.close();
                Class.forName("com.mysql.cj.jdbc.Driver");
                CONNECTION = DriverManager.getConnection(enderecoBanco,nomeUsuario, senha);
                CONNECTION.setAutoCommit(false);
                CONNECTION.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
                LOGGER.info("Connection is Open");
            }else {
                Class.forName("com.mysql.cj.jdbc.Driver");
                CONNECTION = DriverManager.getConnection(enderecoBanco,nomeUsuario, senha);
                CONNECTION.setAutoCommit(false);
                CONNECTION.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
                LOGGER.info("Connection is Open");
            }

        }
        catch (ClassNotFoundException cnf){
            throw new Exception("Driver não encontrado !");
        }
        catch (SQLException sql){
            throw new Exception("Falha ocorrida Connection Factory: "+sql.getMessage());
        }*/
    }

    public ConnectionFactory(String url) throws Exception{
        try {
            if (CONNECTION != null && !CONNECTION.isClosed()){
                CONNECTION.close();
                Class.forName("com.mysql.cj.jdbc.Driver");
                CONNECTION = DriverManager.getConnection(url,usuarioBanco, senhaBanco);
                CONNECTION.setAutoCommit(false);
                CONNECTION.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
                LOGGER.info("Connection is Open");
            }else {
                Class.forName("com.mysql.cj.jdbc.Driver");
                CONNECTION = DriverManager.getConnection(url,usuarioBanco, senhaBanco);
                CONNECTION.setAutoCommit(false);
                CONNECTION.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
                LOGGER.info("Connection is Open");
            }
        }
        catch (ClassNotFoundException cnf){
            throw new Exception("Driver não encontrado !");
        }
        catch (SQLException sql){
            throw new Exception("Falha ocorrida Connection Factory: "+sql.getMessage());
        }
    }

    public Connection getConnection(){
        return CONNECTION;
    }

    public void closeConnection() throws Exception{
        try{

            if (CONNECTION == null || CONNECTION.isClosed()){
                return;
            }else {
                CONNECTION.close();
            }

            LOGGER.info("Connection is Close");
        }
        catch (SQLException sql){
            throw new Exception("Falha ocorrida Close Connection: " + sql.getMessage());
        }
    }

    public void transactionConfirm() throws Exception{
        try{
            if (CONNECTION == null || CONNECTION.isClosed()){
                return;
            }else{
                CONNECTION.commit();
            }

        }
        catch (SQLException sql){
            throw new Exception("Falha ocorrida Transaction Confirm: " + sql.getMessage());
        }
    }

    public void transactionCancel() throws Exception{
        try {
            if (CONNECTION == null || CONNECTION.isClosed()){
                return;
            }else {
                CONNECTION.rollback();
            }

        }
        catch (SQLException sql){
            throw new Exception("Falha ocorrida Transaction Cancel: " + sql.getMessage());
        }
    }
}

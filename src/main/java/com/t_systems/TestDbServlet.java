package com.t_systems;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Logger;


@WebServlet("/test_db_connection")
public class TestDbServlet extends HttpServlet {

    private final Logger logger = Logger.getLogger(String.valueOf(TestDbServlet.class));

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        final String LOGIN = "root";
        final String PASSWORD = "root";
        final String JDBC_URL = "jdbc:mysql://localhost:3306/sbb_db?useSSL=false&serverTimezone=UTC";
        final String DRIVER = "com.mysql.jdbc.Driver";

        try {
            PrintWriter out = resp.getWriter();
            logger.info("Connecting to database: " + JDBC_URL);
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(JDBC_URL, LOGIN, PASSWORD);
            logger.info("Connected to sbb_db");
            connection.close();
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}
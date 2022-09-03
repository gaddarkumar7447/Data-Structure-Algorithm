package code.missiongoogle;
import java.sql.*;
public class MysqlJDBC {
    public static void main(String[] args) throws ClassNotFoundException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        }catch (ArithmeticException e){
           e.printStackTrace();
        }
    }
}

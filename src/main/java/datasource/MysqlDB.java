package datasource;

import connectionString.ConnectionString;
import java.sql.*;
import java.util.Scanner;
public class MysqlDB {
    public static final String RESET = "\033[0m";
    public static final String CYAN = "\033[0;36m";
    public static final String GREEN = "\033[0;32m";

    ConnectionString config = new ConnectionString();
    private Connection connection;
    public void checkConnection(){
        try {
            connection = DriverManager.getConnection(config.getDbUrl(),config.getDbUser(),config.getDbPass());

            if(connection == null){
                System.out.println("Connection is not established!!!");
            } //else
              //  System.out.println("Connection Successfully..");

        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void readMyTasks(){
        checkConnection();
        try {
            Statement statement = connection.createStatement();
            String readQuery = "SELECT task_title,task_status FROM task";
            ResultSet resultSet = statement.executeQuery(readQuery);
            while(resultSet.next()){
                System.out.println("---------------------------------------------");
                System.out.println(GREEN + " My task is : " + CYAN + resultSet.getString("task_title") + RESET);
                System.out.println(GREEN + " Status is : " + CYAN + resultSet.getString("task_status") + RESET);
                System.out.println("---------------------------------------------");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void createNewTask(){
        Scanner input = new Scanner(System.in);
        checkConnection();
        try {
            String createQuery = "INSERT INTO task (task_title ,task_status ) values (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(createQuery);
            System.out.println("Enter title of task:");
            System.out.print(">>  ");
            String taskTitle = input.nextLine();
            System.out.println("Enter status of task:");
            System.out.print(">> ");
            String taskStatus = input.nextLine();
            // Передаем строку
            preparedStatement.setString(1,taskTitle);
            preparedStatement.setString(2,taskStatus);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void changeMyTask(){
        checkConnection();
        Scanner input = new Scanner(System.in);
        try{
            String updateQuery = "UPDATE task set task_status = 'DONE' where task_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            System.out.println("Enter taskID you want to change:");
            System.out.print(">> ");
            int taskId = input.nextInt();
            preparedStatement.setInt(1,taskId);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteMyTask(){
        checkConnection();
        Scanner input = new Scanner(System.in);
        try{
            String deleteQuery = "DELETE FROM task where task_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            System.out.println("Enter taskID you want to delete:");
            System.out.print(">> ");
            int taskId = input.nextInt();
            preparedStatement.setInt(1,taskId);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}

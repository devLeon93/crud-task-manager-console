package controller;

import datasource.MysqlDB;

import javax.swing.*;
import java.util.Scanner;
public class MainController {
    MysqlDB db = new MysqlDB();
    public  void start(){
        gettingStarted();
        showMenu();
    }
    public void gettingStarted(){
        System.out.println("");
        System.out.println("::::::::::::::::Hello It's my first task-manager-application::::::::::::::::");
        System.out.println("");
    }
    public void showMenu(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("");
            System.out.println("1.Show my tasks");
            System.out.println("2.Create new task");
            System.out.println("3.Change my task");
            System.out.println("4.Delete my task");
            System.out.println("5.Exit");
            System.out.println("");

            System.out.println("Choose one of option:");
            System.out.print(">>  ");

            char option = scanner.next().charAt(0);

            switch(option){
                case '1' :
                    db.readMyTasks();
                    break;
                case '2' :
                    db.createNewTask();
                    break;
                case '3' :
                    db.changeMyTask();
                    break;
                case '4' :
                    db.deleteMyTask();
                    break;
                case '5' :
                    System.out.println("::::::::::Goodbye::::::::::");
                    System.exit(0);
                    break;
                default :
                    System.out.println("Unknown option !!!!");

            }
        }
    }
}

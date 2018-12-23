package dz2;

import java.sql.*;
import java.util.Scanner;

public class ProductDB {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.sqlite.JDBC");
        Connection conn;
        conn = DriverManager.getConnection("jdbc:sqlite:Product.db");
        Statement stmt = conn.createStatement();

        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Products (id integer primary key autoincrement not null, prodid integer not null, title text not null, cost real not null);");

        Products prod = new Products(conn, stmt);
        Scanner sc = new Scanner(System.in);

        menu();
        String vvod = sc.nextLine();

        while (!vvod.equals("выход")) {
            action(prod, vvod);
            menu();
            vvod = sc.nextLine();
        }
        conn.close();
    }

    private static void menu() {
        System.out.println();
        System.out.println("===================");
        System.out.println("Основные операции:");
        System.out.println("/цена наименование товара - выводит цену указанного товара");
        System.out.println("/сменитьцену наименование товара новая цена - изменияет цену указанного товара");
        System.out.println("/товарыпоцене минимальная цена максимальная цена - выводит все товары с ценами из указанного диапозона");
        System.out.println("выход - выход из программы");
        System.out.println("===================");
        System.out.println();
    }

    private static void action(Products prod, String vvod) throws SQLException {
        String [] comm = vvod.split(" ");
        String command = comm[0];
        switch (command) {
            case "/цена":
                System.out.println(prod.cost(comm[1]));
                break;
            case  "/сменитьцену":
                prod.updateCost(comm[1], Integer.parseInt(comm[2]));
                break;
            case "/товарыпоцене":
                prod.rangeCostTovars(Integer.parseInt(comm[1]), Integer.parseInt(comm[2]));
                break;
            default:
                System.out.println("Нет такой команды!");
        }
    }
}

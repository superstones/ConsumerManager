package Main;

import Bean.Client;
import Bean.Purchase;
import Bean.Sale;
import Bean.Service;
import Dao.ClientDao;
import Dao.PurchaseDao;
import Dao.SaleDao;
import Dao.ServiceDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Management {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        while (true) {

            System.out.println("**********欢迎进入客户关系管理系统**********");
            System.out.println("*****1.采购管理*****");
            System.out.println("*****2.销售管理*****");
            System.out.println("*****3.客户管理*****");
            System.out.println("*****4.服务管理*****");
            System.out.println("*****0.退出系统*****");
            System.out.println("*****请选择*****");
            switch (sc.nextInt()) {
                case 1:
                    Purchase();
                    break;
                case 2:
                    Sale();
                    break;
                case 3:
                    Client();
                    break;
                case 4:
                    Service();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("请重新输入！");
            }
        }

    }

    public static void Purchase() {
        while (true) {
            System.out.println("欢迎进入采购");
            System.out.println("请输入购买的产品");
            System.out.println("输入0退出");
            String p = sc.next();
            if (p.equals("0")) {
                break;
            }
            System.out.println("请输入要购买的数量");
            int mount = sc.nextInt();
            if (mount == 0) {
                break;
            }
            System.out.println("请输入购买产品的单价");
            int price = sc.nextInt();
            if (price == 0) {
                break;
            }
            if (PurchaseDao.Examine(mount, price)) {
                Purchase purchase = new Purchase(p, mount, price);
                List<Purchase> list = new ArrayList<Purchase>();
                System.out.println(purchase);
                System.out.println("等待产品入库");
                System.out.println("产品是否到货(y/n)");
                String a = sc.next();
                switch (a) {
                    case "y":
                        purchase.setStatus("已入库");
                        System.out.println("产品已入库");
                        System.out.println(purchase);
                        System.out.println("产品是否合格(y/n)");
                        String q = sc.next();
                        switch (q) {
                            case "y":
                                purchase.setQuality(1);
                                System.out.println(purchase);
                                if (PurchaseDao.Qualified(purchase.getQuality())) {
                                    list.add(purchase);
                                    PurchaseDao.add(list);
                                    break;
                                } else {
                                    list.add(purchase);
                                    PurchaseDao.add(list);
                                    break;
                                }

                            case "n":
                                purchase.setQuality(0);
                                purchase.setStatus("返厂处理");
                                System.out.println(purchase);
                                break;

                        }
                        break;
                    case"n":
                        purchase.setStatus("未入库");
                        System.out.println("产品未入库");
                        break;
                }

//                PurchaseDao.Arrival();
//                purchase.setStatus("已入库");



            } else {
                break;
            }

        }
    }

    public static void Sale() {
        while (true) {
            System.out.println("欢迎进入销售管理");
            System.out.println("1.创建销售机会");
            System.out.println("2.查看所有销售机会");
            System.out.println("3.删除销售机会");
            System.out.println("0.退出");
            System.out.println("请输入选项");

            int a = sc.nextInt();
            if (a == 0) {
                break;
            }
            switch (a) {
                case 1:
                    System.out.println("请输入编号:");
                    String nos = sc.next();
                    System.out.println("请输入时间:");
                    String times = sc.next();
                    System.out.println("请输入地点:");
                    String places = sc.next();
                    System.out.println("请输入产品:");
                    String products = sc.next();
                    System.out.println("请输入总量:");
                    String amounts = sc.next();
                    Sale e = new Sale(nos, times, places, products, amounts);
                    List<Sale> list = new ArrayList<Sale>();
                    list.add(e);
                    SaleDao.create(list);
                    break;
                case 2:
                    List<Sale> lists = SaleDao.queryAll();
                    for (Sale s : lists) {
                        System.out.println(s);
                    }
                    break;
                case 3:
                    System.out.println("请输入编号:");
                    String no2 = sc.next();
                    SaleDao.delete(no2);
                    break;

            }
        }
    }

    public static void Client() {
        while (true) {
            System.out.println("欢迎进入客户管理");
            System.out.println("1.增加客户信息");
            System.out.println("2.查看所有客户信息");
            System.out.println("3.删除客户信息");
            System.out.println("0.退出");
            System.out.println("请输入选项");
            int a = sc.nextInt();
            if (a == 0) {
                break;
            }
            switch (a) {
                case 1:
                    System.out.println("请输入客户编号:");
                    String nos = sc.next();
                    System.out.println("请输入姓名:");
                    String names = sc.next();
                    System.out.println("请输入地址:");
                    String places = sc.next();
                    System.out.println("请输入电话:");
                    String phones = sc.next();
                    Client e = new Client(nos, names, phones, places);
                    List<Client> list = new ArrayList<Client>();
                    list.add(e);
                    ClientDao.create(list);
                    break;
                case 2:
                    List<Client> lists = ClientDao.queryAll();
                    for (Client c : lists) {
                        System.out.println(c);
                    }
                    break;
                case 3:
                    System.out.println("请输入编号:");
                    String no2 = sc.next();
                    ClientDao.delete(no2);
                    break;
            }
        }
    }

    public static void Service() {
        while (true) {
            System.out.println("欢迎进入服务管理");
            System.out.println("1.创建服务");
            System.out.println("2.查看所有服务");
            System.out.println("3.删除服务");
            System.out.println("0.退出");
            System.out.println("请输入选项");
            int a = sc.nextInt();
            if (a == 0) {
                break;
            }
            switch (a) {
                case 1:
                    System.out.println("请输入服务编号:");
                    String nos = sc.next();
                    System.out.println("请输入服务开始时间:");
                    String assaigners = sc.next();
                    System.out.println("请输入服务结束时间:");
                    String handlers = sc.next();
                    System.out.println("请输入服务评价:");
                    String Evalutes = sc.next();
                    Service e = new Service(nos, assaigners, handlers, Evalutes);
                    List<Service> list = new ArrayList<Service>();
                    list.add(e);
                    ServiceDao.create(list);
                    break;
                case 2:
                    List<Service> lists = ServiceDao.queryAll();
                    for (Service s : lists) {
                        System.out.println(s);
                    }
                    break;
                case 3:
                    System.out.println("请输入编号:");
                    String no = sc.next();
                    ServiceDao.delete(no);
                    break;
            }
        }
    }


}

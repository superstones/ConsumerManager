package Dao;

import Bean.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceDao {
    public static void create(List<Service> list) {
        StringBuffer str = new StringBuffer();
        for (Service s : list) {
            str.append(s.getNo() + "," + s.getAssaigner() + "," + s.getHandler() + "," + s.getEvalute() + "#");
        }
        try {
            Writer w = new FileWriter("D:/Manage/Service.txt", true);
            BufferedWriter bwriter = new BufferedWriter(w);
            bwriter.write(str.toString());
            bwriter.close();
            w.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static Service query(String no) {
        Service service = null;
        try {
            Reader r = new FileReader("D:/Manage/Service.txt");
            BufferedReader breader = new BufferedReader(r);
            String str = breader.readLine();
            List<Service> list = deal(str);
            for (Service e : list) {
                if (e.getNo().equals(no)) {
                    return e;
                }
            }
            breader.close();
            r.close();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return service;
    }

    public static void delete(String no) {
        List<Service> newlist = new ArrayList<Service>();
        List<Service> listall = queryAll();
        Service service = query(no);
        for (Service e : listall) {
            if (e.getNo().equals(service.getNo())) {
                continue;
            }
            newlist.add(e);
        }
        createFile(newlist);
    }

    /**
     * 添加分配人
     *
     * @param no
     * @param assaigner
     */
    public static void addAssaigner(String no, String assaigner) {
        List<Service> newlist = new ArrayList<Service>();
        List<Service> listall = queryAll();
        Service sale = query(no);
        for (Service e : listall) {
            if (e.getNo().equals(sale.getNo())) {
                e.setAssaigner(assaigner);
            }
            newlist.add(e);
        }
        createFile(newlist);
    }

    /**
     * 添加处理人
     *
     * @param no
     * @param handler
     */
    public static void addHandlerer(String no, String handler) {
        List<Service> newlist = new ArrayList<Service>();
        List<Service> listall = queryAll();
        Service service = query(no);
        for (Service e : listall) {
            if (e.getNo().equals(service.getNo())) {
                e.setHandler(handler);
            }
            newlist.add(e);
        }
        createFile(newlist);
    }

    /**
     * 添加评价
     *
     * @param no
     * @param evalute
     */
    public static void addEvalute(String no, String evalute) {
        List<Service> newlist = new ArrayList<Service>();
        List<Service> listall = queryAll();
        Service service = query(no);
        for (Service e : listall) {
            if (e.getNo().equals(service.getNo())) {
                e.setEvalute(evalute);
            }
            newlist.add(e);
        }
        createFile(newlist);
    }

    public static List<Service> queryAll() {
        List<Service> list = null;
        try {
            Reader r = new FileReader("D:/Manage/Service.txt");
            BufferedReader breader = new BufferedReader(r);
            String str = breader.readLine();
            list = deal(str);
            breader.close();
            r.close();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    public static List<Service> deal(String str) {
        List<Service> list = new ArrayList<Service>();
        String m[] = str.split("#");
        for (String o : m) {
            String s[] = o.split(",");
            Service e = new Service(s[0], s[1], s[2], s[3]);
            list.add(e);
        }
        return list;
    }

    public static void createFile(List<Service> list) {
        StringBuffer str = new StringBuffer();
        for (Service s : list) {
            str.append(s.getNo() + "," + s.getAssaigner() + "," + s.getHandler() + "," + s.getEvalute() + "#");
        }
        try {
            Writer w = new FileWriter("D:/Manage/Service.txt");
            BufferedWriter bwriter = new BufferedWriter(w);
            bwriter.write(str.toString());
            bwriter.close();
            w.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

package Dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import Bean.Sale;

public class SaleDao {
     public static void create(List<Sale> list) {
    	 StringBuffer str = new StringBuffer();
 		 for(Sale sale:list) {
 			str.append(sale.getNo()+","+sale.getTime()+","+sale.getPlace()+","+sale.getProduct()+","+sale.getMainperson()+"#");
 		}
    	 try {
			Writer w = new FileWriter("D:/Manage/sale.txt",true);
			BufferedWriter bwriter = new BufferedWriter(w);
			bwriter.write(str.toString());
			bwriter.close();
			w.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
     
     public static Sale query(String no) {
    	 Sale sale =null;
    	 try {
			Reader r = new FileReader("D:/Manage/sale.txt");
			BufferedReader breader = new BufferedReader(r);
			String str =breader.readLine();
			List<Sale> list = deal(str);
			for(Sale e:list) {
				if(e.getNo().equals(no)) { 
				    return e;
				}
			}
			breader.close();
			r.close();
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 return sale;
     }
     
     public static void delete(String no) {
    	List<Sale> newlist=new ArrayList<Sale>();
    	List<Sale> listall = queryAll();
    	Sale sale =query(no);
    	for(Sale e :listall) {
    		if(e.getNo().equals(sale.getNo())) {
    		   continue;
    		}
    		newlist.add(e);
    	}
    	 createFile(newlist);
     }
     
     public static void updatePerson(String no,String perosn) {
    	 List<Sale> newlist=new ArrayList<Sale>();
     	List<Sale> listall = queryAll();
     	Sale sale =query(no);
     	for(Sale e :listall) {
     		if(e.getNo().equals(sale.getNo())) {
     			e.setMainperson(perosn);
     		}
     		newlist.add(e);
     	}
     	 createFile(newlist);
     }
     
     public static List<Sale> queryAll() {
    	 List<Sale> list =null;
    	 try {
			Reader r = new FileReader("D:/Manage/sale.txt");
			BufferedReader breader = new BufferedReader(r);
			String str =breader.readLine();
		    list = deal(str);
			breader.close();
			r.close();
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 return list;
     }
     
     public static List<Sale> deal(String str) {
 		List<Sale> list = new ArrayList<Sale>();
 		String m[] = str.split("#");
 		for(String o:m) {
 			String s[] = o.split(",");
 			Sale e =new Sale(s[0],s[1],s[2],s[3],s[4]);
 			list.add(e);
 		}
 		return list;
 	}
     
     public static void createFile(List<Sale> list) {
    	 StringBuffer str = new StringBuffer();
 		 for(Sale sale:list) {
 			str.append(sale.getNo()+","+sale.getTime()+","+sale.getPlace()+","+sale.getProduct()+","+sale.getMainperson()+"#");
 		}
    	 try {
			Writer w = new FileWriter("D:/Manage/sale.txt");
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

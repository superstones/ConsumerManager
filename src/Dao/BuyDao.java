package Dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import Bean.Buy;

public class BuyDao {
	
	
	public static void create(List<Buy> list) {
		StringBuffer str = new StringBuffer();
		for(Buy b:list) {
			str.append(b.getProduct()+" "+b.getMount()+" "+b.getPrice()+" "+b.getQuality()+" "+b.getStatus()+"#");
		}
		
		try {
			Writer  w = new FileWriter("D:/Manage/Buy.txt",true);
			BufferedWriter bwriter = new BufferedWriter(w);
			bwriter.write(str.toString());
			bwriter.close();
			w.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	/**
	 * 财务审批功能
	 */
     public static  boolean Examine(int mount,int price) {
    	 if(mount*price <=200000) {
    		 return true;
    	 }else {
    		 System.out.println("超出预算");
    		 return false;
    	 }
     }
     
     /**
      * 产品到货等待时间
      */
     public static void Arrival() {
    	 try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
     
     /**
      * 检查产品是否合格
      * @param quality
      * @return
      */

     public static boolean Qualified(int quality) {
    	 if(quality == 1) {
			 System.out.println("产品合格，入库");
			 return true;
    	 }else {
    		 System.out.println("产品不合格");
    		 return false;
    	 }
     }
}

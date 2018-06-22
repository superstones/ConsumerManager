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

import Bean.Client;

public class ClientDao {
	    public static void create(List<Client> list) {
	    	 StringBuffer str = new StringBuffer();
	 		 for(Client client:list) {
	 			str.append(client.getNo()+","+client.getName()+","+client.getPhone()+","+client.getAddress()+"#");
	 		}
	    	 try {
				Writer w = new FileWriter("D:/Manage/Client.txt",true);
				BufferedWriter bwriter = new BufferedWriter(w);
				bwriter.write(str.toString());
				bwriter.close();
				w.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	     }
	     
	     public static Client query(String no) {
	    	 Client sale =null;
	    	 try {
				Reader r = new FileReader("D:/Manage/Client.txt");
				BufferedReader breader = new BufferedReader(r);
				String str =breader.readLine();
				List<Client> list = deal(str);
				for(Client e:list) {
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
	    	List<Client> newlist=new ArrayList<Client>();
	    	List<Client> listall = queryAll();
	    	Client sale =query(no);
	    	for(Client e :listall) {
	    		if(e.getNo().equals(sale.getNo())) {
	    		   continue;
	    		}
	    		newlist.add(e);
	    	}
	    	 createFile(newlist);
	     }
	     
	     public static void updatePerson(String no,String phone,String address) {
	    	 List<Client> newlist=new ArrayList<Client>();
	     	List<Client> listall = queryAll();
	     	Client sale =query(no);
	     	for(Client e :listall) {
	     		if(e.getNo().equals(sale.getNo())) {
	     			e.setPhone(phone);
	     			e.setAddress(address);
	     		}
	     		newlist.add(e);
	     	}
	     	 createFile(newlist);
	     }
	     
	     public static List<Client> queryAll() {
	    	 List<Client> list =null;
	    	 try {
				Reader r = new FileReader("D:/Manage/Client.txt");
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
	     
	     public static List<Client> deal(String str) {
	 		List<Client> list = new ArrayList<Client>();
	 		String m[] = str.split("#");
	 		for(String o:m) {
	 			String s[] = o.split(",");
	 			Client e =new Client(s[0],s[1],s[2],s[3]);
	 			list.add(e);
	 		}
	 		return list;
	 	}
	     
	     public static void createFile(List<Client> list) {
	    	 StringBuffer str = new StringBuffer();
	 		 for(Client client:list) {
	 			str.append(client.getNo()+","+client.getName()+","+client.getAddress()+","+client.getPhone()+"#");
	 		}
	    	 try {
				Writer w = new FileWriter("D:/Manage/Client.txt");
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

	


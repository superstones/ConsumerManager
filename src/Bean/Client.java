package Bean;

public class Client {
   private String no;
   private String name;
   private String phone;
   private String address;
   
   
	  public Client() {
		super();
	}


	public Client(String no,String name, String phone, String address) {
		super();
		this.no=no;
		this.name = name;
		this.phone = phone;
		this.address = address;
	}

    
	public String getNo() {
		return no;
	}


	public void setNo(String no) {
		this.no = no;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "客户编号:" + no + ", 客户姓名:" + name + ", 客户电话:" + phone + ", 客户地址:" + address  ;
	}


	
    
   
}

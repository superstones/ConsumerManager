package Bean;

public class Sale {
	private String no;
    private String time;
    private String place;
    private String product;
    private String mainperson;
    
    
	public Sale() {
		super();
	}
	public Sale(String no,String time, String place, String product, String mainperson) {
		super();
		this.no=no;
		this.time = time;
		this.place = place;
		this.product = product;
		this.mainperson = mainperson;
	}
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getMainperson() {
		return mainperson;
	}
	public void setMainperson(String mainperson) {
		this.mainperson = mainperson;
	}
	@Override
	public String toString() {
		return " [销售编号=" + no + ", 销售时间=" + time + ", 销售地址=" + place + ", 销售产品=" + product + ", mainperson="
				+ mainperson + "]";
	}
	
    
    
}

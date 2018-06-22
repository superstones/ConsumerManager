package Bean;

public class Service {
     private String no;
     private String assaigner;
     private String handler;
     private String evalute;
     
     
     
	public Service() {
		super();
	}



	public Service(String no, String assaigner, String handler, String evalute) {
		super();
		this.no = no;
		this.assaigner = assaigner;
		this.handler = handler;
		this.evalute = evalute;
	}



	public String getNo() {
		return no;
	}



	public void setNo(String no) {
		this.no = no;
	}



	public String getAssaigner() {
		return assaigner;
	}



	public void setAssaigner(String assaigner) {
		this.assaigner = assaigner;
	}



	public String getHandler() {
		return handler;
	}



	public void setHandler(String handler) {
		this.handler = handler;
	}



	public String getEvalute() {
		return evalute;
	}



	public void setEvalute(String evalute) {
		this.evalute = evalute;
	}



	@Override
	public String toString() {
		return " 服务编号:" + no + ", 开始时间:" + assaigner + ",结束时间:" + handler + ",评价:" + evalute ;
	}
     
     
}

package Bean;



public class Buy {
	      private String product;
	      private int mount;
	      private int quality;
	      private int price;
	      private String status;
		public Buy() {
			super();
		}
		public Buy(String product, int mount, int price) {
			super();
			this.product = product;
			this.mount = mount;
			this.price=price;
			this.quality = Math.random()>0.5?1:0;
			this.status = "未入库";
		}
		
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public String getProduct() {
			return product;
		}
		public void setProduct(String product) {
			this.product = product;
		}
		public int getMount() {
			return mount;
		}
		public void setMount(int mount) {
			this.mount = mount;
		}
		public int getQuality() {
			return quality;
		}
		public void setQuality(int quality) {
			this.quality = quality;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		@Override
		public String toString() {
			return "产品:" + product + ", 产品数量:" + mount + ", 质量:" + quality + ", 价格:" + price
					+ ", 状态:" + status ;
		}
	      
      
}

package homework.tel.entity;

import java.util.List;

/**
 * 客户的实体类
 * @author 啊庭仔
 *
 */
public class Customer {

	private Integer cId; //客户编号
	private String account;  //账号
	private String password; //客户密码
	private String name; //姓名
	private String phone; //电话
	private String address; //地址 
	private List<Integer> ordersId; //订单列表
	
	
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Integer> getOrdersId() {
		return ordersId;
	}
	public void setOrdersId(List<Integer> ordersId) {
		this.ordersId = ordersId;
	}
	public Integer getcId() {
		return cId;
	}
	public void setcId(Integer cId) {
		this.cId = cId;
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
		// TODO Auto-generated method stub
		return this.cId+this.account+this.password+this.name+this.phone+this.address+this.ordersId;
	}
	
}

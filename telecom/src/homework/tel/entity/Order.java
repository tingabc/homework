package homework.tel.entity;

import java.util.List;


/**
 * 账单实体类
 * @author 啊庭仔
 *
 */
public class Order {

	private Integer oId; //账单号 
	private Integer cId; //客户id
	private String oDate; //账单时间
	private List<Integer> odIds; //账单详细id
	private Integer totalcost; //总价
	public Integer getcId() {
		return cId;
	}
	public void setcId(Integer cId) {
		this.cId = cId;
	}
	public Integer getoId() {
		return oId;
	}
	public void setoId(Integer oId) {
		this.oId = oId;
	}
	
	
	
	public List<Integer> getOdIds() {
		return odIds;
	}
	public void setOdIds(List<Integer> odIds) {
		this.odIds = odIds;
	}
	public Integer getTotalcost() {
		return totalcost;
	}
	public void setTotalcost(Integer totalcost) {
		this.totalcost = totalcost;
	}
	public String getoDate() {
		return oDate;
	}
	public void setoDate(String oDate) {
		this.oDate = oDate;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " "+this.oId+this.cId+this.oDate+this.totalcost+this.odIds;
	}
	
	
}

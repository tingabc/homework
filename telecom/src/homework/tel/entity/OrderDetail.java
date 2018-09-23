package homework.tel.entity;


/**
 * 账单详细实体类
 * @author 啊庭仔
 *
 */
public class OrderDetail {

	private Integer odId;  //账单详细id
	private Integer oId; //账单号
	private String detailDate; //日期
	private Integer typeId; //套餐类型
	private Integer pId; //套餐编号
	private Integer cost; //费用
	
	public Integer getOdId() {
		return odId;
	}
	public void setOdId(Integer odId) {
		this.odId = odId;
	}
	public Integer getoId() {
		return oId;
	}
	public void setoId(Integer oId) {
		this.oId = oId;
	}
	
	public String getDetailDate() {
		return detailDate;
	}
	public void setDetailDate(String detailDate) {
		this.detailDate = detailDate;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	public Integer getCost() {
		return cost;
	}
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	
}

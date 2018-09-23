package homework.tel.entity;
/**
 * 电视套餐的实体类
 * @author 啊庭仔
 *
 */
public class Television extends Service{

	private Integer id; //套餐id
	private String name; //电视套餐名称
	private Integer cost; //费用
	private String introduction; //介绍
	
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
	

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCost() {
		return cost;
	}
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.id+this.name+this.cost+this.introduction;
	}
}

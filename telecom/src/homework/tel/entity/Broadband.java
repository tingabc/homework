package homework.tel.entity;
/**
 * 宽频的实体类
 * @author 啊庭仔
 *
 */
public class Broadband extends Service{

	private Integer id; //宽频套餐编号
	private String name; //宽频套餐名称
	private String speed; //上网速度
	private Integer cost; //费用
	
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
	public String getSpeed() {
		return speed;
	}
	public void setSpeed(String speed) {
		this.speed = speed;
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
		return this.id+this.name+this.speed+this.cost;
	}
	
}

package homework.tel.entity;
/**
 * 服务类，用于规范所有服务
 * 这是后来为了用反射而创建的，所以其他类的相关属性还没删掉
 * @author 啊庭仔
 *
 */
public class Service {
	
	private Integer id; //宽频套餐编号
	private String name; //宽频套餐名称
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
	
}

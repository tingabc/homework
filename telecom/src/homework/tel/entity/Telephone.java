package homework.tel.entity;

import java.util.List;

/**
 * 电话套餐实体类
 * @author 啊庭仔
 *
 */
public class Telephone extends Service{

	private Integer id; //电话套餐id
	private String name;  //套餐名称
	private Integer time; //通话时间
	private Integer data; //手机流量
	private List<Member> members; //会员列表
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Member> getMembers() {
		return members;
	}
	public void setMembers(List<Member> members) {
		this.members = members;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTime() {
		return time;
	}
	public void setTime(Integer time) {
		this.time = time;
	}
	public Integer getData() {
		return data;
	}
	public void setData(Integer data) {
		this.data = data;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " "+this.id+this.name+" "+this.time+" "+this.data+this.members;
	}
	
}

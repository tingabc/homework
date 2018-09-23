package homework.tel.entity;
/**
 * 套餐服务的类设计
 * @author 啊庭仔
 *
 */
public class ServicePackage {

	private Integer typeId; //套餐id
	
	private String typeName; //套餐类型
	
	private String serviceName; // 套餐类型名称(主要是为了英文拼写)

	
	

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	@Override
	public String toString() {
		return this.typeId+this.typeName+this.serviceName;
	}
	
}

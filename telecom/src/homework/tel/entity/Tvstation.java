package homework.tel.entity;
/**
 * 电视台实体类
 * @author 啊庭仔
 *
 */
public class Tvstation {

	private Integer TVid; //电视台编号
	private String TVname; //电视台名字
	private boolean isfree; //是否收费
	private String introduction; //介绍
	
	public Integer getTVid() {
		return TVid;
	}

	public void setTVid(Integer tVid) {
		TVid = tVid;
	}

	public String getTVname() {
		return TVname;
	}

	public void setTVname(String tVname) {
		TVname = tVname;
	}

	public boolean isIsfree() {
		return isfree;
	}

	public void setIsfree(boolean isfree) {
		this.isfree = isfree;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return TVid+TVname+this.isfree+this.introduction;
	}
}

package homework.tel.entity;
/**
 * 会员内容
 * @author 啊庭仔
 *
 */
public class Member {

	private Integer mId; //会员编号
	private String mName; //会员名称（例如youkuMember 优酷会员 ）
	public Integer getmId() {
		return mId;
	}
	public void setmId(Integer mId) {
		this.mId = mId;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.mId+this.mName;
	}
}

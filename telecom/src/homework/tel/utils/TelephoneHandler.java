package homework.tel.utils;




import homework.tel.entity.Member;
import homework.tel.entity.Telephone;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * SAX处理程序
 * @author 啊庭仔
 *
 */
public class TelephoneHandler extends DefaultHandler {

	//存储所有电话套餐对象
	private List<Telephone> list = new ArrayList<Telephone>();

	public List<Telephone> getList() {
		return list;
	}

	//保存一个电话套餐信息
	private Telephone telephone;
	
	private static List<Member> allMember;
	
	static{
		//从会员xml中查询出所有数据
		try {
			allMember = Readxml.readAllMember();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 思路： 
	 * 	1）创建telephone对象
	 *  2）把每个telephone标签内容存入到telephone对象
	 *  3）把telephone对象放入List中
	 */
	//用于临时存储当前读到的标签名
	private String curTag;
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		curTag = qName;
		//读取到telephone的开始标签创建telephone对象
		if("telephone".equals(qName)){
			telephone = new Telephone();
			
			//设置id值
			//System.out.println(attributes.getValue("cid"));
			telephone.setId(Integer.valueOf(attributes.getValue("id")));
		}
	}
	

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		//当前文本内容
		String content = new String(ch,start,length);
		
		if("time".equals(curTag)){
			telephone.setTime(Integer.valueOf(content));
		}
		if("name".equals(curTag)){
			telephone.setName(content);
		}
		if("data".equals(curTag)){
			telephone.setData(Integer.valueOf(content));
		}
		if("menberIds".equals(curTag)){
			
			if (content != null || !"".equals(content.trim())){
				String[] members = content.split(",");
				List<Integer> membersList = new ArrayList<Integer>();
				for(int i = 0;i<members.length;i++){
					membersList.add(Integer.valueOf(members[i]));
				}
				//新建一个list用来保存会员数据
				List<Member> Members = new ArrayList<Member>();
				
				//与查询出的member数据进行对比
				for(int i = 0;i<membersList.size();i++){
					for(int j =0;j<allMember.size();j++){
						if(membersList.get(i).equals(allMember.get(j).getmId())){
							Members.add(allMember.get(j));
							break;
						}
					}
				}
				telephone.setMembers(Members);
			}
		}

	}
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		//设置空时为了避免空格换行设置到对象的属性中
		curTag = null;
		//读到telephone的结束标签放入List中
		if("telephone".equals(qName)){
			list.add(telephone);
		}
	}
	
}

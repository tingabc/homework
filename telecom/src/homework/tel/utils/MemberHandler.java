package homework.tel.utils;




import homework.tel.entity.Member;

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
public class MemberHandler extends DefaultHandler {

	//存储所有会员对象
	private List<Member> list = new ArrayList<Member>();

	public List<Member> getList() {
		return list;
	}

	//保存一个会员信息
	private Member member;
	/**
	 * 思路： 
	 * 	1）创建Member对象
	 *  2）把每个Member标签内容存入到member对象
	 *  3）把Member对象放入List中
	 */
	//用于临时存储当前读到的标签名
	private String curTag;
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		curTag = qName;
		//读取到member的开始标签创建Member对象
		if("member".equals(qName)){
			member = new Member();
			
			//设置id值
			//System.out.println(attributes.getValue("cid"));
			member.setmId(Integer.valueOf(attributes.getValue("mid")));
		}
	}
	

	
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		//当前文本内容
		String content = new String(ch,start,length);
		
		if("mname".equals(curTag)){
			member.setmName(content);
		}

	}
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		//设置空时为了避免空格换行设置到对象的属性中
		curTag = null;
		//读到member的结束标签放入List中
		if("member".equals(qName)){
			list.add(member);
		}
	}
	
}

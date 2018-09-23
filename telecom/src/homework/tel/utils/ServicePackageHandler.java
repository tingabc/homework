package homework.tel.utils;




import homework.tel.entity.ServicePackage;

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
public class ServicePackageHandler extends DefaultHandler {

	//存储所有套餐对象
	private List<ServicePackage> list = new ArrayList<ServicePackage>();

	public List<ServicePackage> getList() {
		return list;
	}

	//保存一个套餐信息
	private ServicePackage servicePackage;
	/**
	 * 思路： 
	 * 	1）创建ServicePackage对象
	 *  2）把每个ServicePackage标签内容存入到ServicePackage对象
	 *  3）把ServicePackage对象放入List中
	 */
	//用于临时存储当前读到的标签名
	private String curTag;
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		curTag = qName;
		//读取到servicePackage的开始标签创建ServicePackage对象
		if("ServicePackage".equals(qName)){
			servicePackage = new ServicePackage();
			
			//设置id值
			//System.out.println(attributes.getValue("cid"));
			servicePackage.setTypeId(Integer.valueOf(attributes.getValue("typeId")));
		}
	}
	

	
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		//当前文本内容
		String content = new String(ch,start,length);
		
		if("typeName".equals(curTag)){
			servicePackage.setTypeName(content);
		}
		if("serviceName".equals(curTag)){
			servicePackage.setServiceName(content);
		}
		
	}
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		//设置空时为了避免空格换行设置到对象的属性中
		curTag = null;
		//读到servicePackage的结束标签放入List中
		if("ServicePackage".equals(qName)){
			list.add(servicePackage);
		}
	}
	
}

package homework.tel.dao.impl;

import homework.tel.dao.TelephoneDao;
import homework.tel.entity.Telephone;
import homework.tel.utils.Readxml;

import java.io.File;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.springframework.stereotype.Component;

@Component("telephoneDao")
public class TelephoneDaoImpl implements TelephoneDao{

	@Override
	public List<Telephone> selectAll() throws Exception {
		return Readxml.readAllTelephone();
	}

	@Override
	public Telephone find(Integer id) throws Exception {
		SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
		SingleTelephoneHandler handler = new SingleTelephoneHandler(id);
		String path = Readxml.class.getClassLoader().getResource("").toURI().getPath();
		parser.parse(new File(path+"telephone.xml"), handler);
		Telephone result = handler.getTelephone();
		return result;
	}

	

	
	
	

}

package homework.tel.dao.impl;

import homework.tel.dao.BroadbandDao;
import homework.tel.entity.Broadband;
import homework.tel.utils.Readxml;

import java.io.File;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.springframework.stereotype.Component;

@Component("broadbandDao")
public class BroadbandDaoImpl implements BroadbandDao{

	@Override
	public List<Broadband> selectAll() throws Exception {
		return Readxml.readAllBroadband();
	}

	@Override
	public Broadband find(Integer id) throws Exception {
		SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
		SingleBroadbandHandler handler = new SingleBroadbandHandler(id);
		String path = Readxml.class.getClassLoader().getResource("").toURI().getPath();
		parser.parse(new File(path+"broadband.xml"), handler);
		Broadband result = handler.getBroadband();
		return result;
	}


	
	

}

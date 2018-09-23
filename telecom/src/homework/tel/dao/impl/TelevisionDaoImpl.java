package homework.tel.dao.impl;

import homework.tel.dao.TelevisionDao;
import homework.tel.entity.Television;
import homework.tel.utils.Readxml;

import java.io.File;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.springframework.stereotype.Component;

@Component("televisionDao")
public class TelevisionDaoImpl implements TelevisionDao{

	@Override
	public List<Television> selectAll() throws Exception {
		return Readxml.readAllTelevision();
	}

	@Override
	public Television find(Integer id) throws Exception {
		SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
		SingleTelevisionHandler handler = new SingleTelevisionHandler(id);
		String path = Readxml.class.getClassLoader().getResource("").toURI().getPath();
		parser.parse(new File(path+"television.xml"), handler);
		Television result = handler.getTelevision();
		
		return result;
	}

}

package homework.tel.dao.impl;

import java.util.List;

import homework.tel.dao.TvstationDao;
import homework.tel.entity.Tvstation;
import homework.tel.utils.Readxml;

import org.springframework.stereotype.Component;

@Component("tvstationDao")
public class TvstationDaompl implements TvstationDao{

	@Override
	public List<Tvstation> selectAll() throws Exception {
		return Readxml.readAllTVstation();
	}

	//暂时没有实现
	@Override
	public <T> T find(Integer id) throws Exception {
		return null;
	}

	
}

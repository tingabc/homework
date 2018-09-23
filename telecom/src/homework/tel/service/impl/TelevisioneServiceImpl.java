package homework.tel.service.impl;

import homework.tel.entity.Television;
import homework.tel.service.TelevisionService;

import org.springframework.stereotype.Service;

@Service("televisionService")
public class TelevisioneServiceImpl extends BaseServiceImpl<Television> implements TelevisionService{

	@Override
	public Television find(Integer id) throws Exception {
		return televisionDao.find(id);
	}

	

}

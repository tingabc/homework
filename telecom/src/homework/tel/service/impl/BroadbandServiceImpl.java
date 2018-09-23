package homework.tel.service.impl;

import homework.tel.entity.Broadband;
import homework.tel.service.BroadbandService;

import org.springframework.stereotype.Service;

@Service("broadbandService")
public class BroadbandServiceImpl extends BaseServiceImpl<Broadband> implements BroadbandService{

	@Override
	public Broadband find(Integer id) throws Exception {
		return broadbandDao.find(id);
	}


}

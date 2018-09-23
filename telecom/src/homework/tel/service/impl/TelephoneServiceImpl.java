package homework.tel.service.impl;

import homework.tel.entity.Telephone;
import homework.tel.service.TelephoneService;

import org.springframework.stereotype.Service;

@Service("telephoneService")
public class TelephoneServiceImpl extends BaseServiceImpl<Telephone> implements TelephoneService{

	@Override
	public Telephone find(Integer id) throws Exception {
		return telephoneDao.find(id);
	}

	

}

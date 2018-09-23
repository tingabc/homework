package homework.tel.service.impl;

import java.util.List;

import homework.tel.entity.Customer;
import homework.tel.service.CustomerService;

import org.springframework.stereotype.Service;

@Service("customerService")
public class CustomerServiceImpl extends BaseServiceImpl<Customer> implements CustomerService{

	@Override
	public Customer login(Integer id) throws Exception {
		return customerDao.select(id);
	}

	@Override
	public Customer login(String account) throws Exception {
		return customerDao.select(account);
	}

	@Override
	public void register(Customer customer) throws Exception {
		List<Customer> all = customerDao.selectAll();
		Customer customer2 = all.get(all.size()-1);
		customer.setcId(customer2.getcId()+1);
		
		customerDao.insert(customer);
	}

	@Override
	public void modify(Customer customer) throws Exception {
		customerDao.modify(customer);
	}

	

}

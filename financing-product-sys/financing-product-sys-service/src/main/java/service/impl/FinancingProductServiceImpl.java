package service.impl;

import java.util.List;

import domain.FinancingProduct;
import repository.FinacingProductRepository;
import repository.impl.FinancingProductRepositoryImpl;
import service.FinancingProductService;

public class FinancingProductServiceImpl implements FinancingProductService {

	private FinacingProductRepository financingProductRepository = new FinancingProductRepositoryImpl();
	@Override
	public List<FinancingProduct> findAll(FinancingProduct financingProduct) {
		return financingProductRepository.findAll(financingProduct);
	}

	@Override
	public void save(FinancingProduct financingProduct) {
		financingProductRepository.save(financingProduct);
	}

	@Override
	public void delete(String id) {
		financingProductRepository.delete(id);
		
	}

	@Override
	public void update(FinancingProduct financingProduct) {
		financingProductRepository.update(financingProduct);
		
	}

}

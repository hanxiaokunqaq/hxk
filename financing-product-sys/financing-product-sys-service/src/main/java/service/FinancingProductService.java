package service;

import java.util.List;

import domain.FinancingProduct;

public interface FinancingProductService {
	List<FinancingProduct> findAll(FinancingProduct financingProduct);
	void save(FinancingProduct financingProduct);
	void delete(String id);
	void update(FinancingProduct financingProduct);
}

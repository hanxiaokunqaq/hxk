package repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.FinancingProduct;
import repository.FinacingProductRepository;

public class FinancingProductRepositoryImpl extends BaseDao implements FinacingProductRepository {

	@Override
	public List<FinancingProduct> findAll(FinancingProduct financingProduct) {
		String sql = "SELECT * FROM FinancingProduct WHERE 1=1 ";
		if(financingProduct.getId() != null && financingProduct.getId() != "") {
			sql += " AND id = " + financingProduct.getId();
		} 
		if(financingProduct.getRisk() != null && financingProduct.getRisk() != 0) {
			sql += " AND risk = " + financingProduct.getRisk();
		}
		
		ResultSet rs = (ResultSet) super.execute(sql);
		List<FinancingProduct> financingProducts = new ArrayList<>();
		try {
			while(rs.next()) {
				financingProducts.add(new FinancingProduct(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getDate(5)));
			}
			return financingProducts;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void save(FinancingProduct financingProduct) {
		String sql = "INSERT INTO financingProduct VALUES(?,?,?,?,?,?)";
		super.execute(sql, financingProduct.getId(),financingProduct.getRisk(), financingProduct.getIncome(), financingProduct.getSaleStarting(), financingProduct.getSaleEnd(), financingProduct.getEnd());
	}

	@Override
	public void delete(String id) {
		String sql = "DELETE FROM financingProduct WHERE id = ?";
		super.execute(sql, id);
		
	}

	@Override
	public void update(FinancingProduct financingProduct) {
		String sql = "UPDATE financingProduct SET income=?, risk=?, saleStarting=?, saleEnd=?, end=? WHERE id=?";
		super.execute(sql, 
				financingProduct.getIncome(), 
				financingProduct.getRisk(), 
				financingProduct.getSaleStarting(), 
				financingProduct.getSaleEnd(), 
				financingProduct.getEnd(), 
				financingProduct.getId());
		
		
	}

}

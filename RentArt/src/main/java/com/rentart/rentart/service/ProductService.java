package com.rentart.rentart.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rentart.rentart.domain.product.ProductDao;
import com.rentart.rentart.domain.product.dto.DetailArtistProduct;
import com.rentart.rentart.domain.product.dto.DetailDto;
import com.rentart.rentart.domain.product.dto.InsertProductDto;
import com.rentart.rentart.domain.product.dto.ManageProductDto;
import com.rentart.rentart.domain.product.dto.ThumbnailProduct;
import com.rentart.rentart.util.Utility;

public class ProductService {
	
	private ProductDao productDao;
	
	private Map<Integer, int[]> sizeMap = new HashMap<Integer, int[]>(){{
		put(1, new int[]{1,5});
		put(2, new int[]{6,10});
		put(3, new int[]{11,20});
		put(4, new int[]{21,30});
		put(5, new int[]{31,40});
		put(6, new int[]{41,60});
		put(7, new int[]{61,10000});
	}};
	private Map<Integer, int[]> priceMap = new HashMap<Integer, int[]>(){{
		put(1, new int[]{0,300000});
		put(2, new int[]{300000,500000});
		put(3, new int[]{500000,1000000});
		put(4, new int[]{1000000,2000000});
		put(5, new int[]{2000000,3000000});
		put(6, new int[]{3000000,5000000});
		put(7, new int[]{5000000,10000000});
		put(8, new int[]{10000000,Integer.MAX_VALUE});
	}};
	
	public ProductService() {
		this.productDao = new ProductDao();
	}

	public List<ThumbnailProduct> getProductList(String field, String query, int page) {
		int start = 1+(page-1)*12;
		int end = page*12;
		return productDao.find(start, end, field, query);
	}
	public List<ThumbnailProduct> getProductList(String field, String query, int page, int[] theme, int[] size, int[] price) {
		int start = 1+(page-1)*12;
		int end = page*12;
		
		int[][] sizeList = Utility.filterMapper(sizeMap, size);	
		int[][] priceList = Utility.filterMapper(priceMap, price); 
		
		return productDao.findByFilter(theme, sizeList, priceList, start, end, field, query);
	}
	
	public int countProductList(String field, String query) {
		return productDao.count(field, query);
	}
	
	public int countProductList(String field, String query, int[] theme, int[] size, int[] price) {
		
		int[][] sizeList = Utility.filterMapper(sizeMap, size);	
		int[][] priceList = Utility.filterMapper(priceMap, price); 
		
		return productDao.countByFilter(theme, sizeList, priceList, field, query);
	}
	
	public DetailDto getProductDetail(int prodNo) {
		productDao.updateHits(prodNo);
		return productDao.get(prodNo);
	}
	
	public List<DetailArtistProduct> getArtistProductList(int artistId) {
		return productDao.findByArtistId(artistId, 1, 4);
	}
	
	public List<DetailArtistProduct> getArtistProductListAll(int artistId) {
		return productDao.findByArtistId(artistId);
	}

	public int updateProduct(InsertProductDto dto) {
		return productDao.update(dto);
	}

	public int insertProduct(InsertProductDto dto) {
		return productDao.insert(dto);
	}

	public int deleteProduct(int no) {
		return productDao.delete(no);
	}
	
	//manage
	public List<ManageProductDto> getManageProductListAll(int page, String field, String query) {
		int start = 1+(page-1)*20;
		int end = page*20;
		
		return productDao.findForManage(start, end, field, query);
	}
	
	public int setRentProduct(List<Integer> rents) {
		return productDao.updateRent(rents);
	}

	public int setNoRentProduct(List<Integer> nonRents) {
		return productDao.updateNoRent(nonRents);
	}
	
}

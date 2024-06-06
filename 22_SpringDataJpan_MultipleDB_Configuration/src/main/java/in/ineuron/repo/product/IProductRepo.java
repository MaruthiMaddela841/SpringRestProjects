package in.ineuron.repo.product;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ineuron.config.model.product.Product;

public interface IProductRepo extends JpaRepository<Product, Integer> {

}

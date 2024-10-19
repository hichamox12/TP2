package ma.mundia.jpaap;

import ma.mundia.jpaap.entities.Product;
import ma.mundia.jpaap.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@SpringBootApplication
public class JpaApApplication implements CommandLineRunner {

    @Autowired
   private  ProductRepository productRepository;
    public static void main(String[] args) {
        SpringApplication.run(JpaApApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
for (int i=0;i<100;i++){
    productRepository.save(new Product(null,"Hp",12369.87,(int)(Math.random()*100)));
}
      //  productRepository.save(new Product(null,"Hp",12369.87,(int)(Math.random()*100)));
       // productRepository.save(new Product(null,"Asus",198369.87,4));
       // productRepository.save(new Product(null,"Mac",22369.87,5));

        Page <Product> products= (Page<Product>) productRepository.findAll(PageRequest.of(1,5));
        System.out.println("total pages:"+products.getTotalPages());
        System.out.println("total elements:"+products.getTotalElements());
        System.out.println(" num pages :"+products.getNumber());
        List<Product>content =products.getContent();
        content.forEach(e->{
            System.out.println("================");
            System.out.println(e.getId());
            System.out.println(e.getName());
            System.out.println(e.getPrix());
            System.out.println(e.getQte());

        });
        System.out.println("********************");
        Product product=productRepository.findById(1L).orElse(null);
        if (product!=null){
            System.out.println(product.getName());
            System.out.println(product.getPrix());
            System.out.println(product.getQte());
        }

    }
}

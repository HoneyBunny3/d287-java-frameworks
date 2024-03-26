package com.example.demo.bootstrap;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

/*
        //Create and save part 1
        OutsourcedPart nip = new OutsourcedPart();
        nip.setCompanyName("Hearth's Kat Kingdom");
        nip.setName("Cat Nip");
        nip.setInv(15);
        nip.setPrice(12.0);
        nip.setId(101L);
        outsourcedPartRepository.save(nip);

        //Create and save part 2
        OutsourcedPart  treat = new OutsourcedPart();
        treat.setCompanyName("Hearth's Kat Kingdom");
        treat.setName("Treats");
        treat.setInv(25);
        treat.setPrice(8.0);
        treat.setId(102L);
        outsourcedPartRepository.save(treat);

        //Create and save part 3
        OutsourcedPart filter = new OutsourcedPart();
        filter.setCompanyName("Hearth's Kat Kingdom");
        filter.setName("Water Filter");
        filter.setInv(5);
        filter.setPrice(18.0);
        filter.setId(103L);
        outsourcedPartRepository.save(filter);

        //Create and save part 4
        OutsourcedPart toys = new OutsourcedPart();
        toys.setCompanyName("Hearth's Kat Kingdom");
        toys.setName("Toys");
        toys.setInv(50);
        toys.setPrice(5.0);
        toys.setId(104L);
        outsourcedPartRepository.save(toys);

        //Create and save part 5
        OutsourcedPart grooming = new OutsourcedPart();
        grooming.setCompanyName("Hearth's Kat Kingdom");
        grooming.setName("Brush");
        grooming.setInv(15);
        grooming.setPrice(45.0);
        grooming.setId(105L);
        outsourcedPartRepository.save(grooming);


        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
*/
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }
/*
        //Create 5 products
        Product tower = new Product("Tower",85.00,25);
        Product litter_box = new Product("Litter Box",45.0,50);
        Product food_bowl = new Product("Food Bowl",25.0,30);
        Product water_bowl = new Product("Water Bowl",15.0,45);
        Product treat_puzzle = new Product("Treat Puzzle",20.0,10);
        //Save 5 products
        productRepository.save(tower);
        productRepository.save(litter_box);
        productRepository.save(food_bowl);
        productRepository.save(water_bowl);
        productRepository.save(treat_puzzle);
*/


        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}

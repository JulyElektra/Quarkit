package rc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/crowdsales")
public class CrowdSaleController {
    UserRepository userRepository;
    CrowdSaleRepository crowdSaleRepository;

    public CrowdSaleController(UserRepository userRepository, CrowdSaleRepository crowdSaleRepository) {
        this.userRepository = userRepository;
        this.crowdSaleRepository = crowdSaleRepository;
    }

    @GetMapping("/all")
    public List<CrowdSale> getAll() {
        return crowdSaleRepository.findAll();
    }

    @GetMapping("/id")
    public CrowdSale getById(String id) {
        return crowdSaleRepository.findById(id).get();
    }
}

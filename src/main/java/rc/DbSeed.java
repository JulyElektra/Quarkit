package rc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class DbSeed implements CommandLineRunner {

    CrowdSaleRepository crowdSaleRepository;

    public DbSeed(CrowdSaleRepository crowdSaleRepository) {
        this.crowdSaleRepository = crowdSaleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User("Yuliya", "123", "jfdsk23m21m3k");
        User user2 = new User("Denis", "567", "wdflld2313l32l");


        HashMap<String, Integer> mapPaymentMethodTypeToRate = new HashMap<String, Integer>();
        HashMap<String, Integer> mapDaystoPercentTokensBonuses = new HashMap<String, Integer>();
        HashMap<String, Integer> mapAmounttoPercentTokensBonuses = new HashMap<String, Integer>();

        mapPaymentMethodTypeToRate.put("Eth", 130);
        mapDaystoPercentTokensBonuses.put("45", 45);
        mapAmounttoPercentTokensBonuses.put("200000", 68);

        CrowdSale crowdSale1 = new CrowdSale(user1,
                new Token("TokenICO", "icoshki", 323,true, false, "dsda88sad"),
                new Sale("saleNamehere", "01.01.2019", "30.01.2019", 1000000,
                        mapPaymentMethodTypeToRate, mapDaystoPercentTokensBonuses, mapAmounttoPercentTokensBonuses),
                "ICO fast", "icofast@dr.com" , "sdfsaf88fss");
        CrowdSale crowdSale2 = new CrowdSale(user2,
                new Token("ICO startap", "starteri", 3,false, true, "eff7sad"),
                new Sale("saleOne", "23.01.2019", "01.07.2019", 50000,
                        mapPaymentMethodTypeToRate, mapDaystoPercentTokensBonuses, mapAmounttoPercentTokensBonuses),
                "ICO startap", "startap@to.com" , "fkmks88");

        crowdSaleRepository.deleteAll();

        crowdSaleRepository.save(crowdSale1);
        crowdSaleRepository.save(crowdSale2);

    }
}

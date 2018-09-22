package rc;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Document(collection = "CrowdSale")
public class CrowdSale {

    //Token parameters
    @Id
    String id;

    // Accounts
    CrowdSaleOwner owner;
    List<Investor> investors;

    String tokenName;
    String tokenSymbol;
    int decimals;
    boolean pausable;
    boolean burnable;

    //Sale parameters
    String saleName;
    String startDate;
    String endDate;
    int saleCap;
    Map<String, Integer> mapPaymentMethodTypeToRate;
    Map<Integer, Integer> mapDaystoPercentTokensBonuses; // Time bonus
    Map<Integer, Integer> mapAmounttoPercentTokensBonuses;// Amount bonus

    //Marketing
    String projectName;
    String email;

    //Result info after crowdsale generation
    String tokenAddress;
    String crowdSaleAddress;
}

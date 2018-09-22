package rc;

import java.util.List;
import java.util.Map;

public class Investor extends User {

    public Investor(String name) {
        super(name);
    }

    Map<CrowdSale, Integer> crowdsalesToAmountofTokens;

}

package rc;

public class Token {
    //Token parameters
    String tokenName;
    String tokenSymbol;
    int decimals;
    boolean pausable;
    boolean burnable;

    //Result info after crowdsale generation
    String tokenAddress;

    public Token(String tokenName, String tokenSymbol, int decimals, boolean pausable, boolean burnable, String tokenAddress) {
        this.tokenName = tokenName;
        this.tokenSymbol = tokenSymbol;
        this.decimals = decimals;
        this.pausable = pausable;
        this.burnable = burnable;
        this.tokenAddress = tokenAddress;
    }

    public String getTokenName() {
        return tokenName;
    }

    public String getTokenSymbol() {
        return tokenSymbol;
    }

    public int getDecimals() {
        return decimals;
    }

    public boolean isPausable() {
        return pausable;
    }

    public boolean isBurnable() {
        return burnable;
    }

    public String getTokenAddress() {
        return tokenAddress;
    }
}

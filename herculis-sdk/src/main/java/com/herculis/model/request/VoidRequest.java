package com.herculis.model.request;

import com.herculis.model.Merchant;
import com.herculis.model.PGTransaction;

public class VoidRequest {

    private Merchant merchant;

    private PGTransaction pgTransaction;

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public PGTransaction getPgTransaction() {
        return pgTransaction;
    }

    public void setPgTransaction(PGTransaction pgTransaction) {
        this.pgTransaction = pgTransaction;
    }
}

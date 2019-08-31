package com.herculis.model;

public class PGTransaction {

    private String pgTranId;

    public PGTransaction(String pgTranId) {
        this.pgTranId = pgTranId;
    }

    public String getPgTranId() {
        return pgTranId;
    }

    public void setPgTranId(String pgTranId) {
        this.pgTranId = pgTranId;
    }
}

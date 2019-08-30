package com.herculis.contract;

public interface IFinancialTransaction<R, T> {

    T doTransaction(R request);

}

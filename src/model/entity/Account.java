package model.entity;

import model.exception.BusinessException;
import model.exception.ValidationDomainException;

public class Account {

    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(double amount){
        this.balance += amount;
    }

    public void withdraw(double amount) throws BusinessException {
        if(amount > withdrawLimit){
           throw new BusinessException("Withdraw error: The amount exceeds withdraw limit");
        }
        if(amount > balance){
           throw new BusinessException("Withdraw error: Not enough balance");
        }
        this.balance -= amount;
    }
}

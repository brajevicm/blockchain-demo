package com.brajevicm.blockchain;

public class Main {
  public static void main(String[] args) {
    Blockchain fakeCoin = new Blockchain(4, 10);
    fakeCoin.addTransaction(new Transaction("milos", "marko", 10));
    fakeCoin.addTransaction(new Transaction("milos", "nikola", 100));
    fakeCoin.addTransaction(new Transaction("marko", "jovan", 50));

    fakeCoin.minePendingTransactions("jovan");

    fakeCoin.addTransaction(new Transaction("milos", "marko", 10));
    fakeCoin.addTransaction(new Transaction("milos", "nikola", 100));
    fakeCoin.addTransaction(new Transaction("marko", "jovan", 50));

    fakeCoin.minePendingTransactions("milos");

    System.out.println(fakeCoin.toString());
    System.out.println(fakeCoin.printLatestBlock());
    System.out.println(fakeCoin.isValidChain() ? "true" : "false");
    fakeCoin.getLatestBlock().getTransactions().get(1).setAmount(100000000);
    System.out.println(fakeCoin.isValidChain() ? "true" : "false");
    System.out.println(fakeCoin.toString());
  }
}

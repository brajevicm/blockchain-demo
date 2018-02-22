package com.brajevicm.blockchain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@NoArgsConstructor
public class Blockchain {
  private static final int HASH_SIZE = 64;

  @Getter
  @Setter
  private List<Block> chain;

  @Getter
  @Setter
  private List<Transaction> pendingTransactions;

  @Getter
  @Setter
  private int numberOfZeroes;

  @Getter
  @Setter
  private int minerReward;

  public Blockchain(int numberOfZeroes, int minerReward) {
    this.numberOfZeroes = numberOfZeroes;
    this.minerReward = minerReward;
    initChains();
    addGenesisBlock();
  }

  private void initChains() {
    chain = new LinkedList<>();
    pendingTransactions = new ArrayList<>();
  }

  private void addGenesisBlock() {
    chain.add(new Block(
      new ArrayList<>(), String.join("", Collections.nCopies(HASH_SIZE, "0"))));
  }

  public void addTransaction(Transaction transaction) {
    pendingTransactions.add(transaction);
  }

  public String printLatestBlock() {
    return getLatestBlock().toString();
  }

  public Block getLatestBlock() {
    return chain.get(chain.size() - 1);
  }

  public void minePendingTransactions(String minerAddress) {
    Block block = new Block(pendingTransactions, getLatestBlock().getCurrentHash());
    block.mineBlock(numberOfZeroes);
    chain.add(block);
    pendingTransactions = new ArrayList<>();
  }

  public boolean isValidChain() {
    for (int i = 1; i < this.chain.size(); i++) {
      Block currentBlock = this.chain.get(i);
      Block previousBlock = this.chain.get(i - 1);

      if (!currentBlock.getCurrentHash().equals(currentBlock.calculateHash())) {
        return false;
      }

      if (!currentBlock.getPreviousHash().equals(previousBlock.getCurrentHash())) {
        return false;
      }
    }
    return true;
  }

  @Override
  public String toString() {
    return "Blockchain{" +
      "chain=" + chain.toString() +
      '}';
  }
}
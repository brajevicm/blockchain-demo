package com.brajevicm.blockchain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.*;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
public class Block {
  @Getter
  @Setter
  private Date timestamp;

  @Getter
  @Setter
  private List<Transaction> transactions;

  @Getter
  @Setter
  private int nonce;

  @Getter
  @Setter
  private String previousHash;

  @Getter
  @Setter
  private String currentHash;

  public Block(List<Transaction> transactions, String previousHash) {
    this.timestamp = new Date();
    this.transactions = transactions;
    this.previousHash = previousHash;
    this.currentHash = calculateHash();
    this.nonce = 0;
  }

  public void mineBlock(int numberOfZeroes) {
    String stringToMatch = String.join("", Collections.nCopies(numberOfZeroes, "0"));
    while (!this.currentHash.substring(0, numberOfZeroes).equals(stringToMatch))  {
      this.nonce++;
      this.currentHash = calculateHash();
    }

    System.out.println("Finished mining block: " + this.currentHash);
  }

  public String calculateHash() {
    String transactionsAsJson = new Gson().toJson(transactions);
    String toHash = this.timestamp + this.previousHash + this.nonce + transactionsAsJson;

    return DigestUtils.sha256Hex(toHash);
  }

  @Override
  public String toString() {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    return gson.toJson(this);
  }
}

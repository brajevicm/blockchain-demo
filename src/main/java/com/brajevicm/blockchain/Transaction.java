package com.brajevicm.blockchain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
public class Transaction {
  @Getter
  @Setter
  private String privateKey;

  @Getter
  @Setter
  private String fromAddress;

  @Getter
  @Setter
  private String toAddress;

  @Getter
  @Setter
  private String signature;

  @Getter
  @Setter
  private int amount;

  public Transaction(String fromAddress, String toAddress, int amount) {
    privateKey = "";
    this.fromAddress = fromAddress;
    this.toAddress = toAddress;
    this.amount = amount;
    signature = "";
  }

  public Transaction(String privateKey, String fromAddress, String toAddress, int amount) {
    this.privateKey = privateKey;
    this.fromAddress = fromAddress;
    this.toAddress = toAddress;
    this.amount = amount;
    signature = calculateSignature(privateKey, fromAddress);
  }

  private String calculateSignature(String privateKey, String publicKey) {
    return "";
  }
}

package com.brajevicm.blockchain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class Wallet {
  @Getter
  @Setter
  private int balance;

  @Getter
  @Setter
  private String privateKey;

  @Getter
  @Setter
  private String publicKey;
}

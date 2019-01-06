package com.example.bionic.lesson0306json.models;

import java.util.List;

public class HoundImages {

  private final String status;
  private final List<String> message;

  public HoundImages(String status, List<String> message) {
    this.status = status;
    this.message = message;
  }

  public List<String> getMessage() {
    return message;
  }

  public String getStatus() {
    return status;
  }
}

package project.maru.application.dto;

public enum ResponseStatus {
  SUCCESS("success"),
  FAIL("fail");

  private final String status;

  ResponseStatus(String status) {
    this.status = status;
  }

  public String getStatus() {
    return status;
  }
}

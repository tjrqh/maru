package project.maru.application.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Schema(description = "응답")
public class SimpleApiResponse<T> {

  @Schema(description = "성공/실패 여부")
  private ResponseStatus status;
  @Schema(description = "메시지")
  private String message;
  @Schema(description = "응답 데이터")
  private T data;

  public SimpleApiResponse(ResponseStatus status, String message, T data) {
    this.status = status;
    this.message = message;
    this.data = data;
  }

  public void setStatus(ResponseStatus status) {
    this.status = status;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public void setData(T data) {
    this.data = data;
  }
}

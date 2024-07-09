package project.maru.presentation.util;

import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ParseToken {

  private final CognitoJWTParser cognitoJWTParser;

  public String getParseToken(String accessToken) throws Exception {
    DecodedJWT cognitoToken = cognitoJWTParser.parseToken(accessToken);
    String sub = cognitoToken.getClaims().get("sub").toString();
    return sub.replaceAll("^\"|\"$", "");
  }

}

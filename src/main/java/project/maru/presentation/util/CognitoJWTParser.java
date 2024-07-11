package project.maru.presentation.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.RSAKeyProvider;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import io.github.cdimascio.dotenv.Dotenv;
import java.net.URL;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class CognitoJWTParser {

  private static final String JWKS_URL = Dotenv.load().get("JWKS_URL");

  public DecodedJWT parseToken(String token) throws Exception {
    String jwtToken = token.substring(7); // "Bearer " 이후의 토큰 값을 가져옴

    // 토큰 전처리
    token = jwtToken.trim();

    // 토큰 형식 검증
    if (!token.matches("^[A-Za-z0-9-_=]+\\.[A-Za-z0-9-_=]+\\.[A-Za-z0-9-_.+/=]+$")) {
      throw new IllegalArgumentException("Invalid token format");
    }

    URL jwksUrl = new URL(JWKS_URL);
    JWKSet jwkSet = JWKSet.load(jwksUrl);
    List<JWK> jwks = jwkSet.getKeys();

    DecodedJWT jwt;
    try {
      jwt = JWT.decode(token);
    } catch (JWTDecodeException e) {
      System.out.println("Failed to decode token: " + e.getMessage());
      throw e;
    }

    String keyId = jwt.getKeyId();

    RSAKeyProvider keyProvider = new RSAKeyProvider() {
      @Override
      public RSAPublicKey getPublicKeyById(String keyId) {
        for (JWK jwk : jwks) {
          if (jwk.getKeyID().equals(keyId)) {
            try {
              return ((RSAKey) jwk).toRSAPublicKey();
            } catch (JOSEException e) {
              throw new RuntimeException(e);
            }
          }
        }
        return null;
      }

      @Override
      public RSAPrivateKey getPrivateKey() {
        return null;
      }

      @Override
      public String getPrivateKeyId() {
        return null;
      }
    };

    Algorithm algorithm = Algorithm.RSA256(keyProvider);
    try {
      JWT.require(algorithm).build().verify(token);
    } catch (Exception e) {
      System.out.println("Token verification failed: " + e.getMessage());
      throw e;
    }

    return jwt;
  }
}
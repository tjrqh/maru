package project.maru.presentation.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.RSAKeyProvider;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;

import java.net.URL;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.List;

public class CognitoJWTParser {

    private static final String JWKS_URL = "https://cognito-idp.{region}.amazonaws.com/{userPoolId}/.well-known/jwks.json";

    public DecodedJWT parseToken(String token) throws Exception {
        URL jwksUrl = new URL(JWKS_URL);
        JWKSet jwkSet = JWKSet.load(jwksUrl);
        List<JWK> jwks = jwkSet.getKeys();

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
                return null; // Not needed for verification
            }

            @Override
            public String getPrivateKeyId() {
                return null; // Not needed for verification
            }
        };

        DecodedJWT jwt = JWT.require(Algorithm.RSA256(keyProvider)).build().verify(token);
        return jwt;
    }
}
package com.epam.authservicejwt.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.epam.authservicejwt.exception.InvalidTokenException;

@Service
public class TokenService {

	//authentication
	public boolean authentication(String token) {
		if (token != null && token.startsWith("Bearer ")) {
			token = token.substring(7);
			try {
				Algorithm algorithm = Algorithm.HMAC256("ajeetsecret");
				JWTVerifier jwtVerifier = JWT.require(algorithm).build();
				jwtVerifier.verify(token);
				return true;
			} catch (Exception message) {
				throw new InvalidTokenException(message.getMessage());
			}
		}
		return true;
	}

	public String successToken(String username) {
		Algorithm algorithm = Algorithm.HMAC256("ajeetsecret");
		return JWT.create().withSubject(username).withExpiresAt(new Date(System.currentTimeMillis() + 5 * 60 * 1000))
				.withClaim("USER_ROLE", true).sign(algorithm);
	}

}

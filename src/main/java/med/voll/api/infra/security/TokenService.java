package med.voll.api.infra.security;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import med.voll.api.domain.usuarios.Usuario;
import org.apache.logging.log4j.CloseableThreadContext;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    public String generarToken(Usuario usuario){
        try {
            Algorithm algorithm = Algorithm.HMAC256("123456");
            return JWT.create()
                    .withIssuer("voll med")  //el que lo emite
                    .withSubject(usuario.getLogin()) //a quien va digirido
                    .withClaim("id:", usuario.getId())
                    .withExpiresAt(generarFechaExpiracion())
                    .sign(algorithm);
        }catch (JWTCreationException exception){
            throw new RuntimeException();
        }
    }

    public String getSubject(String token) {
        if (token == null){
            throw new RuntimeException();
        }

        DecodedJWT verifier = null;

        try {
            Algorithm algorithm = Algorithm.HMAC256("123456"); //validando la firma
            verifier = JWT.require(algorithm)
                    .withIssuer("voll med")
                    .build()
                    .verify(token);
            verifier.getSubject();
        }catch (JWTCreationException exception){
            System.out.println(exception.toString());
        }

        if (verifier.getSubject() == null){
            throw new RuntimeException("Verifier invalido");
        }

        return verifier.getSubject();
    }
    private Instant generarFechaExpiracion() {
        return LocalDateTime.now().plusHours(24).toInstant(ZoneOffset.of("-05:00"));
    }


}

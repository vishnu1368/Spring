package com.project.oAuth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/")
    public String hello(){
        return "Hello User!";
    }
}
/*
header.payload.signature
=> base64UrlEncode(header).base64UrlEncode(payload).HMACSHA256(base64UrlEncode(header) + "." + base64UrlEncode(payload), secret_key)
signature = HMACSHA256(base64UrlEncode(header) + "." + base64UrlEncode(payload), secret_key)

So, if the user tries to change the payload not the signature then the recomputed signature won't match with the JWT signature.
header.modifiedPayload.signature

base64UrlEncode(header) + "." + base64UrlEncode(payload)

HMACSHA256(header.modifiedPayload, secret_key)

Where JWT Typically Appears in 3rd-Party Systems?
    Case 1: Your System Calling Stripe (Server → Stripe)
    Stripe does NOT use JWT for API authentication.
    Instead, they use:
        Static API keys (sk_live_xxx)
        OAuth (for Stripe Connect)
    So in this direction, JWT is not required.

    Case 2: Stripe Calling You (Webhooks)
    This is where security matters most.
    After payment succeeds, Stripe sends a webhook:
    Stripe signs the webhook using a signing secret.
    Your server:
        Receives event
        Uses webhook secret
        Verifies signature
        Only then processes order

⚠️ This is conceptually similar to JWT signature verification, but Stripe uses its own HMAC header format — not a JWT token.
 */

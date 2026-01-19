# Spring session cookie

Start the application:

```shell
./mvnw spring-boot:run
```

Perform a request:

```shell
http :8080
```

Despite configuring `server.servlet.session.cookie.same-site=none`, the session cookie has `SameSite: Lax`.

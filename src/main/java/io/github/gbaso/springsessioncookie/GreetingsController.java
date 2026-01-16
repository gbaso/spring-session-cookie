package io.github.gbaso.springsessioncookie;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class GreetingsController {

  @GetMapping
  String hello(HttpServletRequest request) {
    HttpSession session = request.getSession(true);
    return "Hello %s!".formatted(session.getId());
  }

}

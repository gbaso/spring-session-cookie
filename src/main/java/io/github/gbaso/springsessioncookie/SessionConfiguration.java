package io.github.gbaso.springsessioncookie;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.MapSession;
import org.springframework.session.MapSessionRepository;
import org.springframework.session.Session;
import org.springframework.session.SessionRepository;
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;

@Configuration(proxyBeanMethods = false)
@EnableSpringHttpSession
class SessionConfiguration {

  @Bean
  SessionRepository<MapSession> sessionRepository() {
    Map<String, Session>  mapSessions = new ConcurrentHashMap<>();
    return new MapSessionRepository(mapSessions);
  }

}

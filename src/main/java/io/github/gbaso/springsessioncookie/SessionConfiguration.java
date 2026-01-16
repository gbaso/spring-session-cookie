package io.github.gbaso.springsessioncookie;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.MapSession;
import org.springframework.session.SessionRepository;
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;

@Configuration(proxyBeanMethods = false)
@EnableSpringHttpSession
class SessionConfiguration {

  @Bean
  SessionRepository<MapSession> sessionRepository() {
    return new MapSessionRepository();
  }

  static class MapSessionRepository implements SessionRepository<MapSession> {

    private final Map<String, MapSession> sessions = new ConcurrentHashMap<>();

    @Override
    public MapSession createSession() {
      return new MapSession();
    }

    @Override
    public void save(MapSession session) {
      sessions.put(session.getId(), session);
    }

    @Override
    public MapSession findById(String id) {
      return sessions.get(id);
    }

    @Override
    public void deleteById(String id) {
      sessions.remove(id);
    }
  }

}

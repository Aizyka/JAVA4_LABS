package home.masterserver.config;

import home.masterserver.model.UserProfile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Component
public class SecretsCache {

    private final ConcurrentMap<Long, String> cache = new ConcurrentHashMap<>();

    public void put(Long id, String secret) {
        cache.put(id, secret);
    }

    public String get(Long id) {
        return cache.get(id);
    }

    public boolean contains(Long id) {
        return cache.containsKey(id);
    }

    public void remove(Long id) {
        cache.remove(id);
    }

    public void clear() {
        cache.clear();
    }

    public List<String> getAllSecrets() {
        return new ArrayList<>(cache.values());
    }

    public void putAllSecrets(List<UserProfile> profiles) {
        profiles.forEach(profile -> cache.put(profile.getId(), profile.getSecret()));
    }
}
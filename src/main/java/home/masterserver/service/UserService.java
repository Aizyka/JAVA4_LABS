package home.masterserver.service;

import home.masterserver.model.*;
import home.masterserver.repository.*;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserProfileRepository userProfileRepository;
    private final PlatformRepository platformRepository;
    private final RegionRepository regionRepository;

    public UserService(UserRepository userRepository, UserProfileRepository userProfileRepository, PlatformRepository platformRepository, RegionRepository regionRepository) {
        this.userRepository = userRepository;
        this.userProfileRepository = userProfileRepository;
        this.platformRepository = platformRepository;
        this.regionRepository = regionRepository;
    }

    public User getUser(String login, String password) {
        return userRepository.findByLoginAndPassword(login, password);
    }
    public UserProfile getUserProfile(String secret) {
        return userProfileRepository.findBySecret(secret);
    }
    public Platform getPlatform(String platform) {
        return platformRepository.findByPlatform(platform);
    }
    public Region getRegion(String region) {
        return regionRepository.findByRegion(region);
    }

    public boolean existsUser(String login) {
        return userRepository.existsByLogin(login);
    }
    public boolean existsUser(String login, String password) {
        return userRepository.existsByLoginAndPassword(login, password);
    }
    public boolean existUserProfile(String secret) {
        return userProfileRepository.existsBySecret(secret);
    }
    public boolean existsPlatform(String platform) {
        return platformRepository.existsByPlatform(platform);
    }
    public boolean existsRegion(String region) { return regionRepository.existsByRegion(region); }

    public void save(User user) {
        userRepository.save(user);
    }
    public void save(UserProfile userProfile) {
        userProfileRepository.save(userProfile);
    }
    public void delete(User user) {
        userRepository.delete(user);
    }
}

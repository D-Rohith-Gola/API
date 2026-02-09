package com.npci.upi.user;

import com.npci.upi.entity.UserProfile;

public interface UserProfileService {
    UserProfile getUser(String userId);
}
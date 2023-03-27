package com.usermanager.usermanager.Helper;

import com.usermanager.usermanager.model.User;
import com.usermanager.usermanager.request.Payload;
import com.usermanager.usermanager.request.UserManagerRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class Helper {


    public User getUserDetails(UserManagerRequest userManagerRequest){

        Payload payload = userManagerRequest.getPayload();
        if (payload == null) {
            throw new IllegalArgumentException("Payload must not be null");
        }

        User user = new User();
        //String[] ignoreProperties = {"userId"};
        //BeanUtils.copyProperties(payload, user, ignoreProperties);
        BeanUtils.copyProperties(payload, user);
        return user;

    }
}

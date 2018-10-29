package com.sk.learn.birthday.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sk.learn.birthday.domain.Invitation;
import com.sk.learn.birthday.feign.InvitationFeignClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * Created by sk on 28/10/18.
 */
public class BirthdayServiceImpl implements BirthdayService {

    @Autowired
    InvitationFeignClient invitationFeignClient;


    @HystrixCommand(fallbackMethod = "defaultInvitation")
    public Object sendInvitation(Invitation invitation) {

        return "Invitation sent";
    }

    public String defaultInvitation(Map<String, Object> parameters) {
        return "You and your family are invited for the birthday party. We will contact you soon";
    }
}

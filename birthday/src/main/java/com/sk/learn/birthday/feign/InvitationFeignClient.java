package com.sk.learn.birthday.feign;

import com.sk.learn.birthday.domain.Invitation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by sk on 28/10/18.
 */

@FeignClient(name = "/invitation", configuration = FeignConfiguration.class)
public interface InvitationFeignClient {

    @RequestMapping(method = RequestMethod.POST, path = "/send")
    ResponseEntity sendInvitation(Invitation invitation);


}

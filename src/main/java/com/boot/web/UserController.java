package com.boot.web;

import com.boot.util.RenderJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.boot.domain.User;
import com.boot.service.UserService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;

/*@CrossOrigin(origins = {"http://localhost:666", "null"})*/
@Controller
@RestController
public class UserController {
	@Autowired 
	private UserService userService;

    @RequestMapping(value = "/aaa", method = RequestMethod.GET)
	public RenderJson getIndex(){
        Object user = userService.selectUserById(1);
        return RenderJson.Ok("1", "success", user);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public RenderJson getUsers(){
        List<User> userList = userService.getAllUsers();
        return RenderJson.Ok("1", "success", userList);
    }

}

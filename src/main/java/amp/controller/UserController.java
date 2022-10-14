package amp.controller;

import amp.dto.*;
import amp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Response<LoginResponse>> login(@RequestBody LoginRequest loginRequest, HttpServletRequest request) {
        return new ResponseEntity<>(new Response<LoginResponse>().build()
                .setMessage(userService.login(loginRequest))
                .setPath(request.getRequestURI()), OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Response<RegisterResponse>> register(@RequestBody RegisterRequest registerRequest,HttpServletRequest request){
        return new ResponseEntity<>(new Response<RegisterResponse>().build()
                .setMessage(userService.register(registerRequest))
                .setPath(request.getRequestURI()), OK);
    }
}

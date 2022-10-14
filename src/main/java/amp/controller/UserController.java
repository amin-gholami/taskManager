package amp.controller;

import amp.common.dto.*;
import amp.common.dto.request.LoginRequest;
import amp.common.dto.request.RegisterRequest;
import amp.common.dto.response.LoginResponse;
import amp.common.dto.response.RegisterResponse;
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
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Response<LoginResponse>> login(@RequestBody LoginRequest loginRequest, HttpServletRequest request) {
        return new ResponseEntity<>(new Response<LoginResponse>().build()
                .setMessage(userService.login(loginRequest))
                .setPath(request.getRequestURI()), OK);
    }

    @PostMapping("/signUp")
    public ResponseEntity<Response<RegisterResponse>> register(@RequestBody RegisterRequest registerRequest, HttpServletRequest request){
        return new ResponseEntity<>(new Response<RegisterResponse>().build()
                .setMessage(userService.register(registerRequest))
                .setPath(request.getRequestURI()), OK);
    }
}

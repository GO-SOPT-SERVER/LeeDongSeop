package sopt.org.SecondSeminar.controller.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sopt.org.SecondSeminar.controller.user.dto.request.RegisterRequestDto;
import sopt.org.SecondSeminar.service.user.UserService;

import static sopt.org.SecondSeminar.SecondSeminarApplication.userList;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public String register(@RequestBody final RegisterRequestDto request) {
//        System.out.println("이름: " + request.getName());
//        System.out.println("나이: " + request.getAge());
//        System.out.println("주소: " + request.getAddress());
//        System.out.println("성별: " + request.getGender());

        // 서비스 계층에 유저를 등록하는 메서드를 호출
        Long userId = userService.register(request);
        System.out.println(userList.get(userId.intValue() - 1).toString());

        return userId + "번 유저가 등록되었습니다!";
    }

    @GetMapping("/user/{userId}")
    public String getOneUser(@PathVariable final Long userId) {
        System.out.println("요청 유저 아이디: " + userId);

        // 서비스 계층에서 유저 아이디로 유저를 찾는 메서드 호출

        return "유저 조회 성공";
    }

    @GetMapping("/user/search")
    public String searchUser(@RequestParam final String name) {
        System.out.println("유저 이름 검색 인자: " + name);

        // 서비스 계층에서 유저 닉네임으로 유저를 찾는 메서드 호출

        return "유저 검색 성공";
    }
}

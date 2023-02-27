package practice.rn.toy.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import practice.rn.toy.config.BaseResponse;
import practice.rn.toy.dto.GetMemberResponse;
import practice.rn.toy.service.MemberService;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/member/{memberId}")
    public BaseResponse<GetMemberResponse> getMemberInfo(@PathVariable(name="memberId")Long memberId){
        GetMemberResponse response=memberService.getMemberInfo(memberId);

        return new BaseResponse<>(response);
    }
}

package practice.rn.toy.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import practice.rn.toy.dto.GetMemberResponse;
import practice.rn.toy.entity.Member;
import practice.rn.toy.repository.MemberRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public GetMemberResponse getMemberInfo(Long memberId){
        Member member=memberRepository.findById(memberId).get();

        return new GetMemberResponse(member.getId(),member.getGroupList(),member.getName(),member.getEmail());
    }
}

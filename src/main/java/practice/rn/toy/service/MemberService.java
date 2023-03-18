package practice.rn.toy.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import practice.rn.toy.dto.GetMemberResponse;
import practice.rn.toy.dto.MemberGroupResponse;
import practice.rn.toy.entity.Member;
import practice.rn.toy.entity.MemberGroup;
import practice.rn.toy.repository.MemberRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public GetMemberResponse getMemberInfo(Long memberId){
        Member member=memberRepository.findById(memberId).get();
//        log.info("groupListSize: {}",member.getGroupList().get(0).getGroup().getTitle());
        List<MemberGroup> memberGroupList=member.getGroupList();
        List<MemberGroupResponse> memberGroupResponseList=new ArrayList<>();
        for(MemberGroup mg: memberGroupList){
            MemberGroupResponse memberGroupResponse=new MemberGroupResponse(mg.getGroup().getId(),mg.getGroup().getTitle());
            memberGroupResponseList.add(memberGroupResponse);
        }

        return new GetMemberResponse(member.getId(),memberGroupResponseList,member.getName(),member.getEmail());
    }
}

package practice.rn.toy.dto;

import lombok.Data;
import practice.rn.toy.entity.Group;
import practice.rn.toy.entity.MemberGroup;

import java.util.List;

@Data
public class GetMemberResponse {
    private Long memberId;
    private String name;
    private String email;
    private List<MemberGroupResponse> groupList;

    public GetMemberResponse(Long id, List<MemberGroupResponse> groupList, String name, String email) {
        this.memberId=id;
        this.name=name;
        this.email=email;
        this.groupList=groupList;
    }
}

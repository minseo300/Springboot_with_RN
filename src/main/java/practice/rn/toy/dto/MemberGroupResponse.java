package practice.rn.toy.dto;

import lombok.Data;

@Data
public class MemberGroupResponse {
    private Long groupId;
    private String groupTitle;


    public MemberGroupResponse(Long id, String title) {
        this.groupId=id;
        this.groupTitle=title;
    }
}

package practice.rn.toy.dto;

import lombok.Data;

import java.util.List;

@Data
public class GetGroupResponse {
    private Long groupId;
    private String title;
    private List<GetMeetingResponse> meetingList;
}

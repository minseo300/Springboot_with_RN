package practice.rn.toy.dto;

import lombok.Data;

@Data
public class GetMeetingResponse {
    private Long meetingId;
    private String date;
    private String title;

    public GetMeetingResponse(Long id, String date, String title) {
        this.meetingId=id;
        this.date=date;
        this.title=title;
    }
}

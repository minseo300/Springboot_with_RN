package practice.rn.toy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.rn.toy.dto.GetGroupResponse;
import practice.rn.toy.dto.GetMeetingResponse;
import practice.rn.toy.entity.Group;
import practice.rn.toy.entity.Meeting;
import practice.rn.toy.repository.GroupRepository;
import practice.rn.toy.repository.MeetingRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;
    private final MeetingRepository meetingRepository;
    public GetGroupResponse getGroupInfo(Long groupId){
        Group group=groupRepository.findById(groupId).get();
        List<Meeting> meetings=meetingRepository.findAllByGroup_Id(groupId);
        List<GetMeetingResponse> meetingList=new ArrayList<>();
        for(Meeting m:meetings){
            GetMeetingResponse meetingResponse=new GetMeetingResponse(m.getId(),m.getDate(),m.getTitle());
            meetingList.add(meetingResponse);
        }
        GetGroupResponse response=new GetGroupResponse();
        response.setGroupId(group.getId());
        response.setTitle(group.getTitle());
        response.setMeetingList(meetingList);

        return response;
    }
}

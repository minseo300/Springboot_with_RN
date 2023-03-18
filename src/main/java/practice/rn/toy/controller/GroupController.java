package practice.rn.toy.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import practice.rn.toy.config.BaseResponse;
import practice.rn.toy.dto.GetGroupResponse;
import practice.rn.toy.dto.GetMemberResponse;
import practice.rn.toy.service.GroupService;

@RestController
@RequiredArgsConstructor
public class GroupController {
    private final GroupService groupService;

    @Operation(summary = "그룹 정보 요청", description = "그룹 정보가 조회됩니다.", tags = { "Group Controller" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(schema = @Schema(implementation = GetGroupResponse.class))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @GetMapping("/v1/group/{groupId}")
    public BaseResponse<GetGroupResponse> getGroupInfo(@PathVariable(name="groupId")Long groupId){
        GetGroupResponse response=groupService.getGroupInfo(groupId);

        return new BaseResponse<>(response);
    }
}

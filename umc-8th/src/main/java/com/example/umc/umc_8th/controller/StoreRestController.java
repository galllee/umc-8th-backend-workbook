package com.example.umc.umc_8th.controller;

import com.example.umc.umc_8th.apiPayload.ApiResponse;
import com.example.umc.umc_8th.converter.StoreConverter;
import com.example.umc.umc_8th.domain.Mission;
import com.example.umc.umc_8th.domain.Review;
import com.example.umc.umc_8th.domain.Store;
import com.example.umc.umc_8th.domain.mapping.AcceptedMission;
import com.example.umc.umc_8th.dto.request.StoreRequestDTO;
import com.example.umc.umc_8th.dto.response.StoreResponseDTO;
import com.example.umc.umc_8th.service.store.StoreCommandService;
import com.example.umc.umc_8th.service.store.StoreQueryService;
import com.example.umc.umc_8th.validation.annotation.ExistStore;
import com.example.umc.umc_8th.validation.annotation.NotAlreadyAccepted;
import com.example.umc.umc_8th.validation.annotation.PageParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/stores")
public class StoreRestController {
    private final StoreCommandService storeCommandService;
    private final StoreQueryService storeQueryService;

    //지역에 가게 추가
    @PostMapping("/")
    public ApiResponse<StoreResponseDTO.CreateStoreDTO> createStore(@RequestBody @Valid StoreRequestDTO.CreateStoreDTO request) {
        Store store = storeCommandService.createStore(request);

        return ApiResponse.onSuccess(StoreConverter.toCreateStoreDTO(store));
    }

    //가게에 리뷰 추가
    @PostMapping("{storeId}/reviews")
    public ApiResponse<StoreResponseDTO.CreateReviewDTO> createReview(@RequestBody @Valid StoreRequestDTO.CreateReviewDTO request, @PathVariable @ExistStore Long storeId) {
        Review review = storeCommandService.createReview(request, storeId);

        return ApiResponse.onSuccess(StoreConverter.toCreateReviewDTO(review));
    }

    //가게에 미션 추가
    @PostMapping("{storeId}/missions")
    public ApiResponse<StoreResponseDTO.CreateMissionDTO> createMission(@RequestBody @Valid StoreRequestDTO.CreateMissionDTO request, @PathVariable @ExistStore Long storeId) {
        Mission mission = storeCommandService.createMission(request, storeId);

        return ApiResponse.onSuccess(StoreConverter.toCreateMissionDTO(mission));
    }
    //가게의 미션을 도전 중인 미션에 추가 (미션 도전하기)
    @PostMapping("/missions/{missionId}") // storeId가 필요할까? missioncontroller로 독립해도 괜찮을듯
    public ApiResponse<StoreResponseDTO.AcceptMissionDTO> acceptMission(@RequestBody @Valid StoreRequestDTO.AcceptMissionDTO request, @PathVariable @NotAlreadyAccepted Long missionId) {
        AcceptedMission acceptedMission = storeCommandService.createAcceptedMission(request, missionId);

        return ApiResponse.onSuccess(StoreConverter.toAcceptMissionDTO(acceptedMission));
    }

    // 리뷰 목록 조회 api
    @GetMapping("/{storeId}/reviews")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API", description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access 토큰 모양이 이상함", content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!")
    })
    public ApiResponse<StoreResponseDTO.ReviewPreviewListDTO> getReviewList(@ExistStore @PathVariable(name = "storeId") Long storeId, @PageParam Integer page) {
        Page<Review> reviewList = storeQueryService.getReviewList(storeId, page);
        return ApiResponse.onSuccess(StoreConverter.toReviewPreviewListDTO(reviewList));
    }

    // 내가(특정 사용자가) 작성한 리뷰 목록 조회 api
    @GetMapping("/{storeId}/users/{userId}/reviews")
    @Operation(summary = "특정 가게의 내가 작성한 리뷰 목록 조회 API", description = "특정 가게에서 특정 사용자가 작성한 리뷰 목록을 조회하는 API이며, 페이징을 포함합니다. query String으로 page 번호를, path param으로 storeId와 userId를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access 토큰 모양이 이상함", content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!", in = ParameterIn.PATH),
            @Parameter(name = "userId", description = "사용자 아이디, path variable 입니다!", in = ParameterIn.PATH)
    })
    public ApiResponse<StoreResponseDTO.ReviewPreviewListDTO> getReviewListByUserId(
            @ExistStore @PathVariable(name = "storeId") Long storeId,
            @PathVariable(name = "userId") Long userId,
            @PageParam Integer page) {
        Page<Review> reviewList = storeQueryService.getReviewListByUserId(storeId, userId, page);
        return ApiResponse.onSuccess(StoreConverter.toReviewPreviewListDTO(reviewList));
    }

    // 특정 가게의 미션 목록
    @GetMapping("/{storeId}/missions")
    @Operation(summary = "특정 가게의 미션 목록 조회 API", description = "특정 가게의 미션 목록을 조회하는 API이며, 페이징을 포함합니다. query String으로 page 번호를, path param으로 storeId를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access 토큰 모양이 이상함", content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!", in = ParameterIn.PATH)
    })
    public ApiResponse<StoreResponseDTO.MissionPreviewListDTO> getMissionListByStoreId(
            @ExistStore @PathVariable(name = "storeId") Long storeId,
            @PageParam Integer page) {
        Page<Mission> missionList = storeQueryService.getMissionListByStoreId(storeId, page);
        return ApiResponse.onSuccess(StoreConverter.toMissionPreviewListDTO(missionList));
    }
}

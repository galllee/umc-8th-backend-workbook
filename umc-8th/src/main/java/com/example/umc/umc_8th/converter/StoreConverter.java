package com.example.umc.umc_8th.converter;

import com.example.umc.umc_8th.domain.*;
import com.example.umc.umc_8th.domain.mapping.AcceptedMission;
import com.example.umc.umc_8th.domain.FoodCategory;
import com.example.umc.umc_8th.domain.Mission;
import com.example.umc.umc_8th.domain.Region;
import com.example.umc.umc_8th.domain.Store;
import com.example.umc.umc_8th.domain.*;
import com.example.umc.umc_8th.dto.request.StoreRequestDTO;
import com.example.umc.umc_8th.dto.response.StoreResponseDTO;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class StoreConverter {

    public static StoreResponseDTO.CreateStoreDTO toCreateStoreDTO(Store store) {
        return StoreResponseDTO.CreateStoreDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Store toStore(StoreRequestDTO.CreateStoreDTO request, Region region, FoodCategory foodCategory) {
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .region(region)
                .foodCategory(foodCategory)
                .build();
    }


    public static StoreResponseDTO.CreateMissionDTO toCreateMissionDTO(Mission mission) {
        return StoreResponseDTO.CreateMissionDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static StoreResponseDTO.CreateReviewDTO toCreateReviewDTO(Review review) {
        return StoreResponseDTO.CreateReviewDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(StoreRequestDTO.CreateMissionDTO request, Store store) {
        return Mission.builder()
                .point(request.getPoint())
                .deadline(request.getDeadline())
                .store(store)
                .detail(request.getDetail())
                .build();
    }

    public static Review toReview(StoreRequestDTO.CreateReviewDTO request, Store store, User user) {
        return Review.builder()
                .user(user)
                .store(store)
                .score(request.getScore())
                .body(request.getBody())
                .build();
    }

    public static StoreResponseDTO.AcceptMissionDTO toAcceptMissionDTO(AcceptedMission acceptedMission) {
        return StoreResponseDTO.AcceptMissionDTO.builder()
                .acceptedMissionId(acceptedMission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static AcceptedMission toAcceptedMission(StoreRequestDTO.AcceptMissionDTO request, User user, Mission mission) {
        return AcceptedMission.builder()
                .user(user)
                .mission(mission)
                .build();
    }

    public static StoreResponseDTO.ReviewPreviewDTO toReviewPreviewDTO(Review review) {
        return StoreResponseDTO.ReviewPreviewDTO.builder()
                .ownerNickname(review.getUser().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }

    public static StoreResponseDTO.ReviewPreviewListDTO toReviewPreviewListDTO(Page<Review> reviewList) {
        List<StoreResponseDTO.ReviewPreviewDTO> reviewPreviewDTOList = reviewList.stream()
                .map(StoreConverter::toReviewPreviewDTO).collect(Collectors.toList());

        return StoreResponseDTO.ReviewPreviewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreviewDTOList.size())
                .reviewList(reviewPreviewDTOList)
                .build();
    }

    public static StoreResponseDTO.MissionPreviewDTO toMissionPreviewDTO(Mission mission) {
        return StoreResponseDTO.MissionPreviewDTO.builder()
                .storeName(mission.getStore().getName())
                .point(mission.getPoint())
                .detail(mission.getDetail())
                .build();
    }

    public static StoreResponseDTO.MissionPreviewListDTO toMissionPreviewListDTO(Page<Mission> missionList) {
        List<StoreResponseDTO.MissionPreviewDTO> missionPreviewDTOList = missionList.stream()
                .map(StoreConverter::toMissionPreviewDTO).collect(Collectors.toList());

        return StoreResponseDTO.MissionPreviewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreviewDTOList.size())
                .missionList(missionPreviewDTOList)
                .build();
    }

    public static StoreResponseDTO.MissionPreviewByUserDTO toMissionPreviewByUserDTO(AcceptedMission acceptedMission) {
        return StoreResponseDTO.MissionPreviewByUserDTO.builder()
                .storeName(acceptedMission.getMission().getStore().getName())
                .point(acceptedMission.getMission().getPoint())
                .detail(acceptedMission.getMission().getDetail())
                .status(acceptedMission.getStatus())
                .build();
    }

    public static StoreResponseDTO.MissionPreviewByUserListDTO toMissionPreviewByUserListDTO(Page<AcceptedMission> missionList) {
        List<StoreResponseDTO.MissionPreviewByUserDTO> missionPreviewDTOList = missionList.stream()
                .map(StoreConverter::toMissionPreviewByUserDTO).collect(Collectors.toList());

        return StoreResponseDTO.MissionPreviewByUserListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreviewDTOList.size())
                .missionList(missionPreviewDTOList)
                .build();
    }
}

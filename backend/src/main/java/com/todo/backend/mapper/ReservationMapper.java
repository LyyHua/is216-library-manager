package com.todo.backend.mapper;

import com.todo.backend.dto.reservation.CreateReservationDto;
import com.todo.backend.dto.reservation.ResponseReservationDto;
import com.todo.backend.dto.reservation.UpdateReservationDto;
import com.todo.backend.entity.BookTitle;
import com.todo.backend.entity.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservationMapper {
    Reservation toEntity(CreateReservationDto createReservationDto);
    CreateReservationDto toDto(Reservation reservation);

    Reservation toEntity(UpdateReservationDto updateReservationDto);
    UpdateReservationDto toUpdateDto(Reservation reservation);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(UpdateReservationDto updateReservationDto, @MappingTarget Reservation reservation);

    @Mapping(target = "bookTitle", source = "bookTitle")
    @Mapping(target = "bookAuthors", ignore = true)
    ResponseReservationDto toResponseDto(Reservation reservation);
    List<ResponseReservationDto> toResponseDtoList(List<Reservation> reservations);
    
    // Helper method to map BookTitle object to String
    default String map(BookTitle bookTitle) {
        return bookTitle != null ? bookTitle.getTitle() : null;
    }
}

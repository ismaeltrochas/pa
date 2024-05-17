package com.fastlearn.course.infrastructure.rest.controller.mapper.response;

import com.fastlearn.course.domain.model.dto.FileUploadDTO;
import com.fastlearn.course.infrastructure.rest.controller.dto.response.VideoResponse;
import com.fastlearn.course.shared.mapper.EntityToDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VideoResponseDTOMapper extends EntityToDto<FileUploadDTO, VideoResponse> {
}

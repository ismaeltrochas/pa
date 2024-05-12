package com.fastlearn.mediauploader.infrastructure.jpa.repository;

import com.fastlearn.mediauploader.domain.model.FileUpload;
import com.fastlearn.mediauploader.infrastructure.jpa.entity.FileUploadEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileUploadRepository extends JpaRepository<FileUploadEntity, Long> {

  FileUploadEntity findByCourseId(Long id);

  List<FileUploadEntity> findAllByCourseId(Long courseId);


}

package com.fastlearn.mediauploader;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediaUploaderRepository extends JpaRepository<FileUpload, String> {

  FileUpload findByCourseId(Long id);

  List<FileUpload> findAllByCourseId(Long courseId);
}

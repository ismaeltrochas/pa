package com.fastlearn.mediauploader;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediaUploaderRepository extends JpaRepository<FileUpload, String> {

  FileUpload findByCourseId(Long id);
}

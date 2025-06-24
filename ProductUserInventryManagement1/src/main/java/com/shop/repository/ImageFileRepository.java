package com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entity.ImageFile;

public interface ImageFileRepository extends JpaRepository<ImageFile,Long> {

}

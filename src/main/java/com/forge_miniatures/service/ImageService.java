package com.forge_miniatures.service;

import com.forge_miniatures.entity.ArticleImage;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {
    ArticleImage uploadImage(Long articleId, MultipartFile file) throws IOException;
}

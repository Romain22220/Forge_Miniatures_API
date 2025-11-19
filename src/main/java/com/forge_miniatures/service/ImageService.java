package com.forge_miniatures.service;

import com.forge_miniatures.dto.ArticleImageDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {
    ArticleImageDTO uploadImage(Long articleId, MultipartFile file) throws IOException;
}

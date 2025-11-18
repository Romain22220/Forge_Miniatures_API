package com.forge_miniatures.service;

import com.forge_miniatures.entity.Article;
import com.forge_miniatures.entity.ArticleImage;
import com.forge_miniatures.repository.ArticleImageRepository;
import com.forge_miniatures.repository.ArticleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class ImageServiceImpl implements  ImageService{


    private final ArticleRepository articleRepository;
    private final ArticleImageRepository articleImageRepository;

    public ImageServiceImpl(ArticleRepository articleRepository, ArticleImageRepository articleImageRepository) {
        this.articleRepository = articleRepository;
        this.articleImageRepository = articleImageRepository;
    }

    @Override
    public ArticleImage uploadImage(Long articleId, MultipartFile file) throws IOException {

        Article article = articleRepository.findArticleById(articleId);
        if(article==null){
            throw new EntityNotFoundException("Article with "+ articleId + " not found. Please select a real article. ");
        }

        String filename = UUID.randomUUID() + "_" + file.getOriginalFilename();

        String uploadDir = "uploads/miniatures";
        Path savePath = Paths.get(uploadDir, filename);

        Files.copy(file.getInputStream(), savePath, StandardCopyOption.REPLACE_EXISTING);

        // Enregistrement en BDD
        ArticleImage image = new ArticleImage();
        image.setImageUrl("/uploads/" + filename);
        image.setArticle(article);

        return articleImageRepository.save(image);
    }
}

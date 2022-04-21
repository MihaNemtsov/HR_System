package com.nemez.company.hrsystem.dto;

import com.nemez.company.hrsystem.model.Departments;
import com.nemez.company.hrsystem.model.Mens;
import com.nemez.company.hrsystem.model.Post;
import org.springframework.stereotype.Service;

@Service
public class MappingUtils {
    public PostDto mapToPostDto(Post post) {
        PostDto dto = new PostDto();

        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setDateEdit(post.getDateEdit());

        return dto;
    }

    public Post mapToPost(PostDto dto) {
        Post post = new Post();

        post.setId(dto.getId());
        post.setTitle(dto.getTitle());
        post.setDateEdit(dto.getDateEdit());

        return post;
    }

    public MenDto mapToMenDto(Mens mens) {
        MenDto dto = new MenDto();

        dto.setId(mens.getId());
        dto.setFio(mens.getFio());
        dto.setDepartmentID(mens.getDepartmentID());
        dto.setPostID(mens.getPostID());
        dto.setRole(mens.getRole());
        dto.setDateEdit(mens.getDateEdit());

        return dto;
    }

    public Mens mapToMen(MenDto dto) {
        Mens mens = new Mens();

        mens.setId(dto.getId());
        mens.setFio(dto.getFio());
        mens.setDepartmentID(dto.getDepartmentID());
        mens.setPostID(dto.getPostID());
        mens.setRole(dto.getRole());
        mens.setDateEdit(dto.getDateEdit());

        return mens;
    }

    public DepartmentDto mapToDepartmentDto(Departments departments) {
        DepartmentDto dto = new DepartmentDto();

        dto.setId(departments.getId());
        dto.setName(departments.getName());
        dto.setMenID(departments.getMenID());
        dto.setParentID(departments.getParentID());
        dto.setDateEdit(departments.getDateEdit());

        return dto;
    }

    public Departments mapToDepartment(DepartmentDto dto) {
        Departments departments = new Departments();

        departments.setId(dto.getId());
        departments.setName(dto.getName());
        departments.setMenID(dto.getMenID());
        departments.setParentID(dto.getParentID());
        departments.setDateEdit(dto.getDateEdit());

        return departments;
    }
}

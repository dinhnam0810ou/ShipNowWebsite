/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndn.repository;

import com.ndn.pojos.Comment;
import java.util.List;

/**
 *
 * @author Nguyen Dinh Nam
 */
public interface CommentRepository {
    List<Object[]> getCommentByShipperId(int shipperId,int page);
    int countComment(int shipperId);
    Comment addComment(Comment c);
}

package com.mhkim.board.controller.dto

import com.mhkim.board.entity.Board
import org.springframework.beans.BeanUtils.copyProperties

class BoardDto {

    data class Response(
        val boardId: Long?,
        val title: String,
        val content: String,
        val userName: String
    ) {
        constructor(board: Board) : this(board.boardId, board.userName, board.title, board.content) {
            copyProperties(board, this)
        }
    }

    data class Request(
        val boardId: Long?,
        val title: String,
        val content: String,
        val userName: String
    )

    data class Update(
        val boardId: Long,
        val title: String,
        val content: String
    )

    data class Delete(
        val boardId: Long
    )

}
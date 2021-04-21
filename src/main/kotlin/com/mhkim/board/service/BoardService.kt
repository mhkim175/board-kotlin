package com.mhkim.board.service

import com.mhkim.board.entity.Board
import com.mhkim.board.repository.BoardRepository
import javassist.NotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BoardService(private val boardRepository: BoardRepository) {

    fun getBoardList(): List<Board> {
        return boardRepository.findAll()
    }

    fun getBoard(boardId: Long): Board {
        return boardRepository.findByIdOrNull(boardId)
            ?:throw NotFoundException("$boardId Not Found")
    }

    @Transactional
    fun addBoard(userName: String, title: String, content: String): Board {
        return boardRepository.save(
            Board(userName=userName, title=title, content=content)
        )
    }

    @Transactional
    fun updateBoard(boardId: Long, title: String, content: String): Board {
        return boardRepository.findByIdOrNull(boardId)
            ?.apply {
                updateBoard(title, content)
            }
            ?:throw NotFoundException("$boardId Not Found")
    }

    @Transactional
    fun deleteBoard(boardId: Long) {
        return boardRepository.findByIdOrNull(boardId)
            ?.let {
                boardRepository.delete(it)
            }
            ?: throw NotFoundException("$boardId Not Found")
    }

}
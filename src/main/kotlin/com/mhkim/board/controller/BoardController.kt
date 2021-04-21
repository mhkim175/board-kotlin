package com.mhkim.board.controller

import com.mhkim.board.controller.dto.BoardDto
import com.mhkim.board.service.BoardService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1")
class BoardController(private val boardService: BoardService) {

    @GetMapping("/boards")
    fun getBoards(): ResponseEntity<Any> {
        return ResponseEntity.ok()
            .body(
                boardService.getBoardList()
                    .map { BoardDto.Response(it) }
                    .toList()
            )
    }

    @GetMapping("/board/{boardId}")
    fun getBoard(@PathVariable("boardId") boardId: Long): ResponseEntity<Any> {
        return ResponseEntity.ok()
            .body(
                boardService.getBoard(boardId)
            )
    }

    @PostMapping("board")
    fun addBoard(@RequestBody boardRequest: BoardDto.Request): ResponseEntity<BoardDto.Response> {
        return ResponseEntity.ok()
            .body(
                BoardDto.Response(
                    boardService.addBoard(boardRequest.userName, boardRequest.title, boardRequest.content)
                )
            )
    }

    @PatchMapping("board")
    fun updateBoard(@RequestBody boardUpdate: BoardDto.Update): ResponseEntity<BoardDto.Response> {
        return ResponseEntity.ok()
            .body(
                BoardDto.Response(
                    boardService.updateBoard(boardUpdate.boardId, boardUpdate.title, boardUpdate.content)
                )
            )
    }

    @DeleteMapping("board")
    fun deleteBoard(@RequestBody boardDelete: BoardDto.Delete): ResponseEntity<BoardDto.Response> {
        boardService.deleteBoard(boardDelete.boardId)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

}
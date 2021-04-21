package com.mhkim.board.repository

import com.mhkim.board.entity.Board
import org.springframework.data.jpa.repository.JpaRepository

interface BoardRepository : JpaRepository<Board, Long>
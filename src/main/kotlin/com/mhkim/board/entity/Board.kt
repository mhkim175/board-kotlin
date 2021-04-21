package com.mhkim.board.entity

import org.hibernate.annotations.DynamicUpdate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@DynamicUpdate
@Entity
data class Board(

    @Id
    @GeneratedValue
    var boardId: Long? = null,

    var userName: String,

    var title: String,

    var content: String,

    ) {
    constructor(title: String, content: String, writer: String) : this(null, title, content, writer)

    fun updateBoard(title: String, content: String) {
        this.title = title
        this.content = content
    }

}
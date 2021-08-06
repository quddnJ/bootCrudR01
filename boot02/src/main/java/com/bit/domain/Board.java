package com.bit.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
//JPA에 필요한 어노테이션
@Entity
//테이블명(만약 생략이 되면 클래스명으로 테이블 만들어짐)
@Table(name = "tbl_boards")
public class Board {
	
	@Id //primary key 선언
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bno;
	private String title;
	private String writer;
	private String content;
	
	@CreationTimestamp
	private Timestamp regdate; //게시물 작성시간
	@UpdateTimestamp
	private Timestamp updatedate; //게시물 최종 수정시간

}

package com.shop.spring_self.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//+-----------+--------------+------+-----+-------------------+-------------------+
//| Field     | Type         | Null | Key | Default           | Extra             |
//+-----------+--------------+------+-----+-------------------+-------------------+
//| num       | int          | NO   | PRI | NULL              | auto_increment    |
//| member_id | varchar(255) | NO   | MUL | NULL              |                   |
//| title     | varchar(255) | NO   |     | NULL              |                   |
//| contents  | varchar(255) | YES  |     |                   |                   |
//| post_time | datetime     | YES  |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
//| state     | tinyint      | NO   |     | 0                 |                   |
//+-----------+--------------+------+-----+-------------------+-------------------+
@Entity
@Table(name="board")
public class BoardVo {
	@Id
	private int num;
	@Column(name="memberId")
	private String memberId;
	private String title;
	private String contents;
	@Column(name="post_time")
	private Date postTime;
	private byte state;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getPostTime() {
		return postTime;
	}
	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}
	public byte getState() {
		return state;
	}
	public void setState(byte state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "BoardVo [num=" + num + ", memberId=" + memberId + ", title=" + title + ", contents=" + contents
				+ ", postTime=" + postTime + ", state=" + state + "]";
	}
	
}

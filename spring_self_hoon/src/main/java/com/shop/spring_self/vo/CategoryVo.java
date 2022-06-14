package com.shop.spring_self.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/*
+----------+--------------+------+-----+---------+----------------+
| Field    | Type         | Null | Key | Default | Extra          |
+----------+--------------+------+-----+---------+----------------+
| cate_num | int          | NO   | PRI | NULL    | auto_increment |
| name     | varchar(255) | NO   |     | NULL    |                |
| sub      | int          | YES  | MUL | NULL    |                |
+----------+--------------+------+-----+---------+----------------+
*/

@Entity
@Table(name="category")
public class CategoryVo {
	@Id
	@Column(name = "cate_num")
	private int cateNum;
	private String name;
	@Column(insertable=false,updatable=false)
	private Integer sub=null;

	
	@OneToOne
	@JoinColumn(name="sub") 
	private CategoryVo subCate;
	 
	public int getCateNum() {
		return cateNum;
	}
	public void setCateNum(int cateNum) {
		this.cateNum = cateNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSub() {
		return sub;
	}
	public void setSub(Integer sub) {
		this.sub = sub;
	}

	public CategoryVo getSubCate() {
		return subCate; 
	}
	public void setSubCate(CategoryVo subCate) {
		this.subCate = subCate; 
	}
	 
	@Override
	public String toString() {
		return "CategoryVo [cateNum=" + cateNum + ", name=" + name + ", sub=" + sub + "]";
	}
	
	

}

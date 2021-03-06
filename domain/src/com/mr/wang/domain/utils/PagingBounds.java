package com.mr.wang.domain.utils;

import org.apache.ibatis.session.RowBounds;

public class PagingBounds extends RowBounds {
	// 总记录数
	private int total;
	// 查询的起始位置(页码)
	private int offset;
	// 查询多少行记录(条数)
	private int limit;

	public PagingBounds() {
		this.offset = NO_ROW_OFFSET;
		this.limit = NO_ROW_LIMIT;
	}

	public PagingBounds(int offset, int limit) {
		this.offset = offset;
		this.limit = limit;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getOffset() {
		return offset;
	}

	public int getLimit() {
		return limit;
	}

	public void setMeToDefault() {
		this.offset = NO_ROW_OFFSET;
		this.limit = NO_ROW_LIMIT;
	}

	public int getSelectCount() {
		return limit + offset;
	}
}
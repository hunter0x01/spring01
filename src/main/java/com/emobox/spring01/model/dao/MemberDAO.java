package com.emobox.spring01.model.dao;

import java.util.List;

import com.emobox.spring01.model.dto.MemberDTO;

public interface MemberDAO {
	public List<MemberDTO> list(); // java.util.List

	public void insert(MemberDTO tdo);
}

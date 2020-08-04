package com.mega.erp.dao;

import java.util.List;

import com.mega.erp.dto.BbsDTO;

public interface IDao {

	public void Insert(BbsDTO bbsDTO);
	public List<BbsDTO>list();
	public BbsDTO content_view(BbsDTO bbsDTO);
	public void Modify(BbsDTO bbsDTO);
	public void Delete(BbsDTO bbsDTO);
	public BbsDTO Reply_view(BbsDTO bbsDTO);
	public void Reply(BbsDTO bbsDTO);
}

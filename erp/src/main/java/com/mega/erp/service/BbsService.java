package com.mega.erp.service;

import java.util.List;

import com.mega.erp.dto.BbsDTO;

public interface BbsService {

	public void BbsWrite(BbsDTO bbsDTO) throws Exception; //게시글작성
	public List<BbsDTO> BbsList() throws Exception; //게시글전체보기
	public BbsDTO BContent(BbsDTO bbsDTO) throws Exception; //게시글상세보기
	public void BbsModify(BbsDTO bbsDTO) throws Exception;//게시글 수정
	public void BbsDelete(BbsDTO bbsDTO) throws Exception;//게시글 삭제
	public BbsDTO BbsReplyView(BbsDTO bbsDTO) throws Exception;//답글보기
	public void BbsReply(BbsDTO bbsDTO)throws Exception;//답글 작성
}	

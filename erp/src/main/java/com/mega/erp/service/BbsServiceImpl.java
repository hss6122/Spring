package com.mega.erp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mega.erp.dao.BbsDAO;
import com.mega.erp.dto.BbsDTO;

@Service
public class BbsServiceImpl implements BbsService {

	@Autowired
	BbsDAO dao;

	@Override
	public void BbsWrite(BbsDTO bbsDTO) throws Exception{
		System.out.println("글작성 서비스 객체 dao에 넘기는 값 "+ bbsDTO);
		dao.Insert(bbsDTO);
		
	}

	@Override
	public List<BbsDTO> BbsList() throws Exception {
		List<BbsDTO> bbsDTO = dao.list(); //dao 의 작업물 리턴 받기 
		System.out.println("리스트 서비스 객체"+ bbsDTO);
		return bbsDTO;
}

	@Override
	public BbsDTO BContent(BbsDTO bbsDTO) throws Exception {
		bbsDTO = dao.content_view(bbsDTO);
		System.out.println("상세보기 서비스 객체 " + bbsDTO);
		return bbsDTO;
	}

	@Override
	public void BbsModify(BbsDTO bbsDTO) throws Exception {
		dao.Modify(bbsDTO);
		System.out.println("수정하기 서비스 객체"+bbsDTO);
	}

	@Override
	public void BbsDelete(BbsDTO bbsDTO) throws Exception {
		dao.Delete(bbsDTO);
		System.out.println("삭제하기 서비스 객체"+bbsDTO);
	}

	@Override
	public BbsDTO BbsReplyView(BbsDTO bbsDTO) throws Exception {
		bbsDTO = dao.Reply_view(bbsDTO);
		return bbsDTO;
	}

	@Override
	public void BbsReply(BbsDTO bbsDTO) throws Exception {
		dao.Reply(bbsDTO);
		System.out.println("서비스 객체 reply"+bbsDTO);
	}
	
	
}

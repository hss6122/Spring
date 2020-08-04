package com.mega.erp.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mega.erp.dto.BbsDTO;

@Component
public class BbsDAO implements IDao {

	@Autowired
	SqlSessionTemplate my;

	public void Insert(BbsDTO bbsDTO) {
		System.out.println(bbsDTO + "dao insert()");
		my.insert("bbsMapper.insert", bbsDTO);
	}

	public List<BbsDTO> list() {
		List<BbsDTO> dtos = my.selectList("bbsMapper.select");
		System.out.println("dao list()" + dtos);
		return dtos;
	}

	@Override
	public BbsDTO content_view(BbsDTO bbsDTO) {
		upHit(bbsDTO);
		bbsDTO = my.selectOne("bbsMapper.selectone", bbsDTO);
		System.out.println("DAO content_view()" + bbsDTO);
		return bbsDTO;
	}

	@Override
	public void Modify(BbsDTO bbsDTO) {
		my.update("bbsMapper.update", bbsDTO);
		System.out.println("DAO Modify" + bbsDTO);
	}

	@Override
	public void Delete(BbsDTO bbsDTO) {
		my.delete("bbsMapper.delete", bbsDTO);
		System.out.println("DAO Delete" + bbsDTO);
	}

	@Override
	public BbsDTO Reply_view(BbsDTO bbsDTO) {
		bbsDTO = my.selectOne("bbsMapper.selectone", bbsDTO);
		return bbsDTO;
	}

	// 게시글을 조회할 때마다 조회수가 1 증가하는 메서드
	// 메서드 내에서만 사용되므로 밖에서 사용하지 않도록 private속성 
	private void upHit(BbsDTO bbsDTO) {
		my.update("bbsMapper.uphit", bbsDTO);
	}
	private void replyShape(BbsDTO bbsDTO) {
		System.out.println("replyShape()"+bbsDTO);
		my.update("bbsMapper.shape", bbsDTO);
	}
	@Override
	public void Reply(BbsDTO bbsDTO) {
		replyShape(bbsDTO);
		//현재 작성하고자 하는 덧글 외 이전 덧글을 모두 한칸씩 아래로 민다.
		System.out.println("DAO Reply()"+bbsDTO);
		my.insert("bbsMapper.replyinsert", bbsDTO);
	}

}

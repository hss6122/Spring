package com.mega.erp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mega.erp.dto.BbsDTO;
import com.mega.erp.service.BbsService;

@Controller
public class BbsController {

	@Autowired
	BbsService service; // 초기화 하지 않고 선언만 함.

	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(BbsDTO bbsDTO) throws Exception {
		System.out.println("write()" + "컨트롤러에서 글 작성 클래스 실행");
		service.BbsWrite(bbsDTO);
		return "redirect:list";
	}

	// 작성하는 동작아니라 화면만 이다 . 작성 폼이 있는 jsp 페이지로 바로 넘긴다
	@RequestMapping("/write_View")
	public String write_view(BbsDTO bbsDTO) {
		System.out.println("write_view()" + "글쓰기 페이지 불러오기");
		return "write_View";
	}

	@RequestMapping("/list")
	public String list(Model model) throws Exception {
		System.out.println("컨트롤러 list()");
		List<BbsDTO> bList = service.BbsList();
		model.addAttribute("list", bList);
		System.out.println("컨트롤러 리스트 = " + model);
		return "list"; // list.jps페이지로 찾아가랏
	}

	@RequestMapping("/content_view") // BbsDTO.bId 값이 넘어 온다.
	public String content_view(BbsDTO bbsDTO, Model model) throws Exception {
		System.out.println("컨트롤러" + "content_view()" + bbsDTO);
		bbsDTO = service.BContent(bbsDTO);
		model.addAttribute("bbsDTO", bbsDTO);
		return "content_view";
	}

	// 수정클래스
	// 수정이기 때문에 벨류를 명시하고 , 방식은 POST방식으로 한다
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(BbsDTO bbsDTO) throws Exception {
		System.out.println("컨트롤러  modify()" + bbsDTO);
		service.BbsModify(bbsDTO);
		return "redirect:list"; // 리다이렉트 : 리스트
	}

	@RequestMapping("/delete")
	public String delete(BbsDTO bbsDTO) throws Exception {
		System.out.println("컨트롤러 delete()" + bbsDTO);
		service.BbsDelete(bbsDTO);
		return "redirect:list";

	}

	@RequestMapping("/reply_view")
	public String reply_view(BbsDTO bbsDTO, Model model) throws Exception {
		System.out.println("컨트롤러 리플뷰 ()");
		bbsDTO = service.BbsReplyView(bbsDTO);
		model.addAttribute("bbsDTO", bbsDTO);
		return "reply_view";
	}

	@RequestMapping("/reply")
	public String reply(BbsDTO bbsDTO) throws Exception {
		System.out.println("컨트롤러 reply()"+bbsDTO);
		service.BbsReply(bbsDTO);
		return "redirect:list";

	}

}// 메인

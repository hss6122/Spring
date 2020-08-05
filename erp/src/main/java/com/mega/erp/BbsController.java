package com.mega.erp;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.mega.erp.dto.BbsDTO;
import com.mega.erp.service.BbsService;

@Controller
public class BbsController {

	@Autowired
	BbsService service; // 초기화 하지 않고 선언만 함.

	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(BbsDTO bbsDTO) throws Exception {
		String fileName = null; 
		MultipartFile uploadFile = bbsDTO.getUploadFile();
		if (!uploadFile.isEmpty()) {// isEmpty() 객체가 비어 있을때 
			String originalFileName = uploadFile.getOriginalFilename();
			String ext = FilenameUtils.getExtension(originalFileName);  //확장자 구하기
			UUID uuid = UUID.randomUUID(); // uuid 구하기
			fileName=uuid+"."+ext;
			uploadFile.transferTo(new File("D:\\upload\\"+ fileName));
		}
		bbsDTO.setbFileName(fileName);
		System.out.println("write()" + "컨트롤러에서 글 작성 클래스 실행");
		service.BbsWrite(bbsDTO);
		return "redirect:list";
	}
	
	@RequestMapping(value="fileDownload")
	public void fileDownload(BbsDTO bbsDTO, HttpServletRequest request, HttpServletResponse response)throws Exception{
		String filename = bbsDTO.getbFileName();
		String realFilename="";
		System.out.println("컨트롤러 파일 다운로드 ()"+filename);
		
		try {
			String browser = request.getHeader("User-Agent"); //파일 인코딩
			System.out.println(browser);
			if (browser.contains("MSIE") || browser.contains("Trident")
                    || browser.contains("Chrome")) {
				filename = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+","%20");
			}else {
				filename = new String(filename.getBytes("UTF-8"),"ISO-8859-1");
			}
		} catch (UnsupportedEncodingException ex) {
			System.out.println("UnsupportedEncodingException");
		}
		realFilename="D:\\upload\\"+filename;
		System.out.println(realFilename);
		File file = new File(realFilename);
		if (!file.exists()) {
			return;
		}
		
		//파일명 지정
		response.setContentType("pplication/octer-stream");
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.setHeader("Content-Disposition", "attachment; filename=\""+filename+"\"");
		try {
			OutputStream os = response.getOutputStream();
			FileInputStream fis  = new FileInputStream(realFilename);
			
			int ncount = 0;
			byte[] bytes = new byte[512];
			while ((ncount = fis.read(bytes))!= -1) {
				os.write(bytes,0,ncount);
			}
			fis.close();
			os.close();
			
		} catch (Exception e) {
		System.out.println("FileNotFoundException : "+ e);
	}}

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

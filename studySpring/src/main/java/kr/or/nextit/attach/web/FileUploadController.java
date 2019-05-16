package kr.or.nextit.attach.web;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.or.nextit.attach.service.AttachService;

@Controller
public class FileUploadController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "propertyService")
	private Properties propertyService;

	@Autowired
	private AttachService attachService;

	@RequestMapping(value = "/attach/ajaxFileUploadFront.do")
	public String getAjaxFileUploadFront() throws Exception {

		return "attach/ajaxFileUploadFront";
	}

	@RequestMapping(value = "/attach/ajaxFileUploadProc.json")
	@ResponseBody
	public HashMap<String, Object> ajaxfileUploadProc(
			@RequestParam HashMap<String, Object> params,
			@RequestParam(name = "attachFiles") List<MultipartFile> attachFiles, HttpServletRequest req)
			throws Exception {
		
		String savePath = propertyService.getProperty("server.save.path");

		String groupSeqNo = UUID.randomUUID().toString();
		String serviceType = (String) params.get("serviceType");
		
		log.debug("여기 정보 온다 : {}",params);
		log.debug("여기 정보 온다 : {}",params);
		log.debug("여기 정보 온다 : {}",params);
		log.debug("여기 정보 온다 : {}",params);
		req.getSession().getAttribute("loginInfo");

		String userId = "guest";
		String userIp = req.getRemoteAddr();

		HashMap<String, Object> result = attachService.insertFileUploads(groupSeqNo, serviceType, savePath, userId,
				userIp, attachFiles);

		return result;
	}

	@RequestMapping(value = "/attach/fileUploadFront.do")
	public String getFileUploadFront() throws Exception {
		return "attach/fileUploadFront";
	}

	@RequestMapping(value = "/attach/fileUploadProc.do")
	public String setFileUploadProc(@RequestParam HashMap<String, Object> params,
			@RequestParam(name = "attachFiles") List<MultipartFile> attachFiles, HttpServletRequest req, Model model

	// 단일 첨부파일로 넘어올때
	// @RequestParam(name="attachFiles") MultipartFile attachFiles
	) throws Exception {

		log.debug("params : {}", params);

		// 단일 첨부 파일 일때
		// log.debug("MultipartFile.getName : {}",attachFiles.getName());
		// log.debug("MultipartFile.getOriginalFilename :
		// {}",attachFiles.getOriginalFilename());
		// log.debug("MultipartFile.getContentType : {}",attachFiles.getContentType());
		// log.debug("MultipartFile.getSize : {}",attachFiles.getSize());
		//
		// // 저장할 파일 경로와 파일명을 file 객체로 인스턴스 생성
		// File saveFile = new File("/home/pc44/workspace/upload/" +
		// attachFiles.getOriginalFilename());
		//
		// // 클라이언트에서 올라온 파일 inputStream 객체를 saveFile 경로 + 파일 명으로 생성
		// FileUtils.copyToFile(attachFiles.getInputStream(), saveFile);
		//
		String savePath = propertyService.getProperty("server.save.path");

		String groupSeqNo = UUID.randomUUID().toString();
		String serviceType = "test";

		req.getSession().getAttribute("loginInfo");

		String userId = "guest";
		String userIp = req.getRemoteAddr();

		HashMap<String, Object> result = attachService.insertFileUploads(groupSeqNo, serviceType, savePath, userId,
				userIp, attachFiles);
		model.addAttribute("fileInfo", result);

		// for (MultipartFile file : attachFiles) {
		//
		// if (!"".equalsIgnoreCase(file.getOriginalFilename())) {
		// log.debug("file.getName() : {}", file.getName());
		// log.debug("file.getOriginalFilename() : {}", file.getOriginalFilename());
		// log.debug("file.getContentType() : {}", file.getContentType());
		// log.debug("file.getSize() : {}", file.getSize());
		//
		// // File.separator : 윈도우면 \ 리눅스 유닉스 / 파일 구분자 OS에 따라 자동 설정
		// File saveFile = new File(String.format("%s%s%s", savePath, File.separator,
		// file.getOriginalFilename()));
		// log.debug("path : {}", savePath);
		// FileUtils.copyInputStreamToFile(file.getInputStream(), saveFile);
		//// FileUtils.copyToFile(file.getInputStream(), saveFile);
		//
		// }
		// }

		return "attach/fileUploadFront";
	}

	@RequestMapping(value = "/attach/fileUploadPartProc.do")
	public String setFileUploadPartProc(@RequestParam HashMap<String, Object> params,
			@RequestPart List<Part> attachFiles) throws Exception {

		String savePath = propertyService.getProperty("server.save.path");

		log.debug("part : {}", attachFiles);

		for (Part part : attachFiles) {

			log.debug("part.getName() : {}", part.getName());
			log.debug("part.getSubmittedFileName() : {}", part.getSubmittedFileName());
			log.debug("part.getContentType() : {}", part.getContentType());
			log.debug("part.getSize() : {}", part.getSize());

			if (!"".equalsIgnoreCase(part.getSubmittedFileName())) {

				// File.separator : 윈도우면 \ 리눅스 유닉스 / 파일 구분자 OS에 따라 자동 설정
				File saveFile = new File(
						String.format("%s%s%s", savePath, File.separator, part.getSubmittedFileName()));
				log.debug("path : {}", savePath);
				FileUtils.copyInputStreamToFile(part.getInputStream(), saveFile);
				// FileUtils.copyToFile(file.getInputStream(), saveFile);
			}

		}

		return "attach/fileUploadFront";
	}
}

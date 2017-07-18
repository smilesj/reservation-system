package won.reservation.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import won.reservation.domain.File;
import won.reservation.service.FileService;

@RestController
@RequestMapping("/api/files")
public class FileController {
	
	private FileService fileService;
	
	@Autowired
	public FileController(FileService fileService) {
		this.fileService = fileService;
	}
	
	@GetMapping
	@RequestMapping("/{commentId}")
	public List<File> read(@PathVariable(name="commentId") Integer reservationUserCommentId){
		return fileService.readByReservationUserCommentId(reservationUserCommentId);
	}
	
	@GetMapping("/file/{fileId}")
	@ResponseBody
	public String readFile(@PathVariable(name="fileId") Integer fileId) {
		return fileService.read(fileId);
	}
	
}

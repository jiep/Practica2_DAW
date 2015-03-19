package tiendapox;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController {
	
	/*private static final String FILES_FOLDER = "files";

	private List<String> imageTitles = new ArrayList<>();

	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/image/upload", method = RequestMethod.POST)
	public ModelAndView handleFileUpload(
			@RequestParam("imageTitle") String imageTitle,
			@RequestParam("file") MultipartFile file) {

		String fileName = imageTitles.size() + ".jpg";

		if (!file.isEmpty()) {
			try {

				File filesFolder = new File(FILES_FOLDER);
				if (!filesFolder.exists()) {
					filesFolder.mkdirs();
				}

				File uploadedFile = new File(filesFolder.getAbsolutePath(),
						fileName);
				file.transferTo(uploadedFile);

				imageTitles.add(imageTitle);

				return new ModelAndView("index").addObject("imageTitles",
						imageTitles);

			} catch (Exception e) {
				return new ModelAndView("index")
						.addObject("fileName", fileName).addObject("error",
								e.getClass().getName() + ":" + e.getMessage());
			}
		} else {
			return new ModelAndView("index").addObject("error",
					"The file is empty");
		}
	}

	@RequestMapping("/image/{fileName}")
	public void handleFileDownload(@PathVariable String fileName,
			HttpServletResponse res) throws FileNotFoundException, IOException {

		File file = new File(FILES_FOLDER, fileName + ".jpg");

		if (file.exists()) {
			res.setContentType("image/jpeg");
			res.setContentLength(new Long(file.length()).intValue());
			FileCopyUtils
					.copy(new FileInputStream(file), res.getOutputStream());
		} else {
			res.sendError(404, "File" + fileName + "(" + file.getAbsolutePath()
					+ ") does not exist");
		}
	}*/


}

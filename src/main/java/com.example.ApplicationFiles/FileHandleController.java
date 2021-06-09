package com.example.ApplicationFiles;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FileHandleController {

    @PostMapping("/upload")
    @ResponseBody
    public UploadResponse[] handleFileUpload(@RequestParam("file") MultipartFile file
                                   ,RedirectAttributes redirectAttributes) throws IOException, NoSuchAlgorithmException {
        return new UploadResponse[] {new UploadResponse(file.getOriginalFilename(),"Stribog512",
                FileActions.getFile2018Hash(file)), new UploadResponse(file.getOriginalFilename(), "GOST3411-2012.512",
                FileActions.getFile2012Hash(file))};
    }

}
